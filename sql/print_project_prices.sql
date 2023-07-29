
SELECT CONCAT('Project ',TO_CHAR(p.ID)) as name, sum(salary) * datediff(month, start_date, finish_date) as price
FROM project p
JOIN project_worker pw on p.ID = pw.project_id
JOIN worker w on pw.worker_id = w.ID
GROUP BY project_id
ORDER BY price DESC;
