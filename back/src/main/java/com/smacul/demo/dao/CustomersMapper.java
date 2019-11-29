package com.smacul.demo.dao;

import com.smacul.demo.model.ArticleAuthorModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersMapper {

    @Select("select cus_id, cus_name, cus_avatar_url from Customers " +
            "where cus_id = (select art_customer_id from Articles where art_id = #{artId});")
    ArticleAuthorModel getArticleAuthorByArtId(@Param("artId") Integer artId);
}
