/*Insert data to products*/
INSERT INTO `products`
VALUES (1, 'bike01', 'manufacturer01', 'style01', 100, 1000, 100, 0.1),
       (2, 'bike02', 'manufacturer02', 'style02', 200, 2000, 200, 0.2),
       (3, 'bike03', 'manufacturer03', 'style03', 300, 3000, 300, 0.3),
       (4, 'bike04', 'manufacturer04', 'style04', 400, 4000, 400, 0.4);


/*Insert data to customer*/
INSERT INTO `customer`
VALUES (1, 'customerfirstname01', 'customerlastname01', 'customeraddress01', '7707650001', '2022-11-01'),
       (2, 'customerfirstname02', 'customerlastname02', 'customeraddress02', '7707650002', '2022-11-02'),
       (3, 'customerfirstname03', 'customerlastname03', 'customeraddress03', '7707650003', '2022-11-03'),
       (4, 'customerfirstname04', 'customerlastname04', 'customeraddress04', '7707650004', '2022-11-04');

/*Insert data to saleperson*/
INSERT INTO `salesperson`
VALUES (1, 'salespersonfirstname01', 'salespersonlastname01', 'salespersonaddress01', '7707650005', '2021-1-01',NULL, NULL,
        0),
       (2, 'salespersonfirstname02', 'salespersonlastname02', 'salespersonaddress02', '7707650006', '2021-1-02', NULL,'1',
        2000),
       (3, 'salespersonfirstname03', 'salespersonlastname03', 'salespersonaddress03', '7707650007', '2021-1-03', NULL,NULL,
        30),
       (4, 'salespersonfirstname04', 'salespersonlastname04', 'salespersonaddress04', '7707650008', '2021-1-04', NULL,'2',
        0);

/*Insert data to sales table*/
INSERT INTO `sales`
VALUES (1, 1, 2, 1, '2022-11-05',100),
       (2, 2, 2, 3, '2022-11-06',100);
       
/*Insert data to discount table*/
INSERT INTO `discount`
VALUES (1, 1, '2022-11-01','2022-12-05', 0.05);