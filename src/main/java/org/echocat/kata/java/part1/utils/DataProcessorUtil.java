package org.echocat.kata.java.part1.utils;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.echocat.kata.java.part1.domain.Author;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class DataProcessorUtil {

    public static List<Author> getAllAuthors() throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Author.class)
                .withHeader()
                .withArrayElementSeparator(",")
                .withColumnSeparator(';')
                .withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(Author.class).with(schema);
        return reader.<Author>readValues(getFileStream("authors.csv")).readAll();
    }

    private static InputStream getFileStream(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResourceAsStream("org/echocat/kata/java/part1/data/".concat(fileName));
    }
}
