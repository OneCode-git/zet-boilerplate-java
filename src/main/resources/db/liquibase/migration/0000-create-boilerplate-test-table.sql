--liquibase formatted sql
/*
  Created on: 0000-00-00 (YYYYY-MM-DD)
*/

--changeset pranjlpz:1
--comment demonstrating a test table creation
CREATE TABLE IF NOT EXISTS test (
  id BIGINT PRIMARY KEY,
  created_at DATETIME NOT NULL
);