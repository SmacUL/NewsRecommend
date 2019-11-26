# NewsRecommend

##  说明
这是一个基于 Java Web 与 Hadoop 的新闻推荐系统. 系统的 UI 与数据均源自 "今日头条" . 

系统的核心部分也是麻烦的地方, 除了实现**普通用户系统**与**管理员系统**前后端外, 需要完成一个简易的**搜索引擎**, 基于机器学习的**推荐算法**的实现, 至于 **Hadoop** , 以实验的方式引入项目; 

## 需要的东西

- Selenium
- Vue
- Nodejs
- Webpack
- SpringBoot
- MyBatis
- MySQL

## 项目结构

当前系统分成三个部分:
- Python 爬虫
- 用户前端 
- 用户后端

项目的主要结构: 
```
    |-- back                    // 用户后端
        |-- scr.main.smacul.demo
            |-- bean
            |-- controller
            |-- dao             // 存放 mapper
            |-- model
            |-- service
    |-- crawler                 // 爬虫
        |-- AnalyseOP.py        // 分析
        |-- DatabaseOP.py       // 数据库相关操作
        |-- FilterOP.py         // 修正数据内容
        |-- Main.py         
        |-- properties          // 配置文件及模板
        |-- RequestOP.py        // 文章内容请求获取解析
    |-- front                   // 用户前端
        |-- src
            |-- components      // 存放页面需要的组件
                |-- article     // 文章页组件
                |-- common      // 通用组件
                |-- index       // 首页组件
                |-- port        // 登录注册页组件
                |-- search      // 搜索页组件
                |-- self        // 用户中心页组件
            |-- pages           // 存放组合页面
```
