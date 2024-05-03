-- Write your PostgreSQL query statement below
SELECT actor_id, director_id
FROM (
    SELECT actor_id, director_id, COUNT(*) AS collaborations
    FROM ActorDirector
    GROUP BY actor_id, director_id
) AS ad
WHERE ad.collaborations >= 3;
