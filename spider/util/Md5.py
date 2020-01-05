import hashlib


class Md5:

    @staticmethod
    def set_cus_pass(password):
        """ 为用户密码进行 MD-5 加密

        :param password: 密码明文
        :return:
        """
        hl = hashlib.md5()
        hl.update(password.encode('utf-8'))
        return hl.hexdigest()
