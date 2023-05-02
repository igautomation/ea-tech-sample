package sample;

import java.time.Duration;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.restassured.RestAssured;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sample.pages.android.FestivalPage;
import sample.pojo.Festival;

public class AndroidFestivalTest {
    private AndroidDriver            driver;
    private AppiumDriverLocalService service;
    private WebDriverWait            wait;

    @BeforeClass (alwaysRun = true)
    public void setupClass () {
        final var serviceManager = new AppiumServiceManager (4723);
        this.service = serviceManager.buildService ();
        this.service.start ();

        this.driver = new AndroidManager ().createDriver (this.service);
        this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (10));
    }

    @AfterClass (alwaysRun = true)
    public void tearDownClass () {
        this.driver.quit ();
        this.service.stop ();
    }

    @Test
    public void testFestivalListingsAndroid () {

        final List<Festival> festivals = getFestivalsAsList ();

        final var festivalPage = new FestivalPage (this.wait);
        final var softAssert = new SoftAssert ();

        if (festivals.size() > 0)  {

            festivals.forEach (festival -> festival.getBands ()
                    .forEach (band -> {
                        final var name = festival.getName () == null ? "Unknown" : festival.getName ();
                        final var title = band.getName ();
                        final var actualBand = festivalPage.getFestivals (name, title);

                        softAssert.assertTrue (actualBand.isPresent (), title + " is not present");
                        //noinspection ConstantValue
                        if (actualBand.isPresent ()) {
                            softAssert.assertEquals (actualBand.get ()
                                    .title (), title, title + " is not visible on UI");
                            softAssert.assertEquals (actualBand.get ()
                                    .name (), name, name + " is not visible on UI");
                        }

                    }));

            softAssert.assertAll ();

        }

    }

    private String getExpectedFestivals () {
        final var response = RestAssured.given ()
                .baseUri ("https://eacp.energyaustralia.com.au")
                .basePath ("/codingtest/api/v1")
                .when ()
                .get ("/festivals")
                .body ()
                .asPrettyString ();
        System.out.println (response);
        return response;
    }

    private List<Festival> getFestivalsAsList () {
        final var festivalJson = getExpectedFestivals ();
        final var gson = new GsonBuilder ().setPrettyPrinting ()
                .create ();
        final var expectedType = new TypeToken<List<Festival>> () {
        }.getType ();
        return gson.fromJson (festivalJson, expectedType);
    }
}
