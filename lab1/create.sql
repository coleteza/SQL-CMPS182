DROP SCHEMA Lab1 CASCADE;
CREATE SCHEMA Lab1;
ALTER ROLE cteza SET SEARCH_PATH to Lab1;

CREATE TABLE  Drivers(
	LicenseID INTEGER PRIMARY KEY,
	Name VARCHAR(30),
	Address VARCHAR(40),
	Birthdate DATE,
	EyeColor VARCHAR(3),
	HairColor VARCHAR(3),
	LicenseExpireDate DATE,
	LicenseClass VARCHAR(1)
);
	
CREATE TABLE Vehicles(
	VIN INTEGER PRIMARY KEY,
	Model VARCHAR(30),
	Year INTEGER,
	VehicleColor VARCHAR(3),
	OwnerLicenseID INTEGER,
	RegExpireDate DATE,
	InsuranceCo VARCHAR(30),
	InUse BOOLEAN
);

CREATE TABLE Tickets(
	TicketID INTEGER PRIMARY KEY,
	VIN INTEGER,
	LicenseID INTEGER,
	TicketDate DATE,
	Address VARCHAR(40),
	Infraction VARCHAR(30),
	Fee DECIMAL(6,2),
	Paid BOOLEAN
); 
