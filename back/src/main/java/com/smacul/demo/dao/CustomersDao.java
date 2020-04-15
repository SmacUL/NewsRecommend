package com.smacul.demo.dao;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CustomerDynamicModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersDao {

    Customer searchCusByName(@Param("cusName") String cusName);

    Integer countCusByName(@Param("cusName") String cusName);

    Integer insertCus(@Param("cusName") String cusName, @Param("cusPass") String cusPass);

    List<Customer> searchCustomerByCusId(@Param("cusId") Integer cusId);

    //Customer updateCusInfo(Customer customer);

    String updateCusPass(@Param("cusId") Integer cusId, @Param("cussPass") String cussPass);

    Customer searchCusFullByCusId(Integer cusId);
}
