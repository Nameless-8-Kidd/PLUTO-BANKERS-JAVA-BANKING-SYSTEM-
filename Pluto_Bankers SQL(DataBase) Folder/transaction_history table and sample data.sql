
CREATE TABLE transaction_history (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number BIGINT,
    activity TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES accounts(account_number),
    employee_id varchar(50),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

INSERT INTO transaction_history (account_number, activity, employee_id)
VALUES

(9343343, 'DEPOSIT | Amount: R5000.00 | New Balance: R25034.00', 'EMP01'),
(9343343, 'WITHDRAWAL | Amount: R1200.00 | New Balance: R23834.00', 'EMP02'),
(9343343, 'TRANSFER SENT | To: Peter (Acc: 8493733) | Amount: R2500.00 | Ref: Transfer to Peter | New Balance: R21334.00', 'EMP03'),

(4847433, 'DEPOSIT | Amount: R10000.00 | New Balance: R64334.00', 'EMP01'),
(4847433, 'TRANSFER RECEIVED | From: Bob (Acc: 8493733) | Amount: R2500.00 | Ref: Received from Bob | New Balance: R66834.00', 'EMP02'),
(4847433, 'WITHDRAWAL | Amount: R3000.00 | New Balance: R63834.00', 'EMP03'),

(2987654, 'DEPOSIT | Amount: R4500.00 | New Balance: R6454.00', 'EMP01'),
(2987654, 'TRANSFER SENT | To: Linda (Acc: 3043433) | Amount: R1500.00 | Ref: Transfer to Linda | New Balance: R4954.00', 'EMP02'),

(3043433, 'WITHDRAWAL | Amount: R500.00 | New Balance: R7945.00', 'EMP03'),

