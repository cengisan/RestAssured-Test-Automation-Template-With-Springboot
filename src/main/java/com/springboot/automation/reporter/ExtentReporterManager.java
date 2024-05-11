package com.springboot.automation.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.jupiter.api.BeforeAll;

public class ExtentReporterManager {

    @BeforeAll
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setReportName(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setJS("/* -- [ chart options ] -- */\n" +
                "            var options = {\n" +
                "              responsive: true,\n" +
                "              maintainAspectRatio: false,\n" +
                "              legend: {\n" +
                "                  position: \"right\",\n" +
                "                  labels: {\n" +
                "                      boxWidth: 10,\n" +
                "                      fontSize: 11,\n" +
                "                      lineHeight: 1,\n" +
                "                      fontFamily: \"Source Sans Pro\",\n" +
                "                      padding: 1\n" +
                "                  }\n" +
                "              },\n" +
                "              cutoutPercentage: 65\n" +
                "            };\n" +
                "\n" +
                "            function drawChart(ctx, config) {\n" +
                "                ctx.width = 100;\n" +
                "                ctx.height = 80;\n" +
                "                new Chart(ctx, config);\n" +
                "            }\n" +
                "\n" +
                "            /* -- [ parent chart ] -- */\n" +
                "            (function drawParentChart() {\n" +
                "                if (typeof statusGroup !== \"undefined\") {\n" +
                "                    var config = {\n" +
                "                        type: 'doughnut',\n" +
                "                            data: {\n" +
                "                                datasets: [{\n" +
                "                                    borderColor: 'transparent',\n" +
                "                                    data: [\n" +
                "                                        statusGroup.passParent, statusGroup.failParent, statusGroup.fatalParent, statusGroup.errorParent, statusGroup.warningParent, statusGroup.skipParent\n" +
                "                                    ],\n" +
                "                                    backgroundColor: [\n" +
                "                                        \"#00af00\", \"#F7464A\", \"#8b0000\", \"#ff6347\", \"#FDB45C\", \"#1e90ff\"\n" +
                "                                    ]\n" +
                "                                }],\n" +
                "                                labels: [ \"Pass\", \"Fail\", \"Fatal\", \"Error\", \"Warning\", \"Skip\" ]\n" +
                "                            },\n" +
                "                            options: options\n" +
                "                        };\n" +
                "\n" +
                "                        var ctx = document.getElementById(\"parent-analysis\").getContext('2d');\n" +
                "                        drawChart(ctx, config);\n" +
                "                }\n" +
                "            })();\n" +
                "\n" +
                "            /* -- [ children chart ] -- */\n" +
                "            (function drawChildChart() {\n" +
                "                if (typeof statusGroup !== \"undefined\" && statusGroup.childCount > 0) {\n" +
                "                    var config = {\n" +
                "                        type: 'doughnut',\n" +
                "                        data: {\n" +
                "                            datasets: [{\n" +
                "                                borderColor: 'transparent',\n" +
                "                                data: [\n" +
                "                                    statusGroup.passChild, statusGroup.failChild, statusGroup.fatalChild, statusGroup.errorChild, statusGroup.warningChild, statusGroup.skipChild,statusGroup.infoChild\n" +
                "                                ],\n" +
                "                                backgroundColor: [\n" +
                "                                    \"#00af00\", \"#F7464A\", \"#8b0000\", \"#ff6347\", \"#FDB45C\", \"#1e90ff\", \"#46BFBD\"\n" +
                "                                ]\n" +
                "                            }],\n" +
                "                            labels: [ \"Pass\", \"Fail\", \"Fatal\", \"Error\", \"Warning\", \"Skip\", \"Info\" ]\n" +
                "                        },\n" +
                "                        options: options\n" +
                "                    };\n" +
                "\n" +
                "                    var ctx = document.getElementById(\"child-analysis\").getContext('2d');\n" +
                "                    drawChart(ctx, config);\n" +
                "                }\n" +
                "            })();\n" +
                "\n" +
                "            /* -- [ grand-children chart ] -- */\n" +
                "            (function drawGrandChildChart() {\n" +
                "                if ($('#grandchild-analysis').length > 0 && typeof statusGroup !== \"undefined\" && statusGroup.grandChildCount > 0) {\n" +
                "                    var config = {\n" +
                "                        type: 'doughnut',\n" +
                "                        data: {\n" +
                "                            datasets: [{\n" +
                "                                borderColor: 'transparent',\n" +
                "                                data: [\n" +
                "                                    statusGroup.passGrandChild, statusGroup.failGrandChild, statusGroup.fatalGrandChild, statusGroup.errorGrandChild, statusGroup.warningGrandChild, statusGroup.skipGrandChild, statusGroup.infoGrandChild\n" +
                "                                ],\n" +
                "                                backgroundColor: [\n" +
                "                                    \"#00af00\", \"#F7464A\", \"#8b0000\", \"#ff6347\", \"#FDB45C\", \"#1e90ff\", \"#46BFBD\"\n" +
                "                                ]\n" +
                "                            }],\n" +
                "                            labels: [ \"Pass\", \"Fail\", \"Fatal\", \"Error\", \"Warning\", \"Skip\", \"Info\" ]\n" +
                "                        },\n" +
                "                        options: options\n" +
                "                    };\n" +
                "\n" +
                "                    var ctx = document.getElementById(\"grandchild-analysis\").getContext('2d');\n" +
                "                    drawChart(ctx, config);\n" +
                "                }\n" +
                "            })();\n" +
                "\n" +
                "            /* -- [ timeline ] -- */\n" +
                "            function getRandomColor() {\n" +
                "                var letters = '0123456789ABCDEF';\n" +
                "                var color = '#';\n" +
                "                for (var i = 0; i < 6; i++) {\n" +
                "                color += letters[Math.floor(Math.random() * 16)];\n" +
                "                }\n" +
                "                return color;\n" +
                "            }\n" +
                "\n" +
                "            (function drawTimelineChart() {\n" +
                "                if (typeof timeline !== \"undefined\") {\n" +
                "                    var datasets = [];\n" +
                "                    for (var key in timeline) {\n" +
                "                        datasets.push({ label:key, data:[timeline[key]], backgroundColor: getRandomColor(), borderWidth: 1 });\n" +
                "                    }\n" +
                "                    var ctx = document.getElementById('timeline').getContext('2d');\n" +
                "\n" +
                "                    new Chart(ctx, {\n" +
                "                        type: 'horizontalBar',\n" +
                "                        data: {\n" +
                "                            datasets: datasets\n" +
                "                        },\n" +
                "                        options: {\n" +
                "                            responsive: true,\n" +
                "                            maintainAspectRatio: false,\n" +
                "                            tooltips: {\n" +
                "                                mode: 'point'\n" +
                "                            },\n" +
                "                            scales: {\n" +
                "                                xAxes: [{\n" +
                "                                    stacked: true,\n" +
                "                                    gridLines: false\n" +
                "                                }],\n" +
                "                                yAxes: [{\n" +
                "                                    stacked: true,\n" +
                "                                    gridLines: false,\n" +
                "                                    barThickness: 25\n" +
                "                                }]\n" +
                "                            },\n" +
                "                            legend: {\n" +
                "                                display: false\n" +
                "                            }\n" +
                "                        }\n" +
                "                    });\n" +
                "                }\n" +
                "            })();");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("Test Coordinator", "Bilgütay Erdem");
        extentReports.setSystemInfo("Test Engineer", "Orcun Sarman");
        extentReports.setSystemInfo("Test Engineer", "Ahmet Emir Karakaş");
        extentReports.setSystemInfo("Test Engineer", "Cengizhan Uzuner");
        extentReports.setSystemInfo("Test Engineer", "Celal Can Şardan");
        extentReports.setSystemInfo("Test Engineer", "Aslıhan Bala");

        return extentReports;
    }
}
