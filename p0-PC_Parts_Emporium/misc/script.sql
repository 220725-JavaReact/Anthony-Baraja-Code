-- Table: Products
-- Product information detail
-- Used for LineItems and StoreFront

create table products (
	id serial primary key,
	store_id int not null,
	name varchar(50) not null,
	price float NOT null,
	description varchar(200) NOT null,
	category varchar(50) NOT null,
	FOREIGN KEY (store_id) references storeFront(id)
);

select * from products;

drop table products CASCADE;

insert into products(id, store_id, name, price, description, category)
values (DEFAULT, 1, 'Intel Core i3-10105 3.7 GHz 4-Core', 89.99, 'The Intel i3 Processors provide the value and power for everyday gaming, multitasking, and productivity', 'CPU'),
(DEFAULT, 2, 'Intel Core i3-10105 3.7 GHz 4-Core', 89.99, 'The Intel i3 Processors provide the value and power for everyday gaming, multitasking, and productivity', 'CPU'),
(DEFAULT, 3, 'Intel Core i3-10105 3.7 GHz 4-Core', 89.99, 'The Intel i3 Processors provide the value and power for everyday gaming, multitasking, and productivity', 'CPU'),
(DEFAULT, 4, 'Intel Core i3-10105 3.7 GHz 4-Core', 89.99, 'The Intel i3 Processors provide the value and power for everyday gaming, multitasking, and productivity', 'CPU'),
(DEFAULT, 1, 'Intel Core i5-11400 2.6GHz 6-Core', 149.99, 'Create, edit, share 4K content, and enjoy immersive experiences with the Intel i5 processors', 'CPU'),
(DEFAULT, 2, 'Intel Core i5-11400 2.6GHz 6-Core', 149.99, 'Create, edit, share 4K content, and enjoy immersive experiences with the Intel i5 processors', 'CPU'),
(DEFAULT, 4, 'Intel Core i5-11400 2.6GHz 6-Core', 149.99, 'Create, edit, share 4K content, and enjoy immersive experiences with the Intel i5 processors', 'CPU'),
(DEFAULT, 2, 'Intel Core i7-11700K 3.6GHz 8-Core', 269.99, 'With the Intel i7, you will be able to game without compromise, with 8 cores, it divides, so you can conquer', 'CPU'),
(DEFAULT, 3, 'Intel Core i7-11700K 3.6GHz 8-Core', 269.99, 'With the Intel i7, you will be able to game without compromise, with 8 cores, it divides, so you can conquer', 'CPU'),
(DEFAULT, 2, 'Intel Core i9-11900K 3.5GHz 8-Core', 329.99, 'The Intel i9 feature an innovative architecture designed for AI, immersive display and graphics, plus enhanced tuning and expandability to put gamers and PC enthusiasts fully in control of real-world experiences', 'CPU'),
(DEFAULT, 2, 'Intel Core i9-12900K 3.2GHz 16-Core', 529.99, 'The Intel i9 feature an innovative architecture designed for AI, immersive display and graphics, plus enhanced tuning and expandability to put gamers and PC enthusiasts fully in control of real-world experiences', 'CPU'),
(DEFAULT, 1, 'AMD Ryzen 5 5600 3.5GHz 6-Core', 149.99, 'The AMD 5 offers a mid-range processing performance ideal for casual gaming and office work', 'CPU'),
(DEFAULT, 2, 'AMD Ryzen 5 5600 3.5GHz 6-Core', 149.99, 'The AMD 5 offers a mid-range processing performance ideal for casual gaming and office work', 'CPU'),
(DEFAULT, 3, 'AMD Ryzen 5 5600 3.5GHz 6-Core', 149.99, 'The AMD 5 offers a mid-range processing performance ideal for casual gaming and office work', 'CPU'),
(DEFAULT, 4, 'AMD Ryzen 5 5600 3.5GHz 6-Core', 149.99, 'The AMD 5 offers a mid-range processing performance ideal for casual gaming and office work', 'CPU'),
(DEFAULT, 2, 'AMD Ryzen 7 5700X 3.4GHz 8-Core', 239.99, 'The AMD 7 Processors is optimized for high-FPS gaming rigs', 'CPU'),
(DEFAULT, 3, 'AMD Ryzen 7 5700X 3.4GHz 8-Core', 239.99, 'The AMD 7 Processors is optimized for high-FPS gaming rigs', 'CPU'),
(DEFAULT, 4, 'AMD Ryzen 7 5700X 3.4GHz 8-Core', 239.99, 'The AMD 7 Processors is optimized for high-FPS gaming rigs', 'CPU'),
(DEFAULT, 2, 'AMD Ryzen 9 5900X 3.7GHz 12-Core', 399.99, 'The AMD 9 Processors is the world\'s most advanced processor with 12 cores for the world\'s elite gamers', 'CPU'),
(DEFAULT, 2, 'ASUS Z690 Intel 12th Gen ATX Gaming Motherboard', 268.99, 'The ASUS Z690 motherboard takes all the essential elements of the latest Intel processors and combines them with game-ready features and proven durability', 'Motherboard'),
(DEFAULT, 3, 'ASUS Z690 Intel 12th Gen ATX Gaming Motherboard', 268.99, 'The ASUS Z690 motherboard takes all the essential elements of the latest Intel processors and combines them with game-ready features and proven durability', 'Motherboard'),
(DEFAULT, 4, 'ASUS Z690 Intel 12th Gen ATX Gaming Motherboard', 268.99, 'The ASUS Z690 motherboard takes all the essential elements of the latest Intel processors and combines them with game-ready features and proven durability', 'Motherboard'),
(DEFAULT, 1, 'MSI PRO Z690-A ATX Intel Motherboard', 194.99, 'The MSI PRO z690 provide stable functionality and high-quality assembly, not only optimized professional workflows but also less troubleshooting and longevity', 'Motherboard'),
(DEFAULT, 2, 'MSI PRO Z690-A ATX Intel Motherboard', 194.99, 'The MSI PRO z690 provide stable functionality and high-quality assembly, not only optimized professional workflows but also less troubleshooting and longevity', 'Motherboard'),
(DEFAULT, 3, 'MSI PRO Z690-A ATX Intel Motherboard', 194.99, 'The MSI PRO z690 provide stable functionality and high-quality assembly, not only optimized professional workflows but also less troubleshooting and longevity', 'Motherboard'),
(DEFAULT, 1, 'GIGABYTE Z590 Intel ATX Motherboard', 194.99, 'The GIGABYTE z590 is well equipped to unleash the full performance of Intel Core processors, with robust power design, Ultra Durable components, and enlarged heatsinks providing more surface area for heat dissipation', 'Motherboard'),
(DEFAULT, 2, 'GIGABYTE Z590 Intel ATX Motherboard', 194.99, 'The GIGABYTE z590 is well equipped to unleash the full performance of Intel Core processors, with robust power design, Ultra Durable components, and enlarged heatsinks providing more surface area for heat dissipation', 'Motherboard'),
(DEFAULT, 3, 'GIGABYTE Z590 Intel ATX Motherboard', 194.99, 'The GIGABYTE z590 is well equipped to unleash the full performance of Intel Core processors, with robust power design, Ultra Durable components, and enlarged heatsinks providing more surface area for heat dissipation', 'Motherboard'),
(DEFAULT, 4, 'GIGABYTE Z590 Intel ATX Motherboard', 194.99, 'The GIGABYTE z590 is well equipped to unleash the full performance of Intel Core processors, with robust power design, Ultra Durable components, and enlarged heatsinks providing more surface area for heat dissipation', 'Motherboard'),
(DEFAULT, 1, 'ASUS ROG B550-F ATX AMD Motherboard', 189.99, 'The ASUS ROG B550-F provide robust power delivery and effective cooling, this motherboard gives you a head start on your dream build', 'Motherboard'),
(DEFAULT, 3, 'ASUS ROG B550-F ATX AMD Motherboard', 189.99, 'The ASUS ROG B550-F provide robust power delivery and effective cooling, this motherboard gives you a head start on your dream build', 'Motherboard'),
(DEFAULT, 2, 'MSI B450 TOMAHAWK AMD Motherboard', 104.99, 'The MSI B450 TOMAHAWK have been upgraded to support multiple Ryzen processor generations including Ryzen series processors', 'Motherboard'),
(DEFAULT, 4, 'MSI B450 TOMAHAWK AMD Motherboard', 104.99, 'The MSI B450 TOMAHAWK have been upgraded to support multiple Ryzen processor generations including Ryzen series processors', 'Motherboard'),
(DEFAULT, 1, 'ASRock B550 ATX AMD Motherboard', 94.99, 'The ASRock B550 is designed by gamers, it contains gaming oriented features and excellent gaming capabilities', 'Motherboard'),
(DEFAULT, 2, 'ASRock B550 ATX AMD Motherboard', 94.99, 'The ASRock B550 is designed by gamers, it contains gaming oriented features and excellent gaming capabilities', 'Motherboard'),
(DEFAULT, 3, 'ASRock B550 ATX AMD Motherboard', 94.99, 'The ASRock B550 is designed by gamers, it contains gaming oriented features and excellent gaming capabilities', 'Motherboard'),
(DEFAULT, 4, 'ASRock B550 ATX AMD Motherboard', 94.99, 'The ASRock B550 is designed by gamers, it contains gaming oriented features and excellent gaming capabilities', 'Motherboard'),
(DEFAULT, 1, 'G.SKILL Ripjaws 32GB RAM', 88.99, 'The G.SKILL Ripjaws is designed for sleek aesthetics and performance, it is the ideal choice for building a new performance system', 'RAM'),
(DEFAULT, 3, 'G.SKILL Ripjaws 32GB RAM', 88.99, 'The G.SKILL Ripjaws is designed for sleek aesthetics and performance, it is the ideal choice for building a new performance system', 'RAM'),
(DEFAULT, 4, 'G.SKILL Ripjaws 32GB RAM', 88.99, 'The G.SKILL Ripjaws is designed for sleek aesthetics and performance, it is the ideal choice for building a new performance system', 'RAM'),
(DEFAULT, 2, 'CORSAIR Vengeance 16GB RAM', 56.99, 'The CORSAIR Vengeance is designed for high-performance overclocking', 'RAM'),
(DEFAULT, 3, 'CORSAIR Vengeance 16GB RAM', 56.99, 'The CORSAIR Vengeance is designed for high-performance overclocking', 'RAM'),
(DEFAULT, 4, 'CORSAIR Vengeance 16GB RAM', 56.99, 'The CORSAIR Vengeance is designed for high-performance overclocking', 'RAM'),
(DEFAULT, 1, 'Kingston Fury Beast 16GB RAM', 66.99, 'The Kingston Fury Beast delivers a boost of performance and style with high speeds, aggressive styling and RGB lighting that runs the length of the module for smooth and stunning effects', 'RAM'),
(DEFAULT, 3, 'Kingston Fury Beast 16GB RAM', 66.99, 'The Kingston Fury Beast delivers a boost of performance and style with high speeds, aggressive styling and RGB lighting that runs the length of the module for smooth and stunning effects', 'RAM'),
(DEFAULT, 4, 'Kingston Fury Beast 16GB RAM', 66.99, 'The Kingston Fury Beast delivers a boost of performance and style with high speeds, aggressive styling and RGB lighting that runs the length of the module for smooth and stunning effects', 'RAM'),
(DEFAULT, 1, 'MSI Mech Radeon RX 6500 Video Card', 182.99, 'The MSI Mech Radeon is built on the revolutionary AMD architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 2, 'MSI Mech Radeon RX 6500 Video Card', 182.99, 'The MSI Mech Radeon is built on the revolutionary AMD architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 3, 'MSI Mech Radeon RX 6500 Video Card', 182.99, 'The MSI Mech Radeon is built on the revolutionary AMD architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 2, 'ASUS ROG Strix 3050 Video Card', 419.99, 'The ASUS ROG Strix has been designed to push performance boundaries', 'Graphics Card'),
(DEFAULT, 3, 'ASUS ROG Strix 3050 Video Card', 419.99, 'The ASUS ROG Strix has been designed to push performance boundaries', 'Graphics Card'),
(DEFAULT, 4, 'ASUS ROG Strix 3050 Video Card', 419.99, 'The ASUS ROG Strix has been designed to push performance boundaries', 'Graphics Card'),
(DEFAULT, 1, 'EVGA GeForce RTX 3070 Video Card', 599.99, 'The EVGA GeForce RTX are colossally powerful in every way, giving you a whole new tier of performance', 'Graphics Card'),
(DEFAULT, 2, 'EVGA GeForce RTX 3070 Video Card', 599.99, 'The EVGA GeForce RTX are colossally powerful in every way, giving you a whole new tier of performance', 'Graphics Card'),
(DEFAULT, 3, 'EVGA GeForce RTX 3070 Video Card', 599.99, 'The EVGA GeForce RTX are colossally powerful in every way, giving you a whole new tier of performance', 'Graphics Card'),
(DEFAULT, 4, 'EVGA GeForce RTX 3070 Video Card', 599.99, 'The EVGA GeForce RTX are colossally powerful in every way, giving you a whole new tier of performance', 'Graphics Card'),




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


