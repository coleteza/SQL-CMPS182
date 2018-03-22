UPDATE Tickets t
SET Paid = 'TRUE'
WHERE t.fee
	IN (SELECT tp.amount
		FROM TicketPayments tp
		WHERE tp.ticketid= t.ticketid);
