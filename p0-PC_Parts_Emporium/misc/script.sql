-- Table: Products
-- Product information detail
-- Used for LineItems and StoreFront

create table products (
	id serial primary key,
	name varchar(50) not null,
	price float NOT null,
	description varchar(200) NOT null,
	category varchar(50) NOT null,
	store_id int not null,
	FOREIGN KEY (store_id) references storeFront(id)
);

select * from products;

drop table products CASCADE;

insert into products(id, name, price, description, category, store_id)
values (DEFAULT, 'Intel Core i7-9000K', 299.99, '9th Generation Intel Core i7 Processors', 'Processors', 1),
 (DEFAULT, 'ASUS B550-A ATX Motherboard', 189.99, 'GAMING motherboard, based on the fresh AMD B550 chipset', 'Motherboards', 1),
 (DEFAULT, 'Corsair Viper 32GB RAM', 145.99, 'DDR5 Desktop Memory has the high speed needed for the next generation of multi-core CPUs', 'RAM', 1),
 (DEFAULT, 'EVGA NVIDIA GeForce RTX Graphics Card', 739.99, 'Provides high quality NVIDIA RTX experience to handle 1080p and 1440p gaming', 'Graphics Card', 1),
 (DEFAULT, 'Samsung 950 Pro SSD', 149.99, 'Unleash the power of the Samsung 950 PRO PCIe 4.0 SSD for next-level computing', 'Data Storage', 1),
 (DEFAULT, 'Montech X3 Tempered Glass Mid-Tower Computer Case', 67.99, 'PC Gaming case, delivers the best Price per Performance ratio Montech has to offer', 'Computer Case', 1),
 (DEFAULT, 'Cooler Master Hyper 212 CPU Air Cooler', 61.99, 'Cooling solution for heavy computing performance', 'Cooling Unit', 1),
 (DEFAULT, 'ASUS XONAR 5.1 Channel PCIe Sound Card', 48.99, 'Sound card built with high-quality components to satisfy users experience', 'Sound Card', 1),
 (DEFAULT, 'Intel Core i7-9000K', 299.99, '9th Generation Intel Core i7 Processors', 'Processors', 2),
 (DEFAULT, 'Intel Core i7-9000K', 299.99, '9th Generation Intel Core i7 Processors', 'Processors', 4),
 (DEFAULT, 'ASUS B550-A ATX Motherboard', 189.99, 'GAMING motherboard, based on the fresh AMD B550 chipset', 'Motherboards', 2),
 (DEFAULT, 'ASUS B550-A ATX Motherboard', 189.99, 'GAMING motherboard, based on the fresh AMD B550 chipset', 'Motherboards', 3),
 (DEFAULT, 'ASUS B550-A ATX Motherboard', 189.99, 'GAMING motherboard, based on the fresh AMD B550 chipset', 'Motherboards', 4),
 (DEFAULT, 'Corsair Viper 32GB RAM', 145.99, 'DDR5 Desktop Memory has the high speed needed for the next generation of multi-core CPUs', 'RAM', 3),
 (DEFAULT, 'Corsair Viper 32GB RAM', 145.99, 'DDR5 Desktop Memory has the high speed needed for the next generation of multi-core CPUs', 'RAM', 4),
 (DEFAULT, 'EVGA NVIDIA GeForce RTX Graphics Card', 739.99, 'Provides high quality NVIDIA RTX experience to handle 1080p and 1440p gaming', 'Graphics Card', 2),
 (DEFAULT, 'EVGA NVIDIA GeForce RTX Graphics Card', 739.99, 'Provides high quality NVIDIA RTX experience to handle 1080p and 1440p gaming', 'Graphics Card', 3),
 (DEFAULT, 'Cooler Master Hyper 212 CPU Air Cooler', 61.99, 'Cooling solution for heavy computing performance', 'Cooling Unit', 4),
 (DEFAULT, 'ASUS XONAR 5.1 Channel PCIe Sound Card', 48.99, 'Sound card built with high-quality components to satisfy users experience', 'Sound Card', 3),
 (DEFAULT, 'ASUS XONAR 5.1 Channel PCIe Sound Card', 48.99, 'Sound card built with high-quality components to satisfy users experience', 'Sound Card', 4);

