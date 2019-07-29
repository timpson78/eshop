create table users
(
  id serial not null
    constraint users_id_pk
    primary key,
  email varchar not null,
  name varchar not null,
  password varchar not null,
  registred timestamp default now() not null,
  phone varchar,
  enabled boolean default true not null
);


create table items
(
  id serial not null,
  title varchar not null,
  short_description varchar,
  description varchar,
  url_seo varchar,
  images_id integer,
  price numeric(10,2),
  quantity integer,
  mesure  varchar,
  discount integer,
  partnumber varchar,
  weight numeric(5,2),
  brend_id integer,
  category_id integer,
  activity boolean,
  sales_hit boolean,
  new_item boolean,
  promotion boolean,
  properties_id integer,
  meta_data_id integer,
  recomended_item_id integer,
  special_category_id integer
)
;

create unique index items_id_uindex
  on items (id)
;
