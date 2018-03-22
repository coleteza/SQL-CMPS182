DROP SCHEMA lab0 CASCADE;
CREATE SCHEMA lab0;
SET search_path = lab0;

CREATE TABLE Cars (
	vin INTEGER,
	make VARCHAR(16),
	model VARCHAR(16),
	year INTEGER
);

