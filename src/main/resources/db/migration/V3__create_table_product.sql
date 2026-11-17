CREATE TABLE product(
    id BIGSERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    description text,
    price NUMERIC(10, 2) NOT NULL
);