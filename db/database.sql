CREATE DATABASE profile;

CREATE TABLE profile (
	id numeric(38,0) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50),
	address float,
	birth_day date,
	email varchar(100) NOT NULL,
	city varchar(45),
	country varchar(45)
);

ALTER TABLE profile ADD CONSTRAINT profile_pk PRIMARY KEY(id);
ALTER TABLE profile ADD CONSTRAINT profile_bk UNIQUE(email);

