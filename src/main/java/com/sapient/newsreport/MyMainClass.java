package com.sapient.newsreport;

import java.io.File;

public class MyMainClass {

    public static void main(String[] args) {
        // Specify the path to the directory
        String directoryPath = "D:\\Users\\cache\\aniket";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            // If the directory does not exist, create it
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.out.println("Failed to create directory: " + directoryPath);
                return;
            }
        } else {
            System.out.println("Directory already exists: " + directoryPath);
        }

        // List files in the directory
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            System.out.println("Files in directory:");
            for (File file : files) {
                System.out.println(file.getName() + (file.isDirectory() ? " [Directory]" : ""));
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        // Accessing a specific file in the directory
        String fileName = "example.txt"; // Change this to the name of the file you want to access
        File specificFile = new File(directory, fileName);

        // Check if the file exists and read its content
        if (specificFile.exists()) {
            System.out.println("Accessing file: " + specificFile.getAbsolutePath());
            // You can read the file content
        }
    }}