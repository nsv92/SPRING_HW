
drop database spring_lesson_6;
create database spring_lesson_6;
use spring_lesson_6;
create table customers (id serial, name varchar(50) unique not null);
create table products (id serial, title varchar(50) unique not null, price int not null);
create table sold (customer_id BIGINT unsigned not null, product_id BIGINT unsigned not null, 
	foreign key (customer_id) references customers (id) on update cascade, 
    foreign key (product_id) references products (id) on update cascade);
create table hibernate_sequence (next_val bigint null);

insert into customers (name) values ('alex'), ('bob'), ('john'), ('gary'), ('max');

insert into products (title, price) values ('apple', 10), ('banana', 34), ('pineapple', 631), ('milk', 78), ('bread', 31);

