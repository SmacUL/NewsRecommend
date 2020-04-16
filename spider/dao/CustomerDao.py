import util.MySql as MySql
import model.CustomerModel as CusMod

import logging


class CustomerDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def is_cus_exist(self, cus_spider):
        """ 检查用户是否存在与数据库

        :param cus_spider:
        :return:
        """
        try:
            search_sql = "select count(*) from Customers where cus_spider = '%s'" % cus_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("用户 cus_spider=%s 数据库查询 不存在" % cus_spider)
                return False
            else:
                logging.info("用户 cus_spider=%s 数据库查询 已存在" % cus_spider)
                return True
        except:
            logging.exception("用户 cus_spider=%s 数据库查询 失败" % cus_spider)
            raise

    def insert_cus(self, cus_mod: CusMod.CustomerModel):
        """ 向数据库中插入用户数据

        :param cus_mod:
        :return:
        """
        try:
            insert_sql = "insert into Customers(cus_name, cus_pass, cus_spider, cus_avatar_url, " \
                         "cus_style, cus_legal)" \
                         " values ('%s', '%s', '%s', '%s', '%s', %d)" \
                         % (cus_mod.cus_name, cus_mod.cus_pass, cus_mod.cus_spider, cus_mod.cus_avatar_url,
                            cus_mod.cus_style, cus_mod.cus_legal)
            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            logging.info("用户 cus_spider=%s 数据库插入 成功" % cus_mod.cus_spider)
        except:
            self.__base.commit_rollback()
            logging.exception("用户 cus_spider=%s 数据库插入 失败" % cus_mod.cus_spider)
            raise

    def search_cus_id_by_spider(self, cus_spider):
        """ 利用 spider 查询用户 id

        :param cus_spider:
        :return:
        """
        try:
            search_sql = "select cus_id from Customers where cus_spider = '%s'" % cus_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("用户 cus_spider=%s 数据库查询: cus_id 值: %s" % (cus_spider, result[0]))
            return result[0]
        except:
            logging.info("用户 cus_spider=%s 数据库查询 cus_id 失败" % cus_spider)
            raise

    def group_check_insert_cus_then_search_id(self, cus_mod: CusMod.CustomerModel):
        try:
            if not self.is_cus_exist(cus_mod.cus_spider):
                self.insert_cus(cus_mod)
            cus_mod.cus_id = self.search_cus_id_by_spider(cus_mod.cus_spider)
            logging.info("数据库处理成功")
        except:
            logging.exception("数据库处理失败")
            raise

    def insert_cus_behavior(self, behavior, art_id, cus_id, time):
        """

        :param behavior:
        :param art_id:
        :param cus_id:
        :param time:
        :return:
        """
        try:
            insert_sql0 = "insert into ArticleCustomerBehaviors(acb_behavior, acb_time, acb_article_id, acb_customer_id) " \
                         "values (%d, '%s', %d, %d)" % (behavior, time, art_id, cus_id)
            insert_sql1 = "insert into ArticleCustomerBehaviors(acb_behavior, acb_time, acb_article_id, acb_customer_id) " \
                         "values (6, '%s', %d, %d)" % (time, art_id, cus_id)
            self.__base.execute_sql(insert_sql0)
            self.__base.execute_sql(insert_sql1)
            self.__base.commit_transactions()
            logging.info("新闻 art_id=%s 用户 cus_id=%s 行为 %s 数据库插入 成功" % (art_id, cus_id, behavior))
        except:
            self.__base.commit_rollback()
            logging.exception("新闻 art_id=%s 用户 cus_id=%s 行为 %s 数据库插入 失败" % (art_id, cus_id, behavior))
            raise

    def update_cus_feature(self, category, cus_id):
        """ update customer feature data

        :param category:
        :param cus_id:
        :return:
        """
        try:
            # if behavior == 1:
            #     update_sql = "insert into CustomerFeatureCount(cfc_customer_id, {0}) values(%d, %d)" \
            #                      .format('cfc_' + category) % (cus_id, 1)
            # else:
            #     update_sql = "update CustomerFeatureCount set {0}={1}+1 where cfc_customer_id=%d" \
            #                      .format('cfc_' + category, 'cfc_' + category) % cus_id

            search_sql = "select count(*) from CustomerFeatureCount where cfc_customer_id=%d" % cus_id
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("特征 用户 cus_id=%s 数据库查询 不存在" % (cus_id))
                update_sql = "insert into CustomerFeatureCount(cfc_customer_id, {0}) values(%d, %d)" \
                                 .format('cfc_' + category) % (cus_id, 1)
            else:
                logging.info("特征 用户 cus_id=%s 数据库查询 存在" % (cus_id))
                update_sql = "update CustomerFeatureCount set {0}={1}+1 where cfc_customer_id=%d" \
                                 .format('cfc_' + category, 'cfc_' + category) % cus_id

            self.__base.execute_sql(update_sql)
            logging.info("用户 cus_id=%s 类别 %s 特征 数据库插入 成功" % (cus_id, category))
        except:
            self.__base.commit_rollback()
            logging.exception("用户 cus_id=%s 类别 %s 特征 数据库插入 失败" % (cus_id, category))
            raise