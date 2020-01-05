import util.MySql as MySql
import model.ArticleModel as ArtMod

# import os.path
import logging
# logging.basicConfig(filename=os.path.join('log', 'major-log.txt'), filemode='a')


class ArticleDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def is_art_exist(self, art_spider):
        """ 检查新闻是否存在

        :param art_spider:
        :return:
        """
        try:
            search_sql = "select count(*) from Articles where art_spider = '%s'" % art_spider

            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("is_art_exist 新闻 art_spider=%s 数据库查询 不存在" % art_spider)
                return False
            else:
                logging.info("is_art_exist 新闻 art_spider=%s 数据库查询 已存在" % art_spider)
                return True
        except:
            logging.exception("is_art_exist 新闻 art_spider=%s 数据库查询 失败" % art_spider)
            raise

    def insert_art(self, art_mod: ArtMod.ArticleModel):
        """ 插入新闻数据

        :param art_mod:
        :return:
        """
        try:
            insert_sql = "insert into Articles(art_title, art_spider, art_class, art_image_url, " \
                         "art_content, art_tags, " \
                         "art_customer_id, art_time, art_comment_num, art_legal)" \
                         " values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %d)" \
                         % (art_mod.art_title, art_mod.art_spider, art_mod.art_class, art_mod.art_image_url,
                            art_mod.art_content, art_mod.art_tags,
                            art_mod.art_customer_id, art_mod.art_time, art_mod.art_comment_num, art_mod.art_legal)

            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            logging.info("insert_art 新闻 art_spider=%s 数据库插入 成功" % art_mod.art_spider)
        except:
            self.__base.commit_rollback()
            logging.exception("insert_art 新闻 art_spider=%s 数据库插入 失败" % art_mod.art_spider)
            raise

    def search_art_id_by_spider(self, art_spider):
        try:
            search_sql = "select art_id from Articles where art_spider = '%s'" % art_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("search_art_id_by_spider 新闻 art_spider=%s 数据库查询: art_id 值: %s" % (art_spider, result[0]))
            return result[0]
        except:
            logging.info("search_art_id_by_spider 新闻 art_spider=%s 数据库查询 art_id 失败" % art_spider)
            raise

    def check_art_cus_relationship(self, art_id, cus_id):
        try:
            search_sql = "select count(*) from Articles where art_id=%d and art_customer_id=%d" % (art_id, cus_id)
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("check_art_cus_relationship 关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 不存在" % (art_id, cus_id))
                return False
            else:
                logging.info("check_art_cus_relationship 关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 存在" % (art_id, cus_id))
                return True
        except:
            logging.exception("check_art_cus_relationship 关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 错误" % (art_id, cus_id))
            raise

    def update_art_com_number(self, art_id):
        try:
            update_sql = "update Articles set art_comment_num = art_comment_num + 1 where art_id = %d" % art_id

            self.__base.execute_sql(update_sql)
            self.__base.commit_transactions()
            logging.info("update_art_com_number art=%s 评论数 数据库更新 成功" % art_id)
        except:
            self.__base.commit_rollback()
            logging.info("update_art_com_number art=%s 评论数 数据库更新 失败" % art_id)
            raise



