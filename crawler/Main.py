import os

import util.MySql as MySql
import util.Request as Request
import util.Driver as Driver
import util.Json as Json

import dao.ArticleDao as ArtDao
import dao.CustomerDao as CusDao
import dao.CommentDao as ComDao
import dao.ReplyDao as RepDao

import process.ArticleProcess as ArtPro
import process.CustomerProcess as CusPro
import process.CommentProcess as ComPro
import process.ReplyProcess as RepPro


class Major:

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

    def init_database(self, path):
        """ 初始化数据库

        :return:
        """
        db_map = Json.Json.read_json_file(path)
        self.__base = MySql.MySql(db_map['db_name'], db_map['user'], db_map['password'])

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

    def set_process_scope(self, path):
        scope_map = Json.Json.read_json_file(path)
        self.__start = scope_map['start']
        self.__end = scope_map['end']
        self.__total = scope_map['total']

    def major_process(self):
        art_request = Request.Request(os.path.join('properties', 'request.json'))
        counter = 0
        all_counter = 0
        for page in range(1, self.__end+1):
            print("current page: %d, total %d" % (page, self.__total))
            news_data = art_request.more()['data']
            for data in news_data:
                print(data)
                # 文章作者
                art_customer_url = self.__cus_pro.get_article_customer_url(data)
                if not self.__cus_pro.is_customer_exist(art_customer_url):
                    self.__cus_pro.insert_art_customer(data, art_customer_url)
                art_customer_id = self.__cus_pro.get_customer_id_by_url(art_customer_url)
                if art_customer_id is None:
                    continue
                print("文章作者处理完成\n")

                # 文章内容
                driver = Driver.Driver.get_chrome_driver()
                try:
                    article_url = self.__art_pro.get_article_url(data)
                    if not self.__art_pro.is_article_exist(article_url):
                        article_mod = self.__art_pro.get_tiny_article(
                            data, os.path.join('properties', 'filter.json'), article_url, art_customer_id,)
                        driver.implicitly_wait(10)
                        self.__art_pro.get_full_article(article_mod, article_url, driver)
                        self.__art_pro.insert_article(article_mod)
                    else:
                        print("====================\n")
                        continue
                except Exception as err:
                    print(err)
                    continue
                finally:
                    driver.close()
                article_id = self.__art_pro.get_article_id_by_url(article_url)
                if article_id is None:
                    continue
                else:
                    counter += 1
                print("文章内容处理完成, 开始处理评论与回复数据")

                # 评论
                comment_url = 'https://www.toutiao.com/api/pc/article/v4/tab_comments/?' \
                              'aid=66&app_name=toutiao-web&group_id={0}&item_id={1}&offset=0&count={2}'\
                              .format(data['group_id'], data['item_id'], 10)
                comment_request = Request.Request(os.path.join('properties', 'reply-comment-request.json'))
                comment_request.set_url(comment_url)
                comments_data = comment_request.more()['data']

                for comment_data in comments_data:
                    comment = comment_data['comment']

                    # 评论作者
                    com_customer_url = self.__cus_pro.get_comment_customer_url(comment)
                    if not self.__cus_pro.is_customer_exist(com_customer_url):
                        self.__cus_pro.insert_comment_customer(comment, com_customer_url)
                    com_customer_id = self.__cus_pro.get_customer_id_by_url(com_customer_url)
                    if com_customer_id is None:
                        continue

                    # 评论内容
                    comment_identify_id = self.__com_pro.get_comment_identiy_id(comment)
                    if not self.__com_pro.is_comment_exist(comment_identify_id):
                        self.__com_pro.insert_comment(comment, comment_identify_id, article_id, com_customer_id)
                    comment_id = self.__com_pro.get_comment_id_by_identify_id(comment_identify_id)
                    if comment_id is None:
                        continue
                    else:
                        self.__art_pro.update_article_comment_num(article_id)

                    # 回复
                    reply_url = 'https://www.toutiao.com/api/pc/2/comment/v4/reply_list/?' \
                                'aid=24&app_name=toutiao-web&id={0}&offset=0&count={1}&repost=0'\
                                .format(comment['id_str'], 20)
                    reply_request = Request.Request(os.path.join('properties', 'reply-comment-request.json'))
                    reply_request.set_url(reply_url)
                    replys_data = reply_request.more()['data']['data']

                    for reply in replys_data:

                        # 回复作者
                        rep_customer_url = self.__cus_pro.get_reply_customer_url(reply['user'])
                        if not self.__cus_pro.is_customer_exist(rep_customer_url):
                            self.__cus_pro.insert_reply_customer(reply['user'], rep_customer_url)
                        rep_customer_id = self.__cus_pro.get_customer_id_by_url(rep_customer_url)
                        if rep_customer_id is None:
                            continue

                        # 回复内容
                        reply_identify_id = self.__rep_pro.get_reply_identiy_id(reply)
                        try:
                            rep_reply_identify_id = self.__rep_pro.get_reply_reply_identify_id(reply['reply_to_comment'])
                            rep_reply_id = self.__rep_pro.get_reply_id_by_rep_identify_id(rep_reply_identify_id)
                        except:
                            rep_reply_id = None
                        if not self.__rep_pro.is_reply_exist(reply_identify_id):
                            self.__rep_pro.insert_reply(reply, reply_identify_id, article_id,
                                                        rep_customer_id, comment_id, rep_reply_id)
                print("====================\n")

            all_counter += len(news_data)
            print("成功获取的陌生文章比例: %f \n" % (counter / all_counter))
            if (counter / all_counter) < 0.2:
                print("成功获取的陌生文章比例数量低于 20% , 程序终止. ")
                break


if __name__ == '__main__':

    major = Major()
    major.init_database(os.path.join('properties', 'database.json'))
    major.init_dao()
    major.init_process()
    major.set_process_scope(os.path.join('properties', 'scope.json'))
    major.major_process()
