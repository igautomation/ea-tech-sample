/**
 * @author [Muhammad Imran]
 * @email [muhammadghouseimran.zahirudeen@cognizant.com]
 * @create date 2023-05-01 21:30:20
 * @modify date 2023-05-01 21:30:20
 * @desc [Initialization of Android Driver & setting the capabilities required for the test of Android App]
 */

package sample;

import static java.lang.System.getProperty;

import java.nio.file.Path;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Capabilities;

public class AndroidManager {
    private static final String DEVICE_NAME      = "Pixel_6_Pro";
    private static final String PLATFORM_VERSION = "11";
    private static final String USER_DIR         = getProperty ("user.dir");

    public AndroidDriver createDriver (final AppiumDriverLocalService service) {
        return new AndroidDriver (service.getUrl (), buildCapabilities ());
    }

    private Capabilities buildCapabilities () {
        final var options = new UiAutomator2Options ();
        options.setPlatformName ("Android")
            .setPlatformVersion (PLATFORM_VERSION)
            .setDeviceName (DEVICE_NAME)
            .setAvd (DEVICE_NAME)
            .setApp (Path.of (USER_DIR, "src/test/resources/apps/RecordLabelApp.apk")
                .toString ())
            .setAutoGrantPermissions (true)
            .setFullReset (false)
            .setCapability ("appium:settings[ignoreUnimportantViews]", true);
        return options;
    }
}
