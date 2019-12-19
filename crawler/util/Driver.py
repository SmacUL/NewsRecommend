import selenium.webdriver as webdriver
import selenium.webdriver.chrome.options as options


class Driver:

    def __init__(self):
        pass

    @staticmethod
    def get_chrome_driver():
        """ 获得模拟浏览器 Chrome

        :return:
        """
        chrome_options = options.Options()
        # chrome_options.add_argument('--headless')
        return webdriver.Chrome(chrome_options=chrome_options)