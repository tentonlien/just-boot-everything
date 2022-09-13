CREATE DATABASE just_boot_everything DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- just-boot-sharding-jdbc

CREATE TABLE order_1
(
    `id`          INT,
    `name`        VARCHAR(128),
    `customer_id` INT,
    PRIMARY KEY (`id`)
);

CREATE TABLE order_2
(
    `id`          INT,
    `name`        VARCHAR(128),
    `customer_id` INT,
    PRIMARY KEY (`id`)
);