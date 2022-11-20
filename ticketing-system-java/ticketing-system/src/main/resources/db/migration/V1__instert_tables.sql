drop database if exists ticketing_system;
create database ticketing_system;

CREATE TABLE IF NOT EXISTS "groups"(
                         id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS "users" (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    is_manager BOOLEAN NOT NULL,
    group_id INTEGER NOT NULL,
    CONSTRAINT fk_group_id FOREIGN KEY(group_id) REFERENCES groups(id)
);

CREATE TABLE IF NOT EXISTS "tickets"(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    priority VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    resolution VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by INTEGER NOT NULL,
    assignee INTEGER NOT NULL,
    CONSTRAINT fk_created_by FOREIGN KEY(created_by) REFERENCES users(id),
    CONSTRAINT fk_assignee FOREIGN KEY(assignee) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS "comments"(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    text TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id INTEGER NOT NULL,
    ticket_id INTEGER NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_ticket_id FOREIGN KEY(ticket_id) REFERENCES tickets(id)
);

CREATE TABLE IF NOT EXISTS "attachments"(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    file_path VARCHAR(255) NOT NULL,
    uploaded_at TIMESTAMP NOT NULL,
    ticket_id INTEGER NOT NULL,
    CONSTRAINT fk_ticket_id FOREIGN KEY(ticket_id) REFERENCES tickets(id)
);