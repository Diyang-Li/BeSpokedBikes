package com.bespokedbikes;

import com.bespokedbikes.dao.CustomerDAO;
import com.bespokedbikes.dao.ProductsDAO;
import com.bespokedbikes.dao.SalesDAO;
import com.bespokedbikes.dao.SalespersonDAO;
import com.bespokedbikes.entity.Customer;
import com.bespokedbikes.entity.Salesperson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BeSpokedBikesApplicationTests {
    @Autowired
    private ProductsDAO productsDAO;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private SalespersonDAO salespersonDAO;
    @Autowired
    private SalesDAO salesDAO;
    @Test
    void contextLoads() {
//        System.out.println(productsDAO.getById(2));
//        System.out.println(customerDAO.getById(1));
//        System.out.println(salespersonDAO.getById(1));
        System.out.println(salesDAO.getById(1));
        List<Salesperson> allSalesperson = salespersonDAO.getAllSalesperson();
        for(Salesperson salesperson: allSalesperson){
            System.out.println(salesperson);
        }
//        salespersonDAO.updateSalesperson(1,"FirstName", "salespersonfirstname01");
    }

}
