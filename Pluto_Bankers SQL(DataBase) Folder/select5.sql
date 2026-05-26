select Full_name from clients join transactions on clients.client_id = transactions.client_id 
where transactions.transaction_type = 'Deposit' and transactions.amount > 1000;