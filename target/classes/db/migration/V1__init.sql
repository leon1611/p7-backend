CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(100) UNIQUE NOT NULL,
    email         VARCHAR(150) UNIQUE NOT NULL,
    password_hash TEXT                NOT NULL,
    is_active     BOOLEAN   DEFAULT TRUE,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO users (username, email, password_hash, is_active, created_at)
VALUES ('jdoe', 'jdoe@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('msmith', 'msmith@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('ajones', 'ajones@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('lwilson', 'lwilson@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('klopez', 'klopez@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('dgarcia', 'dgarcia@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('mthomas', 'mthomas@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('ebrown', 'ebrown@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('rlee', 'rlee@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW()),
       ('hmartin', 'hmartin@example.com', '3c59dc048e8850243be8079a5c74d079', TRUE, NOW());
