CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id VARCHAR(50) NOT NULL,
    account_number BIGINT UNIQUE NOT NULL,
    account_pin INT NOT NULL,
    account_type VARCHAR(50),
    balance DECIMAL(12,2) DEFAULT 0.00,
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

INSERT INTO accounts (account_id, client_id, account_number, account_pin, account_type, balance)
VALUES

(1, 'CUS01', 9343343, 1234, 'Savings Account', 20034.00),
(2, 'CUS02', 4847433, 2345, 'Checking Account', 54334.00),
(3, 'CUS03', 2987654, 3456, 'Salary Account', 6454.00),
(4, 'CUS04', 3043433, 4567, 'Joint Account', 8445.00),
(5, 'CUS05', 8493733, 5678, 'Savings Account', 9544.00),

