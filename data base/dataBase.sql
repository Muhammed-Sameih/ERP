DROP DATABASE IF EXISTS AccountingSystemDB;

CREATE DATABASE AccountingSystemDB;

USE AccountingSystemDB;


CREATE TABLE item (
    name VARCHAR(50) NOT NULL UNIQUE,
    price NUMERIC(8,2) NOT NULL,
    id INT(6) PRIMARY KEY AUTO_INCREMENT,
    is_deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE admin (
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) PRIMARY KEY NOT NULL,
    password VARCHAR(50) NOT NULL,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    is_supervisor BOOLEAN NOT NULL,
    phone_number int(11) Not Null UNIQUE,
    address VARCHAR(50)
);

CREATE TABLE client (
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE,
    TRN INT(9),
    address VARCHAR(50),
    phone_number int(11) PRIMARY KEY NOT NULL
);

CREATE TABLE invoice (
    status DATETIME DEFAULT CURRENT_TIMESTAMP PRIMARY KEY,
    admin_email VARCHAR(50) NOT NULL,
    client_phone_number int(11) Not Null,
    is_deleted BOOLEAN DEFAULT FALSE NOT NULL,
    FOREIGN KEY (admin_email) REFERENCES admin(email) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (client_phone_number) REFERENCES client(phone_number) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE invoice_include_item (
   item_id INT(6) Not Null,
   invoice_status DATETIME Not Null,
   number_of_item int(6) Not Null,
   FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE RESTRICT ON UPDATE CASCADE,
   FOREIGN KEY (invoice_status) REFERENCES invoice(status) ON DELETE RESTRICT ON UPDATE CASCADE,
   PRIMARY KEY(item_id , invoice_status)
);

CREATE TABLE user_CUD_user (
     supervisor_email VARCHAR(50) NOT NULL,
     user_email VARCHAR(50) NOT NULL,
     status DATETIME not null DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (supervisor_email) REFERENCES admin(email) ON DELETE RESTRICT ON UPDATE CASCADE,
     FOREIGN KEY (user_email) REFERENCES admin(email) ON DELETE RESTRICT ON UPDATE CASCADE,
     PRIMARY KEY(supervisor_email, user_email, status)
);

CREATE TABLE user_CU_client (
     client_phone_number int(11) NOT NULL,
     user_email VARCHAR(50) NOT NULL,
     status DATETIME not null DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (client_phone_number) REFERENCES client(phone_number) ON DELETE RESTRICT ON UPDATE CASCADE,
     FOREIGN KEY (user_email) REFERENCES admin(email) ON DELETE RESTRICT ON UPDATE CASCADE,
     PRIMARY KEY(client_phone_number, user_email, status)
);

CREATE TABLE user_CUD_item (
     item_id INT(6) NOT NULL,
     user_email VARCHAR(50) NOT NULL,
     status DATETIME not null DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE RESTRICT ON UPDATE CASCADE,
     FOREIGN KEY (user_email) REFERENCES admin(email) ON DELETE RESTRICT ON UPDATE CASCADE,
     PRIMARY KEY(item_id, user_email, status)
);