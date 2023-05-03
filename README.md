# ea-tech-sample
energyaustralia-coding-test


# Festivals Mobile App Testing

This project is a sample code for testing the Festivals mobile app using Appium and TestNG. The app is tested on both Android and iOS platforms.

## Prerequisites

Before you can run this project, make sure you have the following software installed on your machine:

- Java 11 or higher
- Maven
- Appium
- Android SDK or Xcode

## Running the Tests

To run the tests, follow these steps:

1. Clone the repository to your local machine.
2. Open a terminal or command prompt in the project directory.
3. Start the Appium server by running the command `appium`.
4. Run the command `mvn clean test`.

## Test Results

The test results can be found in the `target/EA_MOBILE_YYYY.MM.DD.hh.mm.ss.html` directory. Open the `index.html` file in a web browser to view the test report.

## Test Structure

The tests are written using TestNG and follow a page object model structure. The test classes and pages are located in the `src/test/java` directory.

### Android Tests

The Android tests are located in the `AndroidFestivalTest` class. This class uses the `AndroidManager` class to create an Android driver and the `FestivalPage` class to interact with the app.

### iOS Tests

The iOS tests are located in the `IOSFestivalTest` class. This class uses the `IOSManager` class to create an iOS driver and the `FestivalPage` class to interact with the app.

## Authors

- Muhammad Imran (muhammadghouseimran.zahirudeen@cognizant.com)

## License


# Android Manager

This code initializes the Android driver and sets the capabilities required for testing an Android app. The Android driver is created using the AppiumDriverLocalService, and the capabilities are set using UiAutomator2Options.

## Author
- Muhammad Imran
- Email: muhammadghouseimran.zahirudeen@cognizant.com

## Usage

This code is intended to be used in conjunction with an Android app testing framework.

To use this code:
1. Clone the repository
2. Install the necessary software and dependencies
3. Set the device name, platform version, and app path in the AndroidManager class
4. Create a new instance of the AndroidDriver using the createDriver method in AndroidManager class.

## Dependencies

This code has the following dependencies:
- io.appium.java_client.android.AndroidDriver
- io.appium.java_client.android.options.UiAutomator2Options
- io.appium.java_client.service.local.AppiumDriverLocalService
- org.openqa.selenium.Capabilities

## License


# iOS Manager

This code initializes the iOS driver and sets the capabilities required for testing an iOS app. The iOS driver is created using the AppiumDriverLocalService, and the capabilities are set using XCUITestOptions.

## Author
- Muhammad Imran
- Email: muhammadghouseimran.zahirudeen@cognizant.com

## Usage

This code is intended to be used in conjunction with an iOS app testing framework.

To use this code:
1. Clone the repository
2. Install the necessary software and dependencies
3. Set the device name, platform version, and app path in the IOSManager class
4. Create a new instance of the IOSDriver using the createDriver method in IOSManager class.

## Dependencies

This code has the following dependencies:
- io.appium.java_client.ios.IOSDriver
- io.appium.java_client.ios.options.XCUITestOptions
- io.appium.java_client.service.local.AppiumDriverLocalService
- org.openqa.selenium.Capabilities

## License

# Android Festival Test

This is a Test Class for Android Test, which tests the functionality of Festival Listings on an Android device using Appium automation framework and RestAssured for API testing.

## Prerequisites

- Java JDK installed on your system
- Android SDK configured on your system
- Appium installed on your system
- RestAssured library installed in the project

## Getting Started

1. Clone the project from the repository
2. Open the project in your preferred IDE
3. Install the required dependencies
4. Set up the Android emulator or connect an Android device to your computer
5. Run the `AndroidFestivalTest` class

## Project Structure

- `AndroidFestivalTest` - Main test class containing the test methods
- `FestivalPage` - Page Object class for the Festival Page UI
- `Festival` - POJO class representing a Festival object
- `AppiumServiceManager` - Utility class to start the Appium service
- `AndroidManager` - Utility class to create the Android driver

## Running the Tests

1. Open the `AndroidFestivalTest` class
2. Run the class or individual test methods

## Test Description

