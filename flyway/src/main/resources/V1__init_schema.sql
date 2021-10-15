create table if not exists schools
(
    id UUID not null primary key,
    name varchar(255) not null,
    address varchar(255) not null
);

create table if not exists users
(
    id UUID not null primary key,
    first_name varchar(255) not null,
    family_name varchar(255) not null,
    patronymic varchar(255),
    gender varchar(1) not null,
    age int not null,
    school_id UUID,
    foreign key (school_id) references schools(id)
);

create table if not exists posts
(
    id UUID not null primary key,
    body varchar(32768) not null,
    user_id UUID,
    foreign key (user_id) references users(id) on delete cascade
);

create table if not exists friends
(
    foreign key (user_id) references users (id) on delete cascade,
    foreign key (friend_id) references users (id) on delete cascade,
    primary key (user_id, friend_id)
);
