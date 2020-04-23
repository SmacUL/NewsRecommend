<template>
    <div>
        <header><top-bar class="top-bar" :customer="customer"></top-bar></header>
        <main>
            <article>
                <tiny-article v-for="(tinyArticle, i) in tinyArticles" :key="i" :tinyArticle="tinyArticle"
                              v-on:jump="jumpToArticle" v-on:editor="jumpToCustomer"></tiny-article>
            </article>
            <aside>
                <!--<right-menu></right-menu>-->
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article :title="page.hotTitle" :hot-articles="hotArticles"
                             v-on:refresh="refreshHot" v-on:jump="jumpToArticle"></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
    import TopBar from "../components/search/TopBar";
    // import TinyCenter from "../components/search/TinyCenter";
    import EditEntrance from "../components/common/EditEntrance";
    import HotArticle from "../components/common/HotArticle";
    import TinyArticle from "../components/common/TinyArticle";
    // import RightMenu from "../components/index/RightMenu";

    import Logo from '../assets/image/Logo.png'
    import {getHotArtOnePage} from "../control/Load";
    import {searchContentSimple} from "../control/Search";
    import {getCusBasicInfo} from "../control/Self";
    import {jumpInCurPage, jumpInNewPage} from "../util/PageJump";


    export default {
        name: "SearchView",
        components: {TinyArticle, HotArticle, EditEntrance, TopBar},
        mounted: function () {
            window.addEventListener('scroll', this.getMoreTinyArt, false);
            let key = this.$route.params.key;
            searchContentSimple(key, this.page.tinyPage, this.page.tinyPageSize)
                .then((response) => {
                   this.tinyArticles = response.data;
                });
            getCusBasicInfo(0)
                .then((response) => {
                    if (response.data) {
                        this.customer = response.data;
                    } else {
                        jumpInCurPage('/port');
                    }

                });
            getHotArtOnePage(this.page.hotPage, this.page.hotPageSize)
                .then((response) => {
                    this.hotArticles = response.data;
                });
            window.scrollTo(0, 0);
        },
        methods: {
            getMoreTinyArt: function () {
                let artHeight = document.getElementsByTagName('article')[0].offsetHeight;
                let innerHeight = window.innerHeight;
                let otherHeight = 70 + 15;
                let scrollHeight = artHeight - innerHeight + otherHeight;
                if (scrollHeight <= (document.documentElement.scrollTop + 5)) {
                    this.page.tinyPage += 1;
                    // let key = this.$route.params.key;
                    searchContentSimple(this.page.key, this.page.tinyPage, this.page.tinyPageSize)
                        .then((response) => {
                            for (let i = 0; i < response.data.length; i++) {
                                this.tinyArticles.push(response.data[i]);
                            }
                        })
                }
            },

            refreshHot: function () {
                if (this.page.hotPage > 3) {
                    this.page.hotPage = 0;
                } else {
                    this.page.hotPage += 1;
                }
                getHotArtOnePage(this.page.hotPage, this.page.hotPageSize)
                    .then((response) => {
                        this.hotArticles = response.data;
                    })
                    .catch(() => {
                        this.$message.info("抱歉, 发生了点故障");
                    });
            },
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
            }
        },
        data: function () {
            return {
                page: {
                    // menuCurIndex: 0,
                    // menuMajorLen: 8,
                    // menuTip: '更多',
                    tinyPage: 0,
                    tinyPageSize: 10,
                    hotTitle: '热点新闻',
                    hotPage: 0,
                    hotPageSize: 6,
                    key: this.$route.params.key
                },
                tinyArticles: [

                ],
                hotArticles: [
                    { artId: '1', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    { artId: '2', artTitle: 'This is the template title of news', artImageUrl: ''},
                    { artId: '3', artTitle: 'This is the template title of news', artImageUrl: ''},
                    { artId: '4', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    { artId: '5', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    { artId: '6', artTitle: 'This is the template title of news', artImageUrl: Logo},
                ],
                customer: {

                },

            }
        }
    }
</script>

<style scoped src="../assets/css/Narrow.css"></style>
<style scoped>
    .edit-entrance {
        margin-bottom: 10px;
    }

</style>