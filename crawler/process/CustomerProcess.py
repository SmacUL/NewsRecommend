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
        try:
            return "https://www.toutiao.com" + data['media_url']
        except:
            print("新闻作者 cus_url 获取失败")
            return None

    def get_comment_customer_url(self, data):
        try:
            return "https://www.toutiao.com/c/user/" + str(data['user_id'])
        except:
            print("评论作者 cus_url 获取失败")
            return None

    def get_reply_customer_url(self, data):
        try:
            return "https://www.toutiao.com/c/user/" + str(data['user_id'])
        except:
            print("回复作者 cus_url 获取失败")
            return None

    def is_customer_exist(self, url):
        """

        :param url:
        :return:
        """
        try:
            result = self.__dao.count_customer_by_url(url)
            if result == 0:
                return False
            else:
                return True
        except:
            print("用户 cus_url=%s 数据库查询失败" % url)
            return None

    def get_article_customer_content(self, data, cus_url):
        cus_mod = CusMod.CustomerModel()

        try:
            cus_mod.cus_avatar_url = 'https:' + data['media_avatar_url']
            cus_mod.cus_name = data['source']
        except:
            print("新闻用户 cus_url=%s cus_avatar_url 或 cus_name 获取失败" % cus_url)
            return None

        cus_mod.cus_url = cus_url
        cus_mod.cus_background_url = None
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
        cus_mod.cus_style = '这个人很懒, 什么都没写'
        return cus_mod

    def insert_customer(self, cus_mod: CusMod):
        if self.__dao.insert_customer(cus_mod):
            print("用户 cus_url=%s 数据库插入成功" % cus_mod.cus_url)
            return True
        else:
            print("用户 cus_url=%s 数据库插入失败" % cus_mod.cus_url)
            return False

    def get_customer_id_by_url(self, url):
        try:
            return self.__dao.search_customer_id_by_url(url)
        except:
            print("用户 cus_url=%s cus_id 数据库获取失败" % url)
            return None

    def get_comment_customer_content(self, data, cus_url):
        cus_mod = CusMod.CustomerModel()

        try:
            cus_mod.cus_avatar_url = data['user_profile_image_url']
            cus_mod.cus_name = data['user_name']
        except:
            print("评论用户 cus_url=%s cus_avatar_url 或 cus_name 获取失败" % cus_url)
            return None

        cus_mod.cus_url = cus_url
        cus_mod.cus_style = '这个人很懒, 什么都没写'
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
        cus_mod.cus_background_url = None
        return cus_mod

    def get_reply_customer_content(self, data, cus_url):
        cus_mod = CusMod.CustomerModel()

        try:
            cus_mod.cus_name = data['name']
            cus_mod.cus_avatar_url = data['avatar_url']
            if data['description'] != '':
                cus_mod.cus_style = data['description']
        except:
            print("回复用户 cus_url=%s cus_style 或 cus_avatar_url 或 cus_name 获取失败" % cus_url)
            return None

        cus_mod.cus_url = cus_url
        cus_mod.cus_background_url = None
        cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
        return cus_mod

    def get_reply_customer_data(self, data):
        try:
            return data['user']
        except:
            print("回复用户 数据获取失败")
            return None
