<template>
    <div class="editor-brief">
        <el-card>
            <div class="clear-float" slot="header">
                <img class="image" :src="articleAuthor.cusAvatarUrl"/>
                <div class="editor-follow">
                    <span class="editor" @click="jumpToCustomer(articleAuthor.cusId)"> {{articleAuthor.cusName}}</span>
                    <el-button class="follow" type="primary">+关注</el-button>
                </div>
            </div>
            <!-- 作者的相关新闻 -->
            <div>
                <span class="title" v-for="(hotArticle, i) in articleAuthor.hotArticles" :key="i"
                      @click="jumpToArticle(hotArticle.artId)">
                    +&nbsp;{{hotArticle.artTitle}}
                </span>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    props: ['articleAuthor'],
    name: 'EditorBrief',
    methods: {
        jumpToArticle: function (artId) {
            this.$emit('jump', artId);
        },
        jumpToCustomer: function (cusId) {
            this.$emit('editor', cusId);
        }
    },
    data: function () {
        return {

        }
    }
}
</script>

<style scoped>
.el-card.is-always-shadow {
    box-shadow: none;
    background-color: #f4f5f6;
}

.el-card >>> .el-card__header {
    padding: 15px 15px 10px 15px;
}

.image {
    height: 50px;
    float: left;
    margin-right: 10px
}

.editor-follow {
    height: 50px;
    float: left;
}

.editor {
    display: block;
    text-align: left;
    font-size: 12pt;
}

.editor:hover {
    color: #409EFF;
    cursor: pointer;
}

.el-button {
    height: 20px;
    width: 60px;
    padding: 0px;
    font-size: 10pt;
    border-radius: 1px;
}

.el-card >>> .el-card__body {
    padding: 15px 15px 10px 15px;
}

.title {
    overflow: hidden;
    height: 30px;
    text-align: left;
    line-height: 30px;
    display: block;
}

.title:hover {
    color: #409EFF;
    cursor: pointer;
}

</style>
