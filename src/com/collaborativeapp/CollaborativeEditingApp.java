package com.collaborativeapp;

import java.util.Scanner;

public class CollaborativeEditingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataStore dataStore = new DataStore();
        DocumentService documentService = new DocumentService(dataStore);

        System.out.println("Welcome to the Collaborative Editing App!");

        while (true) {
            System.out.println("\nPlease choose a role: ");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Admin admin = new Admin(documentService, scanner);
                    admin.login();
                    break;
                case "2":
                    User user = new User(documentService, scanner);
                    user.login();
                    break;
                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
