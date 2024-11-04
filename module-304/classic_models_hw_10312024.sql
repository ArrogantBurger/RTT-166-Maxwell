-- I want to see all the employees that do not have any customers
-- Subquery should use NOT IN

SELECT * FROM employees e;
SELECT DISTINCT sales_rep_employee_id FROM customers;

SELECT * FROM employees
WHERE employees.id NOT IN (SELECT sales_rep_employee_id FROM customers);

-- I want to see all the customers that do not have any orders
-- Subquery should use NOT IN

SELECT * FROM customers
WHERE customers.id NOT IN (SELECT customer_id FROM orders);

-- I want to see all the products that have never been ordered
-- Subquery should use NOT IN

SELECT * FROM products;

SELECT * FROM products
WHERE products.id NOT IN (SELECT product_id FROM orderdetails);

-- I want to see all customers that have made an order that has more than 3 products in the order regardless of quantity

SELECT c.customer_name, ord.id, COUNT(od.product_id) as product_count FROM customers c, orders ord, orderdetails od
WHERE c.id = ord.customer_id AND od.order_id = ord.id
GROUP BY ord.id
HAVING product_count >= 1
ORDER BY product_count DESC;

-- I want to see any customer that has made an order greater than 50,000

SELECT c.customer_name, ord.id, SUM(od.quantity_ordered * od.price_each) as greatest_order_value FROM customers c, orders ord, orderdetails od
WHERE c.id = ord.customer_id AND od.order_id = ord.id
GROUP BY ord.id
HAVING greatest_order_value >= 50000
ORDER BY c.customer_name, greatest_order_value DESC;

-- Result table should have the following columns: customer_name, min_payment, avg_payment, max_payment, payment_count
-- Modeled after SBA problem
SELECT customer_name, MIN(pm.amount), AVG(pm.amount), MAX(pm.amount), COUNT(pm.amount), SUM(pm.amount)
FROM customers c, payments pm
WHERE pm.customer_id = c.id
GROUP BY customer_name
ORDER BY customer_name ASC;