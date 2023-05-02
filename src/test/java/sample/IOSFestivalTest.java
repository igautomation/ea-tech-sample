    /**
     * @author [Muhammad Imran]
     * @email [muhammadghouseimran.zahirudeen@cognizant.com]
     * @create date 2023-05-02 16:15:05
     * @modify date 2023-05-02 16:15:05
     * @desc [Test Class for iOS Test]
     */

    package sample;

    import com.google.gson.GsonBuilder;
    import com.google.gson.reflect.TypeToken;
    import io.appium.java_client.ios.IOSDriver;
    import io.appium.java_client.service.local.AppiumDriverLocalService;
    import io.restassured.RestAssured;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;
    import org.testng.asserts.SoftAssert;
    import sample.pages.ios.FestivalPage;
    import sample.pojo.Festival;

    import java.time.Duration;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;


    public class IOSFestivalTest {

        private IOSDriver                driver;
        private AppiumDriverLocalService service;
        private WebDriverWait            wait;

        @BeforeClass (alwaysRun = true)
        public void setupClass () {
            final var serviceManager = new AppiumServiceManager (4725);
            this.service = serviceManager.buildService ();
            this.service.start ();

            this.driver = new IOSManager ().createDriver (this.service);
            this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (10));
        }

        @AfterClass (alwaysRun = true)
        public void tearDownClass () {
            this.driver.quit ();
            this.service.stop ();
        }

        @Test
        public void testFestivalListingsiOS () {

            final List<Festival> festivals = getFestivalsAsList();

            final var festivalPage = new FestivalPage(this.wait);
            final var softAssert = new SoftAssert();

            if (festivals.size() > 0)  {

                festivals.forEach(festival -> festival.getBands()
                        .forEach(band -> {
                            final var name = festival.getName() == null ? "Unknown" : festival.getName();
                            final var title = band.getName();

                            // Scroll Default Top Element using JavascriptExecutor
                            swipe("down", title);
                            var actualBand = festivalPage.getFestivals(name, title);

                            if (actualBand.isPresent()) {
                                softAssert.assertEquals(actualBand.get()
                                        .title(), title, title + " is not visible on UI");
                                softAssert.assertEquals(actualBand.get()
                                        .name(), name, name + " is not visible on UI");
                            } else {
                                // Scroll Default Last Element using JavascriptExecutor
                                swipe("up", title);
                                actualBand = festivalPage.getFestivals(name, title);
                                if (actualBand.isPresent ()) {
                                    softAssert.assertEquals(actualBand.get()
                                            .title(), title, title + " is not visible on UI");
                                    softAssert.assertEquals(actualBand.get()
                                            .name(), name, name + " is not visible on UI");
                                } else {
                                    softAssert.assertFalse(false, title + " is not present");
                                }
                            }
                        }));

                softAssert.assertAll();
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

        private void swipe (String direction, String locator){
            // Scroll using JavascriptExecutor
            var js = (JavascriptExecutor)driver;
            Map<String, String> swipe = new HashMap<>();
            swipe.put("direction", direction); // "down", "up", "right", "left"
            swipe.put("id", locator);
            js.executeScript("mobile:swipe", swipe);
        }
    }
