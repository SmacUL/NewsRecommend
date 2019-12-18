import pymysql


class MySql:

    def __init__(self, db_name, user, password, host="localhost", charset="utf8"):
        self.__db_handle = pymysql.connect(host=host,
                                           user=user,
                                           password=password,
                                           db=db_name,
                                           charset=charset)
        self.__cursor = self.__db_handle.cursor()

    def execute_sql(self, sql):
        try:
            print("execute_sql %s" % sql)
            self.__cursor.execute(sql)
        except Exception as err:
            print(err)

    def commit_transactions(self):
        try:
            self.__db_handle.commit()
        except Exception as err:
            self.__db_handle.rollback()
            print(err)

    def get_result_all(self):
        try:
            result = self.__cursor.fetchall()
            return result
        except Exception as err:
            print(err)

    def get_result_one(self):
        try:
            result = self.__cursor.fetchone()
            return result
        except Exception as err:
            print(err)