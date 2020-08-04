drop database shop;
create database shop;
create table shop.categories (
  category_id integer not null auto_increment unique,
  category_name varchar(70),
  primary key (category_id)
  );
create table shop.books (
  book_id integer not null auto_increment unique,
  title varchar(70),
  author varchar(70),
  price double precision,
  category_id integer,
  primary key (book_id)
  );
create index category_id_key on shop.categories (category_id);
create index book_id_key on shop.books (book_id);
alter table shop.books add index category_id (category_id),
  add constraint category_id foreign key (category_id)
  references shop.categories (category_id)
  ;
