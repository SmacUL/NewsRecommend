import requests
import util.Json as Json


class Request:
    """ 用于创建访问请求
    """

    # def __init__(self, url, headers, cookie):
    #     self.__url = url
    #     self.__headers = headers
    #     self.__cookie = cookie

    def __init__(self, path):
        properties = Json.Json.read_json_file(path)
        self.__url = properties['url']
        self.__headers = properties['headers']
        self.__cookie = properties['cookie']

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
