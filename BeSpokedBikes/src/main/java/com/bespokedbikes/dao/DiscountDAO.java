package com.bespokedbikes.dao;

import com.bespokedbikes.entity.Discount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-11-29 10:50 AM
 */
@Mapper
public interface DiscountDAO {
    /**
     * get discounts information by id
     * @param id
     * @return List<Discount></>
     */
    @Select("SELECT * FROM `discount` WHERE `ProductID` = #{id}")
    public List<Discount> getbyPoductId(Long id);
}
