create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table product (
    id bigint not null,
    description LONGTEXT,
    filename varchar(255),
    price double precision not null,
    storage_count integer not null,
    title varchar(255),
    primary key (id));

create table purchase (
    id bigint not null,
    products_count integer not null,
    purchase_date varchar(255),
    purchase_price double precision not null,
    user_id bigint,
    product_id bigint,
    primary key (id));

create table user (
    id bigint not null,
    password varchar(255),
    username varchar(255),
    primary key (id));

create table user_role (
    user_id bigint not null,
    roles varchar(255));

alter table purchase
    add constraint FK86i0stm7cqsglqptdvjij1k3m
    foreign key (user_id) references user (id);

alter table purchase
    add constraint FK3s4jktret4nl7m8yhfc8mfrn5
    foreign key (product_id) references product (id);

alter table user_role
    add constraint FK859n2jvi8ivhui0rl0esws6o
    foreign key (user_id) references user (id);
