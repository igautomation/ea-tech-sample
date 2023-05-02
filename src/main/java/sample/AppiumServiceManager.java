/**
 * @author [Muhammad Imran]
 * @email [muhammadghouseimran.zahirudeen@cognizant.com]
 * @create date 2023-05-01 21:30:20
 * @modify date 2023-05-01 21:30:20
 */

package sample;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOCAL_TIMEZONE;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.SESSION_OVERRIDE;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.USE_DRIVERS;
import static java.lang.System.getProperty;

import java.nio.file.Path;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

class AppiumServiceManager {
    private static final String USER_DIR = getProperty ("user.dir");

    private final int port;

    AppiumServiceManager (final int port) {
        this.port = port;
    }

    public AppiumDriverLocalService buildService () {
        final var logFile = Path.of (USER_DIR, "logs", "appium-test.log")
            .toFile ();
        final var builder = new AppiumServiceBuilder ();
        return builder.withIPAddress ("127.0.0.1")
            .usingPort (this.port)
            .withLogFile (logFile)
            .withArgument (BASEPATH, "/wd/hub")
            .withArgument (LOG_LEVEL, "info")
            .withArgument (USE_DRIVERS, "uiautomator2")
            .withArgument (SESSION_OVERRIDE)
            .withArgument (LOCAL_TIMEZONE)
            .build ();
    }
}
