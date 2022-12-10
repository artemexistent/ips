DROP TABLE barber CASCADE;
DROP TABLE day CASCADE;
DROP TABLE place CASCADE;
DROP TABLE users CASCADE;
DROP TABLE day_of_works CASCADE;
DROP TABLE book CASCADE;

CREATE TABLE barber
(
    id          serial primary key,
    barber_name VARCHAR(64) NOT NULL,
    rating      integer     NOT NULL,
    cost        integer     NOT NULL,
    place_id    integer
);
CREATE TABLE day
(
    id   serial primary key,
    date date NOT NULL
);
CREATE TABLE place
(
    id        serial primary key,
    address   VARCHAR(64) NOT NULL,
    barber_id integer
);
CREATE TABLE users
(
    id           serial primary key,
    user_id      integer     NOT NULL,
    user_name    VARCHAR(64) NOT NULL,
    phone_number VARCHAR(64) NOT NULL
);
CREATE TABLE day_of_works
(
    id        serial primary key,
    barber_id integer NOT NULL,
    day_id    integer NOT NULL
);
CREATE TABLE book
(
    id        serial primary key,
    user_id   integer NOT NULL,
    barber_id integer NOT NULL,
    day_id    integer NOT NULL,
    time_id   integer NOT NULL
);

ALTER TABLE book
    ADD FOREIGN KEY (user_id)
        REFERENCES users (id);
ALTER TABLE book
    ADD FOREIGN KEY (barber_id)
        REFERENCES barber (id);
ALTER TABLE book
    ADD FOREIGN KEY (day_id)
        REFERENCES day (id);

ALTER TABLE day_of_works
    ADD FOREIGN KEY (barber_id)
        REFERENCES barber (id);
ALTER TABLE day_of_works
    ADD FOREIGN KEY (day_id)
        REFERENCES day (id);

ALTER TABLE barber
    ADD FOREIGN KEY (place_id)
        REFERENCES place (id);

INSERT INTO place(address)
VALUES ('first'),
       ('first1'),
       ('first2'),
       ('first3'),
       ('first4');

INSERT INTO barber(barber_name, rating, cost, place_id)
VALUES ('Artem', 5, 100, 1),
       ('Dima', 4, 200, 1),
       ('Eugene', 3, 150, 3);

INSERT INTO day(date)
VALUES ('2017-03-14'),
       ('2017-04-14'),
       ('2017-05-14'),
       ('2017-06-14');

INSERT INTO day_of_works(barber_id, day_id)
VALUES (1, 1),
       (2, 3),
       (3, 3);