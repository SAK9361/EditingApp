package com.collaborativeapp;

import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    private final DataStore dataStore;

    public DocumentService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void createDocument(String name) {
        dataStore.addDocument(new Document(dataStore.generateDocumentId(), name));
    }

    public List<Document> getAllDocuments() {
        return dataStore.getDocuments();
    }

    public List<Document> searchDocuments(String name) {
        List<Document> result = new ArrayList<>();
        for (Document doc : dataStore.getDocuments()) {
            if (doc.getName().contains(name)) {
                result.add(doc);
            }
        }
        return result;
    }

    public boolean deleteDocument(int id) {
        return dataStore.removeDocument(id);
    }

    public boolean applyForDocument(int id, String username) {
        Document document = dataStore.getDocumentById(id);
        if (document != null && !dataStore.getAppliedUsers(id).contains(username)) {
            dataStore.applyUserForDocument(id, username);
            return true;
        }
        return false;
    }

    public boolean editDocument(int id, String username, String content) {
        Document document = dataStore.getDocumentById(id);
        if (document != null && dataStore.getAppliedUsers(id).contains(username)) {
            document.setContent(content, username);
            return true;
        }
        return false;
    }

    public List<String> getUsersForDocument(int id) {
        return dataStore.getAppliedUsers(id);
    }

    public void registerUser(String username) {
        dataStore.addUser(username);
    }

    public boolean isUserRegistered(String username) {
        return dataStore.isUserRegistered(username);
    }
}
