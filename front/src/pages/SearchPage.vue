<template>
    <div>
        <header><top-bar class="top-bar" @search="searchArticles" :message="message"></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main>
            <nav>
                <left-navigater :class="{'left-navigater': true}"
                                :tags="tags" :secondaryTags="secondaryTags" :showLast="false"
                                :curIndex="curIndex.toString()"
                                @changecurindex="getCurTinyArticles">
                </left-navigater>
            </nav>
            <article class="article-a">
                <div  v-for="(tinyArticle, i) in tinyArticles" :key="i">
                    <!--<tiny-article class="tiny-article" :item="item"></tiny-article>-->
                    <tiny-article class="tiny-article" :tinyArticle="tinyArticle"
                                  @jump="jumpToArticle" @editor="jumpToCustomer">
                    </tiny-article>
                </div>
                <div v-if="tinyArticles.length === 0">uh 不爽吧</div>
            </article>
            <aside>
                <hot-article class="hot-article" :hotArticles='hotArticles' :title="'热点新闻'"
                             @refresh="getHotArticles" @jump="dumpToArticle">
                </hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// search
// common
import HotArticle from '@/components/common/HotArticle'
import LeftNavigater from '@/components/common/LeftNavigater'
import TinyArticle from '@/components/common/TinyArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'SearchPage',
    components: { HotArticle, LeftNavigater, TinyArticle, TopBar },
    created: function() {
        this.message = this.$route.params.input;
        // alert(this.message);
        this.getLeftNavTags();
    },
    mounted: function() {
        window.addEventListener('scroll', this.scrollHandler, false);
    },
    methods: {
        /**
         * 获取左侧导航栏需要的标签
         */
        getLeftNavTags: function() {
            this.$axios.get('/api/search/tags?').then(
                (response) => {
                    this.tags = response.data;
                    this.tags.push('');
                    // 在初始化标签的之后, 异步加载文章 getCurTinyArticles;
                    this.getCurTinyArticles(this.curIndex, this.type);
                    this.getHotArticles();
                    // console.log(response.data)
                }
            ).catch(
                (response) => {
                    console.log(response)
                }
            )
        },

        /**
         * 标签切换时, 对必要数据进行修改
         * @Param curIndex 子组件传回的标签索引
         * @Param type 子组件传回的标签类别
         */
        getCurTinyArticles: function(curIndex, type) {
            if (type === 0) {
                this.curTag = this.tags[curIndex];
            } else {
                this.curTag = '综合';
            }

            this.page = 0;
            this.curIndex = curIndex;
            this.type = type;
            this.getTinyArticles();
            window.scrollTo(0, 0);
        },

        /**
         * 获取一次 tiny article 的数据
         * 只要 this.curTag 不发生变化, 就可以直接使用此方法
         */
        getTinyArticles: function() {
            this.$axios.get('/api/search/tiny?', {params: {tag: this.curTag, key: this.message, page: this.page, pageSize: this.pageSize}}).then(
                (response) => {
                    console.log(response.data);
                    let tinyArticles = response.data;
                    // 文章加载
                    if (this.page === 0) {
                        this.tinyArticles = tinyArticles;
                    } else {
                        this.tinyArticles = this.tinyArticles.concat(tinyArticles);
                    }
                    this.page += 1;
                }
            ).catch(
                (response) => {
                    console.log(response)
                }
            )
        },

        /**
         * 提供右侧的热点文章
         */
        getHotArticles: function() {
            this.$axios.get('/api/search/hot?', {params: {page: this.hotPage, pageSize: this.hotPageSize}}).then(
                (response) => {
                    console.log(response.data);
                    this.hotArticles =  response.data;
                    this.hotPage += 1;
                }
            ).catch(
                (response) => {
                    console.log(response)
                }
            )
        },

        /**
         * 当用户浏览到页面底部时, 弹出新的文章
         *
         * 当 main 的相对移动距离 >= main 的总高度 - (网页显示高度 - top bar 的高度) 认为浏览到底部
         * 计算距离的时候 考虑 margin
         */
        scrollHandler: function () {
            //
            let mainE = document.getElementsByTagName('main')[0];
            let topE = document.getElementsByTagName('header')[0];

            let mainEHeight = mainE.clientHeight;
            let topEHeight = topE.clientHeight;
            let browserHeight = document.documentElement.clientHeight || window.innerHeight || 0;
            let scrollHeight = document.documentElement.scrollTop || document.body.scrollTop || window.pageYOffset || 0;

            // 第一个 10 是 main 的 margin-bottom, 第二个 10 是 header 的 margin-bottom
            if (scrollHeight - 10 >= mainEHeight - (browserHeight - topEHeight - 10)) {
                this.getTinyArticles();
            }
        },

        /**
         * 跳转到指定 id 的文章页面
         *
         * @Param: artId
         */
        jumpToArticle: function(artId) {
            let routeData = this.$router.resolve({ name: 'ArticlePage', params: {'artid': artId.toString()} });
            window.open(routeData.href, '_blank');
        },

        /**
         * 跳转到指定 文章 的用户中心
         *
         * @Param: artId
         */
        jumpToCustomer: function(artId) {
            let routeData = this.$router.resolve({ name: 'SelfPage', params: {'type':'art', 'id': artId.toString()} });
            window.open(routeData.href, '_blank');
        },

        searchArticles: function(message) {
            if (message === '') {
                message = '哈哈';
            }
            // let routeData = this.$router.resolve({ name: 'SearchPage', params: {'input': message} });
            // window.open(routeData.href, '_blank');
            this.$router.push({ name: 'SearchPage', params: {'input': message} });
        }
    },
    data: function () {
        return {
            // page: 当前用户浏览的页数, 使用 this.getTinyArticles 前需要正确赋值;
            page: 0,
            // pageSize: 每次请求的文章数量, 使用 this.getTinyArticles 前需要正确赋值;
            pageSize: 10,

            hotPage: 0,
            hotPageSize: 6,


            // type: 返回的菜单标签是属于 this.tags (0) 还是 this.secondaryTags (1)
            type: 0,
            // curIndex: 返回的菜单标签下标
            curIndex: 0,
            // curTag: 当前标签名称, 使用 this.getTinyArticles 前需要正确赋值;
            curTag: '综合',

            message: '',

            tags: ['综合', '文章', '用户'],
            secondaryTags: [],

            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ],
            tinyArticles: [
                {   artId: 1, artTitle: "即将开启降温模式",
                    artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                    artTime:"2019-11-25T08:35:55.000+0000", cusName:"光明网",
                    artImage:"http://p1.pstatp.com/large/pgc-image/Reyxsbp6He2NU3"
                },
            ],
        }
    }
}
</script>

<style scoped>

    /* uh 不爽吧 那几个字 */
    article div:nth-of-type(-1) {
        font-size: 20px; padding-top: 50px;
    }

</style>
