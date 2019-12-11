class ReplyModel:

    def __init__(self):
        self.rep_content = None
        self.rep_like_num = None
        self.rep_customer_id = None
        self.rep_article_id = None
        self.rep_legal = 1

    def set(self, rep_content, rep_like_num, rep_customer_id, rep_article_id):
        self.rep_content = rep_content
        self.rep_like_num = rep_like_num
        self.rep_customer_id = rep_customer_id
        self.rep_article_id = rep_article_id
        self.rep_legal = 1

if __name__ == '__main__':
    pass
    # rm = ReplyModel(1, 2, 3, 4)
    # rm.rep_like_num = 12
    # print(rm.rep_like_num)
    # ReplyModel()
