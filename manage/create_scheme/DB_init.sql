BEGIN;
--ROLLBACK;


DROP TABLE IF EXISTS :schema_name."User" CASCADE;
DROP TABLE IF EXISTS :schema_name."User_info" CASCADE;
DROP TABLE IF EXISTS :schema_name."User_info_type" CASCADE;
DROP TABLE IF EXISTS :schema_name."User_status" CASCADE;
DROP TABLE IF EXISTS :schema_name."User_avatar" CASCADE;
DROP TABLE IF EXISTS :schema_name."Company" CASCADE;
DROP TABLE IF EXISTS :schema_name."Company_info" CASCADE;
DROP TABLE IF EXISTS :schema_name."Company_info_type" CASCADE;
DROP TABLE IF EXISTS :schema_name."Company_status" CASCADE;
DROP TABLE IF EXISTS :schema_name."Company_avatar" CASCADE;
DROP TABLE IF EXISTS :schema_name."Company_alias" CASCADE;
DROP TABLE IF EXISTS :schema_name."Shelter" CASCADE;
DROP TABLE IF EXISTS :schema_name."Shelter_type" CASCADE;
DROP TABLE IF EXISTS :schema_name."Shelter_info" CASCADE;
DROP TABLE IF EXISTS :schema_name."Shelter_info_type" CASCADE;
DROP TABLE IF EXISTS :schema_name."Shelter_status" CASCADE;
DROP TABLE IF EXISTS :schema_name."Shelter_avatar" CASCADE;
DROP TABLE IF EXISTS :schema_name."Tag" CASCADE;
DROP TABLE IF EXISTS :schema_name."Event" CASCADE;
DROP TABLE IF EXISTS :schema_name."Event_info" CASCADE;
DROP TABLE IF EXISTS :schema_name."Event_info_type" CASCADE;
DROP TABLE IF EXISTS :schema_name."UserToCompany" CASCADE;
DROP TABLE IF EXISTS :schema_name."CompanyToEvent" CASCADE;
DROP TABLE IF EXISTS :schema_name."UserToEvent" CASCADE;
DROP TABLE IF EXISTS :schema_name."TagToShelter" CASCADE;

create SCHEMA :schema_name;

CREATE TABLE :schema_name."User" (
	id SERIAL NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	pass_hash VARCHAR NOT NULL,
	phone_num VARCHAR(20) NOT NULL,
	status_id INTEGER NOT NULL,
	avatar_id INTEGER,
	is_superuser BOOLEAN NOT NULL,
	locale_lang VARCHAR(20) DEFAULT 'ru',
	created_date TIMESTAMP NOT NULL,
	created_by_id INTEGER,
	last_modified_date TIMESTAMP NOT NULL,
	last_modified_by_id INTEGER,
	PRIMARY KEY (id),
	UNIQUE (email, phone_num)
);

