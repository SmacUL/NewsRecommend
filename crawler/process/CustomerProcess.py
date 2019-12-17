import dao.CustomerDao as CusDao
import model.CustomerModel as CusMod
import util.Md5 as Md5


class CustomerProcess:

    def __init__(self, dao: CusDao.CustomerDao):
        self.__dao = dao

    def get_customer_url(self, data):
        """ 获得 用户的 url

        :param data:
        :return:
        """
        return "https://www.toutiao.com" + data['media_url']

    def is_art_customer_exist(self, url):
        """

        :param url:
        :return:
        """
        result = self.__dao.count_customer_by_url(url)
        if result == 0:
            return False
        else:
            return True

    def insert_art_customer(self, data):
        cus_mod = CusMod.CustomerModel()

        cus_mod.cus_url = self.get_customer_url(data)
        cus_mod.cus_avatar_url = 'https:' + data['media_avatar_url']
        cus_mod.cus_name = data['source']
        cus_mod.cus_background_url = None
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
        cus_mod.cus_style = '这个人很懒, 什么都没写'

        self.__dao.insert_customer(cus_mod)

    def get_art_customer_id_by_url(self, url):
        return self.__dao.search_customer_id_by_url(url)

    # def check_customer(self, data, cus_mod):
    #     """ 获取并检查用户 url
    #
    #     :param data:
    #     :param cus_mod:
    #     :return:
    #     """
    #     if not isinstance(cus_mod, CusMod.CustomerModel):
    #         return None
    #     cus_mod.cus_url = "https://www.toutiao.com" + data['media_url']
    #     return self.__dao.search_customer_by_url(cus_mod)

    # def insert_customer(self, data, cus_mod):
    #     """ 获取并插入用户数据
    #
    #     :param data:
    #     :param cus_mod:
    #     :return:
    #     """
    #     if not isinstance(cus_mod, CusMod.CustomerModel):
    #         return None
    #     cus_mod.cus_avatar_url = 'https:' + data['media_avatar_url']
    #     cus_mod.cus_name = data['source']
    #     cus_mod.cus_background_url = None
    #     cus_mod.cus_pass = self.__md5.set_cus_pass("123456")
    #     cus_mod.cus_style = None
    #
    #     self.__dao.insert_customer(cus_mod)
    #     cus_mod = self.__dao.search_customer_id_by_url(cus_mod)
    #     return cus_mod


