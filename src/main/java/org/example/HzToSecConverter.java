package org.example;

import java.util.Scanner;

public class HzToSecConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the frequency in Hertz as a string
        System.out.print("Enter a frequency in Hertz (e.g., 1/60): ");
        String input = scanner.nextLine();

        // Parse and evaluate the expression
        double frequencyHz;
        try {
            frequencyHz = evaluateExpression(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numerical frequency.");
            scanner.close();
            return;
        }

        // Calculate the conversion
        double seconds = 1.0 / frequencyHz;

        // Print the conversion steps
        System.out.println("Conversion from Hertz to seconds:");
        System.out.println("Frequency in Hertz: " + frequencyHz + " Hz");
        System.out.println("1 / Frequency in Hertz = 1 / " + frequencyHz + " Hz");
        System.out.println("Seconds = " + seconds + " s");

        // Close the scanner
        scanner.close();
    }

    private static double evaluateExpression(String input) {
        // Split the input by '/' to separate the numerator and denominator
        String[] parts = input.split("/");
        if (parts.length != 2) {
            throw new NumberFormatException();
        }

        // Parse and evaluate the expression
        double numerator = Double.parseDouble(parts[0]);
        double denominator = Double.parseDouble(parts[1]);

        if (denominator == 0.0) {
            throw new ArithmeticException();
        }

        return numerator / denominator;
    }
}
