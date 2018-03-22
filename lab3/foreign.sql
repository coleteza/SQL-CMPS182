--Cole Teza
--foregin.sql
--CMPS 182
--5/19/17

-- a. The VIN field in Tickets should reference the VIN field in Vehicles

ALTER TABLE Tickets
	ADD FOREIGN KEY (VIN)
	REFERENCES Vehicles(VIN);

-- b. The OwnerLicenseID fields in Vehicles should reference the LicenseID field in Drivers

ALTER TABLE Vehicles
	ADD FOREIGN KEY (OwnerLicenseID)
	REFERENCES Drivers(LicenseID);

ALTER TABLE Tickets
	ADD FOREIGN KEY (LicenseID)
	REFERENCES Drivers(LicenseID);

--c. The LicenseID fields in Tickets should reference the LicenseID field in Drivers.
-- notice that LicenseID in Tickets is allowed to be NULL even though it is a Foreign Key 
-- referring to the LicenseID field in Drivers
