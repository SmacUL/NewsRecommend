import requests

class Request:
    """ 用于创建访问请求
    """

    def __init__(self, url, headers=None, cookies=None):
        self.__url = url
        self.__headers = headers
        self.__cookie = cookies

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
