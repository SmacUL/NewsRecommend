import util.MySql as MySql
import model.CommentModel as ComMod


class CommentDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def count_comment_by_url(self, url):
        try:
            search_sql = "select count(*) from Comments where com_url = '%s'" % url
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None

    def insert_comment(self, com_mod: ComMod.CommentModel):
        try:
            insert_sql = "insert into Comments(com_content, com_like_num, com_customer_id," \
                         " com_article_id, com_time, com_identify_id, com_legal)" \
                         " values ('%s', '%d', '%s', '%s', '%s', %s, %d)" \
                         % (com_mod.com_content, com_mod.com_like_num, com_mod.com_customer_id,
                            com_mod.com_article_id,com_mod.com_time, com_mod.com_identify_id, com_mod.com_legal)

            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            return True
        except:
            self.__base.commit_rollback()
            return False

    def count_comment_by_identify_id(self, identify_id):
        try:
            search_sql = "select count(*) from Comments where com_identify_id = %s" % identify_id
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None

    def search_comment_id_by_identify_id(self, identify_id):
        try:
            search_sql = "select com_id from Comments where com_identify_id = %s" % identify_id
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None
