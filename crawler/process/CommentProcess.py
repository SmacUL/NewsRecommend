import dao.CommentDao as ComDao
import model.CommentModel as ComMod

import util.Time as Time


class CommentProcess:

    def __init__(self, dao: ComDao.CommentDao):
        self.__dao = dao

    def get_comment_identiy_id(self, data):
        return str(data['id'])

    def insert_comment(self, data, comment_identify_id, com_article_id, com_customer_id):
        com_mod = ComMod.CommentModel()
        
        com_mod.com_identify_id = str(comment_identify_id)
        com_mod.com_content = data['text']
        com_mod.com_article_id = com_article_id
        com_mod.com_customer_id = com_customer_id
        com_mod.com_like_num = data['digg_count']
        com_mod.com_time = Time.Time().time_trans(data['create_time'])

        self.__dao.insert_comment(com_mod)

    def is_comment_exist(self, identify_id):
        result = self.__dao.count_comment_by_identify_id(identify_id)
        if result == 0:
            return False
        else:
            return True

    def get_comment_id_by_identify_id(self, identify_id):
        return self.__dao.search_comment_id_by_identify_id(identify_id)

