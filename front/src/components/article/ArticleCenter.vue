<template>
    <div class="article-main">
        <div class="title">{{articleMain.artTitle}}</div>
        <div class="article-info">
            <span style="margin-right: 5px;">{{ articleMain.cusName }}</span>
            <span>{{ dataTransfer }}</span>
        </div>
        <div class="content" v-html="articleMain.artContent"></div>
        <div class="up-down clear-float">
            <div class="up"><i class="el-icon-success"></i>{{ articleMain.artLikeNum }}</div>
            <div class="down"><i class="el-icon-error"></i>{{ articleMain.artDislikeNum }}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ArticleCenter",
        props: ['articleMain'],
        computed: {
            dataTransfer: function () {
                return new Date(Date.parse(this.articleMain.artTime)).toLocaleString();
            }
        },
        data: function() {
            return {

            }
        }
    }
</script>

<style scoped>
    .title {
        font-size: 40px;
        font-weight: 800;
        text-align: left;
        line-height: 70px;
    }

    .article-info {
        text-align: left;
        margin-top: 10px;
        margin-bottom: 20px;
        color: #777777;
    }

    .content >>> p {
        text-align: left;
        font-size: 18px;
        margin: 0px;
    }

    .content >>> img {
        text-align: center;
    }

    .up-down {
        width: 120px;
        margin: 0 auto;
        padding: 30px 0px
    }

    .up {
        float: left;
    }

    .el-icon-success {
        margin-right: 10px;
    }

    .down {
        float: right;
    }

    .el-icon-error {
        margin-right: 10px;
    }
</style>