package com.bespokedbikes.controller;

import com.bespokedbikes.dao.*;
import com.bespokedbikes.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:20 PM
 */
@Controller
public class AplicationController {
    @Autowired
    private SalespersonDAO salespersonDAO;
    @Autowired
    private ProductsDAO productsDAO;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private SalesDAO salesDAO;
    @Autowired
    private DiscountDAO discountDAO;
    //month range of each quarter
    private List<String[]> quarter = new ArrayList<>();
    public AplicationController(){
        String[] q1 = {"01-01", "02-29"};
        String[] q2 = {"03-01", "05-31"};
        String[] q3 = {"06-01", "08-31"};
        String[] q4 = {"09-01", "12-31"};
        quarter.add(q1);
        quarter.add(q2);
        quarter.add(q3);
        quarter.add(q4);
    }
    public void commandLoop() {
        Scanner commandLineInput = new Scanner(System.in);
        String wholeInputLine;
        String[] tokens;
        final String DELIMITER = ",";

        while (true) {
            choice();
            try {
                // read the command line from console
                wholeInputLine = commandLineInput.nextLine();
                tokens = wholeInputLine.split(DELIMITER);
                System.out.println("Choice:" + wholeInputLine);
                // Display a list of salespersons
                if(tokens[0].equals("0")){
                    List<Salesperson> allSalesperson = displaySalesperson();
                    for(Salesperson salesperson: allSalesperson){
                        System.out.println(salesperson);
                    }
                }else if(tokens[0].equals("1")){
                    // Update a salesperson
                    // 1. get the salesperson id
                    System.out.println("Please input the saleperson id:");
                    String id = commandLineInput.nextLine();
                    Salesperson saleperson = salespersonDAO.getById((long) Integer.parseInt(id));
                    System.out.println(saleperson);
                    // 2. get the entity to be updated and the new value
                    System.out.println("please input the item want to change(FirstName, LastName, Address, Phone, StartDate, Commission): ");
                    String column = commandLineInput.nextLine();
                    System.out.println("please input the new Value : ");
                    String newValue = commandLineInput.nextLine();
                    // 3. change to new value
                    if(column.equals(("FirstName"))){
                        saleperson.setFirstName(newValue);
                    }else if(column.equals(("LastName"))){
                        saleperson.setLastName(newValue);
                    }else if(column.equals("Address")){
                        saleperson.setAddress(newValue);
                    }else if(column.equals("Phone")){
                        saleperson.setAddress(newValue);
                    }else if(column.equals("StartDate")){
                        saleperson.setStartDate(Date.valueOf(LocalDate.parse(newValue)));
                    }else if(column.equals("Commission")){
                        saleperson.setComission(Double.parseDouble(newValue));
                    }
                    salespersonDAO.updateSalesperson(saleperson.getSalespersonID(), saleperson.getFirstName(), saleperson.getLastName(), saleperson.getAddress(),
                            saleperson.getPhone(), saleperson.getStartDate(), saleperson.getTerminationDate(),saleperson.getManagerId(), saleperson.getComission());
                }else if(tokens[0].equals("2")){
                    // Display a list of products
                    List<Products> allProduct = displayProductList();
                    for(Products product: allProduct){
                        System.out.println(product);
                    }
                }else if (tokens[0].equals("3")){
                    // update a product
                    //1. get product id
                    System.out.println("Please input the product id:");
                    String id = commandLineInput.nextLine();
                    Products product = productsDAO.getById((long) Integer.parseInt(id));
                    // 2.get the entity to be updated and the new value
                    System.out.println("please input the item want to change(Name, Manufacturer, Style, PurchasePrice, SalePrice, QtyOnHand, CommissionPercentage): ");
                    String column = commandLineInput.nextLine();
                    System.out.println("please input the new Value : ");
                    String newValue = commandLineInput.nextLine();
                    // 3. change to new value
                    if(column.equals(("Name"))){
                        product.setName(newValue);
                    }else if(column.equals(("Manufacturer"))){
                        product.setManufacturer(newValue);
                    }else if(column.equals("Style")){
                        product.setStyle(newValue);
                    }else if(column.equals("PurchasePrice")){
                        product.setPurchasePrice(Double.parseDouble(newValue));
                    }else if(column.equals("SalePrice")){
                        product.setSalePrice(Double.parseDouble(newValue));
                    }else if(column.equals("QtyOnHand")){
                        product.setQtyOnHand(Integer.parseInt(newValue));
                    }else if(column.equals("CommissionPercentage")){
                        product.setCommissionPercentage(Double.parseDouble(newValue));
                    }
                    productsDAO.updateProduct(product.getProductID(), product.getName(), product.getManufacturer(), product.getStyle(),
                            product.getPurchasePrice(), product.getSalePrice(), product.getQtyOnHand(), product.getCommissionPercentage());
                }else if (tokens[0].equals("4")){
                    // Display list of customers
                    List<Customer> customers =  customerDAO.getAllCustomer();
                    for (Customer customer: customers){
                        System.out.println(customer);
                    }
                }else if(tokens[0].equals("5")){
                    // Display a list of sales,optionally filter by date range
                    // 1.get the start and end date
                    String d1 = "";
                    String d2 ="";
                    System.out.println("Please input the start date:");
                    d1 = commandLineInput.nextLine();
                    System.out.println("Please input the end date:");
                    d2 = commandLineInput.nextLine();
                    // if d1 and d2 are empty, then display all sales
                    List<Sales> sales = d1.length() == 0 && d2.length() == 0? salesDAO.getAllSales(): salesDAO.getByDate(Date.valueOf(d1), Date.valueOf(d2));
                    for(Sales sale: sales){
                        //2.encapsulate the required infor to SalesDTO
                        Long productid = productsDAO.getById(sale.getProductID()).getProductID();
                        Long customerid = customerDAO.getById(sale.getCustomerID()).getCustomerID();
                        Long salespersonid = salespersonDAO.getById(sale.getSalespersonID()).getSalespersonID();
                        Products product = productsDAO.getById(productid);
                        Customer customer = customerDAO.getById(customerid);
                        Salesperson salesperson = salespersonDAO.getById(salespersonid);
                        SalesDTO salesDTO = new SalesDTO();
                        salesDTO.setProductName(product.getName());
                        salesDTO.setCustomerFirstname(customer.getFirstName());
                        salesDTO.setCustomerLastName(customer.getLastName());
                        salesDTO.setSaleDate(sale.getSalesDate());
                        salesDTO.setPrice(product.getSalePrice());
                        salesDTO.setSalespersonFirstName(salesperson.getFirstName());
                        salesDTO.setSalespersonLastName(salesperson.getLastName());
                        salesDTO.setSalespersonCommission(salesperson.getComission());
                        System.out.println(salesDTO);
                    }
                }else if(tokens[0].equals("6")){
                    // Create a sale
                    //1.display the product list and salesperson list, and get customer id
                    System.out.println("Please input the customer id:");
                    Long customerid = Long.parseLong(commandLineInput.nextLine());
                    List<Products> products = displayProductList();
                    for(Products product: products){
                        System.out.println(product);
                    }
                    System.out.println("Please input the product id:");
                    Long productid = Long.parseLong(commandLineInput.nextLine());
                    List<Salesperson> salespersonList = displaySalesperson();
                    for(Salesperson salesperson: salespersonList){
                        System.out.println(salesperson);
                    }
                    System.out.println("Please input the salesperson id:");
                    Long salespersonid = Long.parseLong(commandLineInput.nextLine());
                    //2.check discount to get total discount
                    double currentDiscount = 0;
                    List<Discount> discounts = discountDAO.getbyPoductId(productid);
                    java.sql.Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
                    for(Discount discount: discounts){
                        Date beginDate = discount.getBeginDate();
                        Date endDate = discount.getEndDate();
                        if(currentDate.after(beginDate) && currentDate.before(endDate)){
                            currentDiscount+=discount.getDiscountPercentage();
                        }
                    }
                    //3.update product number and commission of salesperson
                    Products product = productsDAO.getById(productid);
                    productsDAO.updateProduct(productid, product.getName(), product.getManufacturer(), product.getStyle(),
                            product.getPurchasePrice(), product.getSalePrice(), product.getQtyOnHand()-1,
                            product.getCommissionPercentage());

                    //4.update salesperson commission
                    Double salePrice = product.getSalePrice() * (1-currentDiscount);
                    Double salesCommission = salePrice * product.getCommissionPercentage();
                    Salesperson salesperson = salespersonDAO.getById(salespersonid);
                    salespersonDAO.updateSalesperson(salespersonid,salesperson.getFirstName(), salesperson.getLastName(),
                            salesperson.getAddress(), salesperson.getPhone(), salesperson.getStartDate(), salesperson.getTerminationDate(),salesperson.getManagerId(),
                            salesperson.getComission()+salesCommission);
                    salesDAO.createSales(productid, salespersonid,customerid,currentDate, salesCommission);
                }else if(tokens[0].equals("7")){
                    // Display a quarterly salesperson commission report
                    //1. get salesperson id
                    System.out.println("Please input the salesperson id:");
                    Long salespersonid = Long.parseLong(commandLineInput.nextLine());
                    //2. get quarter and year
                    System.out.println("Please input the quarter number(1-4):");
                    Integer quarterNum = Integer.parseInt(commandLineInput.nextLine());
                    String startDay = quarter.get(quarterNum-1)[0];
                    String endtDay = quarter.get(quarterNum-1)[1];
                    System.out.println("Please input the year:");
                    String year = commandLineInput.nextLine();
                    startDay = year + "-" + startDay;
                    endtDay = year + "-" + endtDay;
                    //3. filter id and time in sales table
                    int totalCommission = 0;
                    List<Sales> salesList = salesDAO.getByDateAndSalepersonid(Date.valueOf(startDay), Date.valueOf(endtDay), salespersonid);
                    for(Sales sales: salesList){
                        totalCommission+=sales.getCommission();
                    }
                    Salesperson salesperson = salespersonDAO.getById(salespersonid);
                    //4. generate
                    System.out.println(salesperson.getFirstName() + " " + salesperson.getLastName() + " Commission:  " + totalCommission);
                }else if(tokens[0].equals("8")){
                    break;
                }
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println();
            }
        }
        System.out.println("simulation terminated");
        commandLineInput.close();
    }
    private List<Products> displayProductList(){
        return productsDAO.getAllProducts();
    }
    private List<Salesperson> displaySalesperson(){
        return salespersonDAO.getAllSalesperson();
    }
    private void choice(){
        List<String> commandList= new ArrayList<>();
        commandList.add("Display a list of salespersons");
        commandList.add("Update a salesperson");
        commandList.add("Display a list of products");
        commandList.add("Update a product");
        commandList.add("Display a list of customers");
        commandList.add("Display a list of sales");
        commandList.add("Create a sale");
        commandList.add("Display a quarterly salesperson commission report");
        commandList.add("Exit");
        for(int i = 0; i < commandList.size(); i++){
            System.out.println("" + i + ". " + commandList.get(i));
        }
    }
}
