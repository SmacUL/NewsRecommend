import os
import time

import model.ArticleModel as ArtMod
import model.CustomerModel as CusMod
import model.CommentModel as ComMod
import model.ReplyModel as RepMod

import util.MySql as MySql
import util.Request as Request
import util.Driver as Driver

import dao.ArticleDao as ArtDao
import dao.CustomerDao as CusDao
import dao.CommentDao as ComDao
import dao.ReplyDao as RepDao

import process.ArticleProcess as ArtPro
import process.CustomerProcess as CusPro
import process.CommentProcess as ComPro
import process.ReplyProcess as RepPro


class Major:

    # __art_dao: ArticleDao
    # __start: int

    def __init__(self):
        self.__base: MySql.MySql = None

        self.__art_dao: ArtDao.ArticleDao = None
        self.__cus_dao: CusDao.CustomerDao = None
        self.__com_dao: ComDao.CommentDao = None
        self.__rep_dao: RepDao.ReplyDao = None

        self.__art_pro: ArtPro.ArticleProcess = None
        self.__cus_pro: CusPro.CustomerProcess = None
        self.__com_pro: ComPro.CommentProcess = None
        self.__rep_pro: RepPro.ReplyProcess = None

        self.__start: int = None
        self.__end: int = None
        self.__total: int = None

    def init_database(self):
        """ 初始化数据库

        :return:
        """
        self.__base = MySql.MySql("NewsRecommend", "root", "123456")

    def init_dao(self):
        self.__art_dao = ArtDao.ArticleDao(self.__base)
        self.__cus_dao = CusDao.CustomerDao(self.__base)
        self.__com_dao = ComDao.CommentDao(self.__base)
        self.__rep_dao = RepDao.ReplyDao(self.__base)

    def init_process(self):
        self.__art_pro = ArtPro.ArticleProcess(self.__art_dao)
        self.__cus_pro = CusPro.CustomerProcess(self.__cus_dao)
        self.__com_pro = ComPro.CommentProcess(self.__com_dao)
        self.__rep_pro = RepPro.ReplyProcess(self.__rep_dao)

    def before_process(self, start: int, end: int, total: int):
        """ [start, end]

        :param start:
        :param end:
        :param total:
        :return:
        """
        self.__start = start
        self.__end = end
        self.__total = total

    def major_process(self):
        art_request = Request.Request(os.path.join('properties', 'request-properties.json'))
        for page in range(1, self.__end + 1):
            print("current page: %d, total %d" % (page, self.__total))
            news_data = art_request.more()['data']
            for data in news_data:
                # 先设置 driver
                # driver = Driver.Driver.get_chrome_driver()

                # 文章作者
                art_customer_url = self.__cus_pro.get_article_customer_url(data)
                if not self.__cus_pro.is_customer_exist(art_customer_url):
                    self.__cus_pro.insert_art_customer(data, art_customer_url)
                art_customer_id = self.__cus_pro.get_customer_id_by_url(art_customer_url)
                # 文章
                article_url = self.__art_pro.get_article_url(data)
                if not self.__art_pro.is_article_exist(article_url):
                    self.__art_pro.insert_tiny_article(data, article_url, art_customer_id)
                    # ToDo 底下的两步放到后面去, 减少等待时间.
                    # self.__art_pro.insert_full_article(article_url, driver)
                    # driver.close()
                else:
                    continue
                article_id = self.__art_pro.get_article_id_by_url(article_url)

                # 评论
                comment_url = 'https://www.toutiao.com/api/pc/article/v4/tab_comments/?' \
                              'aid=66&app_name=toutiao-web&group_id={0}&item_id={1}&offset=0&count={2}'\
                              .format(data['group_id'], data['item_id'], 10)
                comment_request = Request.Request(os.path.join('properties', 'test.json'))
                comment_request.set_url(comment_url)
                comments_data = comment_request.more()['data']

                for comment_data in comments_data:
                    comment = comment_data['comment']

                    # 评论作者
                    com_customer_url = self.__cus_pro.get_comment_customer_url(comment)
                    if not self.__cus_pro.is_customer_exist(com_customer_url):
                        self.__cus_pro.insert_comment_customer(comment, com_customer_url)
                    com_customer_id = self.__cus_pro.get_customer_id_by_url(com_customer_url)

                    # 评论内容 [从成本考虑, 不对评论内容去重, 如果文章存在, 就认为评论和回复都存在.]
                    self.__com_pro.insert_comment(comment, article_id, com_customer_id)

                    # 回复
                    reply_url = 'https://www.toutiao.com/api/pc/2/comment/v4/reply_list/?' \
                                'aid=24&app_name=toutiao-web&id={0}&offset=0&count={1}&repost=0'\
                                .format(comment['id_str'], 20)
                    reply_request = Request.Request(os.path.join('properties', 'test.json'))
                    reply_request.set_url(reply_url)
                    replys_data = reply_request.more()['data']['data']

                    for reply in replys_data:

                        # 回复作者
                        rep_customer_url = self.__cus_pro.get_reply_customer_url(reply['user'])
                        if not self.__cus_pro.is_customer_exist(rep_customer_url):
                            self.__cus_pro.insert_reply_customer(reply['user'], rep_customer_url)
                        rep_customer_id = self.__cus_pro.get_customer_id_by_url(rep_customer_url)

                        # 回复内容



