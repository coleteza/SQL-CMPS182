--Cole Teza
--2.4
--5/18/17
--CMPS182

--Constraint 1
--1. LicenceClass in Drivers must be 'A','B','C' or 'M'  
ALTER TABLE Drivers
	ADD  CONSTRAINT l_class
	CHECK(licenseclass = 'A'
	OR licenseclass = 'B'
	OR licenseclass = 'C'
	OR licenseclass = 'M');
--Constraint 2
--2. Fee in Tickets Must Be Greater than 0
ALTER TABLE Tickets
	ADD CONSTRAINT t_fee
	CHECK(fee>0);
--Constraint 3
--3. In Vehicles, if InUse is TRUE then RegExpireDate can't be NULL
ALTER TABLE Vehicles
	ADD CONSTRAINT v_inUse
	CHECK (CASE WHEN inUSE = 'TRUE' THEN RegExpireDate IS NOT NULL END); 
