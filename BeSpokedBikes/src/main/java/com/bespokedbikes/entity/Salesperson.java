package com.bespokedbikes.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:05 PM
 */
@Data
public class Salesperson {
    private Long salespersonID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Date startDate;
    private Date TerminationDate;
    private Long managerId;
    private Double comission;
}
