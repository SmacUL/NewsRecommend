import os

import dao.ArticleDao as ArtDao
import model.ArticleModel as ArtMod

import util.Time as Time
import util.Filter as Filter
import util.Json as Json
import util.Request as Request


class ArticleProcess:

    def __init__(self, dao: ArtDao.ArticleDao):
        self.__dao = dao

    def get_article_url(self, data):
        """ 获取文章的 URL

        :param data:
        :return:
        """
        try:
            return "https://www.toutiao.com/a{0}/".format(data['item_id'])
        except:
            print("新闻 art_url 获取失败")
            return None

    def is_article_exist(self, url):
        """ 查询指定 URL 的新闻是否存在在数据库中

        :param url:
        :return:
        """
        try:
            result = self.__dao.count_article_by_url(url)
            if result == 0:
                return False
            else:
                return True
        except:
            print("新闻 art_url=%s 数据库查询失败" % url)
            return None

    def get_tiny_article(self, data, class_filter_path, art_url, art_customer_id):
        """ 获取文章的缩略信息

        :param data:
        :param class_filter_path:
        :param art_url:
        :param art_customer_id:
        :return:
        """
        art_mod = ArtMod.ArticleModel()

        try:
            art_mod.art_abstract = data['abstract']
            art_mod.art_title = data['title']
            art_mod.art_time = Time.Time.time_trans(data['behot_time'])
        except:
            print("新闻 art_url=%s art_abstract 或 art_title 或 art_time 获取失败" % art_url)
            return None

        try:
            art_class = data['chinese_tag']
            art_mod.art_class = Filter.Filter().major_filter(art_class, Json.Json.read_json_file(class_filter_path))
        except:
            print("新闻 art_url=%s art_class 获取失败" % art_url)
            art_mod.art_class = '综合'

        try:
            art_mod.art_image_url = data['middle_image']
        except:
            print("新闻  art_url=%s art_image_url 获取失败" % art_url)
            art_mod.art_image_url = ''

        art_mod.art_url = art_url
        art_mod.art_comment_num = 0
        art_mod.art_customer_id = art_customer_id

        return art_mod

    def get_article_id_by_url(self, url):
        try:
            return self.__dao.search_article_id_by_url(url)
        except:
            print("新闻 art_url=%s art_id 数据库获取失败" % url)
            return None

    def get_full_article(self, art_mod, url, driver):
        driver.get(url)
        try:
            art_mod.art_content = driver.find_element_by_class_name("article-content").get_attribute('innerHTML')
            tags_ele = driver.find_elements_by_class_name('label-link')
            tags = []
            for tag in tags_ele:
                tags.append(tag.get_attribute('innerHTML'))
            art_mod.art_tags = '&&'.join(tags)
            return art_mod
        except:
            print("新闻 art_url=%s art_content 或 art_tags 获取失败" % url)
            return None

    def insert_article(self, art_mod):
        if self.__dao.insert_article(art_mod):
            print("新闻 art_url=%s 数据库插入成功" % art_mod.art_url)
            return True
        else:
            print("新闻 art_url=%s 数据库插入失败" % art_mod.art_url)
            return False


    def update_article_comment_num(self, art_id):
        if self.__dao.update_article_comment_num(art_id):
            print("新闻 art_id=%s 数据库更新成功" % art_id)
            return True
        else:
            print("新闻 art_id=%s 数据库更新失败" % art_id)
            return False

    def get_news_data(self):
        try:
            art_request = Request.Request(os.path.join('properties', 'request.json'))
            return art_request.more()['data']
        except:
            print("缩略新闻页 获取失败")
            return None
