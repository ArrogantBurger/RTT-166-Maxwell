-- Which product did we sell the most of?
-- Show number of orders, the total amount sold, and the product name
SELECT count(ord.id) as order_num, p.product_name, sum(od.quantity_ordered) as total_units_sold FROM orders ord, orderdetails od, products p
WHERE od.order_id = ord.id AND od.product_id = p.id
GROUP BY p.product_name
ORDER BY total_units_sold DESC, order_num DESC;

-- Which product generated the most profit by year?
-- Show year, product name, and total profit, Order By year desc, profit, desc
SELECT YEAR(order_date), p.product_name, sum(od.quantity_ordered) as units_sold, sum((od.price_each - p.buy_price) * od.quantity_ordered) as profit FROM orders ord, orderdetails od, products p
WHERE od.product_id = p.id AND od.order_id = ord.id
GROUP BY YEAR(order_date), p.product_name
ORDER BY profit DESC;

-- Which office is the most profitable? Result should show the name off the office, and total profit for the office ordered by profit descending
SELECT o.city, sum((od.price_each - p.buy_price) * od.quantity_ordered) as profit FROM offices o, employees e, customers c, orders ord, orderdetails od, products p
WHERE ord.customer_id = c.id AND c.sales_rep_employee_id = e.id AND e.office_id = o.id AND od.product_id = p.id AND od.order_id = ord.id
GROUP BY o.city
ORDER BY profit DESC;

-- Show me all the customers that have an outstanding balance due. Use a summation of payments for the customer and compare the total amount paid to the total amount purchased.
SELECT customer_name, sum(od.price_each * od.quantity_ordered) as total_purchased, pm.payment_date, sum(pm.amount) as total_paid FROM customers c, payments pm, orders ord, orderdetails od, products p
WHERE ord.customer_id = c.id AND pm.customer_id = c.id AND od.product_id = p.id AND od.order_id = ord.id
GROUP BY customer_name, pm.payment_date
