package sample.pages.android;

import static io.appium.java_client.AppiumBy.id;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class FestivalItem {
    private final WebElement container;

    public FestivalItem (final WebElement container) {
        this.container = container;
    }

    public String name () {
        try {
            return this.container.findElement (id ("com.energyaustralia.codingtestsample:id/festivalTextView"))
                .getText ();
        } catch (final NoSuchElementException e) {
            return EMPTY;
        }
    }

    public String title () {
        try {
            return this.container.findElement (id ("com.energyaustralia.codingtestsample:id/titleTextView"))
                .getText ();
        } catch (final NoSuchElementException e) {
            return EMPTY;
        }
    }
}
