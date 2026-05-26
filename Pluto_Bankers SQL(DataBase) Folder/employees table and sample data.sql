CREATE TABLE employees (
    employee_id varchar(50) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100)
);

INSERT INTO employees(employee_id, username, password, full_name)
VALUES
('EMP01', 'mike', 'emp1', 'Mike Smith'),
('EMP02', 'john', 'emp2', 'John Peterson'),
('EMP03', 'tumi', 'emp3', 'Tumi Daniels');