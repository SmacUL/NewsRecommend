DROP DATABASE IF EXISTS NR;
CREATE DATABASE IF NOT EXISTS NR CHARACTER SET utf8mb4;


-- cus 用户
DROP TABLE IF EXISTS NR.Customer;
CREATE TABLE NR.Customer (
    cus_id INT UNSIGNED NOT NULL auto_increment,
    cus_name VARCHAR(64) UNIQUE,
    cus_pass VARCHAR(255),
    -- 爬虫中用于识别用户
    cus_spider VARCHAR(64) default '',
    -- 用户头像的 url
    cus_avatar_url VARCHAR(255) default 'http://localhost:8080/img/Man.png',
    -- 用户的个人描述
    cus_style VARCHAR(255) default '这个人很懒, 什么都没写',
    -- cus_gender 为 0 时性别未知, 为 1 时为男, 为 -1 时为女
    cus_gender TINYINT DEFAULT 0,
    -- 用户的创建时间
    cus_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- cus_legal 为 0 时待审核, 为 1 时合法, 为 -1 不合法
    cus_legal TINYINT default 0,

    -- cus_type 为 0 时是普通用户, 为 1 时是可编辑用户 ABANDON
    -- cus_type TINYINT default 0,
    -- 用户背景墙的图片 url ABANDON
    -- cus_background_url VARCHAR(255) default '',
    -- 此用户的关注的用户数量 ABANDON
    -- cus_follow_num int UNSIGNED default 0,
    -- 此用户的粉丝 ABANDON
    -- cus_fan_num int UNSIGNED default 0, 
    -- 此用户的文章数量 ABANDON
    -- cus_article_num int UNSIGNED default 0,
    -- 用户评分 ABANDON
    -- cus_scope int UNSIGNED default 0,
	
    primary key(cus_id)
);


-- art 新闻
DROP TABLE IF EXISTS NR.Article;
CREATE TABLE NR.Article (
    art_id INT UNSIGNED NOT NULL auto_increment,
    art_title VARCHAR(255) default '',
    art_content TEXT,
    -- 在爬虫中分辨文章
    art_spider VARCHAR(64) default '',
    -- 文章的分类
    art_type VARCHAR(32),
    -- 文章的标签 应该以 & 分隔
    art_tags VARCHAR(128) default '',
    -- 文章缩略图的信息
    art_image_url VARCHAR(255) default '',
    art_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    art_legal tinyint default 0,
    art_cus_id INT UNSIGNED,

    -- 文章的点赞数量 ABANDON
    -- art_like_num INT UNSIGNED default 0,
    -- 文章的点踩数量 ABANDON
    -- art_dislike_num INT UNSIGNED default 0,
    -- 文章的评论数量 ABANDON
    -- art_comment_num INT UNSIGNED default 0,
    -- 文章的分数 ABANDON
	-- art_scope int UNSIGNED default 0,
    
    primary key(art_id),
	foreign key(art_cus_id) references Customer(cus_id)
);


-- com 评论 
DROP TABLE IF EXISTS NR.Comment;
CREATE TABLE NR.Comment (
    com_id INT UNSIGNED NOT NULL auto_increment,
    com_content TEXT,
    com_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    com_legal tinyint default 0,
    -- 爬虫过程中的评论标识
    com_spider varchar(64) default '',
    com_cus_id INT UNSIGNED,
    com_art_id INT UNSIGNED, 

    -- ABANDON
    -- com_like_num INT UNSIGNED default 0,
    -- ABANDON
    -- com_dislike_num INT UNSIGNED default 0,
	-- 评论的回复数量 ABANDON
    -- com_reply_num INT UNSIGNED default 0,
    -- 评论的分数 ABANDON
	-- com_scope int UNSIGNED default 0,

	primary key(com_id),
    foreign key(com_cus_id) references Customer(cus_id),
	foreign key(com_art_id) references Article(art_id)
);


