
SELECT * FROM worker
WHERE salary = (SELECT max(salary) FROM worker);