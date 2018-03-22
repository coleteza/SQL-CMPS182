--Cole Teza
--Part 2.5
--CMPS182
--5/18/17

--Foreign Key Constraint 1 Unit Test
INSERT INTO Tickets (TicketID, VIN, TicketDate)
	VALUES (1234567, 654321, '1995-03-13');

--Foreign Key Constraint 2 Unit Test
INSERT INTO Vehicles (VIN, model, year, OwnerLicenseID)
	 VALUES (1234567,'Kia Sorrento', 2006, 31395);

--Foreign Key Constraint 3 Unit Test
INSERT INTO Tickets (TicketID, VIN, LicenseID,  TicketDate)
        VALUES (1234567, 654321, 31395, '1995-03-13');

--General Constraint 1(a) Unit Test (Constraint Met)
--INSERT INTO Drivers (LicenseID, name, LicenseClass)
--VALUES (12345, 'Cole Teza', 'A');
UPDATE Drivers
SET LicenseClass = 'A';

--General Constraint 1(b) Unit Test (Constraint Violated)
--INSERT INTO Drivers (LicenseID, name, LicenseClass)
--VALUES (12345, 'Cole Teza', 'Q');
UPDATE Drivers
SET LicenseClass = 'Q';

--General Constraint 2(a) Unit Test (Constraint Met)
--INSERT INTO Tickets (TicketID, VIN, TicketDate, Fee)
--VALUES (1234567, 200012, '1995-03-13', 17.38);
UPDATE Tickets
SET Fee = 17.38;

--General Constraint 2(b) Unit Test (Constraint Violated)
--INSERT INTO Tickets (TicketID, VIN, TicketDate, Fee)
--VALUES (1234567, 200012, '1995-03-13', 0.00);
UPDATE Tickets
SET Fee = '0.00';

--General Constraint 3(a) Unit Test (Constraint Met)
--INSERT INTO Vehicles (VIN, model, year, OwnerLicenseID, RegExpireDate, InUse)
--VALUES (123456, 'Kia Sorrento', 2006, 12345, '1995-03-13','TRUE');
UPDATE Vehicles
SET RegExpireDate = '1995-03-13'
WHERE InUse = 'TRUE';

--General Constraint 3(b) Unit Test (Constraint Violated)
--INSERT INTO Vehicles (VIN, model, year, OwnerLicenseID, RegExpireDate, InUse)
--VALUES (123456, 'Kia Sorrento', 2006, 12345, NULL,'TRUE');
UPDATE Vehicles
SET RegExpireDate = NULL
WHERE InUse = 'TRUE';
