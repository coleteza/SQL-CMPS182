SELECT DISTINCT  t.TicketID, v.Model, v.Year FROM Vehicles v, Tickets t
	WHERE (v.VIN=t.VIN AND v.InsuranceCo='GEICO' AND t.Fee>50);
		
