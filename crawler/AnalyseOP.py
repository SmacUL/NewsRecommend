
class AnalyseOP():

    def __init__(self):
        self.driver = None
        self.item = None

    def setDriver(self, dirver):
        self.driver = dirver

    def setItem(self, item):
        self.item = item

    def get_basic_info(self):
        """ 返回 title, source, abstract, url

        :return:
        """
        if self.item is None:
            print("未设置 item ")
            return None
        return self.item['title'], self.item['source'], self.item['abstract'], self.item['url']

    def get_art_tag(self):
        if self.driver is None:
            print("未设置 dirver")
            return None
        tag_element = self.driver.find_element_by_class_name('chinese-tag')
        a_element = tag_element.find_elements_by_tag_name('a')
        return a_element[1].text

    def get_cus_avater_url(self):
        if self.driver is None:
            print("未设置 dirver")
            return None
        avater_element = self.driver.find_element_by_class_name('user-card-avatar')
        img_element = avater_element.find_element_by_tag_name('img')
        return img_element.get_attribute('src')

    def get_art_content(self):
        if self.driver is None:
            print("未设置 dirver")
            return None
        article_element = self.driver.find_element_by_class_name("article-content")
        return article_element.get_attribute('innerHTML')


if __name__ == '__main__':
    None