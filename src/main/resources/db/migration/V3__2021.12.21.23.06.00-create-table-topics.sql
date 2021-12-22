CREATE TABLE topic (
    id serial primary key,
    title varchar(200),
    message text,
    course_id integer references course (id),
    author_id integer references author (id), 
    created_at timestamp,
    status varchar
    
);

INSERT INTO topic (title, message, course_id, author_id, created_at, status) 
    VALUES ('Why is this not compiling?', 'This piece of code is not running', 1, 1, now(), 'NAO_RESPONDIDO')
