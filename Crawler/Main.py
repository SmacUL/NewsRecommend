from selenium import webdriver
import hashlib
import json
import DatabaseOP as dop
import Crawl as cra


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


def get_chrome_driver():
    """ 获得模拟浏览器 Chrome

    :return:
    """
    return webdriver.Chrome()


def get_source_tiny_articles(page_number):
    """ 获得指定页数的文章缩略信息

    :param page_number: 页数, 一页 10 条
    :return:
    """
    return cra.Crawl(page_number).info()


def get_art_title(json_data):
    return json_data['title']


def get_cus_name(json_data):
    return json_data['source']


def get_art_abstract(json_data):
    return json_data['abstract']


def get_art_url(json_data):
    return json_data['url']


def get_art_tag(driver):
    tag_element = driver.find_element_by_class_name('chinese-tag')
    a_element = tag_element.find_elements_by_tag_name('a')
    return a_element[1].text


def get_cus_avater_url(driver):
    avater_element = driver.find_element_by_class_name('user-card-avatar')
    img_element = avater_element.find_element_by_tag_name('img')
    return img_element.get_attribute('src')


def get_art_content(driver):
    article_element = driver.find_element_by_class_name("article-content")
    return article_element.get_attribute('innerHTML')


def set_cus_pass(password):
    """ 为用户密码进行 MD-5 加密

    :param password: 密码明文
    :return:
    """
    hl = hashlib.md5()
    hl.update(password.encode('utf-8'))
    return hl.hexdigest()


if __name__ == "__main__":
    data_base = connect_database("database-properties.json")
    tiny_news = get_source_tiny_articles(100)

    for news_item in tiny_news:
        for item in news_item:
            print(item)
            driver = get_chrome_driver()
            try:
                # 文章标题
                art_title = get_art_title(item)
                # 用户名
                cus_name = get_cus_name(item)
                # 文章简介
                art_abstract = get_art_abstract(item)
                # 文章 url
                art_url = get_art_url(item)
                # 访问文章具体内容
                driver.get(art_url)
                # 标签
                art_tag = get_art_tag(driver)
                # 用户头像
                cus_avater_url = get_cus_avater_url(driver)
                # 文章主体内容
                art_content = get_art_content(driver)
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
                print("========================================")
                driver.close()
