<template>
    <div class="editor-brief">
        <el-card>
            <div class="clear-float" slot="header">
                <img class="image" :src="editor.avaterUrl"/>
                <div class="editor-follow">
                    <span class="editor"> {{editor.name}}</span>
                    <el-button class="follow" type="primary">+关注</el-button>
                </div>
            </div>
            <div class="titles" v-for="(recentArticle, i) in recentArticles" :key="i">
                <span class="title">+&nbsp;{{recentArticle.title}}</span>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    props: ['recentArticles', 'editor'],
    name: 'EditorBrief'
}
</script>

<style>
.editor-brief .el-card.is-always-shadow {
    box-shadow: none;
    background-color: #f4f5f6;
}

.editor-brief .el-card__header {
    padding: 10px;
}

.editor-brief .image {
    height: 50px;
    float: left;
    margin-right: 10px
}

.editor-brief .editor-follow {
    height: 50px;
    float: left;
}

.editor-brief .editor {
    display: block;
    text-align: left;
    font-size: 12pt;
}

.editor-brief .el-button {
    height: 20px;
    width: 60px;
    padding: 0px;
    font-size: 10pt;
    border-radius: 1px;
}

.editor-brief .el-card__body {
    padding: 10px;
}

.editor-brief .titles {
    overflow: hidden;
}

.editor-brief .title {
    line-height: 30px;
}

</style>