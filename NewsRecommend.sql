DROP DATABASE IF EXISTS NewsRecommend;
CREATE DATABASE IF NOT EXISTS NewsRecommend CHARACTER SET utf8;


-- cus 用户
DROP TABLE IF EXISTS NewsRecommend.Customers;
CREATE TABLE NewsRecommend.Customers (
    cus_id INT UNSIGNED NOT NULL auto_increment,
    cus_name VARCHAR(64),
    cus_pass VARCHAR(255),
    -- 用户的 url , 爬虫中用于识别用户
    cus_url VARCHAR(255) default '',
    -- 用户头像的 url
    cus_avatar_url VARCHAR(255) default '',
    -- 用户背景墙的图片 url
    cus_background_url VARCHAR(255) default '',
    -- 用户的个人描述
    cus_style VARCHAR(255) default '这个人很懒, 什么都没写',
    -- cus_gender 为 0 时性别未知, 为 1 时为男, 为 -1 时为女
    cus_gender TINYINT DEFAULT 0,
    -- 用户的创建时间
    cus_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    -- cus_type 为 0 时是普通用户, 为 1 时是可编辑用户
    cus_type TINYINT default 0,
    -- 此用户的关注的用户数量
    cus_follow_num int UNSIGNED default 0,
    -- 此用户的粉丝
    cus_fan_num int UNSIGNED default 0, 
    -- 此用户的文章数量
    cus_article_num int UNSIGNED default 0,
    -- 用户评分
    cus_scope int UNSIGNED default 0,
    -- cus_legal 为 0 时待审核, 为 1 时合法, 为 -1 不合法
    cus_legal TINYINT default 0,
	
    primary key(cus_id)
);


-- art 新闻
DROP TABLE IF EXISTS NewsRecommend.Articles;
CREATE TABLE NewsRecommend.Articles (
    art_id INT UNSIGNED NOT NULL auto_increment,
    art_title VARCHAR(255) default '',
    art_content TEXT,
    -- 文章的 url , 在爬虫中分辨文章
    art_url VARCHAR(255) default '',
    -- 文章的分类
    art_class VARCHAR(16) default '综合',
    -- 文章的标签 应该以 & 分隔
    art_tags VARCHAR(128) default '',
    -- 文章缩略图的信息
    art_image_url VARCHAR(255) default '',
    -- 文章的点赞数量
    art_like_num INT UNSIGNED default 0,
    -- 文章的点踩数量
    art_dislike_num INT UNSIGNED default 0,
    art_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    -- 文章的评论数量
    art_comment_num INT UNSIGNED default 0,
    -- 文章的分数
	art_scope int UNSIGNED default 0,
    art_legal tinyint default 0,
    
    art_customer_id INT UNSIGNED,
    primary key(art_id),
	foreign key(art_customer_id) references Customers(cus_id)
);


-- com 评论 
DROP TABLE IF EXISTS NewsRecommend.Comments;
CREATE TABLE NewsRecommend.Comments (
    com_id INT UNSIGNED NOT NULL auto_increment,
    com_content TEXT,
    com_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    com_like_num INT UNSIGNED default 0,
    com_dislike_num INT UNSIGNED default 0,
	-- 评论的回复数量
    com_reply_num INT UNSIGNED default 0,
    -- 评论的分数
	com_scope int UNSIGNED default 0,
    com_legal tinyint default 0,
    -- 爬虫过程中的评论标识
    com_identify_id varchar(64) default '',
    
    com_customer_id INT UNSIGNED,
    com_article_id INT UNSIGNED, 
	primary key(com_id),
    foreign key(com_customer_id) references Customers(cus_id),
	foreign key(com_article_id) references Articles(art_id)
);


