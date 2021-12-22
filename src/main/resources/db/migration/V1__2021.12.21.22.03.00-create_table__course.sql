CREATE TABLE course (
    id serial primary key,
    name varchar(50),
    category varchar(50)
);

INSERT INTO course (name, category) VALUES ('Spring boot with Kotlin', 'Backend');
INSERT INTO course (name, category) VALUES ('Beautiful design with Flutter', 'Frontend');
