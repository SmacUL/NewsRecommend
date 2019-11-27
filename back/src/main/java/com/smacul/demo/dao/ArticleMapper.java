package com.smacul.demo.dao;

import com.smacul.demo.model.ArticleModel;
import com.smacul.demo.model.HotArticleModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    @Select("select art_id, art_title, art_content, art_tag, art_like_num, art_dislike_num, art_time, cus_name\n" +
            "from Articles left join Customers on Articles.art_customer_id = Customers.cus_id\n" +
            "where art_id = #{id}")
    ArticleModel getArticleMain(@Param("id") Integer id);

    @Select("select art_id, art_title, art_image from Articles " +
            "where art_tag = #{tag} order by art_time desc limit #{start}, #{pageSize}")
    List<HotArticleModel> getHotArticles(@Param("tag") String tag,
                                         @Param("start") Integer start, @Param("pageSize") Integer pageSize);
}