insert into products
values (Default, 'Test Product', 99.99, 'Test serial auto increment', 'Processors', 1);

select * from products where store_id = 2;
select id from products where store_id = 2;

-- Table: LineItems
-- Quantity of a Product available
-- Used for Orders

create table lineItems (
	id serial primary key,
	product_id int NOT NULL,
	quantity int NOT null,
	FOREIGN KEY (product_id) references products(id)
);

select * from lineitems;

drop table lineitems CASCADE;

insert into lineitems
values (1, 1, 2),
(2, 2, 8),
(3, 3, 23),
(4, 4, 7),
(5, 5, 4),
(6, 6, 8),
(7, 7, 10),
(8, 8, 7),
(9, 20, 2),
(10, 18, 1),
(11, 17, 1),
(12, 19, 1);

select * from lineItems where product_id = 4;

-- Update lineitems 
update lineitems set quantity = 8 where product_id = 4;
update lineitems set quantity = 2 where product_id = 20;

-- Table: Orders
-- Contain information about an order, acts like a receipt
-- Used for StoreFront and Customers

create table orders (
	id serial primary key,
	lineItem_id int NOT NULL,
	store_id int NOT NULL,
	customer_id int NOT NULL,
	totalPrice float NOT null,
	FOREIGN KEY (lineItem_id) references lineItems(id),
	FOREIGN KEY (store_id) references storefront(id),
	FOREIGN KEY (customer_id) references customers(id)
);

select * from orders;

drop table orders CASCADE;

insert into orders
values (DEFAULT, 1, 2, 1, 599.98),
(DEFAULT, 2, 2, 1, 1519.92),
(DEFAULT, 5, 2, 1, 599.96),
(DEFAULT, 11, 3, 2, 739.99),
(DEFAULT, 12, 3, 2, 48.99);

Insert into orders (id, lineItem_id, store_id, customer_id, totalPrice) values (DEFAULT, 1, 2, 1, 599.98);

update orders set lineItem_id = ?, store_id = ?, customer_id = ?, totalPrice = ? where id = ?
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;

DELETE FROM orders WHERE id=?

-- Table: StoreFront
-- Contain Store information, inventory lookup
-- Used to provide store location for Orders

create table storeFront (
	id serial primary key,
	name varchar(50) NOT NULL,
	address varchar(200) NOT null
);

select * from storefront;

drop table storefront CASCADE;

insert into storefront
values (1, 'PC Emporium - San Fernando', '645 E State St, San Fernando, CA 91340'),
(2, 'PC Emporium - Los Angeles', '246 Wilshire Avenue, Los Angeles, CA 90018'),
(3, 'PC Emporium - San Diego', '123 Prime Blvd, San Diego, CA 92116'),
(4, 'PC Emporium - Venice', '987 Cry More Rd, Venice, CA 90294');

-- Table: Customers
-- Contain customer information including order history

create table customers (
	id serial primary key,
	name varchar(50) NOT NULL,
	address varchar(200),
	email varchar(50),
	phone_number varchar(10)
);

select * from customers;
select * from customers where name = 'Anthony Baraja';
select * from customers where name like '%Baraja%';

drop table customers CASCADE;

insert into customers
values (DEFAULT, 'Anthony Baraja', '1234 Main St, Los Angeles, CA 90016', 'anthony9000@hotmail.com', '6364489591'),
 (DEFAULT, 'Kyle Suarez', '452 Fake St, San Diego, CA 92117', 'kyleOne@gmail.com', '6364598534'),
 (DEFAULT, 'Foxxy Grace', '246 Reak St, San Fernando, CA 91341', 'foxxyRoxxy@aol.com', '6366689588');


