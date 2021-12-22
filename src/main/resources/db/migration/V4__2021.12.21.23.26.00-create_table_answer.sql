CREATE TABLE answer (
    id serial primary key,
    message varchar(300),
    created_at timestamp,
    solved boolean,
    author_id integer references author (id),
    topic_id integer references topic (id)
);

