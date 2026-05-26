CREATE TABLE clients (
    client_id Varchar(50) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    address TEXT,
    gender VARCHAR(10),
    status VARCHAR(20) DEFAULT 'ACTIVE'
);

INSERT INTO clients (client_id, username, password, full_name, surname, email, phone, address, gender, status)
VALUES
('CUS01', 'bob', 'bob1', 'John Mark', 'Mark', 'john@gmail.com', '0673459873', '21 mooi street JHB', 'Male', 'ACTIVE'),
('CUS02', 'peter', 'peter1', 'Paul Mcman', 'Mcman', 'paul@gmail.com', '0663452363', '101 good street PTA', 'Male', 'ACTIVE'),
('CUS03', 'josh', 'josh1', 'Sandra Moore', 'Moore','sandra@gmail.com', '0654231200','211 sandom street JHB', 'Female', 'ACTIVE'),
('CUS04', 'sam', 'sam1', 'Peter Zulu', 'Zulu','peter@gmail.com', '0697653473','301 nitye street JHB', 'Male', 'CLOSED'),
('CUS05', 'jack', 'jack1', 'Hazard Disman', 'Disman','hazard@gmail.com', '0634568765','91 mooi street CPT', 'Male', 'ACTIVE'),
;
