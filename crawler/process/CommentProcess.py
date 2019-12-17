import dao.CommentDao as ComDao
import model.CommentModel as ComMod

import util.Time as Time


class CommentProcess:

    def __init__(self, dao: ComDao.CommentDao):
        self.__dao = dao

    def insert_comment(self, data, com_article_id, com_customer_id):
        com_mod = ComMod.CommentModel()

        com_mod.com_content = data['text']
        com_mod.com_article_id = com_article_id
        com_mod.com_customer_id = com_customer_id
        com_mod.com_like_num = data['digg_count']
        com_mod.com_time = Time.Time().time_trans(data['create_time'])

        self.__dao.insert_comment(com_mod)


