import model.ArticleModel as ArtMod
import model.ReplyModel as RepMod
import model.CommentModel as ComMod
import model.CustomerModel as CusMod

import dao.ArticleDao as ArtDao
import dao.ReplyDao as RepDao
import dao.CommentDao as ComDao
import dao.CustomerDao as CusDao

import process.ArticleProcess as ArtPro
import process.ReplyProcess as RepPro
import process.CommentProcess as ComPro
import process.CustomerProcess as CusPro

import util.MySql as MySql
import util.Json as Json
import util.Time as Time
import os.path
import logging

log_file_name = os.path.join('log', '%s.txt' % Time.Time.get_local_time())
logger = logging.getLogger()
logger.setLevel(logging.INFO)
formatter = logging.Formatter('%(levelname)s - %(module)s - %(funcName)s :\n  \t%(message)s')
handler = logging.FileHandler(filename=log_file_name, mode='a', encoding='utf-8')
handler.setFormatter(formatter)
logger.addHandler(handler)


class Major:

    def __init__(self, path):
        db = Json.Json.read_json_file(path)
        self.__base = MySql.MySql(db_name=db['name'], user=db['user'], password=db['pass'],
                                  host=db['host'], charset=db['charset'])

        self.__art_pro = ArtPro.ArticleProcess()
        self.__rep_pro = RepPro.ReplyProcess()
        self.__com_pro = ComPro.CommentProcess()
        self.__cus_pro = CusPro.CustomerProcess()

        self.__cus_dao = CusDao.CustomerDao(self.__base)
        self.__art_dao = ArtDao.ArticleDao(self.__base)
        self.__com_dao = ComDao.CommentDao(self.__base)
        self.__rep_dao = RepDao.ReplyDao(self.__base)

    def major(self):
        categories = ['news_society', 'news_entertainment', 'news_tech', 'news_military', 'news_sports', 'news_car',
                      'news_finance', 'news_world', 'news_fashion', 'news_travel', 'news_discovery', 'news_baby',
                      'news_regimen', 'news_story', 'news_essay', 'news_game', 'news_history', 'news_food']

        for category in categories:
            print("\n当前类别: %s" % category)
            """ 处理 art """
            try:
                arts_brief_json = self.__art_pro.get_arts_brief_json_by_category(category)
                if len(arts_brief_json) != 0:
                    print("新闻总长度: %d" % len(arts_brief_json))
                # print('arts_brief_json 获取 成功')
            except:
                print('arts_brief_json 获取 失败')
                continue

            for art_brief_json in arts_brief_json:
                # art_cus
                art_cus_mod = CusMod.CustomerModel()
                try:
                    self.__cus_pro.set_art_cus(art_brief_json, art_cus_mod)
                    self.__cus_dao.group_check_insert_cus_then_search_id(art_cus_mod)
                    # print("art_cus 处理 成功")
                except:
                    print("art_cus 处理 失败")
                    continue
                # art
                art_mod = ArtMod.ArticleModel()
                try:
                    self.__art_pro.set_art(art_brief_json, category, art_cus_mod.cus_id, art_mod)
                    if not self.__art_dao.is_art_exist(art_mod.art_spider):
                        # 新闻不存在的情况
                        self.__art_dao.insert_art(art_mod)
                    else:
                        print("art 已存在")
                        continue
                    art_mod.art_id = self.__art_dao.search_art_id_by_spider(art_mod.art_spider)
                    art_mod.art_time = self.__art_dao.search_art_time_by_spider(art_mod.art_spider)
                    # print("art 操作 成功")
                except:
                    print("art 操作 失败")
                    continue
                # art cus behavior
                try:
                    if self.__art_dao.check_art_cus_relationship(art_mod.art_id, art_cus_mod.cus_id):
                        self.__cus_dao.insert_cus_behavior(1, art_mod.art_id, art_cus_mod.cus_id, art_mod.art_time)
                        self.__cus_dao.update_cus_feature(category, art_cus_mod.cus_id)
                        self.__art_dao.update_art_feature(1, art_mod.art_id, art_mod.art_time)
                    else:
                        pass
                    # print("art-cus 行为 1 数据库操作 成功")
                except:
                    print("art-cus 行为 1 数据库操作 失败")
                    continue

                """ handel the coms """
                try:
                    coms_json = self.__com_pro.get_coms_json(art_brief_json)
                    if len(coms_json) != 0:
                        print("回复总长 %d" % len(coms_json))
                except:
                    print("coms_json 获取 失败")
                    continue

                for com_json in coms_json:
                    # com_cus
                    com_cus_mod = CusMod.CustomerModel()
                    try:
                        self.__cus_pro.set_com_cus(com_json, com_cus_mod)
                        self.__cus_dao.group_check_insert_cus_then_search_id(com_cus_mod)
                        # print("com_cus 处理 成功")
                    except:
                        print("com_cus 处理 错误")
                        continue
                    # com
                    com_mod = ComMod.CommentModel()
                    try:
                        self.__com_pro.set_com(com_json, art_mod.art_id, com_cus_mod.cus_id, com_mod)
                        if not self.__com_dao.is_com_exist(com_mod.com_spider):
                            # if the com is not exist
                            self.__com_dao.insert_com(com_mod)
                        else:
                            print("com 已存在")
                            continue
                        com_mod.com_id = self.__com_dao.search_com_id_by_spider(com_mod.com_spider)
                        self.__art_dao.update_art_com_number(art_mod.art_id)
                        # print("com 处理 成功")
                    except:
                        print("com 处理 失败")
                        continue
                    # com cus behavior
                    try:
                        if self.__com_dao.check_com_cus_relationship(art_mod.art_id, com_mod.com_id, com_cus_mod.cus_id):
                            self.__cus_dao.insert_cus_behavior(4, art_mod.art_id, com_cus_mod.cus_id, com_mod.com_time)
                            self.__cus_dao.update_cus_feature(category, com_cus_mod.cus_id)
                            self.__art_dao.update_art_feature(4, art_mod.art_id)
                        else:
                            pass
                        # print("art-cus 行为 4 数据库操作 成功")
                    except:
                        print("art-cus 行为 4 数据库操作 失败")
                        continue

                    """ handel the reps """
                    try:
                        reps_json = self.__rep_pro.get_reps_json(com_json)
                        if len(reps_json) != 0:
                            print("回复总长 %d" % len(reps_json))
                    except:
                        print("reps_json 获取 失败")
                        continue

                    for rep_json in reps_json:
                        # rep_cus
                        rep_cus_mod = CusMod.CustomerModel()
                        try:
                            self.__cus_pro.set_rep_cus(rep_json, rep_cus_mod)
                            self.__cus_dao.group_check_insert_cus_then_search_id(rep_cus_mod)
                            # print("rep_cus 处理 成功")
                        except:
                            print("rep_cus 处理 失败")
                            continue
                        # rep
                        rep_mod = RepMod.ReplyModel()
                        try:
                            self.__rep_pro.set_rep(rep_json, art_mod.art_id,
                                                   com_mod.com_id, rep_cus_mod.cus_id, rep_mod)
                            if not self.__rep_dao.is_rep_exist(rep_mod.rep_spider):
                                self.__rep_dao.search_rep_rep_by_spyder(rep_json, rep_mod)
                                self.__rep_dao.insert_rep(rep_mod)
                            else:
                                print("rep 已存在")
                                continue
                            rep_mod.rep_id = self.__rep_dao.search_rep_id_by_spider(rep_mod.rep_spider)
                            # print("rep 处理 成功")
                        except:
                            print("rep 处理 失败")
                            continue

                        # reply customer behavior, customer feature data, article feature data
                        try:
                            if self.__rep_dao.check_rep_cus_relationship(art_mod.art_id, rep_mod.rep_id,
                                                                         rep_cus_mod.cus_id):
                                self.__cus_dao.insert_cus_behavior(5, art_mod.art_id, rep_cus_mod.cus_id,
                                                                   rep_mod.rep_time)
                                self.__cus_dao.update_cus_feature(category, rep_cus_mod.cus_id)
                                self.__art_dao.update_art_feature(5, art_mod.art_id)
                            else:
                                pass
                            # print("art-cus 行为 5 数据库操作 成功")
                        except:
                            print("art-cus 行为 5 数据库操作 失败")
                            continue


if __name__ == '__main__':
    Major(os.path.join('properties', 'database.json')).major()












