package com.quest.property_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateProperties {
    public static void main(String[] args){
        Properties properties = new Properties();

        properties.setProperty("database.url", "mysql://localhost:3306/mydb");
        properties.setProperty("database.username", "root");
        properties.setProperty("database.password", "password123");

        try(FileOutputStream outputStream = new FileOutputStream("config.properties")){
            properties.store(outputStream, "Application configuration");
            System.out.println("Properties file created");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
