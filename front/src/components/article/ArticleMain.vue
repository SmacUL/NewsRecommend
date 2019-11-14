<template>
    <div class="article-main-inner">
        <div class="title">{{article.title}}</div>
        <div class="article-info">
            <span>{{editor.name}}</span>
            <span>{{article.time}}</span>
        </div>
        <div class="content" v-html="article.content"></div>
        <div class="up-down clear-float">
            <div class="up"><i class="el-icon-success"></i>{{ article.likeNum }}</div>
            <div class="down"><i class="el-icon-error"></i>{{ article.dislikeNum }}</div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['article', 'editor'],
    name: 'ArticleMain',
    data: function() {
        return {

        }
    }
}
</script>

<style>
.article-main-inner .title {
    font-size: 40px;
    font-weight: 800;
    text-align: left;
    line-height: 70px;
}

.article-main-inner .article-info {
    text-align: left;
    margin-top: 10px;
    margin-bottom: 20px;
    color: #777777;
}

.article-main-inner .content p {
    text-align: left;
    font-size: 14pt;
}

.article-main-inner .content img {
    text-align: center;
}

.article-main-inner .up-down {
    width: 120px;
    margin: 0 auto;
    padding: 30px 0px
}

.article-main-inner .up {
    float: left;
}

.article-main-inner .el-icon-success {
    margin-right: 10px;
}

.article-main-inner .down {
    float: right;
}

.article-main-inner .el-icon-error {
    margin-right: 10px;
}

</style>