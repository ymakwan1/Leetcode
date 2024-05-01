-- Write your PostgreSQL query statement below
WITH RedCompanyOrders AS (
    SELECT DISTINCT sales_id
    FROM Orders o
    JOIN Company c ON o.com_id = c.com_id
    WHERE c.name = 'RED'
)
SELECT DISTINCT s.name
FROM SalesPerson s
LEFT JOIN RedCompanyOrders rco ON s.sales_id = rco.sales_id
WHERE rco.sales_id IS NULL;
