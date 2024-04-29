-- Write your PostgreSQL query statement below
WITH duplicates AS (
    SELECT email, id, ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS row_num
    FROM Person
)

DELETE FROM Person
WHERE id in (
    SELECT id 
    FROM duplicates
    WHERE row_num > 1
);