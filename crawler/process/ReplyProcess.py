import dao.ReplyDao as RepDao
import model.ReplyModel as RepMod


class ReplyProcess:

    def __init__(self, dao: RepDao.ReplyDao):
        self.__dao = dao

