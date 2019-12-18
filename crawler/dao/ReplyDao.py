import util.MySql as MySql
import model.ReplyModel as RepMod


class ReplyDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def insert_reply(self, rep_mod: RepMod.ReplyModel):
        insert_sql = "insert into Replys(rep_content, rep_like_num, rep_type, rep_time," \
                     " rep_customer_id, rep_article_id, rep_comment_id, " \
                     "rep_reply_id, rep_legal)" \
                     " values ('%s', '%d', '%d', '%s', '%s', '%s', '%s', '%s', %d)" \
                     % (rep_mod.rep_content, rep_mod.rep_like_num, rep_mod.rep_type, rep_mod.rep_time,
                        rep_mod.rep_customer_id, rep_mod.rep_article_id, rep_mod.rep_comment_id,
                        rep_mod.rep_reply_id, rep_mod.rep_legal)
        self.__base.execute_sql(insert_sql)
        search_sql = "select LAST_INSERT_ID()"
        rep_id = self.__base.execute_sql(search_sql)
        self.__base.commit_transactions()
        return rep_id

    def count_reply_by_identify_id(self, id):
        search_sql = "select count(*) from Replys where rep_identify_id = %d" % id
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_all()[0][0]

    def search_reply_id_by_rep_identify_id(self, id):
        search_sql = "select rep_id from Replys where rep_identify_id = %d" % id
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_all()[0][0]

