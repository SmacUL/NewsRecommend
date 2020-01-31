# NewsRecommend

基于协同过滤算法的新闻推荐系统, 推荐部分未开始. 项目分前后端与爬虫. 

## 数据库 NewsRecommend.sql
MySQL 导入自动建库

## 爬虫 spider

### 运行
爬虫独立运行获取数据后写入数据库, 数据来源为 今日头条, 需要 python 3 环境
``` sh
cd spider
python Main.py
```

## 前端 front

前端利用 Vue Cli 3 脚手架. 

### 运行
``` sh
cd front
yarn install
yarn serve
```

### 页面浏览
``` sh
localhost:8080/         # 首页
localhost:8080/article  # 文章阅读页
localhost:8080/self     # 个人中心
localhost:8080/search   # 搜索页面
# ...
```

## 后端 back
....
