package sample;

import static java.lang.System.getProperty;

import java.nio.file.Path;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Capabilities;

public class IOSManager {
    private static final String DEVICE_NAME      = "iPhone 14 Pro Max";
    private static final String PLATFORM_VERSION = "16.4";
    private static final String USER_DIR         = getProperty ("user.dir");

    public IOSDriver createDriver (final AppiumDriverLocalService service) {
        return new IOSDriver (service.getUrl (), buildCapabilities ());
    }

    private Capabilities buildCapabilities () {
        final var options = new XCUITestOptions ();
        options.setPlatformName ("iOS")
            .setPlatformVersion (PLATFORM_VERSION)
            .setDeviceName (DEVICE_NAME)
            .setApp (Path.of (USER_DIR, "src/test/resources/apps/RecordLabelApp.app")
                .toString ())
            .setAutoAcceptAlerts (true)
            .setFullReset (false);
        return options;
    }
}
