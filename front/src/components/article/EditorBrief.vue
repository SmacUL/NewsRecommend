<template>
    <div class="editor-brief-inner">
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
.editor-brief-inner .el-card__header {
    padding: 10px;
}

.editor-brief-inner .image {
    height: 50px;
    float: left;
    margin-right: 10px
}

.editor-brief-inner .editor-follow {
    height: 50px;
    float: left;
}

.editor-brief-inner .editor {
    display: block;
    text-align: left;
    font-size: 12pt;
}

.editor-brief-inner .el-button {
    height: 20px;
    width: 60px;
    padding: 0px;
    font-size: 10pt;
    border-radius: 1px;
}

.editor-brief-inner .el-card__body {
    padding: 10px;
}

.editor-brief-inner .titles {
    overflow: hidden;
}

.editor-brief-inner .title {
    line-height: 30px;
}

</style>