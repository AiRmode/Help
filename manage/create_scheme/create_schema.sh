echo 1>&2 "Enter Username:" 
read user
echo 1>&2 "Enter Schema Name:" 
read sn
psql -U $user -v schema_name=$sn -a -f DB_init.sql  
