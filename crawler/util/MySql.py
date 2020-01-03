import pymysql


class MySql:

    def __init__(self, db_name, user, password, host="localhost", charset="utf8", print_sql=False):
        self.__db_handle = pymysql.connect(host=host,
                                           user=user,
                                           password=password,
                                           db=db_name,
                                           charset=charset)
        self.__print_sql = print_sql
        self.__cursor = self.__db_handle.cursor()

    def execute_sql(self, sql):
        if self.__print_sql:
            print("execute_sql %s" % sql)
        self.__cursor.execute(sql)

    def commit_transactions(self):
        if self.__print_sql:
            print("执行 commit")
        self.__db_handle.commit()

    def commit_rollback(self):
        if self.__print_sql:
            print("执行 rollback")
        self.__db_handle.rollback()

    def get_result_all(self):
        result = self.__cursor.fetchall()
        if self.__print_sql:
            print("获得数据: ", result)
        return result

    def get_result_one(self):
        result = self.__cursor.fetchone()
        if self.__print_sql:
            print("获得数据: ", result)
        return result