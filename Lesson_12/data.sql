
drop database if exists Lesson_12;
create database Lesson_12;
use Lesson_12;

create table products (id serial, title varchar(50), price integer);

insert into products (title, price) values ('apple', 10), ('banana', 34), ('pineapple', 631), ('chiken', 84), ('pork', 12),
                                           ('potatoes', 84), ('cucumber', 12), ('tomato', 78);

create table categories (id serial, name varchar(50));

insert into categories (name) values ('meat'), ('vegetables'), ('fruits');

create table products_categories (product_id bigint, category_id bigint,
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id));
