drop database if exists jvdb_proj1_db ;

create database jvdb_proj1_db ;

use jvdb_proj1_db;




create table Employee (
ID int(15) Primary KEY Auto_increment,
Name varchar(30),
Salary decimal(18,2) not null ,
Date_Employment Date );