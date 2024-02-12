package ru.my.framework.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {

    private final Properties properties = new Properties();
    private static TestPropManager INSTANCE = null;

    private TestPropManager() {
        try {
            properties.load(new FileInputStream(String.format("src/main/resources/%s.properties",
                            System.getProperty("propFile", "application"))));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static TestPropManager getTestPropManager() {
        if (INSTANCE == null){
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key, String defValue){
        return properties.getProperty(key, defValue);
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
