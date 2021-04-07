insert into products (product_id, name, company, price, expiry_date, type, description, country_made) values (1, 'Kinder Egg', 'Nestle', 2.55, '1994-1-8', 'Chocolate Bar', 'Great quality choclate', 'Germany');
insert into products (product_id, name, company, price, expiry_date, type, description, country_made) values (2, 'Coco Pops', 'Nestle', 4.55, '1994-1-8', 'Chocolate Cereal', 'Great tasting Cereal', 'Germany');
insert into shops (shop_id, name, address, country, phone_number, year_founded, picture)  values (1,'Supervalu', 'Knocklyon, Dublin', 'Ireland', 012342354, '1994-1-8', 'dewre');
insert into shops (shop_id, name, address, country, phone_number, year_founded, picture)  values (2,'Centra', 'Old Bawn, Tallaght, Dublin', 'Ireland', 012342654, '1994-1-8', 'Local Centra');
insert into shops (shop_id, name, address, country, phone_number, year_founded, picture)  values (3,'Toms', 'Firhouse, Dublin', 'Ireland', 012343209, '1994-1-8', 'Local Grocery Store');
insert into shop_products(shop_id,product_id) values (1,2);
insert into shop_products(shop_id,product_id) values (2,1);
insert into shop_products(shop_id,product_id) values (1,1);