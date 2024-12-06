package com.quest.property_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("config.properties")) {
            // Load the properties file
            properties.load(inputStream);

            // Accessing the properties
            String dbUrl = properties.getProperty("database.url");
            String dbUsername = properties.getProperty("database.username");
            String dbPassword = properties.getProperty("database.password");

            System.out.println("Database URL: " + dbUrl);
            System.out.println("Username: " + dbUsername);
            System.out.println("Password: " + dbPassword);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