if __name__ == '__main__':

    major = Major()
    major.init_database()
    major.init_dao()
    major.init_process()
    major.before_process(1, 1, 1)
    major.major_process()

    # request = prepare_request(os.path.join('properties', 'request-properties.json'))

    # 初始化 sql
    # base = MySql.MySql("NewsRecommend", "root", "123456")



    # 创建 Dao 用于数据库操作.
    # art_dao = ArtDao.ArticleDao(base)
    # cus_dao = CusDao.CustomerDao(base)

    # 创建 Process
    # art_pro = ArtPro.ArticleProcess(art_dao)
    # cus_pro = CusPro.CustomerProcess(cus_dao)

    # start = 1
    # end = 1
    # total = end

    for page in range(1, end + 1):
        print("current page: %d, total %d" % (page, total))

        result = request.more()

        # 核心数据
        datas = result['data']
        for data in datas:
            article = ArtMod.ArticleModel()
            art_customer = CusMod.CustomerModel()
            # driver = get_chrome_driver()

            # art_customer = cus_pro.check_customer(data, art_customer)
            # if art_customer is None:
                # art_customer = cus_pro.insert_customer(data, art_customer)
            # if art_customer is None:
            #     continue




            # try:
            #     # 文章的内容, 访问获得
            #     article.art_id = None
            #     article.art_url = "https://www.toutiao.com/a{0}/".format(data['item_id'])
            #     article.art_abstract = data['abstract']
            #     article.art_title = data['title']
            #     article.art_class = data['chinese_tag']
            #     article.art_image_url = data['middle_image']
            #     article.art_customer_id = None
            #     # 时间处理
            #     timeStamp = data['behot_time']
            #     timeArray = time.localtime(timeStamp)
            #     article.art_time = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)
            #
            #     # 如果 art_url 已经被插入过了, 后面的操作就不用继续了
            #     # driver.get(article.art_url)
            # except:
            #     print("hhh")


            """ 评论数据开始
            
            """
            # 陈呢个浏览器不注意, 搞点评论
            # comment_url = 'https://www.toutiao.com/api/pc/article/v4/tab_comments/?aid=66&app_name=toutiao-web&group_id={0}&item_id={1}&offset=0&count={2}'.format(data['group_id'], data['item_id'], 10)
            # comment_request = prepare_request(os.path.join('properties', 'test.json'))
            # comment_request.set_url(comment_url)
            # comments_data = comment_request.more()['data']

            for comment_data in comments_data:
                com_data = comment_data['comment']
                comment = ComMod.CommentModel()
                com_customer = CusMod.CustomerModel()

                # try:
                #     # 评论的作者
                #     com_customer.cus_id = None
                #     com_customer.cus_avatar_url = com_data['user_profile_image_url']
                #     com_customer.cus_name = com_data['user_name']
                #     com_customer.cus_url = "https://www.toutiao.com/c/user/" + str(com_data['user_id'])
                #     com_customer.cus_style = None
                #     com_customer.cus_pass = set_cus_pass("123456")
                #     com_customer.cus_background_url = None
                # except:
                #     print("hhhh")


                # try:
                #     # 评论
                #     comment.com_id = None
                #     comment.com_content = com_data['text']
                #     comment.com_article_id = None
                #     comment.com_customer_id = None
                #     comment.com_like_num = com_data['digg_count']
                #     # 评论时间的处理
                #     # create_time
                #     timeStamp = com_data['create_time']
                #     timeArray = time.localtime(timeStamp)
                #     comment.com_time = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)
                # except:
                #     print("yyyy")

                    # print(com_customer.cus_url)

                """ 获取回复数据
                """
                # 想办法搞点回复
                # reply_url = 'https://www.toutiao.com/api/pc/2/comment/v4/reply_list/?aid=24&app_name=toutiao-web&id={0}&offset=0&count={1}&repost=0'.format(com_data['id_str'], 20)
                # reply_request = prepare_request(os.path.join('properties', 'test.json'))
                # reply_request.set_url(reply_url)
                # replys_data = reply_request.more()['data']['data']

                for reply_data in replys_data:
                    reply = RepMod.ReplyModel()
                    rep_customer = CusMod.CustomerModel()
                    # print(reply_data)

                    try:
                        # reply 的 customer
                        # rep_cus_data = reply_data['user']
                        # rep_customer.cus_id = None
                        # rep_customer.cus_url = None
                        # rep_customer.cus_name = rep_cus_data['name']
                        # rep_customer.cus_avatar_url = rep_cus_data['avatar_url']
                        # # description 貌似只有回复中的 user 数据有
                        # if rep_cus_data['description'] != '':
                        #     rep_customer.cus_style = rep_cus_data['description']
                        # rep_customer.cus_background_url = None
                        # rep_customer.cus_pass = set_cus_pass("123456")
                    except:
                        print("jjjj")

                    try:
                        # reply
                        reply.rep_id = None
                        reply.rep_like_num = reply_data['digg_count']
                        reply.rep_type = 0
                        reply.rep_article_id = None
                        reply.rep_customer_id = None
                        reply.rep_reply_id = None
                        reply.rep_comment_id = None
                        reply.rep_content = reply_data['text']
                        # 回复时间的处理
                        # create_time
                        timeStamp = reply_data['create_time']
                        timeArray = time.localtime(timeStamp)
                        reply.rep_time = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)
                    except:
                        print("iiid")

                    try:
                        """ 回复回复其他回复的情况
                        """
                        # 处理一下 reply 回复 其他 reply 的情况.
                        reply_check = reply_data['reply_to_comment']
                        reply_to_comment_customer_url = "https://www.toutiao.com/c/user/" + str(reply_check['user_id'])
                        reply_to_comment_customer_text = reply_check['text']

                        # 这一段逻辑估计要辛苦数据库了.
                        # 如果 reply_to_comment_customer_url 和 reply_to_comment_customer_text 都能找到对应的数据,
                        # 那么 reply.rep_type 将设置为 1, reply.rep_reply_id 将设置为相应的 reply 的 id .

                        # print(reply_data)
                    except:
                        print("uudddd")

                # 文章的另一部分内容



            # try:
            #     """ 文章的另一部分
            #     """
            #     article.art_content = driver.find_element_by_class_name("article-content").get_attribute('innerHTML')
            #     tags_ele = driver.find_elements_by_class_name('label-link')
            #     tags = []
            #     for tag in tags_ele:
            #         tags.append(tag.get_attribute('innerHTML'))
            #     article.art_tags = '&&'.join(tags)
            # except:
            #     print("uiudu")
            # finally:
            #     driver.close()


