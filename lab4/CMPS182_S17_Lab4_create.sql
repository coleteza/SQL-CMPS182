-- 
-- Schema isolation.
--

DROP SCHEMA lab4 CASCADE;
CREATE SCHEMA lab4;

ALTER ROLE cteza  SET SEARCH_PATH TO lab4;
--
-- Drivers
--

CREATE TABLE Drivers (
    LicenseID INT PRIMARY KEY,
    Name VARCHAR(30) NOT NULL,
    Address VARCHAR(40),
    BirthDate DATE,
    EyeColor CHAR(3),
    HairColor CHAR(3),
    LicenseExpireDate DATE,
    LicenseClass CHAR(1),
    UNIQUE(Name, Address)
);


--
-- Vehicles
--

CREATE TABLE Vehicles (
    VIN INT PRIMARY KEY,
    Model VARCHAR(30) NOT NULL,
    Year INT NOT NULL,
    VehicleColor CHAR(3),
    OwnerLicenseID INT NOT NULL,
    RegExpireDate DATE,
    InsuranceCo VARCHAR(30),
    InUse BOOLEAN
);


--
-- Tickets
--

CREATE TABLE Tickets (
    TicketID INT PRIMARY KEY,
    VIN INT NOT NULL,
    LicenseID INT,
    TicketDate DATE NOT NULL,
    Address VARCHAR(40),
    Infraction VARCHAR(30),
    Fee DECIMAL(6,2),
    Paid BOOLEAN
);


