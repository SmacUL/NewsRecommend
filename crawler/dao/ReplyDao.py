import util.MySql as MySql
import model.ReplyModel as RepMod


class ReplyDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def insert_reply(self, rep_mod: RepMod.ReplyModel):
        try:
            if rep_mod.rep_reply_id is None:
                insert_sql = "insert into Replys(rep_content, rep_like_num, rep_type, rep_time," \
                             " rep_customer_id, rep_article_id, rep_comment_id, " \
                             " rep_identify_id, rep_legal)" \
                             " values ('%s', '%d', '%d', '%s', '%s', '%s', '%s', '%s', %d)" \
                             % (rep_mod.rep_content, rep_mod.rep_like_num, rep_mod.rep_type, rep_mod.rep_time,
                                rep_mod.rep_customer_id, rep_mod.rep_article_id, rep_mod.rep_comment_id,
                                rep_mod.rep_identify_id, rep_mod.rep_legal)
            else:
                insert_sql = "insert into Replys(rep_content, rep_like_num, rep_type, rep_time," \
                             " rep_customer_id, rep_article_id, rep_comment_id, " \
                             "rep_reply_id, rep_identify_id, rep_legal)" \
                             " values ('%s', '%d', '%d', '%s', '%s', '%s', '%s', '%d', '%s', %d)" \
                             % (rep_mod.rep_content, rep_mod.rep_like_num, rep_mod.rep_type, rep_mod.rep_time,
                                rep_mod.rep_customer_id, rep_mod.rep_article_id, rep_mod.rep_comment_id,
                                rep_mod.rep_reply_id, rep_mod.rep_identify_id, rep_mod.rep_legal)

            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            return True
        except:
            self.__base.commit_rollback()
            return False

    def count_reply_by_identify_id(self, identify_id):
        try:
            search_sql = "select count(*) from Replys where rep_identify_id = %s" % identify_id
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None

    def search_reply_id_by_rep_identify_id(self, rep_identify_id):
        try:
            search_sql = "select rep_id from Replys where rep_identify_id = %s" % rep_identify_id
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None

