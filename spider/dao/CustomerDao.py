import util.MySql as MySql
import model.CustomerModel as CusMod

import logging


class CustomerDao:
    """ 负责用户的数据库操作

    # 20-04-17 针对新的 SQL 完成修改.

    """


    def __init__(self, base: MySql.MySql):
        self.__base = base


    def is_cus_name_exist(self, cus_name):
        """ 检查用户名是否已经存在在数据库中

        # 20-04-17 创建方法

        :param cus_name:
        :return:
        """
        try:
            search_sql = "select count(*) from Customer where cus_name = '%s'" % cus_name
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("用户 cus_name=%s 数据库查询 不存在" % cus_name)
                return False
            else:
                logging.info("用户 cus_name=%s 数据库查询 已存在" % cus_name)
                return True
        except:
            logging.exception("用户 cus_name=%s 数据库查询 失败" % cus_name)
            raise


    def get_cus_by_name(self, cus_mod: CusMod.CustomerModel):
        """ 通过用户名, 获取用户的信息

        20-04-17 创建方法

        :param cus_mod: 保证 cus_name 被填充
        :return:
        """
        try:
            search_sql = "select cus_id, cus_name, cus_pass, cus_spider, cus_avatar_url, cus_style, cus_legal" \
                         " from Customer where cus_name = '%s'" % cus_mod.cus_name
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_all()

            cus_mod.cus_id = result[0][0]
            # cus_mod.cus_name = result[1]
            cus_mod.cus_pass = result[0][2]
            cus_mod.cus_spider = result[0][3]
            cus_mod.cus_avatar_url = result[0][4]
            cus_mod.cus_style = result[0][5]
            cus_mod.cus_legal = result[0][6]
            logging.info("用户 cus_name=%s 数据库查询 完成" % cus_mod.cus_name)
        except:
            logging.exception("用户 cus_name=%s 数据库查询 失败" % cus_mod.cus_name)
            raise


    def insert_then_get_cus(self, cus_mod: CusMod.CustomerModel):
        """ 检查用户是否存在, 确认是否插入用户, 获取用户 ID.

        # 20-04-17 创建方法

        :param cus_mod:
        :return:
        """
        try:
            # 如果用户不存在, 就直接插入
            if not self.is_cus_name_exist(cus_mod.cus_name):
                self.insert_cus(cus_mod)
            # 直接从数据库中更新数据.
            self.get_cus_by_name(cus_mod)
            logging.info("数据库处理成功")
        except:
            logging.exception("数据库处理失败")
            raise


    def insert_cus(self, cus_mod: CusMod.CustomerModel):
        """ 向数据库中插入用户数据

        # 20-04-17 检查 OK

        :param cus_mod:
        :return:
        """
        try:
            insert_sql = "insert into Customer(cus_name, cus_pass, cus_spider, cus_avatar_url, " \
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


    def insert_cus_behavior(self, cbr_cus_id_from, cbr_cus_id_to, cbr_behavior, cbr_time, cbr_art_id, cbr_type, cbr_target_id):
        """ 插入用户行为

        # 20-04-17 修改完成

        :param cbr_cus_id_from:
        :param cbr_cus_id_to:
        :param cbr_behavior:
        :param cbr_time:
        :param cbr_art_id:
        :param cbr_type:
        :param cbr_target_id:
        :return:
        """
        try:
            insert_sql0 = "insert into CusBehaviorRecord(cbr_cus_id_from, cbr_cus_id_to, cbr_behavior, cbr_time, cbr_art_id, cbr_type, cbr_target_id) " \
                         "values (%d, %d, %d, '%s', %d, %d, %d)" \
                          % (cbr_cus_id_from, cbr_cus_id_to, cbr_behavior, cbr_time, cbr_art_id, cbr_type, cbr_target_id)
            insert_sql1 = "insert into CusBehaviorRecord(cbr_cus_id_from, cbr_cus_id_to, cbr_behavior, cbr_time, cbr_art_id, cbr_type, cbr_target_id) " \
                         "values (%d, %d, 2, '%s', %d, %d, %d)" \
                          % (cbr_cus_id_from, cbr_cus_id_to, cbr_time, cbr_art_id, cbr_type, cbr_target_id)

            self.__base.execute_sql(insert_sql0)
            self.__base.execute_sql(insert_sql1)
            self.__base.commit_transactions()
            logging.info("用户 cus_id=%s 与用户 cus_id=%s 行为 %s 数据库插入 成功" % (cbr_cus_id_from, cbr_cus_id_to, cbr_behavior))
        except:
            self.__base.commit_rollback()
            logging.exception("用户 cus_id=%s 与用户 cus_id=%s 行为 %s 数据库插入 成功" % (cbr_cus_id_from, cbr_cus_id_to, cbr_behavior))
            raise


    def update_cus_feature(self, category, cus_id):
        """ 更新用户统计数据

        # 20-04-17 修改完成
        # 20-04-18 BUG 修改: 每调用一次此方法, 用户特征的增加应该与文章特征的增加保持一致, 即增加 2, 而非 1.

        :param category:
        :param cus_id:
        :return:
        """
        try:
            search_sql = "select count(*) from CusFeatureCount where cfc_cus_id=%d" % cus_id
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("特征 用户 cus_id=%s 数据库查询 不存在" % (cus_id))
                update_sql = "insert into CusFeatureCount(cfc_cus_id, {0}) values(%d, %d)" \
                                 .format('cfc_' + category) % (cus_id, 2)
            else:
                logging.info("特征 用户 cus_id=%s 数据库查询 存在" % (cus_id))
                update_sql = "update CusFeatureCount set {0}={1}+2 where cfc_cus_id=%d" \
                                 .format('cfc_' + category, 'cfc_' + category) % cus_id

            self.__base.execute_sql(update_sql)
            logging.info("用户 cus_id=%s 类别 %s 特征 数据库插入 成功" % (cus_id, category))
        except:
            self.__base.commit_rollback()
            logging.exception("用户 cus_id=%s 类别 %s 特征 数据库插入 失败" % (cus_id, category))
            raise


    @DeprecationWarning
    def is_cus_exist(self, cus_spider):
        """ 检查用户是否存在与数据库

        :param cus_spider:
        :return:
        """
        try:
            search_sql = "select count(*) from Customer where cus_spider = '%s'" % cus_spider
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


    @DeprecationWarning
    def search_cus_id_by_spider(self, cus_spider):
        """ 利用 spider 查询用户 id

        :param cus_spider:
        :return:
        """
        try:
            search_sql = "select cus_id from Customer where cus_spider = '%s'" % cus_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("用户 cus_spider=%s 数据库查询: cus_id 值: %s" % (cus_spider, result[0]))
            return result[0]
        except:
            logging.info("用户 cus_spider=%s 数据库查询 cus_id 失败" % cus_spider)
            raise


