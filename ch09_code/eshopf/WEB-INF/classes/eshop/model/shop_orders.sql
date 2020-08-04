USE shop;
create table shop.order_details (
  id double precision not null auto_increment unique,
  book_id integer,
  title varchar(70),
  author varchar(70),
  quantity integer,
  price double precision,
  order_id double precision,
  primary key (id)
  );
create table shop.orders (
  order_id double precision not null auto_increment unique,
  delivery_name varchar(70),
  delivery_address varchar(70),
  cc_name varchar(70),
  cc_number varchar(32),
  cc_expiry varchar(20),
  primary key (order_id)
  );
create index order_details_id_key on shop.order_details (id);
alter table shop.order_details add index order_id (order_id),
  add constraint order_id foreign key (order_id)
  references shop.orders (order_id)
  ;
create index order_id_key on shop.orders (order_id);
