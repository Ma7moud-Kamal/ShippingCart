package org.example.services.impl;

import java.util.Scanner;

public class InputHandler {
    public static int getUserChoice(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            return choice;
        } else {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.nextLine(); // Consume the invalid input
            return -1; // Indicates invalid choice
        }
    }
}
