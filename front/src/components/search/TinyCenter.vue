<template>
    <div>
        <tiny-article v-for="(tinyArticle, i) in tinyArticles" :key="i" :tinyArticle="tinyArticle"></tiny-article>
        <span class="bottom-tip">我也是有底线哒 ~</span>
    </div>
</template>

<script>
    import TinyArticle from "../common/TinyArticle";
    export default {
        name: "TinyCenter",
        components: {TinyArticle},
        data: function () {
            return {
                tinyArticles: [
                    {   artId: 1, artTitle: "即将开启降温模式",
                        artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                        artTime:"2019-11-25T08:35:55.000+0000", cusName:"光明网",
                        artImage:"http://p1.pstatp.com/large/pgc-image/Reyxsbp6He2NU3"
                    },
                    {   artId: 2, artTitle: "即将开启升温模式",
                        artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                        artTime:"2019-11-25T08:35:55.000+0000", cusName:"光明网",
                        artImage:""
                    },
                ],
            }
        }
    }
</script>

<style scoped>

</style>