import util.MySql as MySql
import model.CommentModel as ComMod


class CommentDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def count_comment_by_url(self, url):
        search_sql = "select count(*) from Comments where com_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_one()

    def insert_comment(self, com_mod: ComMod.CommentModel):
        insert_sql = "insert into Comments(com_content, com_like_num, com_customer_id," \
                     " com_article_id, com_time, com_identify_id, com_legal)" \
                     " values ('%s', '%d', '%s', '%s', '%s', %d, %d)" \
                     % (com_mod.com_content, com_mod.com_like_num, com_mod.com_customer_id,
                        com_mod.com_article_id,com_mod.com_time, com_mod.com_identify_id, com_mod.com_legal)
        self.__base.execute_sql(insert_sql)
        self.__base.commit_transactions()

    def count_comment_by_identify_id(self, id):
        search_sql = "select count(*) from Comments where com_identify_id = %d" % id
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_one()

    def search_comment_id_by_identify_id(self, id):
        search_sql = "select com_id from Comments where com_identify_id = %d" % id
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_one()
