import util.MySql as MySql
import model.CustomerModel as CusMod


class CustomerDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def count_customer_by_url(self, url):
        search_sql = "select count(*) from Customers where cus_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_all()[0][0]

    def search_customer_id_by_url(self, url):
        search_sql = "select cus_id from Customers where cus_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result_all()[0][0]

    def insert_customer(self, cus_mod: CusMod.CustomerModel):
        """ 插入用户数据

        :param cus_mod:
        :return:
        """
        insert_sql = "insert into Customers(cus_name, cus_pass, cus_url, cus_avatar_url, " \
                     "cus_style, cus_background_url, cus_legal)" \
                     " values ('%s', '%s', '%s', '%s', '%s', '%s', %d)" \
                     % (cus_mod.cus_name, cus_mod.cus_pass, cus_mod.cus_url, cus_mod.cus_avatar_url,
                        cus_mod.cus_style, cus_mod.cus_background_url, cus_mod.cus_legal)
        self.__base.execute_sql(insert_sql)
        self.__base.commit_transactions()




