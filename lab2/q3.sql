SELECT v.model, v.year FROM Vehicles v 
	WHERE  v.OwnerLicenseID = ANY
		(SELECT d.LicenseID FROM Drivers d 
			WHERE d.Name = 'John Smith');

