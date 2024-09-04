package com.collaborativeapp;

import java.util.*;

public class DataStore {
    private int documentCounter = 1;
    private final Map<Integer, Document> documents = new HashMap<>();
    private final Set<String> users = new HashSet<>();
    private final Map<Integer, List<String>> documentApplications = new HashMap<>();

    public int generateDocumentId() {
        return documentCounter++;
    }

    public void addDocument(Document document) {
        documents.put(document.getId(), document);
        documentApplications.put(document.getId(), new ArrayList<>());
    }

    public List<Document> getDocuments() {
        return new ArrayList<>(documents.values());
    }

    public Document getDocumentById(int id) {
        return documents.get(id);
    }

    public boolean removeDocument(int id) {
        if (documents.containsKey(id)) {
            documents.remove(id);
            documentApplications.remove(id);
            return true;
        }
        return false;
    }

    public void addUser(String username) {
        users.add(username);
    }

    public boolean isUserRegistered(String username) {
        return users.contains(username);
    }

    public void applyUserForDocument(int documentId, String username) {
        documentApplications.get(documentId).add(username);
    }

    public List<String> getAppliedUsers(int documentId) {
        return documentApplications.get(documentId);
    }
}
