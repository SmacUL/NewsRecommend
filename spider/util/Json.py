import json


class Json:

    def __init__(self):
        pass

    @staticmethod
    def read_json_file(path, encoding='utf-8'):
        js = open(path, encoding=encoding)
        return json.load(js)