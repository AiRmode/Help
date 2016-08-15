@echo off
set /p user="Enter User: "
set /p sn="Enter Schema Name: "
psql -U %user% -v schema_name=%sn% -a -f DB_init.sql
pause;