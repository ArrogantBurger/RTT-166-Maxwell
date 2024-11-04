-- Auction web service needs a query that returns a list of all available lots with offers left by buyers
-- result table should have the following columns: name, min_offer, avg_offer, max_offer, offers
-- SBA question template

SELECT lots.id as name, MIN(amount) as min_offer, AVG(amount) as avg_offer, MAX(amount) as max_offer, COUNT(amount) as offers
FROM lots, offers
WHERE offers.lot_id = lots.id
GROUP BY lots.id
ORDER BY offers DESC;

-- Actual answer ended up needing a LEFT JOIN to include lots that had no offers, using WHERE is like to an INNER JOIN where lots with no offers don't meet the criteria and are nixed from the final result
SELECT lots.id as name, MIN(amount) as min_offer, AVG(amount) as avg_offer, MAX(amount) as max_offer, COUNT(amount) as offers
FROM lots LEFT JOIN offers ON offers.lot_id = lots.id
GROUP BY lots.id
ORDER BY offers DESC;

-- ==================== SBA SQL Part 2 ======================

-- Write a query to list the names of all Courses where the number of faculty assigned to those courses is zero.
-- Output should be sorted by Course Name in ascending alphabetical order.

SELECT DISTINCT c.name as 'Course Name'
FROM course c
LEFT JOIN facultyCourse fc ON fc.courseId = c.id 
GROUP BY c.name
HAVING COUNT(fc.courseId) = 0
ORDER BY c.name ASC;