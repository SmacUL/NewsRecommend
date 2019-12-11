import requests
import json
import os

path = os.path.join('properties', 'request-properties.json')

def json_loader(path, encoding='utf-8'):
    js = open(path, encoding=encoding)
    return json.load(js)


rq = json_loader(path)
print('当前访问 ' + rq['url'])
# rop.RequestOP(rq['page'], rq['url'], rq['headers'], rq['cookie']).info()

page = rq['page']
url = rq['url']
headers = rq['headers']
cookie = rq['cookie']

news = []
for pa in range(1, page+1):
    print("current page: %d, total %d" % (pa, page))
    # html_data = request(pa)

    # time = None
    # if pa == 1:
    #     time = 0
    resp = requests.get(url, headers=headers, cookies=cookie)
    cookie = resp.cookies
    result = resp.json()
    # print(result)

    # 核心数据
    datas = result['data']
    for data in datas:
        # print(data)
        try:
            art_url = "https://www.toutiao.com/a{0}/".format(data['item_id'])
            art_abstract = data['abstract']
            art_title = data['title']
            art_class = data['chinese_tag']
            art_image_url = data['middle_image']

            cus_url = "https://www.toutiao.com" + data['media_url']
            cus_avatar_url = 'https:' + data['media_avatar_url']
            cus_name = data['source']

            # print(cus_url)
            # print(art_url)
            # print(art_abstract)
            # print(art_title)
            # print(art_class)
            # print(art_image_url)
            # print(cus_avatar_url)
            # print(cus_name)

        except Exception as err:
            print(err)





    # time = result['next']['max_behot_time']
    # print(html_data)

    # news.append(parse_html(html_data))
