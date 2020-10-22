package com.orangehrmlive.dataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orangehrmlive.annotation.Source;
import com.orangehrmlive.model.JobTitle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProviders {
    private static final Logger logger = LoggerFactory.getLogger(DataProvider.class);
    private static final String FILE_PATH = "src/test/resources/data/";

    @DataProvider
    public static Iterator<Object[]> getJobTitles(Method method) {
        List<JobTitle> jobTitles = new ArrayList<>();
        if (method.isAnnotationPresent(Source.class)) {
            Source annotation = method.getAnnotation(Source.class);
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + annotation.value()))) {
                String line = reader.readLine();
                StringBuilder builder = new StringBuilder();
                switch (annotation.type()) {
                    case JSON:
                        while (line != null) {
                            builder.append(line);
                            line = reader.readLine();
                        }
                        jobTitles = new ObjectMapper().readValue(builder.toString(), new TypeReference<List<JobTitle>>() {
                        });
                        logger.info("Job Titles are successfully retrieved from JSON-file '" + annotation.value() + "'");
                        break;
                    default:
                        throw new RuntimeException("Unrecognized file type '" + annotation.type() + "'");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jobTitles.stream()
                        .map(jobTitle -> new Object[]{jobTitle})
                        .collect(Collectors.toList())
                        .iterator();
    }
}
