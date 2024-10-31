-- I want to see the name of the product line, and all product names in that product line
-- Order by the produce line name, then by the product name
SELECT pl.product_line, p.product_name FROM products p, productlines pl
WHERE p.productline_id = pl.id
ORDER BY pl.product_line, p.product_name;

-- I want to see the order number, product name, and the quantity ordered
-- Order by the order number (descending), then product name (ascending), then quantity ordered (fewest first)
SELECT od.order_id, p.product_name, od.quantity_ordered FROM orderdetails od, products p
WHERE od.product_id = p.id
ORDER BY od.order_id desc, p.product_name asc, od.quantity_ordered asc;

-- I want to see all payments made by customers. Result should show customer name, check number, payment date, and the amount.
-- Order by customer name (ascending), the payment date (descending, newest first)
SELECT c.customer_name, pm.check_number, pm.payment_date, pm.amount FROM customers c, payments pm
WHERE pm.customer_id = c.id
ORDER BY c.customer_name asc, pm.payment_date desc;

-- I want to see the orders and all products in that order: order number and product name
-- Order by the order number ascending and the product name descending
SELECT od.order_id, od.quantity_ordered, p.product_name FROM orderdetails od, products p
WHERE od.product_id = p.id
ORDER BY od.order_id asc, p.product_name desc;

-- I want to see the number of products in each order, I want to see the order ID and the count of each product in that order
-- Order by count(*) desc
SELECT order_id, count(*) FROM orderdetails od
GROUP BY order_id
ORDER BY order_id;

-- I want to see the customer that has made most payments (group by customer_id)
SELECT c.id, c.customer_name, count(pm.customer_id) as payment_count FROM customers c, payments pm
WHERE pm.customer_id = c.id
GROUP BY c.id
ORDER BY payment_count desc;

-- I want to see the office that has has the most orders (group by office_id)
SELECT o.id, o.city, count(ord.id) as order_count FROM offices o, employees e, customers c, orders ord
WHERE ord.customer_id = c.id AND c.sales_rep_employee_id = e.id AND e.office_id = o.id
GROUP BY o.id
ORDER BY order_count desc;

-- I want to see the order that has the most products ( group by order_id)
SELECT ord.id, c.customer_name,count(od.product_id) as product_count FROM products p, orderdetails od, orders ord, customers c
WHERE od.order_id = ord.id AND od.product_id = p.id AND ord.customer_id = c.id
GROUP BY ord.id
ORDER BY product_count desc, ord.id asc;