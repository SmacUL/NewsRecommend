import dao.CustomerDao as CusDao
import model.CustomerModel as CusMod
import util.Md5 as Md5


class CustomerProcess:

    def __init__(self, dao: CusDao.CustomerDao):
        self.__dao = dao

    def get_article_customer_url(self, data):
        """ 获得 用户的 url

        :param data:
        :return:
        """
        return "https://www.toutiao.com" + data['media_url']

    def get_comment_customer_url(self, data):
        return "https://www.toutiao.com/c/user/" + str(data['user_id'])

    def get_reply_customer_url(self, data):
        return "https://www.toutiao.com/c/user/" + str(data['user_id'])

    def is_customer_exist(self, url):
        """

        :param url:
        :return:
        """
        result = self.__dao.count_customer_by_url(url)
        if result == 0:
            return False
        else:
            return True

    def insert_art_customer(self, data, cus_url):
        cus_mod = CusMod.CustomerModel()

        cus_mod.cus_url = cus_url
        cus_mod.cus_avatar_url = 'https:' + data['media_avatar_url']
        cus_mod.cus_name = data['source']
        cus_mod.cus_background_url = None
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
        cus_mod.cus_style = '这个人很懒, 什么都没写'

        self.__dao.insert_customer(cus_mod)

    def get_customer_id_by_url(self, url):
        return self.__dao.search_customer_id_by_url(url)

    def insert_comment_customer(self, data, cus_url):
        cus_mod = CusMod.CustomerModel()

        cus_mod.cus_url = cus_url
        cus_mod.cus_avatar_url = data['user_profile_image_url']
        cus_mod.cus_name = data['user_name']
        cus_mod.cus_style = '这个人很懒, 什么都没写'
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
        cus_mod.cus_background_url = None

        self.__dao.insert_customer(cus_mod)

    def insert_reply_customer(self, data, cus_url):
        cus_mod = CusMod.CustomerModel()

        cus_mod.cus_url = cus_url
        cus_mod.cus_name = data['name']
        cus_mod.cus_avatar_url = data['avatar_url']
        if cus_mod['description'] != '':
            cus_mod.cus_style = data['description']
        cus_mod.cus_background_url = None
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")

        self.__dao.insert_customer(cus_mod)

