package com.springboot.automation.util;

import com.springboot.automation.reporter.ExtentReporterListener;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.output.WriterOutputStream;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.io.PrintStream;
import java.io.StringWriter;

public class TestBase extends AbstractTestNGSpringContextTests {

    public static StringWriter writer;
    public static PrintStream captor;

    @BeforeMethod
    public void logSetup(ITestResult result) {
        ExtentTest test = ExtentReporterListener.extentReports.createTest("TestCase : " + result.getMethod().getMethodName());
        ExtentReporterListener.testReport.set(test);
        writer = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writer), true);
    }
}
