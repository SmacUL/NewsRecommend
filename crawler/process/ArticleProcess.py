import dao.ArticleDao as ArtDao
import model.ArticleModel as ArtMod

import util.Time as Time
import util.Filter as Filter
import util.Json as Json


class ArticleProcess:

    def __init__(self, dao: ArtDao.ArticleDao):
        self.__dao = dao

    def get_article_url(self, data):
        return "https://www.toutiao.com/a{0}/".format(data['item_id'])

    def is_article_exist(self, url):
        result = self.__dao.count_article_by_url(url)
        if result == 0:
            return False
        else:
            return True

    def get_tiny_article(self, data, class_filter_path, art_url, art_customer_id):
        art_mod = ArtMod.ArticleModel()
        art_mod.art_url = art_url
        art_mod.art_abstract = data['abstract']
        art_mod.art_title = data['title']
        try:
            art_class = data['chinese_tag']
        except:
            art_class = '综合'
        art_mod.art_class = Filter.Filter().major_filter(art_class, Json.Json.read_json_file(class_filter_path))

        try:
            art_mod.art_image_url = data['middle_image']
        except:
            art_mod.art_image_url = ''

        art_mod.art_comment_num = 0
        art_mod.art_customer_id = art_customer_id
        art_mod.art_time = Time.Time.time_trans(data['behot_time'])
        return art_mod
        # self.__dao.insert_article(art_mod)

    def get_article_id_by_url(self, url):
        return self.__dao.search_article_id_by_url(url)

    def get_full_article(self, art_mod, url, driver):
        driver.get(url)
        # art_mod = ArtMod.ArticleModel()
        art_mod.art_content = driver.find_element_by_class_name("article-content").get_attribute('innerHTML')
        tags_ele = driver.find_elements_by_class_name('label-link')
        tags = []
        for tag in tags_ele:
            tags.append(tag.get_attribute('innerHTML'))
        art_mod.art_tags = '&&'.join(tags)
        return art_mod
        # self.__dao.update_full_article_by_url(url, art_mod)

    def insert_article(self, art_mod):
        self.__dao.insert_article(art_mod)

    def update_article_comment_num(self, art_id):
        self.__dao.update_article_comment_num(art_id)
