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
        chrome_prefs = {}
        chrome_options.experimental_options["prefs"] = chrome_prefs
        chrome_prefs["profile.default_content_settings"] = {"images": 2}
        chrome_prefs["profile.managed_default_content_settings"] = {"images": 2}

        # chrome_options.add_argument('--headless')
        return webdriver.Chrome(chrome_options=chrome_options)