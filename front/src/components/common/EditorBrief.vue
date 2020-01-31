<template>
    <dark-card>
        <div class="clear-float">
            <img class="image" :src="articleAuthor.cusAvatarUrl"/>
            <div class="editor-follow">
                <span class="editor" @click="jumpToCustomer(articleAuthor.cusId)"> {{articleAuthor.cusName}}</span>
                <el-button class="follow" type="primary">+关注</el-button>
            </div>
        </div>
    </dark-card>
</template>

<script>
    import DarkCard from './DarkCard'
    export default {
        name: "EditorBrief",
        components: { DarkCard },
        props: ['articleAuthor'],
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
    .image {
        height: 50px;
        float: left;
        margin: 10px;
    }

    .editor-follow {
        height: 50px;
        float: left;
        text-align: left;
        margin: 10px;
    }

    .editor {
        display: block;
        text-align: left;
        font-size: 16px;
        line-height: 25px;
    }

    .editor:hover {
        color: #339999;
        cursor: pointer;
    }

    .el-button {
        height: 25px;
        width: 60px;
        padding: 0px;
        font-size: 10pt;
        border-radius: 1px;
        display: block;
    }
</style>