CREATE TABLE :schema_name."User_info" (
	id SERIAL NOT NULL,
	user_id INTEGER NOT NULL,
	info VARCHAR(255) NOT NULL,
	info_type_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."User_info_type" (
	id SERIAL NOT NULL,
	type VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."User_status" (
	id SERIAL NOT NULL,
	title VARCHAR(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."User_avatar" (
	id SERIAL NOT NULL,
	avatar BYTEA NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Company" (
	id SERIAL NOT NULL,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	status_id INTEGER NOT NULL,
	avatar_id INTEGER,
	created_date TIMESTAMP NOT NULL,
	created_by_id INTEGER,
	last_modified_date TIMESTAMP NOT NULL,
	last_modified_by_id INTEGER,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."Company_info" (
	id SERIAL NOT NULL,
	company_id INTEGER NOT NULL,
	info VARCHAR(255) NOT NULL,
	info_type_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Company_info_type" (
	id SERIAL NOT NULL,
	type VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Company_status" (
	id SERIAL NOT NULL,
	title VARCHAR(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."Company_avatar" (
	id SERIAL NOT NULL,
	avatar BYTEA NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Company_alias" (
	id SERIAL NOT NULL,
	alias VARCHAR NOT NULL,
	company_id VARCHAR NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (alias)
);

CREATE TABLE :schema_name."Shelter" (
	id SERIAL NOT NULL,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	type_id INTEGER NOT NULL,
	status_id INTEGER NOT NULL,
	avatar_id INTEGER,
	created_date TIMESTAMP NOT NULL,
	created_by_id INTEGER,
	last_modified_date TIMESTAMP NOT NULL,
	last_modified_by_id INTEGER,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."Shelter_type" (
	id SERIAL NOT NULL,
	title VARCHAR(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."Shelter_info" (
	id SERIAL NOT NULL,
	shelter_id INTEGER NOT NULL,
	info VARCHAR(255) NOT NULL,
	info_type_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Shelter_info_type" (
	id SERIAL NOT NULL,
	type VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Shelter_status" (
	id SERIAL NOT NULL,
	title VARCHAR(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."Shelter_avatar" (
	id SERIAL NOT NULL,
	avatar BYTEA NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Tag" (
	id SERIAL NOT NULL,
	title VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (title)
);

CREATE TABLE :schema_name."Event" (
	id SERIAL NOT NULL,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	shelter_id INTEGER NOT NULL,
	date TIMESTAMP NOT NULL,
	is_accessable BOOLEAN NOT NULL,
	created_date TIMESTAMP NOT NULL,
	created_by_id INTEGER,
	last_modified_date TIMESTAMP NOT NULL,
	last_modified_by_id INTEGER,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Event_info" (
	id SERIAL NOT NULL,
	event_id INTEGER NOT NULL,
	info VARCHAR(255) NOT NULL,
	info_type_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."Event_info_type" (
	id SERIAL NOT NULL,
	type VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."UserToCompany" (
	id SERIAL NOT NULL,
	user_id INTEGER NOT NULL,
	company_id INTEGER NOT NULL,
	is_admin BOOLEAN NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."CompanyToEvent" (
	id SERIAL NOT NULL,
	event_id INTEGER NOT NULL,
	company_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."UserToEvent" (
	id SERIAL NOT NULL,
	event_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE :schema_name."TagToShelter" (
	id SERIAL NOT NULL,
	shelter_id INTEGER NOT NULL,
	tag_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE :schema_name."User" ADD FOREIGN KEY (status_id) REFERENCES :schema_name."User_status"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."User" ADD FOREIGN KEY (avatar_id) REFERENCES :schema_name."User_avatar"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE :schema_name."User" ADD FOREIGN KEY (created_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."User" ADD FOREIGN KEY (last_modified_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."User_info" ADD FOREIGN KEY (user_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."User_info" ADD FOREIGN KEY (info_type_id) REFERENCES :schema_name."User_info_type"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."Company" ADD FOREIGN KEY (status_id) REFERENCES :schema_name."Company_status"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Company" ADD FOREIGN KEY (avatar_id) REFERENCES :schema_name."Company_avatar"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE :schema_name."Company" ADD FOREIGN KEY (created_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Company" ADD FOREIGN KEY (last_modified_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."Company_info" ADD FOREIGN KEY (company_id) REFERENCES :schema_name."Company"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."Company_info" ADD FOREIGN KEY (info_type_id) REFERENCES :schema_name."Company_info_type"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."Shelter" ADD FOREIGN KEY (status_id) REFERENCES :schema_name."Shelter_status"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Shelter" ADD FOREIGN KEY (avatar_id) REFERENCES :schema_name."Shelter_avatar"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE :schema_name."Shelter" ADD FOREIGN KEY (type_id) REFERENCES :schema_name."Shelter_type"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Shelter" ADD FOREIGN KEY (created_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Shelter" ADD FOREIGN KEY (last_modified_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."Shelter_info" ADD FOREIGN KEY (shelter_id) REFERENCES :schema_name."Shelter"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."Shelter_info" ADD FOREIGN KEY (info_type_id) REFERENCES :schema_name."Shelter_info_type"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."Event" ADD FOREIGN KEY (shelter_id) REFERENCES :schema_name."Shelter"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Event" ADD FOREIGN KEY (created_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE :schema_name."Event" ADD FOREIGN KEY (last_modified_by_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."Event_info" ADD FOREIGN KEY (event_id) REFERENCES :schema_name."Event"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."Event_info" ADD FOREIGN KEY (info_type_id) REFERENCES :schema_name."Event_info_type"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE :schema_name."UserToCompany" ADD FOREIGN KEY (user_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."UserToCompany" ADD FOREIGN KEY (company_id) REFERENCES :schema_name."Company"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE :schema_name."CompanyToEvent" ADD FOREIGN KEY (event_id) REFERENCES :schema_name."Event"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."CompanyToEvent" ADD FOREIGN KEY (company_id) REFERENCES :schema_name."Company"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE :schema_name."UserToEvent" ADD FOREIGN KEY (event_id) REFERENCES :schema_name."Event"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."UserToEvent" ADD FOREIGN KEY (user_id) REFERENCES :schema_name."User"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE :schema_name."TagToShelter" ADD FOREIGN KEY (shelter_id) REFERENCES :schema_name."Shelter"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE :schema_name."TagToShelter" ADD FOREIGN KEY (tag_id) REFERENCES :schema_name."Tag"(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

COMMIT;