<template>
    <div class="article-main">
        <div class="title">{{articleMain.artTitle}}</div>
        <div class="article-info">
            <span class="type"> {{ articleMain.artType }}</span>
            <span style="margin-right: 5px;">{{ articleMain.cusName }}</span>
            <span>{{ dataTransfer }}</span>
        </div>
        <div class="content" v-html="articleMain.artContent"></div>
        <!--<div class="up-down clear-float">-->
        <!--    <div class="up">-->
        <!--        <img :src='control.art.up' @click="cusLikeArt"/>-->
        <!--        <span>{{ articleMain.artLikeNum }}</span>-->
        <!--    </div>-->
        <!--    <div class="down">-->
        <!--        <img :src="control.art.down" @click="cusDislikeArt"/>-->
        <!--        <span>{{ articleMain.artDislikeNum }}</span>-->
        <!--    </div>-->
        <!--</div>-->
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
        methods: {
            cusLikeArt: function () {
                if (this.control.art.up === require('../../assets/icon/Like.png')) {
                    this.control.art.up = require('../../assets/icon/LikeFill.png');
                    this.control.art.down = require('../../assets/icon/Dislike.png');
                } else {
                    this.control.art.up = require('../../assets/icon/Like.png');
                }
            },
            cusDislikeArt: function () {
                if (this.control.art.down === require('../../assets/icon/Dislike.png')) {
                    this.control.art.down = require('../../assets/icon/DislikeFill.png');
                    this.control.art.up = require('../../assets/icon/Like.png');
                } else {
                    this.control.art.down = require('../../assets/icon/Dislike.png')
                }
            }
        },
        data: function() {
            return {
                control: {
                    art: {
                        up: require('../../assets/icon/Like.png'),
                        down: require('../../assets/icon/Dislike.png'),
                    }
                },
                // likeImg: require('../../assets/icon/Like.png'),
                // dislikeImg: require('../../assets/icon/Dislike.png'),
                // likeImgFill: require('../../assets/icon/LikeFill.png'),
                // dislikeImgFill: require('../../assets/icon/DislikeFill.png'),
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
        margin: 10px;
    }

    .content >>> img {
        text-align: center;
    }

    .content {
        margin-bottom: 30px;
    }

    .up-down {
        width: 200px;
        margin: 0 auto;
        padding: 30px 0px
    }

    .up {
        float: left;
        height: 30px;
        width: 50px;
    }

    .up img {
        height: 30px;
        float: left;
    }

    .up span {
        display: inline-block;
        line-height: 30px;
        font-size: 20px;
        float: right;
    }

    /*.el-icon-success {*/
    /*    margin-right: 10px;*/
    /*}*/

    .down {
        float: right;
        height: 30px;
        width: 50px;
    }

    .down img {
        height: 30px;
        float: left;
    }

    .down span {
        display: inline-block;
        line-height: 30px;
        font-size: 20px;
        float: right;
    }

    /*.el-icon-error {*/
    /*    margin-right: 10px;*/
    /*}*/

    .article-info .type {
        margin-right: 10px;
        border: 1px;
        border-style: solid;
        border-radius: 3px;
        color: darkred;
    }
</style>