package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter the name of a story: ");
        String storyName = myScanner.nextLine();

        try {

            FileInputStream fis = new FileInputStream(storyName);
            //Reads input from file
            Scanner scanner = new Scanner(fis);
            int lineNumber = 1;

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.printf("%d: %s \n", lineNumber++, line);
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("We can't do that");
            e.printStackTrace();
        }
    }
}