The `testFestivalListingsAndroid` method tests the functionality of Festival Listings on an Android device. It retrieves a list of festivals from an API endpoint using RestAssured and asserts that each festival and its bands are displayed on the UI using the `FestivalPage` page object class. The test uses a SoftAssert to ensure that all assertions are executed before the test fails.

## Clean Up

The `tearDownClass` method is called after all the tests have completed execution. It closes the Android driver and stops the Appium service.


# IOS Festival Test

This is a Test class for the iOS application that tests the festival listings on the application. The tests use Appium, RestAssured and TestNG frameworks to automate the testing of the iOS application.

## Prerequisites

- Java JDK installed on your system
- XCUI TEST configured on your system
- Appium installed on your system
- RestAssured library installed in the project

## Getting Started

1. Clone the project from the repository
2. Open the project in your preferred IDE
3. Install the required dependencies
4. Set up the iOS simulator or connect an iOS device to your computer
5. Run the `IOSFestivalTest` class

## Project Structure

- `IOSFestivalTest` - Main test class containing the test methods
- `FestivalPage` - Page Object class for the Festival Page UI
- `Festival` - POJO class representing a Festival object
- `AppiumServiceManager` - Utility class to start the Appium service
- `IOSManager` - Utility class to create the iOS driver

## Running the Tests

1. Open the `IOSFestivalTest` class
2. Run the class or individual test methods

## Test Description

testFestivalListingsiOS - This test case retrieves a list of festivals from a REST API, and checks if the festival and the bands are displayed correctly on the iOS application. If the bands are not visible on the current page, it scrolls down until it is visible or until it reaches the end of the page. If the bands are still not visible, it scrolls up until it is visible or until it reaches the top of the page. It then asserts that the festival and the bands are displayed correctly on the iOS application.

## Clean Up

The `tearDownClass` method is called after all the tests have completed execution. It closes the iOS driver and stops the Appium service.



# Test Suite XML file

This is an XML configuration file used by TestNG framework to execute a suite of automated tests for EA Mobile Application on both Android and iOS platforms.

## Purpose
The purpose of this file is to define a suite of tests that will be executed by TestNG framework. The suite consists of two test classes, `AndroidFestivalTest` and `IOSFestivalTest`, each of which will be run on their respective platforms, i.e., Android and iOS.

## Configuration
The `suite` element defines the name of the suite as "EA Mobile Automation Suite". The `parallel` attribute is set to "classes", which means the tests in each class will be run in parallel. The `verbose` attribute is set to "10", which specifies the level of logging detail to be output.

The `listener` element is used to add a custom listener `ExtentReports` which generates an HTML report after the execution of the test suite.

The `test` element defines the name of the test as "ea-coding-test". It includes two test classes, `AndroidFestivalTest` and `IOSFestivalTest`, which are defined using the `class` element.

## Execution
To execute this test suite, you can use any test runner that supports TestNG framework, such as IntelliJ IDEA or Eclipse. Simply right-click on the XML file and select "Run As TestNG Suite" option.

Alternatively, you can use the TestNG command line tool to execute the suite. Open a terminal window, navigate to the directory where the XML file is located, and run the following command:
```
$ java -cp "/path/to/testng.jar:/path/to/project/classes/" org.testng.TestNG suite.xml
```

Replace "/path/to/testng.jar" with the path to the TestNG JAR file, and "/path/to/project/classes/" with the path to the directory containing the compiled test classes.


## Assumption

* Record Label is not implemented in both the apps [iOS, Android]
* API response is not static and inconsistent. Response Data changes on each call in the test
* Android App List view is not displaying "Band" item with no "Festival" data
* iOS App List view is not displaying repeated "Band" item even with unique "Festival" data


## Test Scenarios Covered both iOS and Android
The provided code is a Test class for Android Test, which contains the following methods:

- `setupClass()`: Method with `@BeforeClass` annotation which sets up the required services before starting the tests.
- `tearDownClass()`: Method with `@AfterClass` annotation which stops the running services after executing the tests.
- `testFestivalListingsAndroid()`: Method with `@Test` annotation that contains test cases to verify the expected Festival listings.
- `getExpectedFestivals()`: Private method that returns the expected Festival listings as a string.
- `getFestivalsAsList()`: Private method that returns the expected Festival listings as a list of Festival objects.

