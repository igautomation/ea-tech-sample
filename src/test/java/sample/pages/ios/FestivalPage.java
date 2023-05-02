package sample.pages.ios;

import static io.appium.java_client.AppiumBy.className;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FestivalPage {
    private final WebDriverWait wait;

    public FestivalPage (final WebDriverWait wait) {
        this.wait = wait;
    }

    public List<FestivalItem> getFestivals () {
        return listView ().findElements (className ("XCUIElementTypeCell"))
            .stream ()
            .map (FestivalItem::new)
            .collect (toList ());
    }

    public Optional<FestivalItem> getFestivals (final String name, final String title) {
        return getFestivals ().stream ()
            .filter (festivalItem -> festivalItem.name ()
                .equals (name))
            .filter (festivalItem -> festivalItem.title ()
                .equals (title))
            .findFirst ();
    }

    private WebElement listView () {
        return this.wait.until (visibilityOfElementLocated (className ("XCUIElementTypeCollectionView")));
    }

}
