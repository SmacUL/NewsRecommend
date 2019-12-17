import util.MySql as MySql
import model.CustomerModel as CusMod


class CustomerDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

    def count_customer_by_url(self, url):
        search_sql = "select count(*) from Customers where cus_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result()[0][0]

    def search_customer_id_by_url(self, url):
        search_sql = "select cus_id from Customers where cus_url = '%s'" % url
        self.__base.execute_sql(search_sql)
        return self.__base.get_result()[0][0]


    # def search_customer_by_url(self, cus_mod):
    #     """ 查询 customer 信息, 依据 url
    #
    #     1. 如果 cus_mod 不是 CusMod.CustomerModel 类型 返回 None
    #     2. 如果 cus_mod.cus_url 所指用户 不 存在与数据库中, 返回包含 cus_url 的 cus_mod
    #     3. 如果 cus_mod.cus_url 所指用户存在与数据库中, 返回此用户的全部信息的 cus_mod
    #
    #     :param cus_mod:
    #     :return:
    #     """
    #     if not isinstance(cus_mod, CusMod.CustomerModel):
    #         # 1
    #         return None
    #     search_sql = "select * from Customers where cus_url = '%s'" % cus_mod.cus_url
    #     self.__base.execute_sql(search_sql)
    #     result = self.__base.get_result()
    #
    #     # print(result.__len__())
    #
    #     if result.__len__() == 0:
    #         # 2
    #         return cus_mod
    #     else:
    #         # 3
    #         # 将数据库中的 cus_mod 数据返回
    #         # cus_mod = CusMod.CustomerModel()
    #         # cus_mod
    #         return None

    # def search_customer_id_by_url(self, cus_mod):
    #     """ 查询 用户 id 通过 url
    #
    #     :param cus_mod:
    #     :return:
    #     """
    #     if not isinstance(cus_mod, CusMod.CustomerModel):
    #         return None
    #     search_sql = "select cus_id from Customers where cus_url = '%s'" % cus_mod.cus_url
    #     self.__base.execute_sql(search_sql)
    #     result = self.__base.get_result()
    #     if result[0][0] == 0:
    #         return None
    #     else:
    #         cus_mod.cus_id = result
    #         return cus_mod

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



