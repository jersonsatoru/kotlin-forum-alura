ALTER TABLE author ADD COLUMN password text;

UPDATE author SET password = '$2a$12$1ZuWqfOXvMhDDkYLizoJhOpkhSxdu7sx9S7o00Ai.zzAEThLmhr4W' WHERE id = 1;
