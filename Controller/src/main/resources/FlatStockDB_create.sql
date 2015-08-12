-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-05-31 14:46:06.172

CREATE TYPE gender AS ENUM ('male', 'female');
CREATE TYPE role AS ENUM ('customer', 'administrator');


-- tables
-- Table: Apartment
CREATE TABLE Apartment (
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
    CONSTRAINT Apartment_pk PRIMARY KEY (id)
);



-- Table: Reservation
CREATE TABLE Reservation (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    apartment_id int  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NOT NULL,
    CONSTRAINT Reservation_pk PRIMARY KEY (id)
);



-- Table: Users
CREATE TABLE Users (
    id serial  NOT NULL,
    first_name varchar(100)  NOT NULL,
    last_name varchar(100)  NOT NULL,
    gender gender,
    email varchar(254)  NOT NULL,
    login varchar(100)  NOT NULL UNIQUE,
    password varchar(100)  NOT NULL,
    role role NOT NULL DEFAULT 'customer',
    photo_url varchar(400),
    CONSTRAINT Users_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference:  Flats_Users (table: Apartment)


ALTER TABLE Apartment ADD CONSTRAINT Flats_Users 
    FOREIGN KEY (user_id)
    REFERENCES Users (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Reservation_Flats (table: Reservation)


ALTER TABLE Reservation ADD CONSTRAINT Reservation_Flats 
    FOREIGN KEY (apartment_id)
    REFERENCES Apartment (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Reservation_Users (table: Reservation)


ALTER TABLE Reservation ADD CONSTRAINT Reservation_Users 
    FOREIGN KEY (user_id)
    REFERENCES Users (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;


INSERT INTO Users (first_name, last_name, gender, email, login, password, role)
            VALUES ('admin', 'admin', 'male', 'admin@flatstock.com', 'admin', 'admin', 'administrator');



-- End of file.

