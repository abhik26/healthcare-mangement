create database if not exists healthcare_appointment_system;
use healthcare_appointment_system;
show tables;

create table user (
	id bigint auto_increment primary key,
    email varchar(255) unique not null,
    password varchar(255) not null,
    first_name varchar (255) not null,
    last_name varchar (255),
    contact_number varchar(255) not null,
    address varchar (255) not null,
    date_of_birth date not null,
    roles varchar(255) not null);
    
desc user;

create table patient (
	id bigint auto_increment primary key,
    user_id bigint unique not null,
    gender varchar (10) not null,
    occupation varchar(255) not null,
    emergency_contacts varchar(255) not null,
    past_illnesses text,
    allergies text,
    medication text,
	foreign key (user_id) references user(id));

desc patient;

create table doctor (
	id bigint primary key auto_increment,
    user_id bigint unique not null,
    department varchar(255) not null,
    experience_in_years int not null default 0,
    summary text not null,
    foreign key (user_id) references user(id));
desc doctor;

create table appointment (
	id bigint primary key auto_increment,
    patient_id bigint not null,
    doctor_id bigint not null,
    data_time timestamp not null,
    status varchar(255) not null,
    foreign key (patient_id) references user(id),
    foreign key (doctor_id) references user(id));
    
desc appointment;

create table medical_record (
	id bigint primary key auto_increment,
    patient_id bigint not null,
    doctor_id bigint not null,
    appointment_id bigint not null,
    issues text not null,
    tests text,
    medications text,
    notes text,
    foreign key (patient_id) references patient(id),
    foreign key (doctor_id) references doctor(id),
    foreign key (appointment_id) references appointment(id));
    
desc medical_record;

create table bill (
	id bigint primary key auto_increment,
    patient_id bigint not null,
    appointment_id bigint not null,
    amount double not null,
    status varchar(255) not null,
    generated_on timestamp not null,
    paid_on timestamp,
    updated_at timestamp not null,
    foreign key (patient_id) references patient(id),
    foreign key (appointment_id) references appointment(id));
    
desc bill;
    