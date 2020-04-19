package com.smacul.demo.dao;

import com.smacul.demo.bean.ArtFeatureCount;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtFeatureCountDao {

    ArtFeatureCount getArtFeatureCountByArtId(Integer artId);

}
