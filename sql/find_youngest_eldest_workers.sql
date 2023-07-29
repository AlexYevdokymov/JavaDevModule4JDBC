
SELECT 'YOUNGEST' type, name, birthday
FROM worker
WHERE birthday = (
SELECT birthday
FROM worker
ORDER BY birthday DESC
LIMIT 1)
UNION
SELECT 'ELDEST' type, name, birthday
FROM worker
WHERE birthday = (
SELECT birthday
FROM worker
ORDER BY birthday
LIMIT 1)
ORDER BY birthday DESC;