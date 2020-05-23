import util.MySql as MySql
import model.ArticleModel as ArtMod
import random

import logging


class ArticleDao:
    """ 负责文章的数据库操作

    # 20-04-17 针对新的 SQL 完成修改.

    """


    def __init__(self, base: MySql.MySql):
        self.__base = base


    def is_art_exist(self, art_spider):
        """ 检查新闻是否存在

        # 20-04-17 修改完成

        :param art_spider:
        :return:
        """
        try:
            search_sql = "select count(*) from Article where art_spider = '%s'" % art_spider

            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("新闻 art_spider=%s 数据库查询 不存在" % art_spider)
                return False
            else:
                logging.info("新闻 art_spider=%s 数据库查询 已存在" % art_spider)
                return True
        except:
            logging.exception("新闻 art_spider=%s 数据库查询 失败" % art_spider)
            raise


    def insert_art(self, art_mod: ArtMod.ArticleModel):
        """ 插入新闻数据

        # 20-04-17 修改完成
        # 20-04-23 Rollback BUG Fix

        :param art_mod:
        :return:
        """
        try:
            insert_sql = "insert into Article(art_title, art_spider, art_type, art_image_url, " \
                         "art_content, art_tags, " \
                         "art_cus_id, art_time, art_legal)" \
                         " values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)" \
                         % (art_mod.art_title, art_mod.art_spider, art_mod.art_type, art_mod.art_image_url,
                            art_mod.art_content, art_mod.art_tags,
                            art_mod.art_cus_id, art_mod.art_time, art_mod.art_legal)

            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            logging.info("新闻 art_spider=%s 数据库插入 成功" % art_mod.art_spider)
        except:
            # self.__base.commit_rollback()
            logging.exception("新闻 art_spider=%s 数据库插入 失败" % art_mod.art_spider)
            raise


    def search_art_id_by_spider(self, art_spider):
        """ 通过 spider 查询文章 id

        # 20-04-17 修改完成

        :param art_spider:
        :return:
        """
        try:
            search_sql = "select art_id from Article where art_spider = '%s'" % art_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("新闻 art_spider=%s 数据库查询: art_id 值: %s" % (art_spider, result[0]))
            return result[0]
        except:
            logging.info("新闻 art_spider=%s 数据库查询 art_id 失败" % art_spider)
            raise


    def search_art_time_by_spider(self, art_spider):
        """ 通过 spider 搜索文章时间

        # 20-04-17 修改完毕

        :param art_spider:
        :return:
        """
        try:
            search_sql = "select art_time from Article where art_spider = '%s'" % art_spider
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            logging.info("新闻 art_spider=%s art_time 数据库查询: art_id 值: %s" % (art_spider, result[0]))
            return result[0]
        except:
            logging.info("新闻 art_spider=%s art_time 数据库查询 art_id 失败" % art_spider)
            raise


    def check_art_cus_relationship(self, art_id, cus_id):
        """ 检查 art 与 cus 是否存在.

        # 20-04-17 修改完成

        :param art_id:
        :param cus_id:
        :return:
        """
        try:
            search_sql = "select count(*) from Article where art_id=%d and art_cus_id=%d" % (art_id, cus_id)
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            if result[0] == 0:
                logging.info("关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 不存在" % (art_id, cus_id))
                return False
            else:
                logging.info("关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 存在" % (art_id, cus_id))
                return True
        except:
            logging.exception("关系 新闻 art_id=%s 用户 cus_id=%s 数据库查询 错误" % (art_id, cus_id))
            raise


    @DeprecationWarning
    def update_art_com_number(self, art_id):
        try:
            update_sql = "update Articles set art_comment_num = art_comment_num + 1 where art_id = %d" % art_id

            self.__base.execute_sql(update_sql)
            self.__base.commit_transactions()
            logging.info("update_art_com_number art=%s 评论数 数据库更新 成功" % art_id)
        except:
            # self.__base.commit_rollback()
            logging.info("update_art_com_number art=%s 评论数 数据库更新 失败" % art_id)
            raise


    def update_art_feature(self, behavior, art_id, art_time=''):
        """ 更新新闻的统计信息

        behavior 为 1 是一个比较特殊的情况, 它将设置 update_art_feature 表中的时间.

        # 20-04-17 修改完成
        # 20-04-23 Rollback BUG Fix
        # 20-05-15 修改方法逻辑, 当行为为 6 时, 只将新闻阅读数量加 1

        :param behavior: 这个行为和那个用户行为是两个东西.
        :param art_id:
        :param art_time:
        :return:
        """
        try:
            behavior_dict = {
                1: 'afc_art_time',
                2: 'afc_like_num',
                3: 'afc_dislike_num',
                4: 'afc_com_num',
                5: 'afc_rep_num',
                6: 'afc_read_num'
            }

            if behavior == 1:
                update_sql = "insert into ArtFeatureCount(afc_art_id, afc_art_time) values(%d, '%s')" % (art_id, art_time)
            elif behavior != 1 or behavior != 6:
                update_sql = "update ArtFeatureCount set {0}={1}+1, afc_read_num=afc_read_num+1" \
                             " where afc_art_id=%d"\
                                .format(behavior_dict[behavior], behavior_dict[behavior]) % art_id
            else:
                update_sql = "update ArtFeatureCount set afc_read_num=afc_read_num+1" \
                             " where afc_art_id=%d"\
                                % art_id

            self.__base.execute_sql(update_sql)
            # logging.info("新闻 art_id=%s 特征 %s 数据库插入 成功" % (art_id, behavior))
        except:
            # self.__base.commit_rollback()
            # logging.exception("新闻 art_id=%s 特征 %s 数据库插入 失败" % (art_id, behavior))
            raise


    def get_same_category_art(self, cur_art_id, category):
        """ 随机选择一定数量的同类文章

        此方法的作用主要是为了帮组增加用户的行为数据.
        用户随机浏览发生在两个方面: 一是浏览数量的随机 [1, 40], 二是同类别下浏览文章的随机.

        20-05-15 创建方法
        20-05-19 Bug 修改, 随机逻辑添加

        :param cur_art_id:  当前文章 id
        :param category:    新闻类别
        :return:
        """
        try:
            rand_num = random.randint(1, 40)
            select_sql = "select art_id, art_cus_id from Article where art_type = '%s' and art_id != %d order by rand() limit %d" % \
                         (category, cur_art_id, rand_num)
            self.__base.execute_sql(select_sql)
            return self.__base.get_result_all()
        except:
            raise