## Here are some test cases that can be used to test the `testFestivalListingsAndroid()` method:

- Test Case 1: Verify that all the expected bands are present in their respective festivals.

  Test Steps:
    1. Get the expected Festivals from `getFestivalsAsList()` method.
    2. Iterate over each festival in the expected festivals list.
    3. For each festival, iterate over each band in the festival's bands list.
    4. Verify that the band is present in the corresponding festival using `getFestivals()` method.

  Expected Result: All the expected bands should be present in their respective festivals.

- Test Case 2: Verify that the festival names and band titles are visible on the UI.

  Test Steps:
    1. Get the expected Festivals from `getFestivalsAsList()` method.
    2. Iterate over each festival in the expected festivals list.
    3. For each festival, iterate over each band in the festival's bands list.
    4. Verify that the band is present in the corresponding festival using `getFestivals()` method.
    5. Verify that the festival name and band title are visible on the UI.

  Expected Result: The festival names and band titles should be visible on the UI.

- Test Case 3: Verify that the expected and actual band names are equal.

  Test Steps:
    1. Get the expected Festivals from `getFestivalsAsList()` method.
    2. Iterate over each festival in the expected festivals list.
    3. For each festival, iterate over each band in the festival's bands list.
    4. Verify that the band is present in the corresponding festival using `getFestivals()` method.
    5. Verify that the expected and actual band names are equal.

  Expected Result: The expected and actual band names should be equal.

- Test Case 4: Verify that the expected and actual festival names are equal.

  Test Steps:
    1. Get the expected Festivals from `getFestivalsAsList()` method.
    2. Iterate over each festival in the expected festivals list.
    3. For each festival, iterate over each band in the festival's bands list.
    4. Verify that the band is present in the corresponding festival using `getFestivals()` method.
    5. Verify that the expected and actual festival names are equal.

  Expected Result: The expected and actual festival names should be equal.


## Test cases for the `getExpectedFestivals()` method:

1. Test that the method returns a non-empty string when a valid API endpoint is provided.
2. Test that the method throws an exception or returns an empty string when an invalid API endpoint is provided.
3. Test that the method returns a string in JSON format when a valid API endpoint is provided.
4. Test that the method returns a string that contains the expected data fields, such as `name` and `bands`.
5. Test that the method returns a string that conforms to the expected data format, such as having a top-level JSON object that contains an array of festival objects.


## Test Coverage

Test cases for the `testFestivalListingsiOS` method:

1. Verify that the method does not throw any exceptions when executed with valid input data.
2. Verify that the `getFestivalsAsList()` method is called exactly once and returns a non-null list of festivals.
3. Verify that the list of festivals is filtered to remove any null festivals.
4. Verify that the list of festivals is sorted in alphabetical order by festival name.
5. Verify that the `FestivalPage` instance is created with a non-null `wait` object.
6. Verify that the `SoftAssert` instance is created and used correctly to handle assertions.
7. Verify that the `swipe` method is called with valid input parameters for each festival band in the festivals list.
8. Verify that the `getFestivals` method of the `FestivalPage` instance is called with valid input parameters for each festival band in the festivals list.
9. Verify that the `getFestivals` method returns a non-empty `Optional` object for each festival band in the festivals list.
10. Verify that the `title` and `name` properties of the `FestivalBand` object returned by the `getFestivals` method match the expected values for each festival band in the festivals list.
11. Verify that the `swipe` method is called with valid input parameters for any festival bands that were not found on the first attempt.
12. Verify that the `getFestivals` method of the `FestivalPage` instance is called again with valid input parameters for any festival bands that were not found on the first attempt.
13. Verify that the `getFestivals` method returns a non-empty `Optional` object for any festival bands that were not found on the first attempt.
14. Verify that the `title` and `name` properties of the `FestivalBand` object returned by the `getFestivals` method match the expected values for any festival bands that were not found on the first attempt.
15. Verify that the `assertAll` method of the `SoftAssert` instance is called exactly once at the end of the method execution.
