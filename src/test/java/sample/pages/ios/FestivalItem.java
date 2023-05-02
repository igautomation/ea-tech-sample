/**
 * @author [Muhammad Imran]
 * @email [muhammadghouseimran.zahirudeen@cognizant.com]
 * @create date 2023-05-02 16:15:05
 * @modify date 2023-05-02 16:15:05
 * @desc [Retrieve & Store Festival and Band details from App View]
 */


package sample.pages.ios;

import static io.appium.java_client.AppiumBy.iOSNsPredicateString;
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
            return this.container.findElement (
                    iOSNsPredicateString ("type == \"XCUIElementTypeStaticText\" AND index == 1"))
                .getText ();
        } catch (final NoSuchElementException e) {
            return EMPTY;
        }
    }

    public String title () {
        try {
            return this.container.findElement (
                    iOSNsPredicateString ("type == \"XCUIElementTypeStaticText\" AND index == 0"))
                .getText ();
        } catch (final NoSuchElementException e) {
            return EMPTY;
        }
    }
}
