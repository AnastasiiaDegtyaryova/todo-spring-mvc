CREATE DATABASE IF NOT EXISTS todo DEFAULT CHARACTER SET utf8mb4;

USE todo;

DROP TABLE IF EXISTS task;

CREATE TABLE task (
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(255) NOT NULL,
  status INT NOT NULL,
  assigned_to VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO task (id, description, status, assigned_to) VALUES
(1, 'Fix login bug', 1, 'Anna'),
(2, 'Update user profile UI', 2, 'Dmytro'),
(3, 'Write database migration script', 0, 'Serhii'),
(4, 'Create new registration form', 1, 'Iryna'),
(5, 'Refactor TaskService', 2, 'Oleksandr'),
(6, 'Write unit tests', 0, 'Danylo'),
(7, 'Prepare project for demo', 1, 'Kateryna'),
(8, 'Document API endpoints', 2, 'Nazar'),
(9, 'Add pagination support', 0, 'Oksana'),
(10, 'Deploy app to staging', 1, 'Taras'),
(11, 'Fix broken links', 2, 'Yulia'),
(12, 'Improve error messages', 0, 'Ivan'),
(13, 'Add logging with SLF4J', 1, 'Maria'),
(14, 'Setup Docker Compose', 2, 'Andrii'),
(15, 'Fix null pointer in controller', 0, 'Natalia');
