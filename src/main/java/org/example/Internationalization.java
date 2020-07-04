package org.example;

import com.jayway.jsonpath.DocumentContext;

import java.io.*;
import java.util.Properties;

public class Internationalization {
    private static Internationalization instance = new Internationalization();

    private Properties properties;

    private DocumentContext  jsonContext;

    private Internationalization() {
        try (FileInputStream fileInputStream = new FileInputStream(String.format("src/test/resources/i18n/Variables.%s.properties",
                Environment.getInstance().getValue("language")))) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Internationalization getInstance() {
        return instance;
    }

    public String getValue(String value) {
        return properties.getProperty(value);
    }

}
