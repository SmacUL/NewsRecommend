import util.MySql as MySql
import model.ReplyModel as RepMod


class ReplyDao:

    def __init__(self, base: MySql.MySql):
        self.__base = base

