CREATE TABLE parking
(
    id           UUID PRIMARY KEY,
    client_id     UUID,
    vehicle_id    UUID,
    city_id       UUID,
    duration     bigint         NOT NULL,
    ticket_value DECIMAL(10, 2) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);