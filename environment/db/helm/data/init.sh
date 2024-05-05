#!/bin/bash

psql -U postgres --dbname todo < /data/sql/0_database.sql
psql -U developer --dbname todo < /data/sql/1_tables.sql