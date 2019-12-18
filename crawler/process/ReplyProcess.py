import dao.ReplyDao as RepDao
import model.ReplyModel as RepMod
import util.Time as Time


class ReplyProcess:

    def __init__(self, dao: RepDao.ReplyDao):
        self.__dao = dao

    def insert_reply(self, data, rep_identify_id, rep_article_id, rep_customer_id, rep_comment_id, rep_reply_id):
        rep_mod = RepMod.ReplyModel()

        rep_mod.rep_identify_id = rep_identify_id
        rep_mod.rep_like_num = data['digg_count']
        rep_mod.rep_type = 0
        rep_mod.rep_article_id = rep_article_id
        rep_mod.rep_customer_id = rep_customer_id
        rep_mod.rep_reply_id = rep_reply_id
        rep_mod.rep_comment_id = rep_comment_id
        rep_mod.rep_content = data['text']
        rep_mod.rep_time = Time.Time().time_trans(data['create_time'])

        return self.__dao.insert_reply(rep_mod)

    # def search_rep_reply(self, data):
    #     rep_reply_customer_url = "https://www.toutiao.com/c/user/" + str(data['user_id'])
    #     rep_reply_customer_text = data['text']
    #
    #     self.__dao.search_reply_by
    #     pass

    def get_reply_identiy_id(self, data):
        return data['id']

    def is_reply_exist(self, id):
        result = self.__dao.count_reply_by_identify_id(id)
        if result == 0:
            return False
        else:
            return True

    def get_reply_reply_identify_id(self, data):
        return data['id']

    def get_reply_id_by_rep_identify_id(self, id):
        return self.__dao.search_reply_id_by_rep_identify_id(id)



