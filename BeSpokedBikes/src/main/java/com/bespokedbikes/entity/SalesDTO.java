package com.bespokedbikes.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Diyang Li
 * @create 2022-11-29 10:01 AM
 */
@Data
public class SalesDTO {
    private String productName;
    private String customerFirstname;
    private String customerLastName;
    private Date saleDate;
    private Double price;
    private String salespersonFirstName;
    private String salespersonLastName;
    private Double salespersonCommission;

    @Override
    public String toString() {
        return "SalesDTO{" +
                "productName='" + productName + '\'' +
                ", customerName='" + customerFirstname +
                " " + customerLastName + '\'' +
                ", saleDate=" + saleDate +
                ", price=" + price +
                ", salespersonName='" + salespersonFirstName +
                " " + salespersonLastName + '\'' +
                ", salespersonCommission=" + salespersonCommission +
                '}';
    }
}
