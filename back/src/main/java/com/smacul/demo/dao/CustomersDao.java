package com.smacul.demo.dao;

import com.smacul.demo.bean.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao {

    Customer searchCusByName(@Param("cusName") String cusName);

    Integer countCusByName(@Param("cusName") String cusName);

    Integer insertCus(@Param("cusName") String cusName, @Param("cusPass") String cusPass);
}
