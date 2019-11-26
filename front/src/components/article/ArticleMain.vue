<template>
    <div class="article-main">
        <div class="title">{{title}}</div>
        <div class="article-info">
            <span>{{author}}</span>
            <span>{{ dataTransfer }}</span>
        </div>
        <div class="content" v-html="content"></div>
        <div class="up-down clear-float">
            <div class="up"><i class="el-icon-success"></i>{{ likeNum }}</div>
            <div class="down"><i class="el-icon-error"></i>{{ dislikeNum }}</div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['title', 'content', 'tag', 'author', 'date', 'artId', 'likeNum', 'dislikeNum'],
    name: 'ArticleMain',
    computed: {
        dataTransfer: function () {
            return new Date(Date.parse(this.date)).toLocaleString();
        }
    },
    data: function() {
        return {

        }
    }
}
</script>

<style>
.article-main .title {
    font-size: 40px;
    font-weight: 800;
    text-align: left;
    line-height: 70px;
}

.article-main .article-info {
    text-align: left;
    margin-top: 10px;
    margin-bottom: 20px;
    color: #777777;
}

.article-main .content p {
    text-align: left;
    font-size: 18px;
}

.article-main .content img {
    text-align: center;
}

.article-main .up-down {
    width: 120px;
    margin: 0 auto;
    padding: 30px 0px
}

.article-main .up {
    float: left;
}

.article-main .el-icon-success {
    margin-right: 10px;
}

.article-main .down {
    float: right;
}

.article-main .el-icon-error {
    margin-right: 10px;
}

</style>
