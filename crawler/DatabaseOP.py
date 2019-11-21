import pymysql


class MysqlOP():
    """ Mysql 数据库

    """

    def __init__(self, db_name, user, password, host="localhost", charset="utf8"):
        self.host = host
        self.user = user
        self.password = password
        self.db_name = db_name
        self.charset = charset
        self.db_handle = None
        self.cursor = None

    def create_connection(self):
        self.db_handle = pymysql.connect(host=self.host,
                                         user=self.user,
                                         password=self.password,
                                         db=self.db_name,
                                         charset=self.charset)
        self.cursor = self.db_handle.cursor()

    def execute_sql(self, sql):
        try:
            print(sql)
            self.cursor.execute(sql)
        except:
            print("sql execute has some errors.")

    def commit_transactions(self):
        try:
            self.db_handle.commit()
        except:
            self.db_handle.rollback()

    def get_result(self):
        try:
            result = self.cursor.fetchall()
            print(result)
            return result
        except:
            print("sql fetchall has some errors.")

    def insert_customer(self, cus_name, cus_pass, cus_avatar_url):
        """ 将爬下的信息插入到 Customer 表中

        1. 先检查用户是否存在(检查用户名)
        2. 若用户不存在, 则插入

        :param cus_name:
        :param cus_pass:
        :param cus_avatar_url:
        :return:
        """
        customer_check_sql = "select count(*) from Customers where cus_name = '%s'" % cus_name
        self.execute_sql(customer_check_sql)
        result = self.get_result()
        if result[0][0] == 0:
            customer_insert_sql = "insert into Customers(cus_name, cus_pass, cus_avatar_url, cus_type)" \
                                  " values ('%s', '%s', '%s', 0)" % \
                                  (cus_name, cus_pass, cus_avatar_url)
            self.execute_sql(customer_insert_sql)
            self.commit_transactions()

    def insert_article(self, art_url, cus_name, art_title, art_abstract, art_content, art_tag, art_image):
        article_check_sql = "select count(*) from Articles where art_url = '%s'" % art_url
        self.execute_sql(article_check_sql)
        result = self.get_result()
        if result[0][0] == 0:
            customer_search_sql = "select cus_id from Customers where cus_name = '%s'" % cus_name
            self.execute_sql(customer_search_sql)
            art_customer_id = self.get_result()[0][0]
            article_insert_sql = "insert into Articles(art_title, art_abstract, art_content, art_url, art_customer_id, art_tag, art_image)" \
                                 " values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')" % \
                                 (art_title, art_abstract, art_content, art_url, art_customer_id, art_tag, art_image)
            self.execute_sql(article_insert_sql)
            self.commit_transactions()


if __name__ == "__main__":
    None
