import requests


class RequestOP():
    def __init__(self, page, url, headers, cookie):
        self.page = page
        self.time = 0
        self.url = url
        self.headers = headers
        self.cookie = cookie

    def request(self, page):
        if page == 1:
            self.time = 0
        print(self.url)
        resp = requests.get(self.url, headers=self.headers, cookies=self.cookie)
        self.cookie = resp.cookies
        result = resp.json()
        self.time = result['next']['max_behot_time']
        return result

    def parse_html(self, data):
        items = data['data']

        for item in items:
            try:
                yield {
                    'title': item['title'],
                    'source': item['source'],
                    'abstract': item['abstract'],
                    'url': "https://www.toutiao.com/a{0}/".format(item['item_id'])
                }
            except:
                print("tiny news resource error.")

    def info(self):
        news = []
        for page in range(1, self.page + 1):
            print("current page: %d, total %d" % (page, self.page))
            html_data = self.request(page)
            news.append(self.parse_html(html_data))
        return news


if __name__ == "__main__":
    None