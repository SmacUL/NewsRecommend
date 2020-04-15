package com.smacul.demo.dao;

import com.smacul.demo.model.CustomerDynamicModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCustomerBehaviorDao {

    List<CustomerDynamicModel> searchCusSelfDynamic(
            @Param("cusId") Integer cusId, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    //Integer countCusBeLikedNum(@Param("cusId") Integer cusId);

    Integer countCusWriteNum(@Param("cusId") Integer cusId);
}
