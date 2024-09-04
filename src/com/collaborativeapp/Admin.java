package com.collaborativeapp;

import java.util.Scanner;

public class Admin {
    private final DocumentService documentService;
    private final Scanner scanner;

    public Admin(DocumentService documentService, Scanner scanner) {
        this.documentService = documentService;
        this.scanner = scanner;
    }

    public void login() {
        System.out.println("Admin Login");
        // For simplicity, assume the admin login is successful
        adminMenu();
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Create Document");
            System.out.println("2. View All Documents");
            System.out.println("3. Delete Document");
            System.out.println("4. View Users Applied for a Document");
            System.out.println("5. Logout");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createDocument();
                    break;
                case "2":
                    viewAllDocuments();
                    break;
                case "3":
                    deleteDocument();
                    break;
                case "4":
                    viewUsersForDocument();
                    break;
                case "5":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void createDocument() {
        System.out.println("Enter document name:");
        String name = scanner.nextLine();
        documentService.createDocument(name);
        System.out.println("Document created successfully.");
    }

    private void viewAllDocuments() {
        documentService.getAllDocuments().forEach(System.out::println);
    }

    private void deleteDocument() {
        System.out.println("Enter document ID to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        if (documentService.deleteDocument(id)) {
            System.out.println("Document deleted successfully.");
        } else {
            System.out.println("Document not found.");
        }
    }

    private void viewUsersForDocument() {
        System.out.println("Enter document ID to view users:");
        int id = Integer.parseInt(scanner.nextLine());
        documentService.getUsersForDocument(id).forEach(System.out::println);
    }
}
