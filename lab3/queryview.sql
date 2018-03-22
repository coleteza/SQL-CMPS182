SELECT t.licenseID, SUM(t.fee) AS TicketFeeSum, MAX(t.fee) AS TicketFeeMax 
	FROM tickets t
	WHERE t.licenseid IN
		(SELECT m.licenseid FROM MultiTicketedDrivers m)
		GROUP BY licenseid;

--Delete Tuple with ticketid= 3000013;
DELETE FROM Tickets
	WHERE ticketid = 3000013;

--Delete Tuple with ticketid= 3000016;
DELETE FROM Tickets
        WHERE ticketid = 3000016;



	
