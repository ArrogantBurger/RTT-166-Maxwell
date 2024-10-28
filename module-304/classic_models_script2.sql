-- JOIN and GROUP BY
-- how many employees are in each office? I want to see the office name and the employee count in that office
-- GROUP BY is called an aggregate function, because we can make groups and then find information about that group
SELECT * FROM employees;
SELECT * FROM offices;

-- step 1: get count of office IDs
SELECT office_id, count(*) FROM employees
GROUP BY office_id;

-- step 2: add name of office, forces adding another table to the form and adding WHERE to link the tables together
SELECT e.office_id, o.city, count(*) FROM employees e, offices o
WHERE e.office_id = o.id
GROUP BY office_id;

-- Example of finding number of employees that share the same name
SELECT firstname, count(*) FROM employees
GROUP BY firstname;

-- Find employee with the most customers
SELECT sales_rep_employee_id, count(*) FROM customers
GROUP BY sales_rep_employee_ID
ORDER BY count(*) desc;

-- step 2: Add the employee table to get the employee name
-- Note that entries where sales_rep_employee_id was NULL were lost
SELECT e.firstname, e.lastname, c.sales_rep_employee_id, count(*) FROM customers c, employees e
WHERE c.sales_rep_employee_id = e.id
GROUP BY c.sales_rep_employee_ID
ORDER BY count(*) desc;

-- I want to see a list of all customers for the San Francisco office
SELECT e.firstname, e.lastname, c.customer_name, o.city, c.contact_firstname, c.contact_lastname FROM customers c , employees e, offices o
WHERE c.sales_rep_employee_id = e.id AND e.office_id = o.id AND o.id = 1;

-- I want to see a list of all customers, the sales rep, and the office name
SELECT e.firstname, e.lastname, c.customer_name, o.city, c.contact_firstname, c.contact_lastname FROM customers c , employees e, offices o
WHERE c.sales_rep_employee_id = e.id AND e.office_id = o.id;

-- I want to see all the customers that have made an order, and I want to see the customer name, the office, employee name, and order ID + date, AND product ID + quantity
SELECT c.customer_name, e.firstname, e.lastname, o.city, ord.id, ord.order_date, od.product_id, od.quantity_ordered, p.product_name FROM customers c, employees e, offices o, orders ord, orderdetails od, products p
WHERE c.sales_rep_employee_id = e.id AND e.office_id = o.id AND ord.customer_id = c.id AND od.order_id = ord.id AND od.product_id = p.id
ORDER BY e.id, c.customer_name, od.order_id, p.product_name;

-- I want to see all the products that have been ordered, and how many times each product has been ordered
-- I want to see the product that was ordered the most on top
SELECT od.order_id AS order_number, count(*) FROM orders ord, orderdetails od, products p
WHERE od.product_id = p.id
GROUP BY od.order_id
ORDER BY od.order_id;