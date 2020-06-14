package org.echocat.kata.java.part1.utils;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Slf4j
public class DataProcessorUtil {

    public static <T> List<T> readData(Class<T> clazz, String fileName) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(clazz)
                .withHeader()
                .withArrayElementSeparator(",")
                .withColumnSeparator(';')
                .withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        try {
            return reader.<T>readValues(getFileStream(fileName)).readAll();
        } catch (IOException exception) {
            log.warn("CSV file parsing failed {}", exception.getMessage());
        }
        return Collections.emptyList();
    }

    private static InputStream getFileStream(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResourceAsStream("org/echocat/kata/java/part1/data/".concat(fileName));
    }
}
