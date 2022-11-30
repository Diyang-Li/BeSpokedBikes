package com.bespokedbikes.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Diyang Li
 * @create 2022-11-28 4:34 PM
 */
@Data
public class Products {
    private long productID;
    private String name;
    private String manufacturer;
    private String style;
    private Double purchasePrice;
    private Double salePrice;
    private Integer qtyOnHand;
    private Double commissionPercentage;
}
