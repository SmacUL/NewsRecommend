import dao.ArticleDao as ArtDao
import model.ArticleModel as ArtMod

import util.Time as Time

class ArticleProcess:

    def __init__(self, dao: ArtDao.ArticleDao):
        self.__dao = dao

    def get_article_url(self, data):
        return "https://www.toutiao.com/a{0}/".format(data['item_id'])

    # def check_article(self, data, art_mod):
    #     """ 获取并检查用户 url
    #
    #     :param data:
    #     :param cus_mod:
    #     :return:
    #     """
    #     if not isinstance(art_mod, ArtMod.ArticleModel):
    #         return None
    #     art_mod.cus_url = "https://www.toutiao.com" + data['media_url']
    #     return self.__dao.search_article_by_url(art_mod)
    def is_article_exist(self, url):
        result = self.__dao.count_article_by_url(url)
        if result == 0:
            return False
        else:
            return True

    def insert_tiny_article(self, data, art_url, art_customer_id):
        art_mod = ArtMod.ArticleModel()
        print(data)
        art_mod.art_url = art_url
        art_mod.art_abstract = data['abstract']
        art_mod.art_title = data['title']
        try:
            art_mod.art_class = data['chinese_tag']
        except:
            art_mod.art_class = '综合'

        try:
            art_mod.art_image_url = data['middle_image']
        except:
            art_mod.art_image_url = ''

        art_mod.art_customer_id = art_customer_id
        art_mod.art_time = Time.Time.time_trans(data['behot_time'])

        self.__dao.insert_article(art_mod)

    def get_article_id_by_url(self, url):
        return self.__dao.search_article_id_by_url(url)