<template>
    <div class="article-main">
        <div class="title">{{articleMain.artTitle}}</div>
        <div class="article-info">
            <span>{{ articleMain.cusName }}</span>
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
    // props: ['title', 'content', 'tag', 'author', 'date', 'artId', 'likeNum', 'dislikeNum'],
    // articleMain: {
    //     artId: 4,
    //     artTitle: "上海公安机关：外媒报道的所谓“中国特工”王立强系涉案在逃人员",
    //     artContent: "<p>新华社上海11月23日电 记者从上海市公安局静安分局获悉，澳大利亚《悉尼先驱晨报》报道的所谓“…护照和香港永久居民身份证均系伪造证件。</p><p>目前，公安机关对此案正在进一步调查中。</p>",
    //     artTag: "综合",
    //     artLikeNum: 0,
    //     artDislikeNum: 0,
    //     artTime: '2019-11-25T10:05:44.000+0000',
    //     cusName: '国际在线'
    // }
    props: ['articleMain'],
    name: 'ArticleMain',
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
