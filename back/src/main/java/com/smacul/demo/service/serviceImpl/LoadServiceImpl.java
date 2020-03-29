package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.bean.Article;
import com.smacul.demo.dao.ArticlesDao;
import com.smacul.demo.model.ArticleCustomerModel;
import com.smacul.demo.service.LoadService;
import com.smacul.demo.util.PageHandler;
import com.smacul.demo.util.TypeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    ArticlesDao articlesDao;

    @Autowired
    HttpSession session;

    @Override
    public List<String> getArtTypes() {
        List<String> result = articlesDao.searchArtTypes();
        List<String> newTypes = TypeTranslator.typeTransAllEnToCh(result);
        return newTypes;
    }

    /**
     * 为路人用户或新用户推荐文章, 这个方法应该需要修改.
     *
     * @{searchTinyArtOnePageFromGlobal} 文章"综合"类别推荐
     * @{searchTinyArtOnePageByClass} 文章按照"类别"推荐
     *
     * @param artType
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<ArticleCustomerModel> getTinyArtOnePageByType(String artType, Integer page, Integer pageSize) {
        Integer start = PageHandler.calcuStartNO(page, pageSize);
        if (artType.equals("综合")) {
            return articlesDao.searchTinyArtOnePageFromGlobal(start, pageSize);
        } else {
            return articlesDao.searchTinyArtOnePageByType(TypeTranslator.typeTransSingleChToEn(artType), start, pageSize);
        }
    }

    @Override
    public List<ArticleCustomerModel> getHotArtOnePage(Integer page, Integer pageSize) {
        Integer start = 0;
        if (page <= 4) {
            start = PageHandler.calcuStartNO(page, pageSize);
        }
        return articlesDao.searchHotArtOnePage(start, pageSize);
    }

    @Override
    public ArticleCustomerModel getFullArtWithCus(Integer artId) {
        return articlesDao.searchFullArtWithCus(artId);
    }

    @Override
    public Boolean cusArtPreference(Integer artId, Boolean preference) {
        if (preference) {
            return articlesDao.updateArtLikeNum(artId);
        } else {
            return articlesDao.updateArtDislikeNum(artId);
        }
    }
}
