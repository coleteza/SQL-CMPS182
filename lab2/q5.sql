SELECT t.TicketID, t.TicketDate, t.Infraction, d1.Name AS TDriverName, d2.Name AS OwnName
	FROM Tickets t, Drivers d1, Drivers d2, Vehicles v
	WHERE t.VIN=v.VIN AND  d1.LicenseID = t.LicenseID
		AND v.OwnerLicenseID = d2.LicenseID AND d1.LicenseID <> d2.LicenseID;
