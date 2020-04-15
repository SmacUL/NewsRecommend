package com.smacul.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCustomerFollowDao {
    Integer countCusFollowNum(@Param("cusId") Integer cusId);

    Integer countCusFanNum(@Param("cusId") Integer cusId);

}
