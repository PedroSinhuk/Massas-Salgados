ALTER TABLE product
    ADD COLUMN category_id BIGINT REFERENCES category(id),
    ADD COLUMN filling_id BIGINT REFERENCES filling(id);