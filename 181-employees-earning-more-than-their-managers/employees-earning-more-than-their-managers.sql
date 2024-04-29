-- Write your PostgreSQL query statement below
WITH Manager AS (
    SELECT e1.name AS Employee, e1.salary AS EmployeeSalary, e2.salary AS ManagerSalary
    FROM Employee e1
    JOIN Employee e2 ON e1.managerId = e2.id
)
SELECT Employee
FROM Manager
WHERE EmployeeSalary > ManagerSalary;
