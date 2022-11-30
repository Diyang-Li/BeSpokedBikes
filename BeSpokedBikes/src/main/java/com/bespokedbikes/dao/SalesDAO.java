package com.bespokedbikes.dao;

import com.bespokedbikes.entity.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.sql.Date;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:12 PM
 */
@Mapper
public interface SalesDAO {
    /**
     * get a sale information by id
     * @param id
     * @return Sales
     */
    @Select("SELECT * FROM `sales` WHERE `SalesID` = #{id}")
    public Sales getById(Integer id);

    /**
     * get a list of Sales by date range
     * @param d1
     * @param d2
     * @return List<Sales></>
     */
    @Select("SELECT * FROM `sales`\n" +
            "WHERE `SalesDate` BETWEEN #{d1} AND #{d2}")
    public List<Sales> getByDate(Date d1, Date d2);

    /**
     * get all sales information
     * @return List<Sales></>
     */
    @Select("SELECT * FROM `sales`")
    public List<Sales> getAllSales();

    /**
     * Insert a new sale information to the sale table
     * @param productid
     * @param salespersonid
     * @param customerid
     * @param saleDate
     * @param commission
     */
    @Select("INSERT INTO `sales`(`ProductID`,`SalespersonID`,`CustomerID`,`SalesDate`,`Commission`) \n" +
            "VALUES(#{productid},#{salespersonid},#{customerid},#{saleDate},#{commission})")
    public void createSales(Long productid, Long salespersonid, Long customerid, Date saleDate,Double commission);

    /**
     * get a list of sales information by d1, d2, and salespersonid
     * @param d1
     * @param d2
     * @param id
     * @return List<Sales></>
     */
    @Select("SELECT * FROM `sales`\n" +
            "WHERE `SalesDate` BETWEEN #{d1} AND #{d2} AND`SalespersonID`=#{id}")
    public List<Sales> getByDateAndSalepersonid(Date d1, Date d2, Long id);
}
