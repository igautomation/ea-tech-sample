package sample.pages.android;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FestivalPage {
    private final WebDriverWait wait;

    public FestivalPage (final WebDriverWait wait) {
        this.wait = wait;
    }

    public List<FestivalItem> getFestivals () {
        return listView ().findElements (className ("android.widget.LinearLayout"))
            .stream ()
            .map (FestivalItem::new)
            .collect (toList ());
    }

    public Optional<FestivalItem> getFestivals (final String name, final String title) {
        try {
            this.wait.until (visibilityOfElementLocated (androidUIAutomator (format (
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"{0}\"))",
                title))));
        } catch (final TimeoutException e) {
            e.printStackTrace ();
        }

        return getFestivals ().stream ()
            .filter (festivalItem -> festivalItem.name ()
                .equals (name))
            .filter (festivalItem -> festivalItem.title ()
                .equals (title))
            .findFirst ();
    }

    private WebElement listView () {
        return this.wait.until (visibilityOfElementLocated (id ("festival_list")));
    }
}
