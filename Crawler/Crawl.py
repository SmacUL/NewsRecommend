import requests
import execjs


class Crawl():
    def __init__(self, page):
        self.page = page
        self.time = 0
        self.headers = {
            "Host": "www.toutiao.com",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) " 
                          "Chrome/75.0.3770.100 Safari/537.36"
        }
        self.cookie = {}
        # 初始化JS
        with open("toutiao.js", "r") as f:
            JsCode = f.read()
        self.js = execjs.compile(JsCode)

    def request(self, page):
        if page == 1:
            self.time = 0
        as_, cp_ = self.js.call("getHoney")  # r返回结果   as
        url2 = "https://www.toutiao.com/api/pc/feed/?min_behot_time=0&category=__all__&utm_source=toutiao&widen=1&tadrequire=true&as={0}&cp={1}".format(
            as_, cp_)
        resp = requests.get(url2, headers=self.headers, cookies=self.cookie)
        self.cookie = resp.cookies
        result = resp.json()
        self.time = result['next']['max_behot_time']
        return result

    def parse_html(self, data):
        items = data['data']

        for item in items:
            yield {
                'title': item['title'],
                'source': item['source'],
                'abstract': item['abstract'],
                'url': "https://www.toutiao.com/a{0}/".format(item['item_id'])
            }

    def info(self):
        news = []
        for page in range(1, self.page + 1):
            html_data = self.request(page)
            news.append(self.parse_html(html_data))
        return news


if __name__ == "__main__":
    None