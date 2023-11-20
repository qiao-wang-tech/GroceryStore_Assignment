package edu.sdccd.cisc191.template;

import java.io.*;

public class GroceryIOLab {
    //Reads the grocery items and list their name, price, and if they're organic.
    public static String readTestResults(String file) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new
                FileReader("src/main/resources/" + file))) {
            String line;
            while (
                    (line = br.readLine()) != null) {
                result.append(line.trim()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return result.toString().trim();
    }

    //Adds additional grocery items to the Prices.csv
    public static void appendTestResult(String file, String addToFile) {
        try (BufferedWriter bw = new BufferedWriter(new
                FileWriter("src/main/resources/" + file, true))) {
            bw.write(addToFile + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}