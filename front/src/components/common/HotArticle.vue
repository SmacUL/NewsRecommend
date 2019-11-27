<template>
    <div class="hot-article">
        <el-card>
            <div slot="header">
                <span class="hot-art">{{ title }}</span>
                <el-button class="refresh" type="text" @click="refreshArticles">刷新</el-button>
            </div>
            <div class="clear-float" v-for="(hotArticle, i) in hotArticles" :key="i">
                <img class="image" v-if="hotArticle.artImage !== ''" :src="hotArticle.artImage"/>
                <span class="title" :class="[hotArticle.artImage !== '' ? narrowTitle : wideTitle]"
                      @click="dumpToArticle(hotArticle.artId)">
                    {{ hotArticle.artTitle }}
                </span>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    props: ['title', 'hotArticles'],
    name: 'HotArticle',
    computed: {
    },
    methods: {
        dumpToArticle: function (artId) {
            this.$emit('jump', artId);
        },
        refreshArticles: function () {
            this.$emit('refresh');
        },
    },
    data: function() {
        return {
            narrowTitle: 'narrow-title',
            wideTitle: 'wide-title'

        }
    }
}
</script>

<style>

    .hot-article .el-card {
        border-radius: 0px;
    }

    .hot-article .el-card.is-always-shadow {
        box-shadow: none;
        background-color: #f4f5f6;
    }

    .hot-article .el-card__header {
        padding: 15px 15px 5px 15px;
        text-align: left;
    }

    .hot-article .hot-art {
        font-size: 20px;
        font-weight: 800;
        height: 30px;
        line-height: 30px;
    }

    /* 刷新按钮 */
    .hot-article .refresh {
        height: 30px;
        padding: 0px;
        float: right;
    }

    /* 刷新 两个字 */
    .hot-article .refresh span {
        font-size: 16px;
        font-weight: 500;
    }

    .hot-article .el-card__body {
        padding: 5px 15px;
    }

    .hot-article .el-card__body .clear-float {
        margin-bottom: 5px;
    }

    .hot-article .image {
        height: 50px;
        width: 27%;
        margin-right: 3%;
        float: left;
    }

    /* 新闻标题 */
    .hot-article .title {
        float: left;
        line-height: 50px;
        font-weight: 500;
        overflow: hidden;
        height: 50px;
        text-align: left;
    }

    .hot-article .narrow-title {
        width: 70%;
    }

    .hot-article .wide-title {
        width: 100%;
    }

    .hot-article .title:hover {
        color: #409EFF;
        cursor: pointer;
    }

</style>
