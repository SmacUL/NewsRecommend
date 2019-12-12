import requests
import json
import os
import time

from selenium import webdriver
from selenium.webdriver.chrome.options import Options

from model import ArticleModel as ART, CustomerModel as CUS, CommentModel as COM, ReplyModel as REP


def json_loader(path, encoding='utf-8'):
    js = open(path, encoding=encoding)
    return json.load(js)


def get_chrome_driver():
    """ 获得模拟浏览器 Chrome

    :return:
    """
    chrome_options = Options()
    # chrome_options.add_argument('--headless')
    return webdriver.Chrome(chrome_options=chrome_options)


def prepare_request(property):
    rq = json_loader(property)
    # print('当前访问 ' + rq['url'])

    page = rq['page']
    url = rq['url']
    headers = rq['headers']
    cookie = rq['cookie']

    # 创建对象
    return Request(url, headers, cookie)


class Request:
    """ 用于创建访问请求
    """

    def __init__(self, url, headers, cookie):
        self.__url = url
        self.__headers = headers
        self.__cookie = cookie

    def set_url(self, url):
        self.__url = url

    def set_headers(self, headers):
        self.__headers = headers

    def set_cookie(self, cookie):
        self.__cookie = cookie

    def more(self):
        resp = requests.get(self.__url, headers=self.__headers, cookies=self.__cookie)
        self.__cookie = resp.cookies
        return resp.json()


if __name__ == '__main__':

    request = prepare_request(os.path.join('properties', 'request-properties.json'))

    start = 1
    end = 1
    total = end

    for page in range(1, end + 1):
        print("current page: %d, total %d" % (page, total))

        result = request.more()

        # 核心数据
        datas = result['data']
        for data in datas:
            article = ART.ArticleModel()
            art_author = CUS.CustomerModel()
            # driver = get_chrome_driver()
            try:
                # 文章的作者
                art_author.cus_id = None
                art_author.cus_url = "https://www.toutiao.com" + data['media_url']
                art_author.cus_avatar_url = 'https:' + data['media_avatar_url']
                art_author.cus_name = data['source']

                # 文章的内容, 访问获得
                article.art_id = None
                article.art_url = "https://www.toutiao.com/a{0}/".format(data['item_id'])
                article.art_abstract = data['abstract']
                article.art_title = data['title']
                article.art_class = data['chinese_tag']
                article.art_image_url = data['middle_image']
                article.art_customer_id = None

                timeStamp = data['behot_time']
                timeArray = time.localtime(timeStamp)
                article.art_time = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)

                # 如果 art_url 已经被插入过了, 后面的操作就不用继续了
                # driver.get(article.art_url)

                # 陈呢个浏览器不注意, 搞点评论
                comment_url = 'https://www.toutiao.com/api/pc/article/v4/tab_comments/?aid=66&app_name=toutiao-web&group_id={0}&item_id={1}&offset=0&count={2}'.format(data['group_id'], data['item_id'], 10)
                comment_request = prepare_request(os.path.join('properties', 'test.json'))
                comment_request.set_url(comment_url)
                comments_data = comment_request.more()['data']

                for comment_data in comments_data:
                    com_data = comment_data['comment']
                    comment = COM.CommentModel()
                    com_customer = CUS.CustomerModel()

                    # 评论的作者
                    com_customer.cus_id = None
                    com_customer.cus_avatar_url = com_data['user_profile_image_url']
                    com_customer.cus_name = com_data['user_name']
                    com_customer.cus_url = "https://www.toutiao.com/c/user/" + str(com_data['user_id'])

                    # 评论
                    comment.com_id = None
                    comment.com_content = com_data['text']
                    comment.com_article_id = None
                    comment.com_customer_id = None
                    comment.com_like_num = com_data['digg_count']
                    # 评论时间的处理
                    # create_time
                    timeStamp = com_data['create_time']
                    timeArray = time.localtime(timeStamp)
                    comment.com_time = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)

                    # print(com_customer.cus_url)

                    # 想办法搞点回复
                    reply_url = 'https://www.toutiao.com/api/pc/2/comment/v4/reply_list/?aid=24&app_name=toutiao-web&id={0}&offset=0&count={1}&repost=0'.format(com_data['id_str'], 20)
                    reply_request = prepare_request(os.path.join('properties', 'test.json'))
                    reply_request.set_url(reply_url)
                    replys_data = reply_request.more()['data']['data']

                    for reply_data in replys_data:
                        reply = REP.ReplyModel()
                        rep_customer = CUS.CustomerModel()
                        # print(reply_data)

                        # reply 的 customer
                        rep_cus_data = reply_data['user']
                        rep_customer.cus_id = None
                        rep_customer.cus_url = None
                        rep_customer.cus_name = rep_cus_data['name']
                        rep_customer.cus_avatar_url = rep_cus_data['avatar_url']
                        # description 貌似只有回复中的 user 数据有
                        if rep_cus_data['description'] != '':
                            rep_customer.cus_style = rep_cus_data['description']
                        rep_customer.cus_background_url = None

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

                        # 处理一下 reply 回复 其他 reply 的情况.
                        reply_check = reply_data['reply_to_comment']
                        reply_to_comment_customer_url = "https://www.toutiao.com/c/user/" + str(reply_check['user_id'])
                        reply_to_comment_customer_text = reply_check['text']

                        # 这一段逻辑估计要辛苦数据库了.
                        # 如果 reply_to_comment_customer_url 和 reply_to_comment_customer_text 都能找到对应的数据,
                        # 那么 reply.rep_type 将设置为 1, reply.rep_reply_id 将设置为相应的 reply 的 id .

                        # print(reply_data)

                # 文章的另一部分内容

                # article.art_content = driver.find_element_by_class_name("article-content").get_attribute('innerHTML')
                # tags_ele = driver.find_elements_by_class_name('label-link')
                # tags = []
                # for tag in tags_ele:
                #     tags.append(tag.get_attribute('innerHTML'))
                # article.art_tags = '&&'.join(tags)
                # article.art_comment_num = None


            except Exception as err:
                print(err)
            finally:
                # driver.close()
                pass
