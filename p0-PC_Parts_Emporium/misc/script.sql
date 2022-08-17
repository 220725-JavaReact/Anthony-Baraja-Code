-- Table: Products
-- Product information detail
-- Used for LineItems and StoreFront

create table products (
	id serial primary key,
	store_id int not null,
	name varchar(150) not null,
	price float NOT null,
	description varchar(300) NOT null,
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
(DEFAULT, 2, 'AMD Ryzen 9 5900X 3.7GHz 12-Core', 399.99, 'The AMD 9 Processors is the world''s most advanced processor with 12 cores for the world''s elite gamers', 'CPU'),
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
(DEFAULT, 1, 'MSI Mech Radeon RX Video Card', 182.99, 'The MSI Mech Radeon RX is built on the revolutionary AMD 2 architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 2, 'MSI Mech Radeon RX Video Card', 182.99, 'The MSI Mech Radeon RX is built on the revolutionary AMD 2 architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 3, 'MSI Mech Radeon RX Video Card', 182.99, 'The MSI Mech Radeon RX is built on the revolutionary AMD 2 architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 4, 'MSI Mech Radeon RX Video Card', 182.99, 'The MSI Mech Radeon RX is built on the revolutionary AMD 2 architecture, delivers impressive 1080p performance in both AAA and esports titles', 'Graphics Card'),
(DEFAULT, 2, 'CORSAIR Tempered Glass Mid-Tower ATX Smart Case', 159.99, 'The CORSAIR Tempered Glass makes a stunning, showpiece-worthy PC easy to build and easier to keep cool with the space and flexibility to mount multiple fans', 'Computer Case'),
(DEFAULT, 4, 'CORSAIR Tempered Glass Mid-Tower ATX Smart Case', 159.99, 'The CORSAIR Tempered Glass makes a stunning, showpiece-worthy PC easy to build and easier to keep cool with the space and flexibility to mount multiple fans', 'Computer Case'),
(DEFAULT, 1, 'Fractal Design White Steel Mid Tower ATX Computer Case', 99.99, 'The Fractal Design White Steel strikes an aggressive pose in the Fractal Design lineup with unparalleled cooling performance and a defiant new look', 'Computer Case'),
(DEFAULT, 3, 'Fractal Design White Steel Mid Tower ATX Computer Case', 99.99, 'The Fractal Design White Steel strikes an aggressive pose in the Fractal Design lineup with unparalleled cooling performance and a defiant new look', 'Computer Case'),
(DEFAULT, 1, 'Cooler Master MB530P Black ATX Computer Case', 106.99, 'The Cooler Master MB530P will impress everyone with premium build quality and tempered-glass panel on three sides', 'Computer Case'),
(DEFAULT, 2, 'Cooler Master MB530P Black ATX Computer Case', 106.99, 'The Cooler Master MB530P will impress everyone with premium build quality and tempered-glass panel on three sides', 'Computer Case'),
(DEFAULT, 3, 'Cooler Master MB530P Black ATX Computer Case', 106.99, 'The Cooler Master MB530P will impress everyone with premium build quality and tempered-glass panel on three sides', 'Computer Case'),
(DEFAULT, 4, 'Cooler Master MB530P Black ATX Computer Case', 106.99, 'The Cooler Master MB530P will impress everyone with premium build quality and tempered-glass panel on three sides', 'Computer Case'),
(DEFAULT, 1, 'EVGA 400W Power Supply', 49.99, 'The EVGA 400W Strix contains a quiet and intelligent auto fan for near-silent operation', 'Power Supply'),
(DEFAULT, 2, 'EVGA 400W Power Supply', 49.99, 'The EVGA 400W Strix contains a quiet and intelligent auto fan for near-silent operation', 'Power Supply'),
(DEFAULT, 3, 'EVGA 400W Power Supply', 49.99, 'The EVGA 400W Strix contains a quiet and intelligent auto fan for near-silent operation', 'Power Supply'),
(DEFAULT, 4, 'EVGA 400W Power Supply', 49.99, 'The EVGA 400W Strix contains a quiet and intelligent auto fan for near-silent operation', 'Power Supply'),
(DEFAULT, 2, 'FSP Hydro GE 550W PFC Power Supply', 79.99, 'The FSP Hydro is designed to maximize cooling efficiency with features such as thermal control design, internal component arrangement for increased airflow, enhanced heat dissipation and efficient energy conversion', 'Power Supply'),
(DEFAULT, 3, 'FSP Hydro GE 550W PFC Power Supply', 79.99, 'The FSP Hydro is designed to maximize cooling efficiency with features such as thermal control design, internal component arrangement for increased airflow, enhanced heat dissipation and efficient energy conversion', 'Power Supply'),
(DEFAULT, 4, 'FSP Hydro GE 550W PFC Power Supply', 79.99, 'The FSP Hydro is designed to maximize cooling efficiency with features such as thermal control design, internal component arrangement for increased airflow, enhanced heat dissipation and efficient energy conversion', 'Power Supply'),
(DEFAULT, 1, 'Seasonic SSP-650RS 650W Power Supply', 117.99, 'The Seasonic SSP-650RS units are well protected against short circuit, over power and over voltage occurrences', 'Power Supply'),
(DEFAULT, 3, 'Seasonic SSP-650RS 650W Power Supply', 117.99, 'The Seasonic SSP-650RS units are well protected against short circuit, over power and over voltage occurrences', 'Power Supply'),
(DEFAULT, 4, 'Seasonic SSP-650RS 650W Power Supply', 117.99, 'The Seasonic SSP-650RS units are well protected against short circuit, over power and over voltage occurrences', 'Power Supply'),
(DEFAULT, 2, 'CORSAIR RM 750W Power Supply', 129.99, 'The CORSAIR RM delivers efficient power to your PC and have all the connections needed to power today’s most demanding PC upgrades', 'Power Supply'),
(DEFAULT, 3, 'CORSAIR RM 750W Power Supply', 129.99, 'The CORSAIR RM delivers efficient power to your PC and have all the connections needed to power today’s most demanding PC upgrades', 'Power Supply'),
(DEFAULT, 4, 'CORSAIR RM 750W Power Supply', 129.99, 'The CORSAIR RM delivers efficient power to your PC and have all the connections needed to power today’s most demanding PC upgrades', 'Power Supply'),
(DEFAULT, 1, 'Seagate BarraCuda 4TB Hard Drive', 67.99, 'The Seagate BarraCuda is a cost-effective storage upgrade for desktop computers', 'Internal Drive'),
(DEFAULT, 2, 'Seagate BarraCuda 4TB Hard Drive', 67.99, 'The Seagate BarraCuda is a cost-effective storage upgrade for desktop computers', 'Internal Drive'),
(DEFAULT, 3, 'Seagate BarraCuda 4TB Hard Drive', 67.99, 'The Seagate BarraCuda is a cost-effective storage upgrade for desktop computers', 'Internal Drive'),
(DEFAULT, 4, 'Seagate BarraCuda 4TB Hard Drive', 67.99, 'The Seagate BarraCuda is a cost-effective storage upgrade for desktop computers', 'Internal Drive'),
(DEFAULT, 1, 'Seagate IronWolf 12TB Hard Drive', 229.99, 'The Seagate IronWolf enables dual-plane balancing and RAID optimization in multi-bay environments', 'Internal Drive'),
(DEFAULT, 2, 'Seagate IronWolf 12TB Hard Drive', 229.99, 'The Seagate IronWolf enables dual-plane balancing and RAID optimization in multi-bay environments', 'Internal Drive'),
(DEFAULT, 3, 'Seagate IronWolf 12TB Hard Drive', 229.99, 'The Seagate IronWolf enables dual-plane balancing and RAID optimization in multi-bay environments', 'Internal Drive'),
(DEFAULT, 4, 'Seagate IronWolf 12TB Hard Drive', 229.99, 'The Seagate IronWolf enables dual-plane balancing and RAID optimization in multi-bay environments', 'Internal Drive'),
(DEFAULT, 2, 'Crucial MX500 1TB Internal SSD', 82.99, 'The Crucial MX500 is a drive built on quality, speed, and security that’s all backed by helpful service and support', 'Internal Drive'),
(DEFAULT, 3, 'Crucial MX500 1TB Internal SSD', 82.99, 'The Crucial MX500 is a drive built on quality, speed, and security that’s all backed by helpful service and support', 'Internal Drive'),
(DEFAULT, 1, 'SAMSUNG 870 EVO Series 4TB Internal SSD', 399.99, 'The SAMSUNG 870 EVO has indisputable performance, reliability and compatibility built upon Samsung''s pioneering technology', 'Internal Drive'),
(DEFAULT, 4, 'SAMSUNG 870 EVO Series 4TB Internal SSD', 399.99, 'The SAMSUNG 870 EVO has indisputable performance, reliability and compatibility built upon Samsung''s pioneering technology', 'Internal Drive'),
(DEFAULT, 1, 'Noctua NH-L9i Low-Profile Cooler', 43.99, 'The Noctua NH-L9i is a premium quality quiet CPU cooler for Intel LGA115x based HTPCs and Small Form Factor systems', 'Cooling Unit'),
(DEFAULT, 2, 'Noctua NH-L9i Low-Profile Cooler', 43.99, 'The Noctua NH-L9i is a premium quality quiet CPU cooler for Intel LGA115x based HTPCs and Small Form Factor systems', 'Cooling Unit'),
(DEFAULT, 3, 'Noctua NH-L9i Low-Profile Cooler', 43.99, 'The Noctua NH-L9i is a premium quality quiet CPU cooler for Intel LGA115x based HTPCs and Small Form Factor systems', 'Cooling Unit'),
(DEFAULT, 4, 'Noctua NH-L9i Low-Profile Air Cooler', 43.99, 'The Noctua NH-L9i is a premium quality quiet CPU cooler for Intel LGA115x based HTPCs and Small Form Factor systems', 'Cooling Unit'),
(DEFAULT, 1, 'Cooler Master MA612 Stealth Air Cooler', 101.99, 'The Cooler Master MA612 contains asymmetrical heat pipe design provides RAM compatibility and clearance across various platforms', 'Cooling Unit'),
(DEFAULT, 2, 'Cooler Master MA612 Stealth Air Cooler', 101.99, 'The Cooler Master MA612 contains asymmetrical heat pipe design provides RAM compatibility and clearance across various platforms', 'Cooling Unit'),
(DEFAULT, 3, 'Cooler Master MA612 Stealth Air Cooler', 101.99, 'The Cooler Master MA612 contains asymmetrical heat pipe design provides RAM compatibility and clearance across various platforms', 'Cooling Unit'),
(DEFAULT, 4, 'Cooler Master MA612 Stealth Air Cooler', 101.99, 'The Cooler Master MA612 contains asymmetrical heat pipe design provides RAM compatibility and clearance across various platforms', 'Cooling Unit'),
(DEFAULT, 2, 'Rosewill RGB AIO 240mm CPU Liquid Cooler', 89.99, 'The Rosewill RGB AIO 240mm is an effective water-based coolant liquid cooling transfers heat away from CPU and GPU more efficiently than air', 'Cooling Unit'),
(DEFAULT, 4, 'Rosewill RGB AIO 240mm CPU Liquid Cooler', 89.99, 'The Rosewill RGB AIO 240mm is an effective water-based coolant liquid cooling transfers heat away from CPU and GPU more efficiently than air', 'Cooling Unit'),
(DEFAULT, 1, 'CORSAIR iCUE H150i ELITE CAPELLIX Liquid Cooler', 179.99, 'The CORSAIR iCUE H150i consist of powerful, low-noise cooling capabilities, and your build will look as cool as it runs', 'Cooling Unit'),
(DEFAULT, 3, 'CORSAIR iCUE H150i ELITE CAPELLIX Liquid Cooler', 179.99, 'The CORSAIR iCUE H150i consist of powerful, low-noise cooling capabilities, and your build will look as cool as it runs', 'Cooling Unit'),
(DEFAULT, 1, 'ASUS Xonar AE 7.1 Channels Interface Sound Card', 69.99, 'The ASUS Xonar AE is a gaming sound card built with high-quality components to satisfy gamers who demand exceptional sound for the best gaming and multimedia experiences', 'Sound Card'),
(DEFAULT, 2, 'ASUS Xonar AE 7.1 Channels Interface Sound Card', 69.99, 'The ASUS Xonar AE is a gaming sound card built with high-quality components to satisfy gamers who demand exceptional sound for the best gaming and multimedia experiences', 'Sound Card'),
(DEFAULT, 3, 'ASUS Xonar AE 7.1 Channels Interface Sound Card', 69.99, 'The ASUS Xonar AE is a gaming sound card built with high-quality components to satisfy gamers who demand exceptional sound for the best gaming and multimedia experiences', 'Sound Card'),
(DEFAULT, 4, 'ASUS Xonar AE 7.1 Channels Interface Sound Card', 69.99, 'The ASUS Xonar AE is a gaming sound card built with high-quality components to satisfy gamers who demand exceptional sound for the best gaming and multimedia experiences', 'Sound Card');

insert into products
values (Default, 'Test Product', 99.99, 'Test serial auto increment', 'Processors', 1);

select * from products where store_id = 2;
select id from products where store_id = 2;
select * from products where id = 60;

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
select * from lineitems where product_id = 10;

drop table lineitems CASCADE;

insert into lineitems
values (DEFAULT, 1, 8),
(DEFAULT, 2, 7),
(DEFAULT, 3, 8),
(DEFAULT, 4, 8),
(DEFAULT, 5, 8),
(DEFAULT, 6, 6),
(DEFAULT, 7, 5),
(DEFAULT, 8, 3),
(DEFAULT, 9, 8),
(DEFAULT, 10, 2),
(DEFAULT, 11, 5),
(DEFAULT, 12, 8),
(DEFAULT, 13, 4),
(DEFAULT, 14, 2),
(DEFAULT, 15, 7),
(DEFAULT, 16, 6),
(DEFAULT, 17, 3),
(DEFAULT, 18, 3),
(DEFAULT, 19, 2),
(DEFAULT, 20, 7),
(DEFAULT, 21, 3),
(DEFAULT, 22, 6),
(DEFAULT, 23, 2),
(DEFAULT, 24, 2),
(DEFAULT, 25, 8),
(DEFAULT, 26, 3),
(DEFAULT, 27, 7),
(DEFAULT, 28, 8),
(DEFAULT, 29, 7),
(DEFAULT, 30, 8),
(DEFAULT, 31, 6),
(DEFAULT, 32, 5),
(DEFAULT, 33, 8),
(DEFAULT, 34, 7),
(DEFAULT, 35, 6),
(DEFAULT, 36, 6),
(DEFAULT, 37, 6),
(DEFAULT, 38, 7),
(DEFAULT, 39, 4),
(DEFAULT, 40, 5),
(DEFAULT, 41, 5),
(DEFAULT, 42, 8),
(DEFAULT, 43, 5),
(DEFAULT, 44, 3),
(DEFAULT, 45, 3),
(DEFAULT, 46, 3),
(DEFAULT, 47, 6),
(DEFAULT, 48, 8),
(DEFAULT, 49, 7),
(DEFAULT, 50, 4),
(DEFAULT, 51, 2),
(DEFAULT, 52, 6),
(DEFAULT, 53, 2),
(DEFAULT, 54, 4),
(DEFAULT, 55, 4),
(DEFAULT, 56, 6),
(DEFAULT, 57, 5),
(DEFAULT, 58, 5),
(DEFAULT, 59, 6),
(DEFAULT, 60, 8),
(DEFAULT, 61, 2),
(DEFAULT, 62, 4),
(DEFAULT, 63, 4),
(DEFAULT, 64, 5),
(DEFAULT, 65, 5),
(DEFAULT, 66, 3),
(DEFAULT, 67, 4),
(DEFAULT, 68, 7),
(DEFAULT, 69, 7),
(DEFAULT, 70, 6),
(DEFAULT, 71, 7),
(DEFAULT, 72, 7),
(DEFAULT, 73, 6),
(DEFAULT, 74, 3),
(DEFAULT, 75, 2),
(DEFAULT, 76, 2),
(DEFAULT, 77, 2),
(DEFAULT, 78, 6),
(DEFAULT, 79, 2),
(DEFAULT, 80, 6),
(DEFAULT, 81, 2),
(DEFAULT, 82, 3),
(DEFAULT, 83, 8),
(DEFAULT, 84, 3),
(DEFAULT, 85, 5),
(DEFAULT, 86, 2),
(DEFAULT, 87, 4),
(DEFAULT, 88, 5),
(DEFAULT, 89, 6),
(DEFAULT, 90, 4),
(DEFAULT, 91, 6),
(DEFAULT, 92, 8),
(DEFAULT, 93, 4),
(DEFAULT, 94, 3),
(DEFAULT, 95, 7),
(DEFAULT, 96, 4),
(DEFAULT, 97, 5),
(DEFAULT, 98, 4),
(DEFAULT, 99, 7),
(DEFAULT, 100, 7),
(DEFAULT, 101, 5),
(DEFAULT, 102, 2),
(DEFAULT, 103, 6),
(DEFAULT, 104, 6),
(DEFAULT, 105, 4),
(DEFAULT, 106, 8),
(DEFAULT, 107, 3),
(DEFAULT, 108, 8),
(DEFAULT, 109, 4);

select * from lineItems where product_id = 60;

-- Update lineitems 
update lineitems set quantity = 8 where product_id = 4;
update lineitems set quantity = 2 where product_id = 20;

-- Table: Orders
-- Contain information about an order, acts like part of a receipt
-- Used for StoreFront and Customers

create table orders (
	id serial primary key,
	lineItem_id int NOT NULL,
	store_id int NOT NULL,
	customer_id int NOT NULL,
	order_link int NOT NULL,
	totalPrice float NOT null,
	FOREIGN KEY (lineItem_id) references lineItems(id),
	FOREIGN KEY (store_id) references storefront(id),
	FOREIGN KEY (customer_id) references customers(id),
	FOREIGN KEY (order_link) references orderlink(id)
);

select * from orders;
select * from orders order by order_link asc;
select * from orders order by totalPrice asc;
select * from orders where customer_id = 1 order by order_link ASC;
select * from orders where customer_id = 1 order by order_link desc;
select * from orders where customer_id = 1 order by order_link DESC;

select * from orders where store_id = 2 order by order_link ASC;

select orders.* from orders
join orderlink
on orders.order_link = orderlink.id and orders.customer_id = 1
order by orderlink.subtotal asc;

select orders.* from orders join orderlink on orders.order_link = orderlink.id and orders.customer_id = 1  order by orderlink.subtotal desc;

select orders.* from orders join orderlink on orders.order_link = orderlink.id and orders.store_id = 2  order by orderlink.subtotal desc;

drop table orders CASCADE;

insert into orders
values (DEFAULT, 1, 2, 1, 1, 599.98),
(DEFAULT, 2, 2, 1, 2, 1519.92),
(DEFAULT, 5, 2, 1, 3, 599.96);

Insert into orders (id, lineItem_id, store_id, customer_id, order_link, totalPrice) values (DEFAULT, 1, 2, 1, 599.98);

update orders set lineItem_id = ?, store_id = ?, customer_id = ?, totalPrice = ? where id = ?
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;

DELETE FROM orders WHERE id=?

-- Table: OrderLinks
-- Contain Full order, acts like a receipt

create table orderlink (
	id serial primary key,
	subTotal float not null
);

select * from orderlink;

drop table orderlink CASCADE;

DELETE FROM orderlink WHERE id=4;

insert into orderlink
values (DEFAULT, 599.98),
(DEFAULT, 1519.92),
(DEFAULT, 599.96);


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


