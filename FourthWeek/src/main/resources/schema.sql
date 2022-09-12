#schema.sql
drop table member if exists
create table member (id varchar(255) not null, date date not null, name varchar(255), address varchar(255), phoneNumber varchar(255), primary key (id, date))