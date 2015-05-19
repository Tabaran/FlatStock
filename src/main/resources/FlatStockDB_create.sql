-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-05-19 18:12:26.09




-- tables
-- Table: Cusumers
CREATE TABLE Cusumers (
    id int  NOT NULL,
    first_name varchar(100)  NOT NULL,
    last_name varchar(100)  NOT NULL,
    email varchar(254)  NOT NULL,
    photo_url varchar(400)  NOT NULL,
    CONSTRAINT Cusumers_pk PRIMARY KEY (id)
);



-- Table: Flats
CREATE TABLE Flats (
    id int  NOT NULL,
    address varchar(400)  NOT NULL,
    room_number int  NOT NULL,
    floor int  NOT NULL,
    price money  NOT NULL,
    available boolean  NOT NULL,
    rating int  NOT NULL,
    photo_url varchar(400)  NOT NULL,
    owner_id int  NOT NULL,
    type varchar(100)  NOT NULL,
    description text  NOT NULL,
    CONSTRAINT Flats_pk PRIMARY KEY (id)
);



-- Table: Owners
CREATE TABLE Owners (
    id int  NOT NULL,
    first_name varchar(100)  NOT NULL,
    last_name varchar(100)  NOT NULL,
    email varchar(254)  NOT NULL,
    photo_url varchar(200)  NOT NULL,
    CONSTRAINT Owners_pk PRIMARY KEY (id)
);



-- Table: Reservation
CREATE TABLE Reservation (
    id int  NOT NULL,
    cusumer_id int  NOT NULL,
    flat_id int  NOT NULL,
    start_time time  NOT NULL,
    end_time time  NOT NULL,
    CONSTRAINT Reservation_pk PRIMARY KEY (id)
);







-- foreign keys
-- Reference:  Flats_Owners (table: Flats)


ALTER TABLE Flats ADD CONSTRAINT Flats_Owners 
    FOREIGN KEY (owner_id)
    REFERENCES Owners (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Reservation_Cusumers (table: Reservation)


ALTER TABLE Reservation ADD CONSTRAINT Reservation_Cusumers 
    FOREIGN KEY (cusumer_id)
    REFERENCES Cusumers (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Reservation_Flats (table: Reservation)


ALTER TABLE Reservation ADD CONSTRAINT Reservation_Flats 
    FOREIGN KEY (flat_id)
    REFERENCES Flats (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;






-- End of file.

