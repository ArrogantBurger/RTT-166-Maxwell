-- Let's calculate the total profit for an order with ID 10100
SELECT p.id, p.product_name, p.buy_price, od.quantity_ordered, od.price_each, (od.price_each - p.buy_price) as profit_margin, ((od.price_each - p.buy_price) * od.quantity_ordered) as order_profit FROM orderdetails od, products p
WHERE od.product_id = p.id AND od.order_id = 10100;

-- Let's calculate the total profit for all orders
SELECT od.order_id, sum((od.price_each - p.buy_price) * od.quantity_ordered) as order_profit FROM orderdetails od, products p
WHERE od.product_id = p.id
GROUP BY od.order_id;

-- Total profit across all orders for a month
SELECT YEAR(order_date), MONTH(order_date), sum((od.price_each - p.buy_price) * od.quantity_ordered) as order_profit FROM orders ord, orderdetails od, products p
WHERE od.product_id = p.id AND od.order_id = ord.id
GROUP BY YEAR(ord.order_date), MONTH(ord.order_date);

-- ============================

SELECT * FROM orders
WHERE order_date < current_date();

-- Replaces null elements in order.comments column with "Replace comment"
SELECT IFNULL(comments, "Replace comment") FROM orders;

-- THIS IS A WRONG QUERY.
SELECT * FROM orders WHERE comments = null;
-- THIS IS CORRECT.
SELECT * FROM orders WHERE comments IS NULL;

-- Example of OR operator
SELECT * FROM orders
WHERE id = 10101 OR id = 10107;

-- CASE statement example, behaves the same as a switch statement in Java
-- SBA QUESTION
SELECT product_name, buy_price,
CASE
	WHEN buy_price > 9 AND buy_price <= 50 THEN "LOW PRICE"
    WHEN buy_price > 50 AND buy_price <= 100 THEN "Medium price"
    WHEN buy_price > 100 AND buy_price <= 200 THEN "high price"
ELSE "Out of our range" END AS price_status
FROM products
ORDER BY buy_price DESC;

-- IN operator is like an OR, and in this case will return any row matching any of the 3 cities
-- The two queries are functionally equivalent
SELECT * FROM customers WHERE city IN ('Las Vegas', 'Nantes', 'Frankfurt');
SELECT * FROM customers WHERE city = 'Las Vegas' OR city = 'Nantes' OR city = 'Frankfurt';

-- Show all of the orders for customers that have a name starting with A
-- Start with all IDs of customers where the names start with A
SELECT id FROM customers WHERE customer_name LIKE 'A%';

-- Technique where IN keyword is used as a filter via subquery (subquery must return single column)
-- Pulls all orders where customer_id is present in list of IDs from customers table where the name starts with A
SELECT * FROM orders WHERE customer_id IN (SELECT id FROM customers WHERE customer_name LIKE 'A%');

-- Subquery: by using a subquery in the FROM clause, it creates a small table in memory from the original query
-- then you can join it to the table as if it were real
-- In this example, subquery introduces customer table with names that start with A
SELECT * FROM orders ord, (SELECT id FROM customers WHERE customer_name LIKE 'A%') as c
WHERE ord.customer_id = c.id;
