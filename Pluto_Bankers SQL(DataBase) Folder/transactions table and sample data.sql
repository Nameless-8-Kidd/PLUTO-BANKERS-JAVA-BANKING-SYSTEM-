CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    employee_id varchar(50),
    client_id Varchar(50), 
    transaction_type VARCHAR(50),
    amount DECIMAL(12,2),
    reference_note VARCHAR(255),
    transaction_date date DEFAULT CURRENT_DATE(),
    FOREIGN KEY (account_id) REFERENCES accounts(account_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    Time tIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO transactions (account_id, employee_id, client_id, transaction_type, amount, reference_note)
VALUES


(1, 'EMP01', 'CUS01', 'DEPOSIT', 5000.00, 'Cash Deposit'),
(1, 'EMP02', 'CUS01', 'WITHDRAWAL', 1200.00, 'ATM Withdrawal'),
(1, 'EMP03', 'CUS01', 'TRANSFER SENT', 2500.00, 'Transfer to Peter'),

(2, 'EMP01', 'CUS02', 'DEPOSIT', 10000.00, 'Salary Payment'),
(2, 'EMP02', 'CUS02', 'TRANSFER RECEIVED', 2500.00, 'Received from Bob'),
(2, 'EMP03', 'CUS02', 'WITHDRAWAL', 3000.00, 'ATM Withdrawal'),

(3, 'EMP01', 'CUS03', 'DEPOSIT', 4500.00, 'Monthly Salary'),
(3, 'EMP02', 'CUS03', 'TRANSFER SENT', 1500.00, 'Transfer to Linda'),

(4, 'EMP03', 'CUS04', 'WITHDRAWAL', 500.00, 'Store Purchase'),

(5, 'EMP01', 'CUS05', 'DEPOSIT', 2000.00, 'Cash Deposit'),
(5, 'EMP02', 'CUS05', 'TRANSFER RECEIVED', 800.00, 'Received from Kevin'),

