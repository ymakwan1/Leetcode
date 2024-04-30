-- Write your PostgreSQL query statement below
SELECT e.name, b.bonus
FROM Employee as e
LEFT JOIN Bonus as b
ON e.empId = b.empId
WHERE b.Bonus < 1000 OR b.bonus IS NULL;