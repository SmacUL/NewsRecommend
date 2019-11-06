DROP DATABASE IF EXISTS NewsRecommend;
CREATE DATABASE IF NOT EXISTS NewsRecommend CHARACTER SET utf8;


-- cus 用户
-- cus_type 为 1 时是普通用户, 为 0 时是可编辑用户
-- cus_gender 为 0 时性别未知, 为 1 时为男, 为 -1 时为女
DROP TABLE IF EXISTS Customers;
CREATE TABLE NewsRecommend.Customers (
    cus_id INT UNSIGNED NOT NULL auto_increment,
    cus_name VARCHAR(64),
    cus_pass VARCHAR(255),
    cus_email VARCHAR(64),
    cus_phone VARCHAR(64),
    cus_address VARCHAR(255),
    cus_avater_url VARCHAR(255),
    cus_style VARCHAR(255),
    cus_gender TINYINT DEFAULT 0,
    cus_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    cus_type TINYINT default 0,
    cus_legal TINYINT default 1,
	
    primary key(cus_id)
);


-- art 新闻
DROP TABLE IF EXISTS Articles;
CREATE TABLE NewsRecommend.Articles (
    art_id INT UNSIGNED NOT NULL auto_increment,
    art_title VARCHAR(255),
    art_abstract VARCHAR(255),
    art_content TEXT,
    art_url VARCHAR(255),
    art_tag VARCHAR(64),
    art_like_num INT UNSIGNED default 0,
    art_dislike_num INT UNSIGNED default 0,
    art_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    art_legal tinyint default 1,
    
    art_customer_id INT UNSIGNED,
    primary key(art_id),
	foreign key(art_customer_id) references Customers(cus_id)
);


-- com 评论 
DROP TABLE IF EXISTS Comments;
CREATE TABLE NewsRecommend.Comments (
    com_id INT UNSIGNED NOT NULL auto_increment,
    com_content TEXT,
    com_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    com_like_num INT UNSIGNED default 0,
    com_legal tinyint default 1,
    
    com_customer_id INT UNSIGNED,
    com_article_id INT UNSIGNED, 
	primary key(com_id),
    foreign key(com_customer_id) references Customers(cus_id),
	foreign key(com_article_id) references Articles(art_id)
);


-- rep 回复
DROP TABLE IF EXISTS Replys;
CREATE TABLE NewsRecommend.Replys (
    rep_id INT UNSIGNED NOT NULL auto_increment,
    rep_content TEXT,
    rep__time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    rep_like_num INT UNSIGNED default 0,
	rep_legal tinyint default 1,
    
    rep_customer_id INT UNSIGNED,
    rep_article_id INT UNSIGNED,
    rep_reply_id INT UNSIGNED,
    primary key(rep_id),
    foreign key(rep_customer_id) references Customers(cus_id),
	foreign key(rep_article_id) references Articles(art_id),
    foreign key(rep_reply_id) references Replys(rep_id)
);


-- adm 管理员
DROP TABLE IF EXISTS Administrators;
CREATE TABLE NewsRecommend.Administrators (
    adm_id INT UNSIGNED NOT NULL auto_increment,
    adm_name VARCHAR(64),
    adm_pass VARCHAR(255),
    adm_email VARCHAR(64),
    adm_phone VARCHAR(64),
    adm_address VARCHAR(255),
    adm_avater_url VARCHAR(255),
    adm_gender TINYINT DEFAULT 0,
    adm_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    primary key(adm_id)
);



-- ccf 用户的新闻点赞记录
-- follower -> follower
DROP TABLE IF EXISTS CustomerCustomerFollow;
CREATE TABLE NewsRecommend.ArticleCustomLike (
    ccf_id INT UNSIGNED NOT NULL,
    ccf_follower_id INT UNSIGNED,
    ccf_followee_id INT UNSIGNED,
    ccf_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

	primary key(ccf_id),
    foreign key(ccf_follower_id) references Customers(cus_id),
    foreign key(ccf_followee_id) references Customers(cus_id)
);



-- acp 用户的新闻点赞记录
-- acp_perference 0 表示中立; -1 表示讨厌; 1 表示喜欢
DROP TABLE IF EXISTS ArticleCustomPerference;
CREATE TABLE NewsRecommend.ArticleCustomPerference (
    acp_id INT UNSIGNED NOT NULL,
	acp_article_id INT UNSIGNED,
    acp_custom_id INT UNSIGNED,
    acp_perference TINYINT default 0,
    acp_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
	primary key(acp_id),
    foreign key(acp_article_id) references Articles(art_id),
    foreign key(acp_custom_id) references Customers(cus_id)
);


-- ccl 用户的评论点赞记录
DROP TABLE IF EXISTS CommentCustomLike;
CREATE TABLE NewsRecommend.CommentCustomDislike (
    ccl_id INT UNSIGNED NOT NULL,
	ccl_comment_id INT UNSIGNED,
    ccl_custom_id INT UNSIGNED,
    ccl_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
	primary key(ccl_id),
    foreign key(ccl_comment_id) references Comments(com_id),
    foreign key(ccl_custom_id) references Customers(cus_id)
);


-- rcl 用户的回复点赞记录
DROP TABLE IF EXISTS ReplyCustomLike;
CREATE TABLE NewsRecommend.ReplyCustomDislike (
    rcl_id INT UNSIGNED NOT NULL,
	rcl_replay_id INT UNSIGNED,
    rcl_custom_id INT UNSIGNED,
    rcl_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
	primary key(rcl_id),
    foreign key(rcl_replay_id) references Replys(rep_id),
    foreign key(rcl_custom_id) references Customers(cus_id)
);

