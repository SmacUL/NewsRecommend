import util.MySql as MySql
import model.CommentModel as ComMod

import logging


class CommentDao:
    """ 负责评论的数据库操作

    # 20-04-17 针对新的 SQL 完成修改.

    """


    def __init__(self, base: MySql.MySql):
        self.__base = base


    def is_com_exist(self, com_spider):
        """ 检查评论是否存在于数据库

        # 20-04-17 修改完成

        :param com_spider:
        :return:
        """
        try:
            search_sql = "select count(*) from Comment where com_spider = '%s'" % com_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("is_com_exist 评论 com_spider=%s 数据库查询 不存在" % com_spider)
                return False
            else:
                logging.info("is_com_exist 评论 com_spider=%s 数据库查询 已存在" % com_spider)
                return True
        except:
            logging.exception("is_com_exist 评论 com_spider=%s 数据库查询 失败" % com_spider)
            raise


    def insert_com(self, com_mod: ComMod.CommentModel):
        """ 将评论插入到数据库中

        # 20-04-17 修改完成
        # 20-04-23 Rollback BUG Fix

        :param com_mod:
        :return:
        """
        try:
            insert_sql = "insert into Comment(com_content, com_cus_id," \
                         " com_art_id, com_time, com_spider, com_legal)" \
                         " values ('%s', %d, %d, '%s', '%s', %d)" \
                         % (com_mod.com_content, com_mod.com_cus_id,
                            com_mod.com_art_id,com_mod.com_time, com_mod.com_spider, com_mod.com_legal)
            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            logging.info("insert_com 评论 com_spider=%s 数据库插入 成功" % com_mod.com_spider)
        except:
            # self.__base.commit_rollback()
            logging.exception("insert_com 评论 com_spider=%s 数据库插入 失败" % com_mod.com_spider)
            raise


    def search_com_id_by_spider(self, com_spider):
        """ 利用 spider 查询用户 id

        # 20-04-17 修改完成

        :param com_spider:
        :return:
        """
        try:
            search_sql = "select com_id from Comment where com_spider = '%s'" % com_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("search_com_id_by_spider 评论 com_spider=%s 数据库查询: com_id 值: %s" % (com_spider, result[0]))
            return result[0]
        except:
            logging.info("search_com_id_by_spider 评论 com_spider=%s 数据库查询: com_id 失败" % com_spider)
            raise


    def check_com_cus_relationship(self, art_id, com_id, cus_id):
        """ 检查 com cus 是否存在在数据库中

        # 20-04-17 修改完成

        :param art_id:
        :param com_id:
        :param cus_id:
        :return:
        """
        try:
            search_sql = "select count(*) from Comment " \
                         "where com_art_id=%d and com_id=%d and com_cus_id=%d" % (art_id, com_id, cus_id)
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("评论关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 不存在" % (art_id, cus_id))
                return False
            else:
                logging.info("评论关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 存在" % (art_id, cus_id))
                return True
        except:
            logging.exception("评论关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 错误" % (art_id, cus_id))
            raise
