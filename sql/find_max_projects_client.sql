
SELECT c.name, count(*) project_count
FROM project p
JOIN client c on c.ID = p.client_id
GROUP BY client_id
HAVING count(*) =
(SELECT count(*) as amount
FROM project
GROUP BY client_id
ORDER BY amount DESC
LIMIT 1);