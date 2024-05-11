package com.springboot.automation.reporter.annotation.link;

import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class LinkProcessor {
    public static String testLink(ITestResult result) {
        ArrayList<String> links = new ArrayList<>();
        String testInfo;
        String linksAdjustment;
        try {
            Class<?> clazz = Class.forName(result.getInstanceName());
            Method method = clazz.getMethod(result.getMethod().getMethodName());
            Link[] methodLinks = method.getDeclaredAnnotationsByType(Link.class);

            if (methodLinks != null)
                for (Link annotation : methodLinks) {
                    String url = annotation.url();
                    System.out.println();
                    testInfo = "<a href=\"" + "https://dummyjson.com/" + url + "\" target=\"_blank\" rel=\"noopener noreferrer\">" + url + "</a>";
                    links.add(testInfo);
                }
            else {
                testInfo = "<b>TestCase link was not added!</b>";
                links.add(testInfo);
            }
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        linksAdjustment = String.valueOf(links).replace("[", "").replace("]", "");

        return linksAdjustment;
    }
}