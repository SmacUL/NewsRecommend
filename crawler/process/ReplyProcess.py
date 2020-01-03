import os

import dao.ReplyDao as RepDao
import model.ReplyModel as RepMod
import util.Time as Time
import util.Request as Request


class ReplyProcess:

    def __init__(self, dao: RepDao.ReplyDao):
        self.__dao = dao

    def get_reply_content(self, data, rep_identify_id, rep_article_id, rep_customer_id, rep_comment_id, rep_reply_id):
        rep_mod = RepMod.ReplyModel()

        try:
            rep_mod.rep_like_num = data['digg_count']
            rep_mod.rep_content = data['text']
            rep_mod.rep_time = Time.Time().time_trans(data['create_time'])
        except:
            print("回复 rep_identify_id=%s rep_like_num 或 rep_content 或 rep_time 获取失败" % rep_identify_id)
            return None

        rep_mod.rep_identify_id = str(rep_identify_id)
        rep_mod.rep_type = 0
        rep_mod.rep_article_id = rep_article_id
        rep_mod.rep_customer_id = rep_customer_id
        rep_mod.rep_reply_id = rep_reply_id
        rep_mod.rep_comment_id = rep_comment_id
        return rep_mod

    def insert_reply(self, rep_mod: RepMod):
        if self.__dao.insert_reply(rep_mod):
            print("回复 rep_identify_id=%s 数据库插入成功" % rep_mod.rep_identify_id)
            return True
        else:
            print("回复 rep_identify_id=%s 数据库插入失败" % rep_mod.rep_identify_id)
            return False

    def get_reply_identiy_id(self, data):
        try:
            return str(data['id'])
        except:
            print("回复 rep_identify_id 获取失败")
            return None

    def is_reply_exist(self, identify_id):
        try:
            result = self.__dao.count_reply_by_identify_id(identify_id)
            if result == 0:
                return False
            else:
                return True
        except:
            print("回复 rep_identify_id=%s 数据库查询失败" % identify_id)
            return None

    def get_reply_reply_identify_id(self, data):
        try:
            return str(data['id'])
        except:
            print("回复 的回复 rep_identify_id 获取失败")
            return None

    def get_reply_id_by_rep_identify_id(self, rep_identify_id):
        try:
            return self.__dao.search_reply_id_by_rep_identify_id(rep_identify_id)
        except:
            print("回复 rep_identify_id=%s rep_id 数据库获取失败" % rep_identify_id)
            return None

    def get_replys_data(self, comment):
        try:
            reply_url = 'https://www.toutiao.com/api/pc/2/comment/v4/reply_list/?' \
                        'aid=24&app_name=toutiao-web&id={0}&offset=0&count={1}&repost=0' \
                        .format(comment['id_str'], 20)
            reply_request = Request.Request(os.path.join('properties', 'reply-comment-request.json'))
            reply_request.set_url(reply_url)
            return reply_request.more()['data']['data']
        except:
            print("评论页数据 获取失败")
            return None

    def get_reply_to_comment_data(self, data):
        try:
            return data['reply_to_comment']
        except:
            print("评论的回复获取失败")
            return None






