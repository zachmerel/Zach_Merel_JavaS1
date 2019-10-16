use northwind;
-- What are the categories of products in the database?  
select distinct category from products;
-- What products are made by Dell? 
select * from  products where product_name like 'Dell%';
-- List all the orders shipped to Pennsylvania. 
select * from orders where ship_state = 'Pennsylvania';
-- List the first name and last name of all employees with last names that start with w   
select first_name, last_name from employees where last_name like 'w%'; 
-- List all customers from zipcodes that start with 55   
select first_name, last_name, postal_code  from customers where postal_code like '55%';
-- List all customers from zipcodes that end with 0    
select first_name, last_name. postal_code  from customers where postal_code like '%0';
-- List the first name, last name, and email for all customers with a .org email address 
select first_name, last_name, email from customers where email like '%.org';
-- List the first name, last name, and phone number for all customers from the 202 area code  
select first_name, last_name, phone from customers where phone like '1-(202)%';
-- List the order id for each order placed by George Wilson  
select orders.id 
    from orders
    inner join customers on orders.customer_id=customers.id
    where customers.first_name='George'
        and customers.last_name='Wilson';
 -- List all the products and quantities associated with order 4003   
select
    products.product_name,
    order_details.quantity
from
    order_details
    inner join products on order_details.product_id = products.id
where
    order_id=4003;
    
use car_lot;
-- Add the following cars to inventory:
insert into car(model_year, color, make, model) values(1, '2012','Red', 'Honda', 'Accord');
insert into car(model_year, color, make, model) values(1, '2017','Black', 'Chevy', 'Impala');
insert into car(model_year, color, make, model) values(1, '2019','Silver', 'Ford', 'F-150');
insert into car(model_year, color, make, model) values(1, '2020','White', 'Subaru', 'Outback');
insert into car(model_year, color, make, model) values(1, '2015','Silver', 'Ford', 'Mustang');
insert into car(model_year, color, make, model) values(1, '2018','Blue', 'Honda', 'Ridgeline');
insert into car(model_year, color, make, model) values(1, '2017','Grey', 'Chevy', 'Silverado');


   /* Change all Hondas to Black
    Change 'Chevy' to 'Chevrolet'
    Change all 2020 model years to 2019*/ 
update car set color = 'Black' where make = 'Honda';
update car set make = 'Chevrolet' where make = 'Chevy';
update car set model_year = '2019' where model_year = '2020';

/*  Delete all blue inventory
    Delete all Fords
    Delete all cars from 2012 and 2017*/
delete from car where color = 'blue';
delete from car where make = 'Ford';
delete from car where model_year > 2012 and model_year <2017;
       