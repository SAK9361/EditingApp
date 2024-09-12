CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL
);

CREATE TABLE documents (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    content TEXT,
    status VARCHAR(50) DEFAULT 'Draft'
);

CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    document_id INT,
    user_id INT,
    comment_text TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (document_id) REFERENCES documents(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE tags (
    id INT PRIMARY KEY AUTO_INCREMENT,
    document_id INT,
    tag VARCHAR(100),
    FOREIGN KEY (document_id) REFERENCES documents(id)
);

CREATE TABLE document_status (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status_name VARCHAR(50) NOT NULL
);
