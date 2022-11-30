package com.bespokedbikes.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:10 PM
 */
@Data
public class Sales {
    private Long salesID;
    private Long productID;
    private Long salespersonID;
    private Long customerID;
    private Date salesDate;
    private Double commission;
}
