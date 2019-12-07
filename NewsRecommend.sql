DROP DATABASE IF EXISTS NewsRecommend;
CREATE DATABASE IF NOT EXISTS NewsRecommend CHARACTER SET utf8;


-- cus 用户
-- cus_type 为 1 时是普通用户, 为 0 时是可编辑用户
-- cus_gender 为 0 时性别未知, 为 1 时为男, 为 -1 时为女
DROP TABLE IF EXISTS NewsRecommend.Customers;
CREATE TABLE NewsRecommend.Customers (
    cus_id INT UNSIGNED NOT NULL auto_increment,
    cus_name VARCHAR(64) unique,
    cus_pass VARCHAR(255),
    cus_email VARCHAR(64),
    cus_phone VARCHAR(64),
    cus_address VARCHAR(255),
    cus_avatar_url VARCHAR(255),
    cus_background_url VARCHAR(255),
    cus_style VARCHAR(255),
    cus_gender TINYINT DEFAULT 0,
    cus_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    cus_type TINYINT default 0,
    cus_legal TINYINT default 1,
	
    primary key(cus_id)
);


-- art 新闻
DROP TABLE IF EXISTS NewsRecommend.Articles;
CREATE TABLE NewsRecommend.Articles (
    art_id INT UNSIGNED NOT NULL auto_increment,
    art_title VARCHAR(255),
    art_abstract VARCHAR(255),
    art_content TEXT,
    art_url VARCHAR(255),
    art_tag VARCHAR(64),
    art_image VARCHAR(64) default '',
    art_like_num INT UNSIGNED default 0,
    art_dislike_num INT UNSIGNED default 0,
    art_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    art_legal tinyint default 1,
    
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
    com_legal tinyint default 1,
    
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
    rep_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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



-- ccf 用户的新闻点赞记录
-- follower -> followee
DROP TABLE IF EXISTS NewsRecommend.CustomerCustomerFollow;
CREATE TABLE NewsRecommend.CustomerCustomerFollow (
    ccf_id INT UNSIGNED NOT NULL,
    ccf_follower_id INT UNSIGNED,
    ccf_followee_id INT UNSIGNED,
    ccf_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

	primary key(ccf_id),
    foreign key(ccf_follower_id) references Customers(cus_id),
    foreign key(ccf_followee_id) references Customers(cus_id)
);



-- acp 用户的新闻点赞记录
-- acp_preference 0 表示中立; -1 表示讨厌; 1 表示喜欢
DROP TABLE IF EXISTS NewsRecommend.ArticleCustomerPreference;
CREATE TABLE NewsRecommend.ArticleCustomerPreference (
    acp_id INT UNSIGNED NOT NULL,
	acp_article_id INT UNSIGNED,
    acp_customer_id INT UNSIGNED,
    acp_preference TINYINT default 0,
    acp_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
	primary key(acp_id),
    foreign key(acp_article_id) references Articles(art_id),
    foreign key(acp_customer_id) references Customers(cus_id)
);


-- ccp 用户的评论点赞记录
-- ccp_preference 0 表示中立; -1 表示讨厌; 1 表示喜欢
DROP TABLE IF EXISTS NewsRecommend.CommentCustomerPreference;
CREATE TABLE NewsRecommend.CommentCustomerPreference (
    ccp_id INT UNSIGNED NOT NULL,
	ccp_comment_id INT UNSIGNED,
    ccp_customer_id INT UNSIGNED,
    ccp_preference TINYINT default 0,
    ccp_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
	primary key(ccp_id),
    foreign key(ccp_comment_id) references Comments(com_id),
    foreign key(ccp_customer_id) references Customers(cus_id)
);


-- rcp 用户的回复点赞记录
-- rcp_preference 0 表示中立; -1 表示讨厌; 1 表示喜欢
DROP TABLE IF EXISTS NewsRecommend.ReplyCustomerPreference;
CREATE TABLE NewsRecommend.ReplyCustomerPreference (
    rcp_id INT UNSIGNED NOT NULL,
	rcp_reply_id INT UNSIGNED,
    rcp_customer_id INT UNSIGNED,
    rcp_preference TINYINT default 0,
    rcp_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
	primary key(rcp_id),
    foreign key(rcp_reply_id) references Replys(rep_id),
    foreign key(rcp_customer_id) references Customers(cus_id)
);

