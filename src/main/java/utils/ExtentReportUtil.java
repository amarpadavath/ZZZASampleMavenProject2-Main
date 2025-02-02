package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports and the ExtentSparkReporter
    public static void initExtentReport() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports/extent-report.html");
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    // Start a test in the ExtentReport
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    // Flush the report after all tests
    public static void flushExtentReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Add logs to the ExtentTest
    public static void log(String message) {
        if (test != null) {
            test.info(message);
        }
    }

    public static void pass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }

    public static void fail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }
}
