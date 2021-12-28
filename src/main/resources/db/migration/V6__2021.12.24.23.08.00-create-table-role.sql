CREATE TABLE role (
    id serial primary key,
    name varchar(50)
);

INSERT INTO role (id, name) VALUES (1, 'READ_WRITE');
INSERT INTO role (id, name) VALUES (2, 'READ');
INSERT INTO role (id, name) VALUES (3, 'WRITE');
