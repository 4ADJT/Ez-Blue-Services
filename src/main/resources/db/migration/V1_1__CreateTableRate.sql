CREATE TABLE rate
(
    id                 UUID PRIMARY KEY,
    city_id            UUID UNIQUE REFERENCES city (id),
    currency           VARCHAR(10)    NOT NULL,
    rate_value         DECIMAL(10, 2) NOT NULL,
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);