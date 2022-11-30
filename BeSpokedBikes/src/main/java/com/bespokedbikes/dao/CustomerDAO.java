package com.bespokedbikes.dao;

import com.bespokedbikes.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:02 PM
 */
@Mapper
public interface CustomerDAO {
    /**
     * get customer by id
     * @param id
     * @return Customer
     */
    @Select("SELECT * FROM `customer` WHERE `CustomerID` = #{id}")
    public Customer getById(Long id);

    /**
     * get all customers
     * @return List<Customer></>
     */
    @Select("SELECT * FROM `customer`")
    public List<Customer> getAllCustomer();
}
