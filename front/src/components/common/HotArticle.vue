<template>
    <div class="hot-article-inner">
        <el-card>
            <div slot="header">
                <span class="hot-art">热点新闻</span>
                <el-button class="refresh" type="text">刷新</el-button>
            </div>
            <div class="clear-float" v-for="(hotNews, i) in hotNewsList" :key="i">
                <img class="image" src="@/assets/logo.png"/>
                <span class="title">{{hotNews.title}}</span>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    props: ['hotNewsList'],
    name: 'HotArticle',
    data: function() {
        return {

        }
    }
}
</script>

<style>

.hot-article-inner .el-card {
    border-radius: 0px;
}

.hot-article-inner .el-card__header {
    padding: 10px;
    text-align: left;
}

.hot-article-inner .hot-art {
    font-size: 16pt;
    font-weight: 800;
    height: 30px;
    line-height: 30px;
}

.hot-article-inner .refresh {
    height: 30px;
    padding: 0px;
    float: right;
}

.hot-article-inner .refresh span {
    font-size: 12pt;
    font-weight: 400;
}

.hot-article-inner .el-card__body {
    padding: 10px;
}

.hot-article-inner .el-card__body .clear-float {
    margin-bottom: 5px;
}

.hot-article-inner .image {
    height: 50px;
    width: 27%;
    margin-right: 3%;
    float: left;
}

.hot-article-inner .title {
    width: 70%;
    float: left;
    line-height: 50px;
    font-weight: 800;
    overflow: hidden;
}
</style>