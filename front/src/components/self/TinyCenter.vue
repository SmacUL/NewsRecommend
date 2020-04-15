<template>
    <div>
        <float-card class="float-card clear-float" v-for="(CustomerDynamic, i) in CustomerDynamics" :key="i" >
            <div class="span-div">
                <span class="span-a">{{ownerCustomer.cusName}}</span>
                <span class="span-b">{{transBehaviorCodeToWord(CustomerDynamic.acbBehavior)}}</span>
                <!--<span class="span-c">此文章</span>-->
            </div>
            <!--<tiny-article :tinyArticle="CustomerDynamic.artWithCus" v-on:jump="jumpToArticle" v-on:editor="jumpToCustomer"></tiny-article>-->
            <div>
                <div class="image" v-if="CustomerDynamic.artWithCus.artImageUrl !== ''">
                    <img :src="CustomerDynamic.artWithCus.artImageUrl" >
                </div>
                <div class="word" :class="[wideSwitch ? tinyArt : tinyArtWide]">
                    <div class="title" @click="jumpToArticle(CustomerDynamic.artWithCus.artId)">{{ CustomerDynamic.artWithCus.artTitle }}</div>
                    <div class="info">
                        <span class="customer" @click="jumpToCustomer(CustomerDynamic.artWithCus.customer.cusId)">{{ CustomerDynamic.artWithCus.customer.cusName }}</span>
                        <span>{{ date(CustomerDynamic.artWithCus.artTime) }}</span>
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
        props: ['CustomerDynamics', 'ownerCustomer'],
        methods: {
            /**
             * 跳转至文章页面
             * @param artId
             */
            jumpToArticle: function (artId) {
                // this.$router.push('/article/' + artId)
                jumpInNewPage('/article/' + artId);
            },

            /**
             * 跳转至作者用户页面
             * @param cusId
             */
            jumpToCustomer: function (cusId) {
                // this.$router.push('/self/' + cusId);
                jumpInNewPage('/self/' + cusId);
            },

            date: function (time) {
                return transUTCtoLocal(time);
            },

            transBehaviorCodeToWord: function (code) {
                if (code === 1) {
                    return '编辑了';
                } else if (code === 2) {
                    return '点赞了';
                } else if (code === 3) {
                    return '点踩了';
                } else if (code === 4) {
                    return '评论了';
                } else if (code === 5) {
                    return '回复了';
                } else if (code === 6) {
                    return '浏览了';
                }
            }
        },
        data: function () {
            return {
                // tinyArticles: [
                //     {   artId: 1, artTitle: "即将开启降温模式",
                //         artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                //         artTime:"2019-11-25T08:35:55.000+0000", cusName:"光明网",
                //         artImage:"http://p1.pstatp.com/large/pgc-image/Reyxsbp6He2NU3"
                //     },
                //     {   artId: 2, artTitle: "即将开启升温模式",
                //         artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                //         artTime:"2019-11-25T08:35:55.000+0000", cusName:"光明网",
                //         artImage:""
                //     },
                // ],
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

    .customer {
        margin-right: 5px;
    }

    .customer:hover {
        color: #339999;
        cursor: pointer;
    }
</style>