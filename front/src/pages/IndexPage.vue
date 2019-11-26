<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main>
            <nav>
                <left-navigater :class="{'left-navigater': true}"
                                :tags="tags" :secondaryTags="secondaryTags" :showLast="true"
                                :curIndex="curIndex.toString()"
                                @changecurindex="getCurTinyArticles">
                </left-navigater>
            </nav>
            <article class="article-a">
                <div  v-for="(item, i) in articles" :key="i">
                    <tiny-article class="tiny-article"
                                  :title="item.artTitle" :abstract="item.artAbstract" :image="item.artImage"
                                  :author="item.cusName" :date="item.artTime" :artId="item.artId">
                    </tiny-article>
                </div>
            </article>
            <aside>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article class="hot-article" :hotArticles='hotArticles'></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// index
// common components
import EditEntrance from '@/components/common/EditEntrance'
import HotArticle from '@/components/common/HotArticle'
import LeftNavigater from '@/components/common/LeftNavigater'
import TinyArticle from '@/components/common/TinyArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'IndexPage',
    components: { EditEntrance, HotArticle, LeftNavigater, TinyArticle, TopBar },
    created: function() {
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
            this.$axios.get('/api/index/tags?').then(
                (response) => {
                    let border = 10;
                    this.tags = response.data.slice(0, border);
                    this.tags.push('更多');
                    this.secondaryTags = response.data.slice(border);
                    // 在初始化标签的之后, 异步加载文章;
                    this.getTinyArticles(this.curIndex, this.type);
                    console.log(response.data)
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
            } else if (type === 1) {
                let firTag = this.tags[this.tags.length - 2];
                let secTag = this.secondaryTags[curIndex];

                this.$set(this.tags, this.tags.splice(this.tags.length - 2, 1, secTag));
                this.$set(this.secondaryTags, this.secondaryTags.splice(curIndex, 1, firTag));

                curIndex = this.tags.length - 2;
                type = 0;
                this.curTag = this.tags[curIndex];
            } else {
                this.curTag = '综合';
            }

            this.page = 0;
            this.curIndex = curIndex;
            this.type = type;
            this.getTinyArticles()
        },

        /**
         * 获取一次 tiny article 的数据
         * 只要 this.curTag 不发生变化, 就可以直接使用此方法
         */
        getTinyArticles: function() {
            this.$axios.get('/api/index/tiny?', {params: {tag: this.curTag, page: this.page, pageSize: this.pageSize}}).then(
                (response) => {
                    console.log(response.data);
                    let articles = response.data;
                    // articles.forEach(
                    //     (item, index, array) => {
                    //         let time = item['artTime'];
                    //         item['artTime'] = new Date(Date.parse(time)).toLocaleDateString();
                    //     }
                    // );
                    // 文章加载
                    if (this.page === 0) {
                        this.articles = articles;
                    } else {
                        this.articles = this.articles.concat(articles);
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


        }

    },
    data: function() {
        return {
            // page: 当前用户浏览的页数, 使用 this.getTinyArticles 前需要正确赋值;
            page: 0,
            // pageSize: 每次请求的文章数量, 使用 this.getTinyArticles 前需要正确赋值;
            pageSize: 10,
            // type: 返回的菜单标签是属于 this.tags (0) 还是 this.secondaryTags (1)
            type: 0,
            // curIndex: 返回的菜单标签下标
            curIndex: 0,
            // curTag: 当前标签名称, 使用 this.getTinyArticles 前需要正确赋值;
            curTag: '综合',

            articles: [
                {   artId: 1, artTitle: "即将开启降温模式",
                    artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                    artTime:"2019-11-25T08:35:55.000+0000", cusName:"光明网",
                    artImage:"http://p1.pstatp.com/large/pgc-image/Reyxsbp6He2NU3"
                },
            ],

            tags: ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'],
            secondaryTags: ['a', 'jj', 'ee', 'eek', 'e', 'kko','sd'],
            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ]
        }
    },

}
</script>

<style>

.tiny-article {
    margin-bottom: 10px;
}

.edit-entrance {
    background-color: #238493;
    margin-bottom: 10px;
}

.hot-article {
    background-color: #910383;
}

</style>
