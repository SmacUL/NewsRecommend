package com.smacul.demo.dao;

import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexMapper {

    @Select("select art_tag from Articles group by art_tag order by count(art_tag) desc")
    List<String> getLeftNavTags();

    @Select("select art_id, art_title, art_abstract, art_time, art_image, cus_name\n" +
            "from Articles left join Customers on Articles.art_customer_id = Customers.cus_id\n" +
            "where art_tag = #{tag} order by art_time desc limit #{start}, #{pageSize}")
    List<TinyArticleModel> getTinyArticles(@Param("tag") String tag, @Param("start") Integer start,
                                           @Param("pageSize") Integer pageSize);

    @Select("select art_id, art_title, art_image from Articles " +
            "where art_tag = '综合' order by art_time desc limit #{start}, #{pageSize}")
    List<HotArticleModel> getHotArticles(@Param("start")Integer start, @Param("pageSize")Integer pageSize);
}
