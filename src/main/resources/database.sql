CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF exists favorite_heroes_users;
DROP TABLE IF exists heroes;
DROP TABLE IF exists users;

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    full_name VARCHAR(128),
    name VARCHAR(64) UNIQUE,
    password VARCHAR(64),
    hierarchy VARCHAR(32)
);

CREATE TABLE heroes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE favorite_heroes_users (
    -- id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    hero_id UUID NOT NULL,
    PRIMARY KEY (user_id, hero_id)
);
-- CREATE UNIQUE INDEX "rule_unique:favorite_heroes_users.user_hero" ON favorite_heroes_users(user_id, hero_id);


-- Seeds.
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 01', 'username01', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 02', 'username02', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 03', 'username03', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 04', 'username04', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 05', 'username05', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 06', 'username06', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 07', 'username07', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 08', 'username08', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 09', 'username09', '123');
INSERT INTO users (id, full_name, name, password) VALUES (gen_random_uuid(), 'Full name 10', 'username10', '123');