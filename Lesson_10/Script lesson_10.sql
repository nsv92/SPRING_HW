
drop database spring_lesson_10;
create database spring_lesson_10;
use spring_lesson_10;
create table products (id serial, title varchar(50) unique not null, price int not null);

create table carts (id serial, customer varchar(50));
create table carts_details (cart_id BIGINT unsigned not null, product_id BIGINT unsigned not null, 
	foreign key (cart_id) references carts (id) on update cascade, 
    foreign key (product_id) references products (id) on update cascade);

create table hibernate_sequence (next_val bigint null);


insert into products (title, price) values ('apple', 10), ('banana', 34), ('pineapple', 631), ('milk', 78), ('bread', 31), 
										   ('meat', 78), ('chiken', 84), ('pork', 12), ('watermeloon', 78), ('chease', 78), 
                                           ('kiwi', 78), ('potatoes', 84), ('cucumber', 12), ('tomato', 78), ('avokado', 78), 
                                           ('apricot', 78), ('peach', 84), ('mango', 12), ('orange', 78), ('eggs', 78);
                                           
insert into carts (customer) values ('Bob'), ('Charly'), ('Alex');

