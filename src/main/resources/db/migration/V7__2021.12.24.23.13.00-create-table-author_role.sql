CREATE TABLE author_role (
    id serial primary key,
    author_id integer references author (id),
    role_id integer references role (id)
);

INSERT INTO author_role (author_id, role_id) VALUES (1, 1);
