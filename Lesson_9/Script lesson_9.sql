
drop database spring_lesson_9;
create database spring_lesson_9;
use spring_lesson_9;
create table products (id serial, title varchar(50) unique not null, price int not null);



insert into products (title, price) values ('apple', 10), ('banana', 34), ('pineapple', 631), ('milk', 78), ('bread', 31), 
										   ('meat', 78), ('chiken', 84), ('pork', 12), ('watermeloon', 78), ('chease', 78), 
                                           ('kiwi', 78), ('potatoes', 84), ('cucumber', 12), ('tomato', 78), ('avokado', 78), 
                                           ('apricot', 78), ('peach', 84), ('mango', 12), ('orange', 78), ('eggs', 78);

