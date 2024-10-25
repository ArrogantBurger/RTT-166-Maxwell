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
-- SELECT * FROM customers WHERE 