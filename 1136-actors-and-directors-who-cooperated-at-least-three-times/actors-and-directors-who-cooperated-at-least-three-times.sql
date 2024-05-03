-- Write your PostgreSQL query statement below
WITH Collaborations AS (
    SELECT actor_id, director_id, COUNT(*) AS num_collaborations
    FROM ActorDirector
    GROUP BY actor_id, director_id
)
SELECT actor_id, director_id
FROM Collaborations
WHERE num_collaborations >= 3;