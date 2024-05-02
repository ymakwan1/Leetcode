-- Write your PostgreSQL query statement below
WITH MaxNumbers AS (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
)

SELECT MAX(num) AS num FROM MaxNumbers;