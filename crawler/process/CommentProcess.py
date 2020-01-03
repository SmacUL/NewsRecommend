import os

import dao.CommentDao as ComDao
import model.CommentModel as ComMod

import util.Time as Time
import util.Request as Request


class CommentProcess:

    def __init__(self, dao: ComDao.CommentDao):
        self.__dao = dao

    def get_comment_identiy_id(self, data):
        try:
            return str(data['id'])
        except:
            print("评论 com_identify_id 获取失败")
            return None

    def get_comment_content(self, data, comment_identify_id, com_article_id, com_customer_id):
            com_mod = ComMod.CommentModel()

            try:
                com_mod.com_content = data['text']
                com_mod.com_like_num = data['digg_count']
                com_mod.com_time = Time.Time().time_trans(data['create_time'])
            except:
                print("评论 com_identify_id=%s com_content 或 com_like_num 或 com_time" % comment_identify_id)
                return None
            com_mod.com_identify_id = str(comment_identify_id)
            com_mod.com_article_id = com_article_id
            com_mod.com_customer_id = com_customer_id
            return com_mod

    def insert_comment(self, com_mod):

        if self.__dao.insert_comment(com_mod):
            print("评论 com_identify_id=%s 数据库插入成功" % com_mod.com_identify_id)
            return False
        else:
            print("评论 com_identify_id=%s 数据库插入失败" % com_mod.com_identify_id)
            return True

    def is_comment_exist(self, identify_id):
        try:
            result = self.__dao.count_comment_by_identify_id(identify_id)
            if result == 0:
                return False
            else:
                return True
        except:
            print("评论 com_identify_id=%s 数据库查询失败" % identify_id)
            return None

    def get_comment_id_by_identify_id(self, identify_id):
        try:
            return self.__dao.search_comment_id_by_identify_id(identify_id)
        except:
            print("评论 com_identify_id=%s com_id 数据库获取失败" % identify_id)
            return None

    def get_comments_data(self, data):
        try:
            comment_url = 'https://www.toutiao.com/api/pc/article/v4/tab_comments/?' \
                          'aid=66&app_name=toutiao-web&group_id={0}&item_id={1}&offset=0&count={2}' \
                .format(data['group_id'], data['item_id'], 10)
            comment_request = Request.Request(os.path.join('properties', 'reply-comment-request.json'))
            comment_request.set_url(comment_url)
            return comment_request.more()['data']
        except:
            print("评论页数据 获取失败")
            return None

    def get_comment_data(self, data):
        try:
            return data['comment']
        except:
            print("评论数据 获取失败")
            return None

