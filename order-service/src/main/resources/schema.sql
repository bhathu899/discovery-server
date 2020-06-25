DROP TABLE IF EXISTS ORDERS;  
CREATE TABLE ORDERS ( 
product_code VARCHAR(50) PRIMARY KEY,
customer_name VARCHAR(50) NOT NULL,
shipping_address VARCHAR(50) NOT NULL,
order_date TIMESTAMP(9) NOT NULL,
total INT(8) NOT NULL  
);    