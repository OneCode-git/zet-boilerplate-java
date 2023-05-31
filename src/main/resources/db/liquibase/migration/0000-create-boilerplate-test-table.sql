-- liquibase formatted sql

CREATE TABLE IF NOT EXISTS test (
  id BIGINT PRIMARY KEY,
  created_at DATETIME NOT NULL
);