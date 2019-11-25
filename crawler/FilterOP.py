
class FilterOP():

    def __init__(self):
        self.tag = None
        self.tag_maps = None

    def set_tag(self, tag):
        self.tag = tag

    def set_tag_maps(self, tag_maps):
        self.tag_maps = tag_maps

    def major_filter(self, tag, tag_maps):
        """

            tag_maps 的示例: {'综合': ['其他', '其它'], '科技': ['科技', '科学']}

        :param tag:
        :param tag_maps:
        :return:
        """
        self.set_tag(tag)
        self.set_tag_maps(tag_maps)
        for map_key in tag_maps:
            print(tag_maps[map_key])
            for map_val in tag_maps[map_key]:
                if tag == map_val:
                    return map_key
        return self.tag


if __name__ == '__main__':
    fop = FilterOP()
    print(fop.major_filter('测试', {'综合': ['其他', '其它'], '科技': ['科技', '科学']}))
    print(fop.major_filter('科学', {'综合': ['其他', '其它'], '科技': ['科学']}))

