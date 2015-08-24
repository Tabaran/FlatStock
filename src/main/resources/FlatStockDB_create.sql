-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-05-31 14:46:06.172

CREATE TYPE gender AS ENUM ('male', 'female');
CREATE TYPE role AS ENUM ('customer', 'administrator');


-- tables
-- Table: Apartment
CREATE TABLE APARTMENTS (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    address varchar(400)  NOT NULL,
    room_number int  NOT NULL,
    floor int  NOT NULL,
    price int  NOT NULL,
    rating int,
    photo_url varchar(400),
    type varchar(100),
    description text  NOT NULL,
    square int,
    CONSTRAINT APARTMENTS_PK PRIMARY KEY (id)
);

-- Table: Reservation
CREATE TABLE RESERVATIONS (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    apartment_id int  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NOT NULL,
    CONSTRAINT RESERVATIONS_PK PRIMARY KEY (id)
);

-- Table: Users
CREATE TABLE USERS (
    id serial  NOT NULL,
    first_name varchar(100)  NOT NULL,
    last_name varchar(100)  NOT NULL,
    gender gender,
    email varchar(254)  NOT NULL,
    login varchar(100)  NOT NULL UNIQUE,
    password varchar(100)  NOT NULL,
    role role NOT NULL DEFAULT 'customer',
    photo_url varchar(400),
    CONSTRAINT USERS_PK PRIMARY KEY (id)
);

-- Table: Url
CREATE TABLE URLS
(
    id SERIAL PRIMARY KEY NOT NULL,
    url VARCHAR(400) NOT NULL,
    group_id int NOT NULL
);
ALTER TABLE URLS
ADD CONSTRAINT unique_url UNIQUE (url);

-- Table: AccessMap
CREATE TABLE ACCESS_TABLE
(
    group_id int  NOT NULL,
    role role
);

CREATE TABLE FUNCTIONAL_GROUPS
(
    id SERIAL PRIMARY KEY NOT NULL,
    group_name VARCHAR(400) NOT NULL,
    description TEXT
);
ALTER TABLE FUNCTIONAL_GROUPS
 ADD CONSTRAINT unique_group_name UNIQUE (group_name);


-- foreign keys
-- Reference:  Flats_Users (table: Apartment)


ALTER TABLE APARTMENTS ADD CONSTRAINT Flats_Users
    FOREIGN KEY (user_id)
    REFERENCES Users (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Access_Url (table: AccessMap)

ALTER TABLE ACCESS_TABLE ADD CONSTRAINT Access_Url
    FOREIGN KEY (group_id)
    REFERENCES functional_groups (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  Reservation_Flats (table: Reservation)

ALTER TABLE RESERVATIONS ADD CONSTRAINT Reservations_Flats
FOREIGN KEY (apartment_id)
REFERENCES Apartment (id)
NOT DEFERRABLE
INITIALLY IMMEDIATE
;

-- Reference:  Reservation_Users (table: Reservation)


ALTER TABLE RESERVATIONS ADD CONSTRAINT Reservation_Users
    FOREIGN KEY (user_id)
    REFERENCES Users (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

ALTER TABLE URLS ADD CONSTRAINT URLS_GROUPS
    FOREIGN KEY (group_id)
    REFERENCES FUNCTIONAL_GROUPS (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;


ALTER TABLE ACCESS_TABLE ADD CONSTRAINT access_groups
FOREIGN KEY (group_id)
REFERENCES FUNCTIONAL_GROUPS (id)
NOT DEFERRABLE
INITIALLY IMMEDIATE
;


-- End of file.