package com.bespokedbikes.dao;

import com.bespokedbikes.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-11-28 4:45 PM
 */
@Mapper
public interface ProductsDAO {
    /**
     * get a product by id
     * @param id
     * @return Product
     */
    @Select("SELECT * FROM `products` WHERE `ProductID` = #{id}")
    public Products getById(Long id);

    /**
     * get all products
     * @return List<Products></>
     */
    @Select("SELECT * FROM `products`")
    public List<Products> getAllProducts();

    /**
     * update information of a product by id
     * @param id
     * @param name
     * @param manufacturer
     * @param style
     * @param purchasePrice
     * @param salePrice
     * @param qtyOnHand
     * @param commissionPercentage
     */
    @Update("UPDATE `products`\n" +
            "SET `ProductID` = #{id}, `Name` = #{name}, `Manufacturer` = #{manufacturer},\n" +
            "`Style` = #{style}, `PurchasePrice` = #{purchasePrice}, `SalePrice` = #{salePrice}, `QtyOnHand`= #{qtyOnHand},\n" +
            "`CommissionPercentage` = #{commissionPercentage}\n" +
            "WHERE `ProductID` = #{id}")
    public void updateProduct(Long id, String name, String manufacturer, String style, Double purchasePrice,
                              Double salePrice, Integer qtyOnHand, Double commissionPercentage);
}
