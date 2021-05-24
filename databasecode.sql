CREATE SCHEMA SEP;

SET SCHEMA 'sep';

--entities

CREATE TABLE role (
    id SERIAL PRIMARY KEY ,
    role_name VARCHAR (50)
);
CREATE TABLE branch (
    id SERIAL PRIMARY KEY ,
    name VARCHAR (500) NOT NULL,
    location VARCHAR (500)
);

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(800) NOT NULL,
    surname VARCHAR (40) NOT NULL,
    role_id INTEGER,
    branch_id INTEGER,
    username VARCHAR (30) NOT NULL,
    password VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (branch_id) REFERENCES branch (id)
);




CREATE TABLE car (
    id SERIAL PRIMARY KEY ,
    make VARCHAR (30) NOT NULL ,
    model VARCHAR (50) NOT NULL ,
    color VARCHAR (30) NOT NULL ,
    number_plates VARCHAR (10) NOT NULL ,
    fuel_type VARCHAR (50) NOT NULL ,
    fuel_consumption VARCHAR (50) NOT NULL ,
    seats INTEGER NOT NULL CHECK (seats > 0 AND seats < 100),
    engine VARCHAR (300) NOT NULL ,
    transmission VARCHAR (300) NOT NULL ,
    equipment VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    branch_id INTEGER NOT NULL,
    daily_price NUMERIC NOT NULL CHECK (daily_price > 0),
    FOREIGN KEY (branch_id) REFERENCES branch (id)
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY ,
    name VARCHAR (800) NOT NULL ,
    surname VARCHAR (40) NOT NULL ,
    drivers_licence VARCHAR (50) NOT NULL ,
    address_street VARCHAR (100) NOT NULL ,
    address_city VARCHAR (100) NOT NULL ,
    address_zip VARCHAR (12) NOT NULL ,
    address_country VARCHAR (100) NOT NULL ,
    car_id INTEGER NOT NULL ,
    start_branch_id INTEGER NOT NULL ,
    end_branch_id INTEGER NOT NULL ,
    start_date DATE NOT NULL ,
    end_date DATE NOT NULL ,
    price NUMERIC NOT NULL ,
    FOREIGN KEY (car_id) references car (id),
    FOREIGN KEY (start_branch_id) references branch (id),
    FOREIGN KEY (end_branch_id) references  branch (id)
);