<template>
    <div>
        <float-card class="float-card clear-float" v-for="(customerDynamic, i) in customerDynamics" :key="i" >
            <div class="span-div">
                <span class="span-a">{{customerDynamic.cusFrom.cusName}}</span>
                <span class="span-b">{{transBehaviorCodeToWord(customerDynamic.cbrBehavior)}}</span>
            </div>
            <!-- 文章处理 -->
            <div v-if="customerDynamic.cbrType === 1" class="art-han">
                <div class="image" v-if="customerDynamic.article.artImageUrl !== ''">
                    <img :src="customerDynamic.article.artImageUrl" >
                </div>
                <div class="word" :class="[customerDynamic.article.artImageUrl !== '' ? tinyArt : tinyArtWide]">
                    <div class="title" @click="jumpToArticle(customerDynamic.article.artId)">{{ customerDynamic.article.artTitle }}</div>
                    <div class="info">
                        <span class="type">{{ customerDynamic.article.artType}}</span>
                        <span class="customer" @click="jumpToCustomer(customerDynamic.cusTo.cusId)">{{ customerDynamic.cusTo.cusName }}</span>
                        <span>{{ date(customerDynamic.article.artTime) }}</span>
                    </div>
                </div>
            </div>
            <!-- 评论处理 -->
            <div v-if="customerDynamic.cbrType === 2" class="com-han">
                <div class="com clear-float">
                    <div class="title" @click="jumpToArticle(customerDynamic.cbrArtId)">{{ customerDynamic.article.artTitle }}</div>
                    <div class="com-content"  v-html="customerDynamic.comment.comContent"></div>
                    <div class="info">
                        <span class="type">{{ customerDynamic.article.artType}}</span>
                        <span class="customer" @click="jumpToCustomer(customerDynamic.cusTo.cusId)">{{ customerDynamic.cusTo.cusName }}</span>
                        <span>{{ date(customerDynamic.comment.comTime) }}</span>
                    </div>
                </div>
            </div>
            <!-- 回复处理 -->
            <div v-if="customerDynamic.cbrType === 3" class="rep-han">
                <div class="rep clear-float">
                    <div class="title" @click="jumpToArticle(customerDynamic.cbrArtId)">{{ customerDynamic.article.artTitle }}</div>
                    <div class="com-content" v-html="customerDynamic.reply.repContent"></div>
                    <div class="info">
                        <span class="type">{{ customerDynamic.article.artType}}</span>
                        <span class="customer" @click="jumpToCustomer(customerDynamic.cusTo.cusId)">{{ customerDynamic.cusTo.cusName }}</span>
                        <span>{{ date(customerDynamic.reply.repTime) }}</span>
                    </div>
                </div>
            </div>
            <!-- 用户关注 -->
            <div v-if="customerDynamic.cbrType === 0" class="fol-han">
                <div class="name-time">
                    <div class="title" @click="jumpToCustomer(customerDynamic.cusTo.cusId)">{{ customerDynamic.cusTo.cusName }}</div>
                    <div class="info">
                        <span>{{ date(customerDynamic.cbrTime) }}</span>
                    </div>
                </div>
            </div>

        </float-card>>

        <span class="bottom-tip">我也是有底线哒 ~</span>
    </div>
</template>

<script>
    // import TinyArticle from "../common/TinyArticle";
    import {jumpInNewPage} from "../../util/PageJump";
    import {transUTCtoLocal} from "../../util/TimeHandler";
    import FloatCard from "../common/FloatCard";
    export default {
        name: "TinyCenter",
        components: {FloatCard},
        // components: {TinyArticle},
        props: ['customerDynamics', 'ownerCustomer'],
        methods: {
            /**
             * 跳转至文章页面
             * @param artId
             */
            jumpToArticle: function (artId) {
                jumpInNewPage('/article/' + artId);
            },

            /**
             * 跳转至作者用户页面
             * @param cusId
             */
            jumpToCustomer: function (cusId) {
                jumpInNewPage('/self/' + cusId);
            },

            date: function (time) {
                return transUTCtoLocal(time);
            },

            transBehaviorCodeToWord: function (code) {
                if (code === 1) {
                    return '编辑了文章';
                } else if (code === 3) {
                    return '点赞了文章';
                } else if (code === 4) {
                    return '点踩了文章';
                } else if (code === 5 || code === 8) {
                    return '评论了文章';
                } else if (code === 11) {
                    return '关注了用户'
                }
            }
        },
        data: function () {
            return {
                tinyArt: 'tiny-art',
                tinyArtWide: 'tiny-art-wide',
            }
        }
    }
</script>

<style scoped>

    .span-div {
        display: flex;
        height: 40px;
        font-size: 20px;
        color: #008080;
    }

    .span-a {
        margin-right: 10px;
    }

    .span-b {
        /*margin-right: 10px;*/
    }

    .bottom-tip {
        color: #888888;
    }

    .float-card {
        margin-bottom: 15px;
    }

    .image img {
        float: left;
        width: 27%;
        height: 120px;
        margin-right: 3%;
    }

    .word {
        float: left;
        height: 120px;
        position: relative;
    }

    .com {
        float: left;
        /*height: 120px;*/
        position: relative;
    }

    .rep {
        float: left;
        /*height: 120px;*/
        position: relative;
    }

    .tiny-art {
        width: 70%;
    }

    .tiny-art-wide {
        width: 100%;
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
        color: #339999;
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
        bottom: 0;
        color: #888888;
    }

    .info :first-child {
        font-weight: 400;
    }

    .com-han .info {
        text-align: left;
        font-size: 14px;
        position: static;
        /*bottom: 0;*/
        color: #888888;
        margin-top: 10px;
    }

    .rep-han .info {
        text-align: left;
        font-size: 14px;
        position: static;
        /*bottom: 0;*/
        color: #888888;
        margin-top: 10px;
    }

    .fol-han .info {
        text-align: left;
        font-size: 14px;
        position: static;
        /*bottom: 0;*/
        color: #888888;
    }

    .fol-han .title {
        height: 30px;
        line-height: 30px;
        font-size: 18pt;
        overflow: hidden;
        text-align: left;
        margin-bottom: 5px;
        font-weight: 800;
    }


    .customer {
        margin-right: 5px;
    }

    .customer:hover {
        color: #339999;
        cursor: pointer;
    }

    .com-content {
        text-align: left;
        /*height: 30px;*/
        /*overflow: hidden;*/
    }

    .com-content >>> p {
        /*margin: 0px 0 0 0;*/
        margin: 0;
        /*line-height: 30px;*/
    }

    .type {
        margin-right: 10px;
        border: 1px;
        border-style: solid;
        border-radius: 3px;
        color: darkred;
    }
</style>