import util.MySql as MySql
import model.ArticleModel as ArtMod


class ArticleDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    # def search_article_by_url(self, art_mod):
    #     if not isinstance(art_mod, ArtMod.ArticleModel):
    #         return None
    #
    #     search_sql = "select * from Articles where art_url = '%s'" % art_mod.art_url
    #     self.__base.execute_sql(search_sql)
    #     result = self.__base.get_result()
    #
    #     if result.__len__() == 0:
    #         # 2
    #         return art_mod
    #     else:
    #         # 3
    #         # cus_mod 的插入操作.
    #         art_mod = ArtMod.ArticleModel()
    #         return None

    def count_article_by_url(self, url):
        search_sql = "select count(*) from Articles where art_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result()[0][0]

    def insert_article(self, art_mod: ArtMod.ArticleModel):
        insert_sql = "insert into Articles(art_title, art_url, art_class, " \
                     "art_image_url, art_customer_id, art_time, art_legal)" \
                     " values ('%s', '%s', '%s', '%s', '%s', '%s', %d)" \
                     % (art_mod.art_title, art_mod.art_url, art_mod.art_class,
                        art_mod.art_image_url, art_mod.art_customer_id, art_mod.art_time, art_mod.art_legal)
        self.__base.execute_sql(insert_sql)
        self.__base.commit_transactions()

    def search_article_id_by_url(self, url):
        search_sql = "select art_id from Articles where art_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result()[0][0]

