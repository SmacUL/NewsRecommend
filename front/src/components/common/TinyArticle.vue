<template>
    <div class="tiny-article">
        <el-card>
            <div class="image" v-if="tinyArticle.artImage !== ''">
                <img :src="tinyArticle.artImage" >
            </div>
            <div :class="[wideSwitch ? tinyArt : tinyArtWide]">
                <div class="title" @click="dumpToArticle(tinyArticle.artId)">{{ tinyArticle.artTitle }}</div>
                <div class="description">{{ tinyArticle.artAbstract }}</div>
                <div class="info">
                    <!-- TODO 点击 author, 可以直接到 author 的主页-->
                    <span style="margin-right: 5px; color: #409EFF;">{{ tinyArticle.cusName }}</span>
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
        dumpToArticle: function (artId) {
            this.$emit('jump', artId);
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

<style>
.tiny-article .el-card {
    padding: 10px;
    border: 0px;
    border-radius: 0px;
}

.tiny-article .el-card.is-always-shadow {
    border-bottom: solid 1px rgba(0,0,0,.1);
    box-shadow: none;
}

.tiny-article .el-card.is-always-shadow:hover {
    box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
    background-color: #f4f5f6;
    border-bottom: none;
}

.tiny-article .image img {
    float: left;
    width: 27%;
    height: 120px;
    margin-right: 3%;
}

.tiny-article .el-card__body {
    padding: 0px;
}

.tiny-article .tiny-art {
    float: left;
    width: 70%;
    height: 120px;
    position: relative;
}

.tiny-article .tiny-art-wide {
    float: left;
    width: 100%;
    height: 120px;
    position: relative;
}

.tiny-article .title {
    height: 60px;
    line-height: 30px;
    font-size: 18pt;
    overflow: hidden;
    text-align: left;
    margin-bottom: 5px;
    font-weight: 800;
}

.tiny-article .title:hover {
    color: #409EFF;
    cursor: pointer;
}

.tiny-article .description {
    height: 20px;
    line-height: 20px;
    overflow: hidden;
    text-align: left;
    color: #888888;
}

.tiny-article .info {
    text-align: left;
    font-size: 14px;
    position: absolute;
    bottom: 0px;
    color: #888888;
}

.tiny-article .info :first-child {
    font-weight: 400;
}

/*.tiny-article .info :last-child {*/
/*    font-weight: 100;*/
/*}*/

</style>
