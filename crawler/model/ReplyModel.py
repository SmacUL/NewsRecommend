class ReplyModel:

    def __init__(self):
        self.rep_id = None
        self.rep_content = None
        self.rep_like_num = None
        self.rep_type = None
        self.rep_time = None
        self.rep_customer_id = None
        self.rep_article_id = None
        self.rep_comment_id = None
        self.rep_reply_id = None
        self.rep_identify_id = None
        self.rep_legal = 1

    def set(self, rep_id, rep_content, rep_like_num, rep_type, rep_time,
            rep_customer_id, rep_article_id, rep_comment_id, rep_reply_id, rep_identify_id):
        self.rep_id = rep_id
        self.rep_content = rep_content
        self.rep_like_num = rep_like_num
        self.rep_type = rep_type
        self.rep_time = rep_time
        self.rep_customer_id = rep_customer_id
        self.rep_article_id = rep_article_id
        self.rep_comment_id = rep_comment_id
        self.rep_reply_id = rep_reply_id
        self.rep_identify_id = rep_identify_id
        self.rep_legal = 1


if __name__ == '__main__':
    pass
    # rm = ReplyModel(1, 2, 3, 4)
    # rm.rep_like_num = 12
    # print(rm.rep_like_num)
    # ReplyModel()
