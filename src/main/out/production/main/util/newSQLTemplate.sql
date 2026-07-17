/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  orian
 * Created: Jul 15, 2026
 */

create database easystay;
use easystay;
create table customer(
	customer_id int auto_increment primary key,
    name varchar(50) not null,
    nic varchar(12) not null,
    phone varchar(10) not null,
    email varchar(30) not null
);
create table user(
	user_id int auto_increment primary key,
    username varchar(50) not null,
    email varchar(30) ,
    password varchar(30) not null
);
alter table user add column name varchar(50);
alter table customer add column dob date ;
select * from customer;
create table room(
	room_id int auto_increment primary key,
    room_number varchar(5) NOT NULL,
    room_type varchar(30) NOT NULL,
    price decimal(10,2) NOT NULL,
    room_status boolean default false
    );

create table reservation(
	reservation_id int auto_increment primary key,
    customer_id int ,
    room_id int,
    check_in datetime NOT NULL,
    check_out datetime,
    total_amount decimal(10,2),
    Constraint fk_customer foreign key (customer_id) references customer(customer_id),
    constraint fk_room foreign key (room_id) references room(room_id)
);
ALTER TABLE reservation 
MODIFY check_in datetime NULL;
create table payment(
	payment_id int auto_increment primary key,
    reservation_id int,
    amount decimal(10,2) not null,
    payment_datetime datetime not null,
    method varchar(20) not null,
    constraint fk_reservation foreign key (reservation_id)references reservation(reservation_id)
);
select * from user;
select * from customer;
insert into user  (username,email,password, name) VALUES ('REC001','jhonDoe@gmail.com','rep001psswd','Jhon Doe');
INSERT INTO room (room_number, room_type, price, room_status)
VALUES
('101', 'Single', 4500.00, TRUE),
('102', 'Single', 4500.00, FALSE),
('103', 'Double', 6500.00, TRUE),
('104', 'Double', 6500.00, FALSE),
('105', 'Deluxe', 8500.00, TRUE),
('106', 'Deluxe', 8500.00, FALSE),
('107', 'Suite', 12000.00, TRUE),
('108', 'Suite', 12000.00, FALSE),
('201', 'Single', 4700.00, TRUE),
('202', 'Double', 6700.00, FALSE),
('203', 'Deluxe', 9000.00, TRUE),
('204', 'Suite', 13000.00, FALSE),
('205', 'Family', 10000.00, TRUE),
('206', 'Family', 10000.00, FALSE),
('301', 'Presidential', 25000.00, TRUE);

SELECT 
    r.reservation_id,
    c.name AS customer_name,
    c.nic,
    c.phone,
    rm.room_number,
    rm.room_type,
    rm.price,
    r.check_in,
    r.check_out,
    r.total_amount
FROM reservation r
JOIN customer c 
ON r.customer_id = c.customer_id
JOIN room rm
ON r.room_id = rm.room_id;