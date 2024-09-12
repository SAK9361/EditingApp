INSERT INTO users (username) VALUES ('Alice');
INSERT INTO users (username) VALUES ('Bob');
INSERT INTO documents (name, content, status) VALUES ('Project Plan', 'Initial draft content', 'Draft');
INSERT INTO documents (name, content, status) VALUES ('Design Specs', 'Design specification content', 'Reviewed');
INSERT INTO comments (document_id, user_id, comment_text) VALUES (1, 1, 'This is a comment on the project plan.');
INSERT INTO tags (document_id, tag) VALUES (1, 'planning');
INSERT INTO tags (document_id, tag) VALUES (1, 'project management');
