import util.MySql as MySql
import model.ReplyModel as RepMod

# import os.path
import logging
# logging.basicConfig(filename=os.path.join('log', 'major-log.txt'), filemode='a')


class ReplyDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def is_rep_exist(self, rep_spider):
        try:
            search_sql = "select count(*) from Replys where rep_spider = '%s'" % rep_spider

            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("is_rep_exist 回复 rep_spider=%s 数据库查询 不存在" % rep_spider)
                return False
            else:
                logging.info("is_rep_exist 回复 rep_spider=%s 数据库查询 已存在" % rep_spider)
                return True
        except:
            logging.exception("is_rep_exist 回复 rep_spider=%s 数据库查询 失败" % rep_spider)
            raise

    def insert_rep(self, rep_mod: RepMod.ReplyModel):
        try:
            if rep_mod.rep_reply_id is None:
                insert_sql = "insert into Replys(rep_content, rep_like_num, rep_type, rep_time," \
                             " rep_customer_id, rep_article_id, rep_comment_id, " \
                             " rep_spider, rep_legal)" \
                             " values ('%s', %d, %d, '%s', %d, %d, %d, '%s', %d)" \
                             % (str(rep_mod.rep_content), int(rep_mod.rep_like_num), int(rep_mod.rep_type), str(rep_mod.rep_time),
                                int(rep_mod.rep_customer_id), int(rep_mod.rep_article_id), int(rep_mod.rep_comment_id),
                                str(rep_mod.rep_spider), int(rep_mod.rep_legal))
            else:
                insert_sql = "insert into Replys(rep_content, rep_like_num, rep_type, rep_time," \
                             " rep_customer_id, rep_article_id, rep_comment_id, " \
                             "rep_reply_id, rep_spider, rep_legal)" \
                             " values ('%s', %d, %d, '%s', %d, %d, %d, %d, '%s', %d)" \
                             % (str(rep_mod.rep_content), int(rep_mod.rep_like_num), int(rep_mod.rep_type), str(rep_mod.rep_time),
                                int(rep_mod.rep_customer_id), int(rep_mod.rep_article_id), int(rep_mod.rep_comment_id),
                                int(rep_mod.rep_reply_id), str(rep_mod.rep_spider), int(rep_mod.rep_legal))

            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            logging.info("insert_rep 回复 rep_spider=%s 数据库插入 成功" % rep_mod.rep_spider)
        except:
            self.__base.commit_rollback()
            logging.exception("insert_rep 回复 rep_spider=%s 数据库插入 失败" % rep_mod.rep_spider)
            raise

    def search_rep_id_by_spider(self, rep_spider):
        try:
            search_sql = "select rep_id from Replys where rep_spider = '%s'" % rep_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("search_rep_id_by_spider 新闻 rep_spider=%s 数据库查询: rep_id 值: %s" % (rep_spider, result[0]))
            return result[0]
        except:
            logging.info("search_rep_id_by_spider 新闻 rep_spider=%s 数据库查询 rep_id 失败" % rep_spider)
            raise

    def check_rep_cus_relationship(self, art_id, rep_id, cus_id):
        try:
            search_sql = "select count(*) from Replys " \
                         "where rep_article_id=%d and rep_id=%d and rep_customer_id=%d" % (art_id, rep_id, cus_id)
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("check_rep_cus_relationship 回复关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 不存在" % (art_id, cus_id))
                return False
            else:
                logging.info("check_rep_cus_relationship 回复关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 存在" % (art_id, cus_id))
                return True
        except:
            logging.exception("check_rep_cus_relationship 回复关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 错误" % (art_id, cus_id))
            raise

    def search_rep_rep_by_spyder(self, rep_json, rep_mod):
        """ 处理回复的回复

        :param rep_json:
        :param rep_mod:
        :return:
        """
        try:
            rep_rep_spider = str(rep_json['reply_to_comment']['id'])
            rep_mod.rep_reply_id = self.search_rep_id_by_spider(rep_rep_spider)
            rep_mod.rep_type = 1
            logging.info("search_rep_rep_by_spyder rep_reply_id 与 rep_type 数据库查询 成功")
        except:
            rep_mod.rep_reply_id = None
            rep_mod.rep_type = 0
            logging.warning("search_rep_rep_by_spyder rep_reply_id 与 rep_type 数据库查询 失败")
