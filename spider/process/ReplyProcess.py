import util.Request as Request
import util.Time as Time
import model.ReplyModel as RepMod

import logging


class ReplyProcess:
    """ 回复数据的获取与填充

    # 20-17-04 依据新的 SQL 修改

    """


    def get_reps_json(self, com_json):
        """ 获取 回复 包括 回复的回复 的数据

        # 20-04-17 代码检查 OK
        # 20-05-07 代码修改, 当获取的内容为 None 时, raise Exception

        数据接口参考:
            https://www.toutiao.com/2/comment/v2/reply_list/?aid=24&app_name=toutiao-web&id=6733175468666748931&offset=0&count=20&repost=0

        :param com_json:
        :return:
            example:
            [
                {
                    "id":6777317683702185995,
                    "id_str":"6777317683702185995",
                    "create_time":1577967243,
                    "text":"西瓜整个买的 好像只有中锅和美锅 其他都是切开卖的",
                    "content":"西瓜整个买的 好像只有中锅和美锅 其他都是切开卖的",
                    "content_rich_span":"{"links":[]}",
                    "digg_count":6,
                    "forward_count":0,
                    "user_digg":false,
                    "is_owner":false,
                    "has_author_digg":0,
                    "thumb_image_list":[

                    ],
                    "large_image_list":[

                    ],
                    "user":{
                        "user_id":4540648983,
                        "name":"拔吊无情3344",
                        "screen_name":"拔吊无情3344",
                        "avatar_url":"http://sf6-ttcdn-tos.pstatp.com/img/tos-cn-i-0022/ec4a0856405d4b3c92febe148fbe26e5~120x256.image",
                        "description":"",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_following":false,
                        "is_followed":false,
                        "is_blocking":false,
                        "is_blocked":false,
                        "author_badge":[

                        ],
                        "author_badge_night":[

                        ],
                        "interact_style":0,
                        "is_pgc_author":false,
                        "user_relation":0,
                        "user_decoration":"",
                        "band_url":"",
                        "band_name":""
                    },
                    "group":null,
                    "repost_params":null
                },
                {
                    "id":6777509244712976384,
                    "id_str":"6777509244712976384",
                    "create_time":1578011843,
                    "text":"现在我也是半个半个买了，太贵了",
                    "content":"现在我也是半个半个买了，太贵了",
                    "content_rich_span":"{"links":[]}",
                    "digg_count":1,
                    "forward_count":0,
                    "user_digg":false,
                    "is_owner":false,
                    "has_author_digg":0,
                    "thumb_image_list":[

                    ],
                    "large_image_list":[

                    ],
                    "user":{
                        "user_id":5943146542,
                        "name":"灵辉72330603",
                        "screen_name":"灵辉72330603",
                        "avatar_url":"http://p3.pstatp.com/thumb/5ac8001ee3bc186542d0",
                        "description":"",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_following":false,
                        "is_followed":false,
                        "is_blocking":false,
                        "is_blocked":false,
                        "author_badge":[

                        ],
                        "author_badge_night":[

                        ],
                        "interact_style":0,
                        "is_pgc_author":false,
                        "user_relation":0,
                        "user_decoration":"",
                        "band_url":"",
                        "band_name":""
                    },
                    "group":null,
                    "repost_params":null,
                    "reply_to_comment":{
                        "id":6777317683702185995,
                        "id_str":"6777317683702185995",
                        "text":"西瓜整个买的 好像只有中锅和美锅 其他都是切开卖的",
                        "content_rich_span":"{"links":[]}",
                        "status":1,
                        "user_id":4540648983,
                        "user_name":"拔吊无情3344",
                        "user_profile_image_url":"http://sf6-ttcdn-tos.pstatp.com/img/tos-cn-i-0022/ec4a0856405d4b3c92febe148fbe26e5~120x256.image",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_pgc_author":false,
                        "is_followed":false,
                        "is_following":false,
                        "user_relation":0,
                        "large_image_list":[

                        ],
                        "thumb_image_list":[

                        ]
                    }
                },
                {
                    "id":6765863594673405963,
                    "id_str":"6765863594673405963",
                    "create_time":1575300379,
                    "text":"那精致的吃法。或用水果叉还撒盐。",
                    "content":"那精致的吃法。或用水果叉还撒盐。",
                    "content_rich_span":"{"links":[]}",
                    "digg_count":5,
                    "forward_count":0,
                    "user_digg":false,
                    "is_owner":false,
                    "has_author_digg":0,
                    "thumb_image_list":[

                    ],
                    "large_image_list":[

                    ],
                    "user":{
                        "user_id":64403579548,
                        "name":"軋軋闹猛",
                        "screen_name":"軋軋闹猛",
                        "avatar_url":"http://sf3-ttcdn-tos.pstatp.com/img/tos-cn-i-0022/e581bc04e29a489cb38ce9a6ab689a11~120x256.image",
                        "description":"hello",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_following":false,
                        "is_followed":false,
                        "is_blocking":false,
                        "is_blocked":false,
                        "author_badge":[

                        ],
                        "author_badge_night":[

                        ],
                        "interact_style":0,
                        "is_pgc_author":false,
                        "user_relation":0,
                        "user_decoration":"",
                        "band_url":"",
                        "band_name":""
                    },
                    "group":null,
                    "repost_params":null
                },
                {
                    "id":6778028635040694272,
                    "id_str":"6778028635040694272",
                    "create_time":1578132771,
                    "text":"是太贵了",
                    "content":"是太贵了",
                    "content_rich_span":"{"links":[]}",
                    "digg_count":0,
                    "forward_count":0,
                    "user_digg":false,
                    "is_owner":false,
                    "has_author_digg":0,
                    "thumb_image_list":[

                    ],
                    "large_image_list":[

                    ],
                    "user":{
                        "user_id":85682550538,
                        "name":"高木同学w",
                        "screen_name":"高木同学w",
                        "avatar_url":"http://sf6-ttcdn-tos.pstatp.com/img/user-avatar/8a763365d363bd85011a7c3c9e319bca~120x256.image",
                        "description":"",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_following":false,
                        "is_followed":false,
                        "is_blocking":false,
                        "is_blocked":false,
                        "author_badge":[

                        ],
                        "author_badge_night":[

                        ],
                        "interact_style":0,
                        "is_pgc_author":false,
                        "user_relation":0,
                        "user_decoration":"",
                        "band_url":"",
                        "band_name":""
                    },
                    "group":null,
                    "repost_params":null,
                    "reply_to_comment":{
                        "id":6765863594673405963,
                        "id_str":"6765863594673405963",
                        "text":"那精致的吃法。或用水果叉还撒盐。",
                        "content_rich_span":"{"links":[]}",
                        "status":1,
                        "user_id":64403579548,
                        "user_name":"軋軋闹猛",
                        "user_profile_image_url":"http://sf3-ttcdn-tos.pstatp.com/img/tos-cn-i-0022/e581bc04e29a489cb38ce9a6ab689a11~120x256.image",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_pgc_author":false,
                        "is_followed":false,
                        "is_following":false,
                        "user_relation":0,
                        "large_image_list":[

                        ],
                        "thumb_image_list":[

                        ]
                    }
                },
                {
                    "id":6777979056702308367,
                    "id_str":"6777979056702308367",
                    "create_time":1578121229,
                    "text":"要是中国一个西瓜二百块钱，那也会用牙签吃。",
                    "content":"要是中国一个西瓜二百块钱，那也会用牙签吃。",
                    "content_rich_span":"{"links":[]}",
                    "digg_count":0,
                    "forward_count":0,
                    "user_digg":false,
                    "is_owner":false,
                    "has_author_digg":0,
                    "thumb_image_list":[

                    ],
                    "large_image_list":[

                    ],
                    "user":{
                        "user_id":109181261304,
                        "name":"7853624655665862",
                        "screen_name":"7853624655665862",
                        "avatar_url":"http://sf1-ttcdn-tos.pstatp.com/img/mosaic-legacy/3797/2889309425~120x256.image",
                        "description":"",
                        "user_verified":false,
                        "verified_reason":"",
                        "user_auth_info":"",
                        "is_following":false,
                        "is_followed":false,
                        "is_blocking":false,
                        "is_blocked":false,
                        "author_badge":[

                        ],
                        "author_badge_night":[

                        ],
                        "interact_style":0,
                        "is_pgc_author":false,
                        "user_relation":0,
                        "user_decoration":"",
                        "band_url":"",
                        "band_name":""
                    },
                    "group":null,
                    "repost_params":null
                }
            ]

        """
        try:
            reply_url = 'https://www.toutiao.com/api/pc/2/comment/v4/reply_list/?' \
                        'aid=24&app_name=toutiao-web&id={0}&offset=0&count={1}&repost=0' \
                        .format(com_json['id'], 20)
            headers = {
                "Host": "www.toutiao.com",
                'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36'
            }
            result = Request.Request(reply_url, headers).more()['data']['data']
            if result is None:
                raise
            logging.info("获取回复信息 %s 成功" % reply_url)
            return result
        except:
            # logging.exception("获取回复信息 失败")
            raise


    def set_rep(self, rep_json, rep_art_id, rep_com_id, rep_cus_id, rep_mod: RepMod.ReplyModel):
        """ 填充回复数据

        # 20-04-17 修改完成

        :param rep_json:
        :param rep_art_id:
        :param rep_com_id:
        :param rep_cus_id:
        :param rep_mod:
        :return:
        """
        try:
            rep_mod.rep_rep_id = None
            rep_mod.rep_legal = 1
            rep_mod.rep_cus_id = rep_cus_id
            rep_mod.rep_time = Time.Time.time_trans(rep_json['create_time'])
            rep_mod.rep_content = rep_json['text']
            rep_mod.rep_com_id = rep_com_id
            rep_mod.rep_id = None
            rep_mod.rep_art_id = rep_art_id
            rep_mod.rep_spider = str(rep_json['id'])

            # logging.info("设置回复信息 成功")
        except:
            # logging.exception("获取回复信息 失败")
            raise








