CREATE TABLE city
(
    id                 UUID PRIMARY KEY,
    city               VARCHAR(100) NOT NULL,
    state              VARCHAR(100) NOT NULL,
    country            VARCHAR(100) NOT NULL,
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (city, state, country)
);