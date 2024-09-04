package com.collaborativeapp;

import java.util.Scanner;

public class User {
    private final DocumentService documentService;
    private final Scanner scanner;

    public User(DocumentService documentService, Scanner scanner) {
        this.documentService = documentService;
        this.scanner = scanner;
    }

    public void login() {
        System.out.println("User Login/Register");
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        if (!documentService.isUserRegistered(username)) {
            System.out.println("User not found, registering new user.");
            documentService.registerUser(username);
        }
        userMenu(username);
    }

    private void userMenu(String username) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View All Documents");
            System.out.println("2. Search Document");
            System.out.println("3. Apply for Document Editing");
            System.out.println("4. Edit Document");
            System.out.println("5. Logout");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewAllDocuments();
                    break;
                case "2":
                    searchDocument();
                    break;
                case "3":
                    applyForDocument(username);
                    break;
                case "4":
                    editDocument(username);
                    break;
                case "5":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void viewAllDocuments() {
        documentService.getAllDocuments().forEach(System.out::println);
    }

    private void searchDocument() {
        System.out.println("Enter document name to search:");
        String name = scanner.nextLine();
        documentService.searchDocuments(name).forEach(System.out::println);
    }

    private void applyForDocument(String username) {
        System.out.println("Enter document ID to apply for editing:");
        int id = Integer.parseInt(scanner.nextLine());
        if (documentService.applyForDocument(id, username)) {
            System.out.println("Application successful.");
        } else {
            System.out.println("Document not found or already applied.");
        }
    }

    private void editDocument(String username) {
        System.out.println("Enter document ID to edit:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new content:");
        String content = scanner.nextLine();
        if (documentService.editDocument(id, username, content)) {
            System.out.println("Document edited successfully.");
        } else {
            System.out.println("Editing failed. Ensure you have applied for this document.");
        }
    }
}