-- rep 回复
DROP TABLE IF EXISTS NewsRecommend.Replys;
CREATE TABLE NewsRecommend.Replys (
    rep_id INT UNSIGNED NOT NULL auto_increment,
    rep_content TEXT,
    -- 回复的类型, 0 是对评论的回复, 1 是对回复的回复
    rep_type tinyint default 0, 
    rep_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    rep_like_num INT UNSIGNED default 0,
    rep_dislike_num INT UNSIGNED default 0,
	-- 回复的回复数量
    rep_reply_num INT UNSIGNED default 0,
    -- 回复的分数
	rep_scope int UNSIGNED default 0,
	rep_legal tinyint default 0,

    -- 爬虫过程中的评论标识
    rep_identify_id varchar(64) default '',

    rep_customer_id INT UNSIGNED,
    rep_article_id INT UNSIGNED,
    rep_comment_id INT UNSIGNED, 
    rep_reply_id INT UNSIGNED,
    primary key(rep_id),
    foreign key(rep_customer_id) references Customers(cus_id),
	foreign key(rep_article_id) references Articles(art_id),
    foreign key(rep_comment_id) references Comments(com_id),
    foreign key(rep_reply_id) references Replys(rep_id)
);


-- adm 管理员
DROP TABLE IF EXISTS NewsRecommend.Administrators;
CREATE TABLE NewsRecommend.Administrators (
    adm_id INT UNSIGNED NOT NULL auto_increment,
    adm_name VARCHAR(64),
    adm_pass VARCHAR(255),
    adm_email VARCHAR(64),
    adm_phone VARCHAR(64),
    adm_address VARCHAR(255),
    adm_avatar_url VARCHAR(255),
    adm_gender TINYINT DEFAULT 0,
    adm_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    primary key(adm_id)
);



-- ccf 用户的关注情况记录
-- follower -> followee
DROP TABLE IF EXISTS NewsRecommend.CustomerCustomerFollow;
CREATE TABLE NewsRecommend.CustomerCustomerFollow (
    ccf_id INT UNSIGNED NOT NULL,
    ccf_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    ccf_follower_id INT UNSIGNED,
    ccf_followee_id INT UNSIGNED,
	primary key(ccf_id),
    foreign key(ccf_follower_id) references Customers(cus_id),
    foreign key(ccf_followee_id) references Customers(cus_id)
);



-- acb 用户的新闻偏好程度记录
DROP TABLE IF EXISTS NewsRecommend.ArticleCustomerBehavior;
CREATE TABLE NewsRecommend.ArticleCustomerBehavior (
    acb_id INT UNSIGNED NOT NULL,
    -- acb_behavior 用户行为: 无 0, 写作 1, 点赞 2, 点踩 3, 评论 4, 回复 5
    acb_behavior INT UNSIGNED default 0,
    acb_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    acb_article_id INT UNSIGNED,
    acb_customer_id INT UNSIGNED,
	primary key(acb_id),
    foreign key(acb_article_id) references Articles(art_id),
    foreign key(acb_customer_id) references Customers(cus_id)
);


-- ccp 用户的评论点赞点踩记录
-- DROP TABLE IF EXISTS NewsRecommend.CommentCustomerPreference;
-- CREATE TABLE NewsRecommend.CommentCustomerPreference (
--     ccp_id INT UNSIGNED NOT NULL,
--     -- ccp_prefer 0 表示中立; -1 表示讨厌; 1 表示喜欢
--     ccp_prefer TINYINT default 0,
--     ccp_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

--     ccp_comment_id INT UNSIGNED,
--     ccp_customer_id INT UNSIGNED,
-- 	primary key(ccp_id),
--     foreign key(ccp_comment_id) references Comments(com_id),
--     foreign key(ccp_customer_id) references Customers(cus_id)
-- );


-- rcp 用户的回复点赞点踩记录
-- DROP TABLE IF EXISTS NewsRecommend.ReplyCustomerPreference;
-- CREATE TABLE NewsRecommend.ReplyCustomerPreference (
--     rcp_id INT UNSIGNED NOT NULL,
--     -- rcp_prefer 0 表示中立; -1 表示讨厌; 1 表示喜欢
--     rcp_prefer TINYINT default 0,
--     rcp_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

-- 	rcp_reply_id INT UNSIGNED,
--     rcp_customer_id INT UNSIGNED,
-- 	primary key(rcp_id),
--     foreign key(rcp_reply_id) references Replys(rep_id),
--     foreign key(rcp_customer_id) references Customers(cus_id)
-- );

