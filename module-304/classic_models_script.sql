SELECT count(*) FROM offices;

-- Transaction example, keywords of TRANSACTION are START, COMMIT, and ROLLBACK
-- Changes made in a transaction are invisible to other users of the database until the COMMIT is invoked
-- This guarantees atomicity of a database
START TRANSACTION;
DELETE FROM offices WHERE id = 11;
SELECT * FROM offices;
ROLLBACK;
COMMIT;

-- INSERT INTO offices ( city, phone, address_line1, address_line2, state, country, postal_code, territory )
-- 			VALUES ( 'Not Null', '555-1212', 'Downtown Denver', 'Address Line 2', 'CO', 'USA', '80203', 'USA' );
SELECT * FROM offices;

-- UPDATE will affect the entire table if a WHERE clause is not invoked
-- always use a WHERE clause with the UPDATE
UPDATE offices SET phone = '+1 123 555 1212' WHERE phone = '555-1212' AND ID = '11';

-- DELETE will affect the entire table if a WHERE clause is not invoked
DELETE FROM offices WHERE id = '11';
SELECT * FROM offices;


SELECT * FROM employees WHERE office_id = 4;

-- I want to see the first and last name of all employees and the office city that they work in.
SELECT firstname, lastname, city, o.id, e.office_id
FROM employees e, offices o WHERE e.office_id = o.id;

-- I want to see a list of customers for a particular employee
SELECT * FROM customers WHERE sales_rep_employee_id = 1504;

-- I want to see all customers with the contact last name Cassidy
SELECT * FROM customers WHERE contact_lastname = 'Cassidy';
SELECT * FROM customers WHERE country = 'Ireland';

-- credit limit less than 10k
SELECT * FROM customers WHERE credit_limit > 10000 AND credit_limit < 50000;

-- I want to see all customer contracts where the first name starts with J
SELECT * FROM customers WHERE contact_firstname LIKE 'J%';

-- I want to see the list of customers that work with an employee in the San Fran office
-- SELECT * FROM customers WHERE employees.city = "San Francisco"