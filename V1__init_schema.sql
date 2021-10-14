create table if not exists school
(
    id UUID not null primary key,
    name varchar(255) not null,
    address varchar(255) not null
);

create table if not exists teacher
(
    id UUID not null primary key,
    first_name varchar(255) not null,
    family_name varchar(255) not null,
    patronymic varchar(255) not null,
    gender varchar(1) not null,
    age int not null
);

create table if not exists student
(
    id UUID not null primary key,
    first_name varchar(255) not null,
    family_name varchar(255) not null,
    patronymic varchar(255) not null,
    gender varchar(1) not null,
    age int not null
);

create table if not exists subject
(
    id UUID not null primary key,
    name varchar(255) not null
);

create table if not exists teacher_subject
(
    teacher_id UUID references teacher (id),
    subject_id UUID references subject (id),
    primary key (teacher_id, subject_id)
);

create table if not exists student_subject
(
    student_id UUID references student (id),
    subject_id UUID references subject (id),
    primary key (student_id, subject_id)
);
