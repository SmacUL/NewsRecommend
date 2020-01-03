import util.MySql as MySql
import model.CustomerModel as CusMod


class CustomerDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def count_customer_by_url(self, url):
        try:
            search_sql = "select count(*) from Customers where cus_url = '%s'" % url
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None

    def search_customer_id_by_url(self, url):
        try:
            search_sql = "select cus_id from Customers where cus_url = '%s'" % url
            self.__base.execute_sql(search_sql)
            result = self.__base.get_result_one()
            return result[0]
        except:
            return None

    def insert_customer(self, cus_mod: CusMod.CustomerModel):
        """ 插入用户数据

        :param cus_mod:
        :return:
        """
        try:
            insert_sql = "insert into Customers(cus_name, cus_pass, cus_url, cus_avatar_url, " \
                         "cus_style, cus_background_url, cus_legal)" \
                         " values ('%s', '%s', '%s', '%s', '%s', '%s', %d)" \
                         % (cus_mod.cus_name, cus_mod.cus_pass, cus_mod.cus_url, cus_mod.cus_avatar_url,
                            cus_mod.cus_style, cus_mod.cus_background_url, cus_mod.cus_legal)
            self.__base.execute_sql(insert_sql)
            self.__base.commit_transactions()
            return True
        except:
            self.__base.commit_rollback()
            return False




