
SELECT CONCAT('Project ',TO_CHAR(ID)) as name, datediff(month, start_date, finish_date) month_count
FROM project
WHERE datediff(month, start_date, finish_date) = 
(SELECT datediff(month, start_date, finish_date) m_count
FROM PROJECT
ORDER BY m_count DESC
LIMIT 1);