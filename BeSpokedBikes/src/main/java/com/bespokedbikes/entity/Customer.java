package com.bespokedbikes.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:00 PM
 */
@Data
public class Customer {
    private Long customerID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Date startDate;
}
