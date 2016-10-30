#!/usr/bin/env bash

#apply admin creation script
echo 1>&2 "Enter Username:"
read user
echo 1>&2 "Enter Schema Name:"
read sn
psql -U $user -v schema_name=$sn -a -f ../database/scripts/init/admin_user_insert.sql

#TODO: apply static data to DB