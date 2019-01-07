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

