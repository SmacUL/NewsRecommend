package com.smacul.demo.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CusRecommendRecordDao {

    /**
     *
     * @param cusId
     * @param list
     * @return
     */
    Integer addRecommendList(Integer cusId, List<Integer> list);
}
