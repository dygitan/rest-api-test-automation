package com.github.tanpatrick;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@KarateOptions(tags = {"~@ignore"}, features = "classpath:features")
public class RestApiTestRunner {

    private static void generateReport(String karateOutputPath) throws Exception {
        List<String> jsonPaths = FileUtils
                .listFiles(new File(karateOutputPath), new String[]{"json"}, true).stream()
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());

        Configuration config = new Configuration(new File("results"), "rest-api-test-automation");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);

        try {
            reportBuilder.generateReports();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Test
    public void runMe() {
        try {
            Results results = Runner.parallel(getClass(), 1, "results/reports");
            generateReport(results.getReportDir());
            assertEquals(String.format("Test has %s failed test(s). %s", results.getFailCount(), results.getErrorMessages()), 0, results.getFailCount());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}