-- rep 回复
DROP TABLE IF EXISTS NR.Reply;
CREATE TABLE NR.Reply (
    rep_id INT UNSIGNED NOT NULL auto_increment,
    rep_content TEXT,
    -- 回复的类型, 0 是对评论的回复, 1 是对回复的回复
    rep_type tinyint default 0, 
    rep_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	rep_legal tinyint default 0,
    -- 爬虫过程中的评论标识
    rep_spider varchar(64) default '',
    rep_cus_id INT UNSIGNED,
    rep_art_id INT UNSIGNED,
    rep_com_id INT UNSIGNED, 
    rep_rep_id INT UNSIGNED,

    -- ABANDON
    -- rep_like_num INT UNSIGNED default 0,
    -- ABANDON
    -- rep_dislike_num INT UNSIGNED default 0,
	-- 回复的回复数量 ABANDON
    -- rep_reply_num INT UNSIGNED default 0,
    -- 回复的分数 ABANDON
	-- rep_scope int UNSIGNED default 0,

    primary key(rep_id),
    foreign key(rep_cus_id) references Customer(cus_id),
	foreign key(rep_art_id) references Article(art_id),
    foreign key(rep_com_id) references Comment(com_id),
    foreign key(rep_rep_id) references Reply(rep_id)
);


-- adm 管理员
DROP TABLE IF EXISTS NR.Administrator;
CREATE TABLE NR.Administrator (
    adm_id INT UNSIGNED NOT NULL auto_increment,
    adm_name VARCHAR(64),
    adm_pass VARCHAR(255),
    adm_email VARCHAR(64),
    adm_phone VARCHAR(64),
    adm_address VARCHAR(255),
    adm_avatar_url VARCHAR(255),
    adm_gender TINYINT DEFAULT 0,
    adm_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    primary key(adm_id)
);



-- ccf 用户的关注情况记录
-- follower -> followee
-- DROP TABLE IF EXISTS NewsRecommend.CustomerCustomerFollow;
-- CREATE TABLE NewsRecommend.CustomerCustomerFollow (
--     ccf_id INT UNSIGNED NOT NULL auto_increment,
--     ccf_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

--     ccf_follower_id INT UNSIGNED,
--     ccf_followee_id INT UNSIGNED,
-- 	primary key(ccf_id),
--     foreign key(ccf_follower_id) references Customers(cus_id),
--     foreign key(ccf_followee_id) references Customers(cus_id)
-- );



-- cbr 用户的行为记录
-- 此表比较复杂, 用户之间的关注, 用户对文章, 用户对评论, 用户对回复. 
DROP TABLE IF EXISTS NR.CusBehaviorRecord;
CREATE TABLE NR.CusBehaviorRecord (
    cbr_id INT UNSIGNED NOT NULL auto_increment,
    -- 用户 攻
    cbr_cus_id_from INT UNSIGNED,
    -- 用户 受
    cbr_cus_id_to INT UNSIGNED,
    -- 行为类别
    cbr_behavior INT default 0,
    -- 行为时间
    cbr_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- 行为发生的文章 ID
    cbr_art_id INT UNSIGNED,
    -- 行为发生的位置代号, 0: 无发生, 1: 文章, 2: 评论, 3:回复
    cbr_type TINYINT DEFAULT 0,
    -- target ID
    cbr_target_id INT UNSIGNED,
    
	primary key(cbr_id),
    foreign key(cbr_art_id) references Article(art_id),
    foreign key(cbr_cus_id_from) references Customer(cus_id),
    foreign key(cbr_cus_id_to) references Customer(cus_id)
);

