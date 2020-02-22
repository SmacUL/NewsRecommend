import util.Request as Request
import util.Time as Time
import model.CommentModel as ComMod

import logging


class CommentProcess:

    def get_coms_json(self, art_brief_json):
        """ 获取评论列表

        参考接口:
            https://www.toutiao.com/article/v2/tab_comments/?aid=24&app_name=toutiao-web&group_id=6732655510039822860&item_id=6732655510039822860&offset=0&count=5

        :param art_brief_json:
        :return:

            example:
            [
                Object{...},
                {
                    "comment":{
                        "id":6732812439848665099,
                        "id_str":"6732812439848665099",
                        "text":"见过一个女孩，搞防晒真的是全副武装，... 承认我是个女的😂",
                        "content_rich_span":"{"links":[]}",
                        "reply_count":71,
                        "reply_list":[

                        ],
                        "digg_count":1372,
                        "bury_count":0,
                        "forward_count":0,
                        "create_time":1567605056,
                        "score":1.8130338214242776,
                        "user_id":1684053931865459,
                        "user_name":"用户896765315284",
                        "remark_name":"",
                        "user_profile_image_url":"http://sf1-ttcdn-tos.pstatp.com/img/mosaic-legacy/3793/3131589739~120x256.image",
                        "user_verified":false,
                        "interact_style":0,
                        "is_following":0,
                        "is_followed":0,
                        "is_blocking":0,
                        "is_blocked":0,
                        "is_pgc_author":0,
                        "author_badge":[

                        ],
                        "author_badge_night":[

                        ],
                        "verified_reason":"",
                        "user_bury":0,
                        "user_digg":0,
                        "user_relation":0,
                        "user_auth_info":"",
                        "user_decoration":"",
                        "band_url":"",
                        "band_name":"",
                        "aid":35,
                        "large_image_list":[

                        ],
                        "thumb_image_list":[

                        ],
                        "media_info":{
                            "name":"",
                            "avatar_url":""
                        },
                        "tags":null,
                        "platform":"feifei",
                        "has_author_digg":0,
                        "multi_media":null,
                        "has_multi_media":false,
                        "show_tags":0
                    },
                    "ad":null,
                    "embedded_data":null,
                    "id":6732812439848665099,
                    "cell_type":1
                },
                Object{...},
                Object{...},
                Object{...}
            ],

        """
        try:
            com_url = 'https://www.toutiao.com/api/pc/article/v4/tab_comments/?' \
                          'aid=66&app_name=toutiao-web&group_id={0}&item_id={1}&offset=0&count={2}' \
                        .format(art_brief_json['group_id'], art_brief_json['item_id'], 10)
            headers = {
                "Host": "www.toutiao.com",
                'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36'
            }
            result = Request.Request(com_url, headers).more()['data']
            logging.info("获取评论页数据 %s 失败" % com_url)
            return result
        except:
            logging.exception("获取评论页数据 失败")
            return None

    def set_com(self, com_json, art_id, cus_id, com_mod: ComMod.CommentModel):
        """ set a single comment

        :param com_json:
        :param art_id:
        :param cus_id:
        :param com_mod:
        :return:
        """
        try:
            com_mod.com_customer_id = cus_id
            com_mod.com_time = Time.Time.time_trans(com_json['comment']['create_time'])
            com_mod.com_content = com_json['comment']['text']
            com_mod.com_like_num = com_json['comment']['digg_count']
            com_mod.com_article_id = art_id
            com_mod.com_id = None
            com_mod.com_legal = 1
            com_mod.com_spider = str(com_json['comment']['id'])

            logging.info("设置评论数据 成功")
        except:
            logging.exception("设置评论数据 失败")
            raise
