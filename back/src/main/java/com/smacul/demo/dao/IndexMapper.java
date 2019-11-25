package com.smacul.demo.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexMapper {

    @Select("select art_tag from Articles group by art_tag order by count(art_tag) desc")
    List<String> getLeftNavTags();
}
