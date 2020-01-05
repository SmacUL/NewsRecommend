import model.CustomerModel as CusMod
import util.Md5 as Md5
import logging


class CustomerProcess:

    def set_art_cus(self, art_brief_json, cus_mod: CusMod):
        try:
            cus_mod.cus_spider = str(art_brief_json['media_info']['media_id'])
            cus_mod.cus_legal = 1
            cus_mod.cus_background_url =''
            cus_mod.cus_style = '这个用户很懒啥也没写'
            cus_mod.cus_avatar_url = art_brief_json['media_info']['avatar_url']
            cus_mod.cus_name = art_brief_json['media_info']['name']
            cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
            cus_mod.cus_id = None
            logging.info("set_art_cus 设置新闻用户信息 成功")
        except:
            logging.exception("set_art_cus 设置新闻用户信息 失败")
            raise

    def set_com_cus(self, com_json, cus_mod: CusMod.CustomerModel):
        """ 设置评论用户

        :param com_json:
        :param cus_mod:
        :return:
        """
        try:
            cus_mod.cus_spider = str(com_json['comment']['user_id'])
            cus_mod.cus_legal = 1
            cus_mod.cus_background_url =''
            cus_mod.cus_style = '这个用户很懒啥也没写'
            cus_mod.cus_avatar_url = com_json['comment']['user_profile_image_url']
            cus_mod.cus_name = com_json['comment']['user_name']
            cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
            cus_mod.cus_id = None
            logging.info("set_com_cus 设置评论用户信息 成功")
            # return cus_mod
        except:
            logging.exception("set_com_cus 设置评论用户信息 失败")
            raise
            # return None

    def set_rep_cus(self, rep_json, cus_mod: CusMod.CustomerModel):
        try:
            cus_mod.cus_spider = str(rep_json['user']['user_id'])
            cus_mod.cus_legal = 1
            cus_mod.cus_background_url = ''
            try:
                cus_mod.cus_style = rep_json['user']['description']
                if cus_mod.cus_style == '':
                    cus_mod.cus_style = '这个用户很懒啥也没写'
            except:
                logging.warning("set_rep_cus cus_style 获取 失败")
                cus_mod.cus_style = '这个用户很懒啥也没写'
            cus_mod.cus_avatar_url = rep_json['user']['avatar_url']
            cus_mod.cus_name = rep_json['user']['name']
            cus_mod.cus_pass = Md5.Md5.set_cus_pass("123456")
            cus_mod.cus_id = None

            logging.info("set_rep_cus 设置回复用户信息 成功")
            # return cus_mod
        except:
            logging.exception("set_rep_cus 设置回复用户信息 失败")
            raise


