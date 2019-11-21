from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import hashlib
import json
import os

import DatabaseOP as dop
import RequestOP as rop
import AnalyseOP as aop


def connect_database(path, encoding='utf-8'):
    """ 数据库配置初始化

    :param path: json 格式的数据库配置文件地址
    :param encoding: 数据库配置文件编码
    :return:
    """
    dp = open(path, encoding=encoding)
    dp = json.load(dp)
    data_base = dop.MysqlOP(dp["db_name"], dp['user'], dp['password'])
    data_base.create_connection()
    return data_base


def get_source_tiny_articles(path, encoding='utf-8'):
    """ 获取文章缩略图的信息

    :param path: json 格式的数据库配置文件地址
    :param encoding:
    :return:
    """
    rq = open(path, encoding=encoding)
    rq = json.load(rq)
    return rop.RequestOP(rq['page'], rq['url'], rq['headers'], rq['cookie']).info()


def get_chrome_driver():
    """ 获得模拟浏览器 Chrome

    :return:
    """
    chrome_options = Options()
    chrome_options.add_argument('--headless')
    return webdriver.Chrome(chrome_options=chrome_options)


def set_cus_pass(password):
    """ 为用户密码进行 MD-5 加密

    :param password: 密码明文
    :return:
    """
    hl = hashlib.md5()
    hl.update(password.encode('utf-8'))
    return hl.hexdigest()


if __name__ == "__main__":
    data_base = connect_database(os.path.join('properties', 'database-properties.json'))
    tiny_news = get_source_tiny_articles(os.path.join('properties', 'request-properties.json'))
    print(tiny_news.__len__())
    analyser = aop.AnalyseOP()
    for i, news_item in enumerate(tiny_news):
        for j, item in enumerate(news_item):
            print(item)
            driver = get_chrome_driver()
            try:
                analyser.setItem(item)
                # 获得 art_title, cus_name, art_abstract, art_url
                art_title, cus_name, art_abstract, art_url = analyser.get_basic_info()
                # 访问文章具体内容
                driver.get(art_url)
                analyser.setDriver(driver)
                # 标签
                art_tag = analyser.get_art_tag()
                # 用户头像
                cus_avater_url = analyser.get_cus_avater_url()
                # 文章主体内容
                art_content = analyser.get_art_content()
                # 插入用户
                cus_pass = set_cus_pass("123456")
                data_base.insert_customer(cus_name, cus_pass, cus_avater_url)
                # 插入文章
                data_base.insert_article(art_url, cus_name, art_title, art_abstract, art_content, art_tag)
            except:
                print("曾经发生过错误")
                continue
            finally:
                # 关闭浏览器
                print("========= page %d, item %d, total pages %d complete ==========="
                      % (i + 1, j + 1, tiny_news.__len__()))
                driver.close()
