-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-05-31 14:46:06.172




-- tables
-- Table: Apartment
CREATE TABLE Apartment (
    apartment_id int  NOT NULL,
    user_id int  NOT NULL,
    address varchar(400)  NOT NULL,
    room_number int  NOT NULL,
    floor int  NOT NULL,
    price int  NOT NULL,
    rating int  NOT NULL,
    photo_url varchar(400)  NOT NULL,
    type varchar(100)  NOT NULL,
    description text  NOT NULL,
    square int  NOT NULL,
    CONSTRAINT Apartment_pk PRIMARY KEY (apartment_id)
);



-- Table: Reservation
CREATE TABLE Reservation (
    res_id int  NOT NULL,
    user_id int  NOT NULL,
    apartment_id int  NOT NULL,
    start_time time  NOT NULL,
    end_time time  NOT NULL,
    CONSTRAINT Reservation_pk PRIMARY KEY (res_id)
);



-- Table: Users
CREATE TABLE Users (
    id int  NOT NULL,
    first_name varchar(100)  NOT NULL,
    last_name varchar(100)  NOT NULL,
    gender boolean  NOT NULL,
    email varchar(254)  NOT NULL,
    login varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    photo_url varchar(400)  NOT NULL,
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
    REFERENCES Apartment (apartment_id)
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






-- End of file.

