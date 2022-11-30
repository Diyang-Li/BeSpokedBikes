DROP DATABASE IF EXISTS `bespoked`;
CREATE DATABASE IF NOT EXISTS `bespoked`;
/*Create Products table*/
CREATE TABLE Products
(
    `ProductID`            BIGINT PRIMARY KEY AUTO_INCREMENT,
    `Name`                 VARCHAR(250),
    `Manufacturer`         VARCHAR(250),
    `Style`                VARCHAR(250),
    `PurchasePrice`        DOUBLE,
    `SalePrice`            DOUBLE,
    `QtyOnHand`            INT,
    `CommissionPercentage` DOUBLE,
    CONSTRAINT uc_name_manufacturer_style UNIQUE(`Name`,`Manufacturer`,`Style`)
);

/*Create Salesperson table*/
CREATE TABLE Salesperson
(
    `SalespersonID` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `FirstName`     VARCHAR(250),
    `LastName`      VARCHAR(250),
    `Address`       VARCHAR(250),
    `Phone`         VARCHAR(250),
    `StartDate`     DATE,
    `TerminationDate` DATE,
    `ManagerID`     BIGINT,
    `Comission`     DOUBLE,
    CONSTRAINT uc_phone UNIQUE(`Phone`)

);
/*Create Customer table*/
CREATE TABLE Customer
(
    `CustomerID` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `FirstName`  VARCHAR(250),
    `LastName`   VARCHAR(250),
    `Address`    VARCHAR(250),
    `Phone`      VARCHAR(250),
    `StartDate`  DATE
);

/*Create Sales table*/
CREATE TABLE Sales
(
    `SalesID`       BIGINT PRIMARY KEY AUTO_INCREMENT,
    `ProductID`     BIGINT,
    `SalespersonID` BIGINT,
    `CustomerID`    BIGINT,
    `SalesDate`     DATE,
    `Commission`    DOUBLE
);

/*Create Discount table*/
CREATE TABLE Discount
(
    `DiscountID`    BIGINT PRIMARY KEY AUTO_INCREMENT,
    `ProductID`     BIGINT,
    `BeginDate`     DATE,
    `EndDate`       DATE,
    `DiscountPercentage`     DOUBLE
);

/*Build FK to connect saleperson and manager*/
ALTER TABLE `salesperson`
    ADD CONSTRAINT fk_salesperson_salesperson FOREIGN KEY (`ManagerID`) REFERENCES `salesperson` (`SalespersonID`);

/*Buikd FK of sales table*/
ALTER TABLE `sales`
    ADD CONSTRAINT fk_sales_products FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`),
    ADD CONSTRAINT fk_sales_salesperson FOREIGN KEY (`SalespersonID`) REFERENCES `salesperson` (`SalespersonID`),
    ADD CONSTRAINT fk_sales_customer FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);
