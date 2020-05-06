import pymysql
import logging


class MySql:

    def __init__(self, db_name, user, password, host="localhost", charset="utf8"):
        self.__db_handle = pymysql.connect(host=host,
                                           user=user,
                                           password=password,
                                           db=db_name,
                                           charset=charset)
        self.__cursor = self.__db_handle.cursor()

    def execute_sql(self, sql):
        # logging.info("%s" % sql)
        self.__cursor.execute(sql)

    def commit_transactions(self):
        # logging.info("事务提交")
        self.__db_handle.commit()

    def commit_rollback(self):
        # logging.info("提交回滚")
        self.__db_handle.rollback()

    def get_result_all(self):
        result = self.__cursor.fetchall()
        # logging.info("获得数据: %s" % result)
        return result

    def get_result_one(self):
        result = self.__cursor.fetchone()
        # logging.info("获得数据: %s" % result)
        return result
