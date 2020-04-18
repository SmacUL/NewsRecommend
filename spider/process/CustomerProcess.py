import model.CustomerModel as CusMod
import util.Md5 as Md5
import logging


class CustomerProcess:
    """ 用户数据的获取与填充

    # 20-17-04 依据新的 SQL 修改

    """


    def set_art_cus(self, art_brief_json, cus_mod: CusMod):
        """ 设置用户信息

        # 20-04-17 修改完成

        :param art_brief_json:
        :param cus_mod:
        :return:
        """
        try:
            cus_mod.cus_spider = str(art_brief_json['media_info']['media_id'])
            cus_mod.cus_legal = 1
            cus_mod.cus_style = '这个用户很懒啥也没写'
            cus_mod.cus_avatar_url = art_brief_json['media_info']['avatar_url']
            # cus_mod.cus_name = art_brief_json['media_info']['name'] + cus_mod.cus_spider[0:4]
            cus_mod.cus_name = art_brief_json['media_info']['name']
            cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
            cus_mod.cus_id = None
            logging.info("设置新闻用户信息 成功")
        except:
            logging.exception("设置新闻用户信息 失败")
            raise


    def set_com_cus(self, com_json, cus_mod: CusMod.CustomerModel):
        """ 设置评论用户

        # 20-04-17 修改完成

        :param com_json:
        :param cus_mod:
        :return:
        """
        try:
            cus_mod.cus_spider = str(com_json['comment']['user_id'])
            cus_mod.cus_legal = 1
            cus_mod.cus_style = '这个用户很懒啥也没写'
            cus_mod.cus_avatar_url = com_json['comment']['user_profile_image_url']
            # cus_mod.cus_name = com_json['comment']['user_name'] + cus_mod.cus_spider[0:4]
            cus_mod.cus_name = com_json['comment']['user_name']
            cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
            cus_mod.cus_id = None
            logging.info("设置评论用户信息 成功")
        except:
            logging.exception("设置评论用户信息 失败")
            raise


    def set_rep_cus(self, rep_json, cus_mod: CusMod.CustomerModel):
        """ 设置回复用户

        # 20-04-17 修改完成

        :param rep_json:
        :param cus_mod:
        :return:
        """
        try:
            cus_mod.cus_spider = str(rep_json['user']['user_id'])
            cus_mod.cus_legal = 1
            try:
                cus_mod.cus_style = rep_json['user']['description']
                if cus_mod.cus_style == '':
                    cus_mod.cus_style = '这个用户很懒啥也没写'
            except:
                logging.warning("cus_style 获取 失败")
                cus_mod.cus_style = '这个用户很懒啥也没写'
            cus_mod.cus_avatar_url = rep_json['user']['avatar_url']
            # cus_mod.cus_name = rep_json['user']['name'] + cus_mod.cus_spider[0:4]
            cus_mod.cus_name = rep_json['user']['name']
            cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
            cus_mod.cus_id = None

            logging.info("设置回复用户信息 成功")
        except:
            logging.exception("设置回复用户信息 失败")
            raise


