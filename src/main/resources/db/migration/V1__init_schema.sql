create table if not exists "schools"
(
    id UUID not null primary key,
    name int not null,
    address varchar(255) not null
);

create table if not exists "users"
(
    id UUID not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    gender varchar(1) not null,
    age int not null,
    school_id UUID,
    foreign key (school_id) references "schools"(id) on delete set null
);

create table if not exists "posts"
(
    id UUID not null primary key,
    body varchar(4096) not null,
    user_id UUID not null,
    foreign key (user_id) references "users"(id) on delete cascade
);

create table if not exists friends
(
    user_id UUID not null,
    friend_id UUID not null,
    foreign key (user_id) references "users"(id) on delete cascade,
    foreign key (friend_id) references "users"(id) on delete cascade,
    primary key (user_id, friend_id)
);