-- afc 文章特征统计表
DROP TABLE IF EXISTS NR.ArtFeatureCount;
CREATE TABLE NR.ArtFeatureCount (
    afc_id INT UNSIGNED NOT NULL auto_increment,
    afc_art_id INT UNSIGNED NOT NULL,

    afc_like_num INT UNSIGNED default 0,
    afc_dislike_num INT UNSIGNED default 0,
    afc_com_num INT UNSIGNED default 0,
    afc_rep_num INT UNSIGNED default 0,
    afc_read_num INT UNSIGNED default 0,
    afc_art_time TIMESTAMP,

	primary key(afc_id),
    foreign key(afc_art_id) references Article(art_id)
);


-- cfc 用户特征统计表
DROP TABLE IF EXISTS NR.CusFeatureCount;
CREATE TABLE NR.CusFeatureCount (
    cfc_id INT UNSIGNED NOT NULL auto_increment,

    cfc_cus_id INT UNSIGNED NOT NULL,

    cfc_news_society INT UNSIGNED default 0,
    cfc_news_entertainment INT UNSIGNED default 0,
    cfc_news_tech INT UNSIGNED default 0,
    cfc_news_military INT UNSIGNED default 0,
    cfc_news_sports INT UNSIGNED default 0,
    cfc_news_finance INT UNSIGNED default 0,
    cfc_news_world INT UNSIGNED default 0,
    cfc_news_fashion INT UNSIGNED default 0,
    cfc_news_travel INT UNSIGNED default 0,
    cfc_news_discovery INT UNSIGNED default 0,
    cfc_news_baby INT UNSIGNED default 0,
    cfc_news_regimen INT UNSIGNED default 0,
    cfc_news_story INT UNSIGNED default 0,
    cfc_news_essay INT UNSIGNED default 0,
    cfc_news_game INT UNSIGNED default 0,
    cfc_news_history INT UNSIGNED default 0,
    cfc_news_food INT UNSIGNED default 0,
    cfc_news_car INT UNSIGNED default 0,

	primary key(cfc_id),
    foreign key(cfc_cus_id) references Customer(cus_id)
);

-- crr 推荐内容记录表
DROP TABLE IF EXISTS NR.CusRecommendRecord;
CREATE TABLE NR.CusRecommendRecord (
    crr_id INT UNSIGNED NOT NULL auto_increment,
    crr_cus_id INT UNSIGNED NOT NULL,
    crr_art_id INT UNSIGNED NOT NULL,
    crr_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

	primary key(crr_id),
    foreign key(crr_cus_id) references Customer(cus_id),
    foreign key(crr_art_id) references Article(art_id)
);


-- 新闻 分数 for tiny 列表 asl
DROP VIEW IF EXISTS NR.ArtScoreList;
create view NR.ArtScoreList(asl_art_id, asl_art_score) as
    select
        afc_art_id,
        timestampdiff(HOUR,now(),afc_art_time)*20+cast(afc_like_num as signed)*4+cast(afc_dislike_num as signed)*(-6)+cast(afc_com_num as signed)*3+cast(afc_read_num as signed )*1+cast(afc_rep_num as signed )*2 as afc_art_socre
    from NR.ArtFeatureCount
    order by afc_art_socre desc;

-- 新闻 分数 for hot 列表 atl
DROP VIEW IF EXISTS NR.ArtTimeList;
create view NR.ArtTimeList(atl_art_id, atl_art_score) as 
    SELECT
        afc_art_id,
        timestampdiff(HOUR,now(),afc_art_time)*32+cast(afc_like_num as signed)*4+cast(afc_dislike_num as signed)*(-6)+cast(afc_com_num as signed)*3+cast(afc_read_num as signed )*1+cast(afc_rep_num as signed )*2 as atl_art_score
    from NR.ArtFeatureCount left join NR.Article on NR.ArtFeatureCount.afc_art_id = NR.Article.art_id
    where
        NR.Article.art_type in ("news_society", "news_military", "news_finance", "news_entertainment",
                                "news_game", "news_sports", "news_world", "news_tech", "news_car", "news_fashion") and
        abs(timestampdiff(HOUR,now(),afc_art_time)) < 72
    order by atl_art_score desc;
