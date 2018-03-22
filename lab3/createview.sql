CREATE VIEW MultiTicketedDrivers
	AS SELECT d.licenseID, d.name, d.address
	FROM Drivers d, Tickets t
		WHERE d.licenseid = (SELECT licenseid FROM tickets
			GROUP BY licenseid
			HAVING COUNT (licenseid) > 1);


