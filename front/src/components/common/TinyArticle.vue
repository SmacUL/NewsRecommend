<template>
    <div class="tiny-article">
        <el-card>
            <div class="image" v-if="tinyArticle.artImage !== ''">
                <img :src="tinyArticle.artImage" >
            </div>
            <div :class="[wideSwitch ? tinyArt : tinyArtWide]">
                <div class="title" @click="jumpToArticle(tinyArticle.artId)">{{ tinyArticle.artTitle }}</div>
                <div class="description">{{ tinyArticle.artAbstract }}</div>
                <div class="info">
                    <span class="customer" @click="jumpToCustomer(tinyArticle.artId)">{{ tinyArticle.cusName }}</span>
                    <span>{{ dataTransfer }}</span>
                </div>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    props: ['tinyArticle'],
    name: 'TinyArticle',
    computed: {
        wideSwitch: function () {
            return this.tinyArticle.artImage !== '';
        },
        dataTransfer: function () {
            return new Date(Date.parse(this.tinyArticle.artTime)).toLocaleString();
        }
    },
    methods: {
        jumpToArticle: function (artId) {
            this.$emit('jump', artId);
        },

        jumpToCustomer: function (artId) {
            this.$emit('editor', artId);
        }
    },
    data: function() {
        return {
            tinyArt: 'tiny-art',
            tinyArtWide: 'tiny-art-wide',
        }
    },
}
</script>

<style scoped>
    .el-card {
        padding: 10px;
        border: 0px;
        border-radius: 0px;
    }

    .el-card.is-always-shadow {
        border-bottom: solid 1px rgba(0,0,0,.1);
        box-shadow: none;
    }

    .el-card.is-always-shadow:hover {
        box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
        background-color: #f4f5f6;
        border-bottom: none;
    }

    .image img {
        float: left;
        width: 27%;
        height: 120px;
        margin-right: 3%;
    }

    .el-card >>> .el-card__body {
        padding: 0px;
        overflow: hidden;

    }

    .tiny-art {
        float: left;
        width: 70%;
        height: 120px;
        position: relative;
    }

    .tiny-art-wide {
        float: left;
        width: 100%;
        height: 120px;
        position: relative;
    }

    .title {
        height: 60px;
        line-height: 30px;
        font-size: 18pt;
        overflow: hidden;
        text-align: left;
        margin-bottom: 5px;
        font-weight: 800;
    }

    .title:hover {
        color: #409EFF;
        cursor: pointer;
    }

    .description {
        height: 20px;
        line-height: 20px;
        overflow: hidden;
        text-align: left;
        color: #888888;
    }

    .info {
        text-align: left;
        font-size: 14px;
        position: absolute;
        bottom: 0px;
        color: #888888;
    }

    .info :first-child {
        font-weight: 400;
    }

    .customer {
        margin-right: 5px;

    }

    .customer:hover {
        color: #409EFF;
        cursor: pointer;
    }

</style>
