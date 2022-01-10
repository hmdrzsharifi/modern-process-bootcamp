
CREATE TABLE employee (
    id SERIAL NOT NULL ,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) DEFAULT NULL,
    address varchar(100) DEFAULT NULL,
    email varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);