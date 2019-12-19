class ArticleModel:

    def __init__(self):
        self.art_id = None
        self.art_title = None
        self.art_content = None
        self.art_url = None
        self.art_class = None
        self.art_image_url = None
        self.art_comment_num = None
        self.art_customer_id = None
        self.art_tags = None
        self.art_time = None

        self.art_legal = 1

    def set(self, art_id, art_title, art_content, art_url, art_class, art_image_url,
                 art_comment_num, art_customer_id, art_tags, art_time):
        self.art_id = art_id
        self.art_title = art_title
        self.art_content = art_content
        self.art_url = art_url
        self.art_class = art_class
        self.art_image_url = art_image_url
        self.art_comment_num = art_comment_num
        self.art_customer_id = art_customer_id
        self.art_tags = art_tags
        self.art_time = art_time

        self.art_legal = 1