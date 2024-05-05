create user developer with password 'developer' superuser;
create database todo owner developer encoding 'UTF8';
grant all privileges on database todo to developer;

\c todo;
CREATE SCHEMA todo;

set statement_timeout = 0;
set lock_timeout = 0;
set client_encoding = 'UTF-8';
set standard_conforming_strings = on;
set check_function_bodies = false;
set client_min_messages = warning;

alter system set max_connections = 5000;
alter system reset shared_buffers;