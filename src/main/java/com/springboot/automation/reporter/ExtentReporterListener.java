package com.springboot.automation.reporter;

import com.springboot.automation.reporter.annotation.description.DescriptionProcessor;
import com.springboot.automation.reporter.annotation.link.LinkProcessor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterListener implements ITestListener {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
    static String fileName = "Test Automation Report " + dateFormat.format(new Date()) + ".html";
    public static final ExtentReports extentReports = ExtentReporterManager.createInstance(System.getProperty("user.dir") + "\\test-output\\" + fileName);
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    @Override
    public void onTestSuccess(ITestResult result) {
        String testLinkLog = "<b>Test Case Link: </b>" + LinkProcessor.testLink(result);
        Markup test = MarkupHelper.createLabel(testLinkLog, ExtentColor.TRANSPARENT);
        testReport.get().log(Status.PASS, test);
        Markup description = MarkupHelper.createLabel(DescriptionProcessor.descriptionInfo(result), ExtentColor.TRANSPARENT);
        testReport.get().pass(description);

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testLinkLog = "<b>Test Case Link: </b>" + LinkProcessor.testLink(result);
        Markup test = MarkupHelper.createLabel(testLinkLog, ExtentColor.TRANSPARENT);
        testReport.get().log(Status.FAIL, test);
        Markup description = MarkupHelper.createLabel(DescriptionProcessor.descriptionInfo(result), ExtentColor.TRANSPARENT);
        testReport.get().log(Status.FAIL, description);
        testReport.get().fail(result.getThrowable());

        String failureLog = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testLinkLog = "<b>Test Case Link: </b>" + LinkProcessor.testLink(result);
        Markup test = MarkupHelper.createLabel(testLinkLog, ExtentColor.TRANSPARENT);
        testReport.get().log(Status.SKIP, test);
        Markup description = MarkupHelper.createLabel(DescriptionProcessor.descriptionInfo(result), ExtentColor.TRANSPARENT);
        testReport.get().skip(description);

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " SKIPPED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(m);
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public static void logInfo(String detail) {
        testReport.get().info(detail);
    }

    public void requestAndResponseReporter(String request, String response) {
        logInfo("---- REQUEST ----");
        apiAndLogFormatInReport(request);
        logInfo("---- RESPONSE ----");
        apiAndLogFormatInReport(response);
    }

    public void apiAndLogFormatInReport(String content) {
        String prettyPrint = content.replace("\n", "<br>");
        logInfo("<pre>" + prettyPrint + "</pre>");
    }

    public static void step(String stepName) {
        logInfo("<b> STEP: " + stepName.replace("\n", "<br>").toUpperCase() + ":</b>");
    }
}
