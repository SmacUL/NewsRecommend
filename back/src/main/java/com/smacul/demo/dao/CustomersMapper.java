package com.smacul.demo.dao;

import com.smacul.demo.model.ArticleAuthorModel;
import com.smacul.demo.model.CustomerModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersMapper {

    @Select("select cus_id, cus_name, cus_avatar_url from Customers " +
            "where cus_id = (select art_customer_id from Articles where art_id = #{artId});")
    ArticleAuthorModel getArticleAuthorByArtId(@Param("artId") Integer artId);


    @Select("select cus_id, cus_name, cus_email, cus_phone, cus_address, cus_avatar_url, " +
            "cus_style, cus_gender, cus_time, cus_type from Customers " +
            "where cus_id = (select art_customer_id from Articles where art_id = #{artId});")
    CustomerModel getCustomerInfoByArtId(@Param("artId") Integer artId);


    @Select("select cus_id, cus_name, cus_email, cus_phone, cus_address, cus_avatar_url, " +
            "cus_style, cus_gender, cus_time, cus_type from Customers " +
            "where cus_id = #{cusId};")
    CustomerModel getCustomerInfoByCusId(@Param("cusId")Integer cusId);
}
