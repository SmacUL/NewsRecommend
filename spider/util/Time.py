import time


class Time:

    @staticmethod
    def time_trans(time_data):
        time_stamp = time_data
        time_array = time.localtime(time_stamp)
        return time.strftime("%Y-%m-%d %H-%M-%S", time_array)

    @staticmethod
    def get_local_time():
        return Time.time_trans(time.time())
