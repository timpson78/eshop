create sequence global_seq
;

create sequence global_seq2
;

create sequence items_seq
;

create sequence item_category_seq
;

create sequence item_images_seq
;

create sequence item_mesures_seq
;

create sequence seo_meta_data_seq
;

create sequence item_brand_seq
;

create sequence item_common_properties_seq
;

create sequence item_property_groups_seq
;

create sequence item_property_values_seq
;

create sequence item_properties_value_type_seq
;

create table users
(
  id serial not null
    constraint users_id_pk
    unique,
  email varchar not null,
  name varchar not null,
  password varchar,
  registered timestamp default now() not null,
  phone varchar,
  enabled boolean default true not null,
  sex integer,
  birthday date
)
;

create unique index users_email_uindex
  on users (email)
;

create table user_roles
(
  user_id integer not null,
  role varchar,
  constraint user_roles_user_id_role_pk
  unique (user_id, role)
)
;

create table items
(
  id integer default nextval('items_seq'::regclass) not null
    constraint items_id_pk
    primary key,
  title varchar not null,
  short_description varchar,
  description varchar,
  url_seo varchar,
  price numeric(10,2),
  quantity integer,
  mesure_id integer,
  discount numeric(5,2),
  partnumber varchar,
  weight numeric(5,2),
  brend_id integer,
  category_id integer,
  activity boolean,
  sales_hit boolean,
  new_item boolean,
  promotion boolean
)
;

create unique index items_id_uindex
  on items (id)
;

create table item_images
(
  id integer default nextval('item_images_seq'::regclass) not null
    constraint item_images_id_pk
    primary key,
  fk_item_id integer not null,
  src varchar
)
;

create unique index item_images_id_uindex
  on item_images (id)
;

create table item_brends
(
  id integer default nextval('item_brand_seq'::regclass) not null
    constraint item_brends_id_pk
    primary key,
  name varchar
)
;

create unique index brends_id_uindex
  on item_brends (id)
;

create table item_categories
(
  id integer default nextval('item_category_seq'::regclass) not null
    constraint item_categories_id_pk
    primary key,
  name varchar not null,
  left_key integer not null,
  right_key integer not null,
  level integer not null,
  parent_id integer
)
;

create table item_properties
(
  id integer default nextval('global_seq2'::regclass) not null
    constraint items_properties_id_pk
    primary key,
  item_id integer not null,
  item_common_property_id integer,
  item_propery_value_type_id integer,
  item_propery_value_id integer
)
;

create unique index items_properties_id_uindex
  on item_properties (id)
;

create table item_common_properties
(
  id integer default nextval('item_common_properties_seq'::regclass) not null
    constraint item_common_properties_id_pk
    primary key,
  item_property_group_id integer not null,
  item_property_value_type_id integer,
  name varchar,
  description varchar,
  mesure varchar
)
;

create unique index common_properties_id_uindex
  on item_common_properties (id)
;

create table item_property_groups
(
  id integer default nextval('item_property_groups_seq'::regclass) not null
    constraint item_property_group_id_pk
    primary key,
  name varchar
)
;

create unique index item_property_group_id_uindex
  on item_property_groups (id)
;

create table recomended_items
(
  id integer default nextval('global_seq2'::regclass) not null
    constraint recomended_items_id_pk
    primary key,
  item_id integer not null,
  recomended_item_id integer not null
)
;

create unique index recomended_items_id_uindex
  on recomended_items (id)
;

create table item_mesures
(
  id integer default nextval('item_mesures_seq'::regclass) not null
    constraint item_mesures_id_pk
    primary key,
  name varchar
)
;

create table seo_meta_data
(
  id integer default nextval('seo_meta_data_seq'::regclass) not null
    constraint seo_meta_data_pkey
    primary key,
  title varchar,
  keywords varchar,
  description varchar
)
;

create table item_property_values
(
  id serial not null
    constraint item_property_values_pkey
    primary key,
  item_common_property_id integer not null
)
;

create table item_properties_value_type
(
  id integer default nextval('item_properties_value_type_seq'::regclass) not null
    constraint item_property_value_type_pkey
    primary key,
  name varchar not null,
  aliasname varchar
)
;

create table item_property_values_integer
(
  id integer not null
    constraint item_propery_values_integer_id_pk
    primary key,
  value integer
)
;

create table item_property_values_boolean
(
  id integer not null
    constraint item_property_values_boolean_pkey
    primary key,
  value boolean
)
;

create table item_property_values_string
(
  id integer not null
    constraint item_property_values_string_pkey
    primary key,
  value varchar
)
;

create table item_property_values_list
(
  id integer not null
    constraint item_property_values_list_id_pk
    primary key,
  fk_item_property_value_id integer,
  value varchar,
  active boolean
)
;

create unique index item_property_values_list_id_uindex
  on item_property_values_list (id)
;

