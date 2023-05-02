/**
 * @author [Muhammad Imran]
 * @email [muhammadghouseimran.zahirudeen@cognizant.com]
 * @create date 2023-05-02 08:40:17
 * @modify date 2023-05-02 08:40:17
 * @desc [Generate test execution report]
 */

package sample.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.sql.Time;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

public class ExtentReports implements ITestListener, ISuiteListener, IConfigurationListener {
    private com.aventstack.extentreports.ExtentReports extent;
    private ExtentTest test;
    private ExtentTest testCase;

    @Override
    public void onStart (final ISuite suite) {
        extent = new com.aventstack.extentreports.ExtentReports();
        final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Time time = new Time(System.currentTimeMillis());

        var spark = new ExtentSparkReporter ("target/EA_MOBILE_"+sdf1.format(time)+".html");
        extent.attachReporter (spark);
        extent.setSystemInfo ("os.name", System.getProperty ("os.name"));
        extent.setSystemInfo ("os.arch", System.getProperty ("os.arch"));
        extent.setSystemInfo ("os.version", System.getProperty ("os.version"));
    }

    @Override
    public void onConfigurationFailure (final ITestResult result) {
        test.fail (result.getThrowable ());
    }

    @Override
    public void onConfigurationSkip (final ITestResult result) {
        var cause = result.getSkipCausedBy ().get (0);
        test.warning (MessageFormat.format ("Skipped due to : {0}", cause.getMethodName ()));
    }

    @Override
    public void onFinish (final ISuite suite) {
        extent.flush ();
    }

    @Override
    public void onTestStart (final ITestResult result) {
        testCase = test.createNode (result.getName ());
    }

    @Override
    public void onTestSuccess (final ITestResult result) {
        testCase.pass (result.getName ());
    }

    @Override
    public void onTestFailure (final ITestResult result) {
        testCase.fail (result.getThrowable ());
    }

    @Override
    public void onTestSkipped (final ITestResult result) {
        var cause = result.getSkipCausedBy ().get (0);
        testCase.warning (MessageFormat.format ("Skipped due to : {0}", cause.getMethodName ()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage (final ITestResult result) {
        testCase.fail (result.getThrowable ());
    }

    @Override
    public void onTestFailedWithTimeout (final ITestResult result) {
        testCase.fail (result.getThrowable ());
    }

    @Override
    public void onStart (final ITestContext context) {
        test = extent.createTest (context.getName ());
        test.assignAuthor (System.getProperty ("user.name"));
    }

    @Override
    public void onFinish (final ITestContext context) {
        ITestListener.super.onFinish (context);
    }
}
