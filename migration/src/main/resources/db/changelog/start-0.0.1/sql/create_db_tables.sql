CREATE TABLE contact
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    phone_number VARCHAR (32) NOT NULL,
    email VARCHAR (128) NOT NULL,
    profile_link TEXT
);

CREATE TABLE adress
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    contact_id BIGINT NOT NULL references contact(id),
    country_id BIGINT NOT NULL,
    city VARCHAR (255) NOT NULL,
    index INTEGER NOT NULL,
    street VARCHAR (255) NOT NULL,
    building VARCHAR (255) NOT NULL,
    flat VARCHAR (255) NOT NULL
);

CREATE TABLE medical_card
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    client_status CHAR NOT NULL,
    med_status CHAR NOT NULL,
    registry_dt DATE NOT NULL,
    comment TEXT
);

CREATE TABLE illness
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    medical_card_id BIGINT NOT NULL references medical_card(id),
    type_id BIGINT NOT NULL,
    heaviness CHAR NOT NULL,
    appearance_dttm TIMESTAMP NOT NULL,
    recovery_dt date
);

CREATE TABLE person_data
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR (255) NOT NULL,
    last_name VARCHAR (255) NOT NULL,
    birth_dt DATE NOT NULL,
    age SMALLINT NOT NULL,
    sex CHAR NOT NULL,
    contact_id BIGINT NOT NULL references adress(id),
    medical_card_id BIGINT NOT NULL references medical_card(id),
    parent_id BIGINT NOT NULL references person_data(id)
);