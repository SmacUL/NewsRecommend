from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.action_chains import ActionChains
import hashlib
import json
import os

import DatabaseOP as dop
import RequestOP as rop
import AnalyseOP as aop
import FilterOP as fop

# def get_chrome_driver():
#     """ 获得模拟浏览器 Chrome
#
#     :return:
#     """
#
#     # chrome_options.add_argument('--headless')
#     return webdriver.Chrome(chrome_options=chrome_options)


def xp_section(tag, type, name, index):
    final_str = str("%s" % tag)
    if type is not None and name is not None:
        final_str += str("[@%s='%s']" % (tag, name))
    if index is not None:
        final_str += str('[%d]' % index)
    return final_str

def xp_assemble(sections, log=False):
    result = ''
    if sections[0][0:2] == '//':
        result = str('//'.join(sections))
    else:
        result = str('//' + '//'.join(sections))
    if log:
        print("当前定位路径: %s" % result)
    return result

chrome_options = Options()
# with webdriver.Chrome(chrome_options=chrome_options) as driver:
driver = webdriver.Chrome(chrome_options=chrome_options)

    # 万恶之源
    # driver = get_chrome_driver()
driver.implicitly_wait(10)


# 这个部分先打开所有的评论
driver.get('https://www.toutiao.com/a6768441317455299086/')
ele = driver.find_elements_by_class_name('c-load-more')[0]

# print(ele.text)
import time
time.sleep(3)
# ActionChains(driver).move_to_element(ele).perform()
ActionChains(driver).click(ele).perform()

import re



# item_eles = driver.find_elements_by_class_name('c-item')

# xp_assemble((xp_section('div', 'id', 'comment', None), 'li'))

item_eles = driver.find_elements_by_xpath("//div[@id='comment']//li")
# item_eles = driver.find_elements_by_xpath(xp_assemble((xp_section('div', 'id', 'comment', None), 'li'), True))

# print(item_eles)

for index, item_ele in enumerate(item_eles):
    # if index == item_eles.__len__() - 2:
    #     break
    # 这玩意居然是从 1 开始算起的, 淦
    # hh = str()     class="c-reply-count"
    # print("hhhhh")
    # comment_path = xp_assemble((xp_section('div', 'id', 'comment', None), xp_section('li', None, None, index+1), xp_section('p', None, None, None)), True)
    comment = driver.find_element_by_xpath("//div[@id='comment']//li[%d]//p" % (index + 1))
    # comment = driver.find_element_by_xpath(comment_path)
    print(comment.text)
    try:
        reply_button = driver.find_element_by_xpath("//div[@id='comment']//li[%d]//span[@class='c-reply-count']" % (index + 1))
        ActionChains(driver).click(reply_button).perform()

        c_reply_comments = driver.find_elements_by_xpath("//div[@id='comment']//li[%d]//div[@class='c-reply-comment']" % (index + 1))
        for j, reply in enumerate(c_reply_comments):
            re = driver.find_element_by_xpath("//div[@id='comment']//li[%d]//div[@class='c-reply-comment'][%d]//p" % (index + 1, j + 1))
            print(re.text.split('//')[0])
    except Exception as err:
        print(err)
        continue
# c-reply-comment
driver.close()


