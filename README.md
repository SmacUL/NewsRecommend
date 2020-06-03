# NewsRecommend

基于协同过滤算法的新闻推荐系统, 项目分前后端与爬虫. 

实现热点新闻推荐以及个性化新闻推荐.

[项目的具体说明](https://smacul.github.io/log/news_recommend/)

喜欢的话, 可以点个 star 奥. 

## 项目分支

- main: 主分支, 保存最新的可预览状态.
- dev: Mac 上的开发分支
- dev-win: Win 上的开发分支

**不同分支使用的数据库名称可能并不一致, 以各个分支中的 `NewsRecommend.sql` 文件为准**

## 数据库 NewsRecommend.sql
MySQL 导入自动建库

## 爬虫 spider

### 运行
爬虫独立运行获取数据后写入数据库, 数据来源为 今日头条, 需要 python 3 环境.

在 `spider` 目录下创建 `properties/database.json`.   
*database.json* 模板：
``` json
{
  "name": "NewsRecommend",
  "user": "your name",
  "pass": "your pass",
  "host": "your host",
  "charset": "utf8mb4"
}
```

并在 `spider` 目录下创建 `log` 目录，用于存放日志文件 (我懒得写)

正确安装 webdriver 后执行：

``` sh
cd spider
python Main.py
```

## 前端 front

前端利用 Vue Cli 3 脚手架. 需要 node.js yarn.

应该需要先装 wangeditor (富文本编辑工具) `npm install wangeditor`

### 运行
``` sh
cd front
yarn install
yarn serve
```

<!-- ### 页面浏览
``` sh
localhost:8071/         # 首页
localhost:8071/article  # 文章阅读页
localhost:8071/self     # 个人中心
localhost:8071/search   # 搜索页面
# ...
​``` -->

## 后端 back

后端基于 SpringBoot 与 MyBatis. 

现在工程目录下的 `src/main/resources` 中创建 application.properties 文件, 内容大致如下: 

``` shell   
spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.datasource.url = jdbc:mysql://[主机名]:3306/[数据库名称]?useUnicode=true&characterEncoding=utf8&useSSL=true
spring.datasource.username = [用户名]
spring.datasource.password = [密码]
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

## 预览

![首页](./index.png)

