create schema if not exists nasa;

create table if not exists nasa.camera (
    id bigserial not null,
    rover_id integer,
    nasa_camera_id bigint not null unique,
    full_name varchar(255) unique,
    name varchar(255) not null unique,
    primary key (id)
);

create table if not exists nasa.picture (
    id bigserial not null,
    sol integer not null,
    camera_info_dto_id bigint,
    nasa_photo_id bigint not null unique,
    img_src varchar(255) not null unique,
    primary key (id)
);

alter table if exists nasa.picture add constraint fk_picture_camera_id foreign key (camera_info_dto_id) references nasa.camera;