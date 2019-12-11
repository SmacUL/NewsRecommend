class CommentModel:

    def __init__(self):
        self.com_id = None
        self.com_content = None
        self.com_like_num = None
        self.com_customer_id = None
        self.com_article_id = None
        self.com_legal = 1

    def set(self, com_id, com_content, com_like_num, com_customer_id, com_article_id):
        self.com_id = com_id
        self.com_content = com_content
        self.com_like_num = com_like_num
        self.com_customer_id = com_customer_id
        self.com_article_id = com_article_id
        self.com_legal = 1

