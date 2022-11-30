package com.bespokedbikes.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Diyang Li
 * @create 2022-11-29 10:48 AM
 */
@Data
public class Discount {
    private Long disocuntId;
    private Long productId;
    private Date beginDate;
    private Date endDate;
    private Double discountPercentage;
}
