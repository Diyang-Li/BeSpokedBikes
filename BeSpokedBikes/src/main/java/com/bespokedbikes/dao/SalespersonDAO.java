package com.bespokedbikes.dao;

import com.bespokedbikes.entity.Customer;
import com.bespokedbikes.entity.Salesperson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-11-28 5:08 PM
 */
@Mapper
public interface SalespersonDAO {
    /**
     * get a salesperson information by id
     * @param id
     * @return Salesperson
     */
    @Select("SELECT * FROM `salesperson` WHERE `SalespersonID` = #{id}")
    public Salesperson getById(Long id);

    /**
     * get all salesperson information
     * @return List<Salesperson></>
     */
    @Select("SELECT * FROM `salesperson`")
    public List<Salesperson> getAllSalesperson();

    /**
     * update a salesperson information by id
     * @param id
     * @param firstname
     * @param lastname
     * @param address
     * @param phone
     * @param startDate
     * @param managerID
     * @param comission
     */
    @Update("UPDATE `salesperson` SET `SalespersonID` = #{id}, `FirstName` = #{firstname}, \n" +
            "`LastName` = #{lastname}, `Address` = #{address}, `Phone` = #{phone},\n" +
            "`StartDate` = #{startDate}, `TerminationDate` = #{terminationDate},`ManagerID` = #{managerID}, `Comission` = #{comission}\n" +
            "WHERE `SalespersonID` = #{id};")
    public void updateSalesperson(Long id, String firstname, String lastname, String address, String phone, Date startDate,Date terminationDate, Long managerID, Double comission);
}
