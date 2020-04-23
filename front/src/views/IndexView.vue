<template>
    <div>
        <header>
            <top-bar class="top-bar" :customer="customer"></top-bar>
        </header>
        <main>
            <nav>
                <left-menu :curIndex="page.menuCurIndex" :majorLength="page.menuMajorLen" :tip="page.menuTip"
                                 :artClassList="artTypes" v-on:changeCurIndex="changeCurIndex"></left-menu>
            </nav>
            <article>
                <tiny-article v-for="(tinyArticle, i) in tinyArticles" :key="i" :tinyArticle="tinyArticle"
                              v-on:jump="jumpToArticle" v-on:editor="jumpToCustomer"></tiny-article>
            </article>
            <aside>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article :title="page.hotTitle" :hot-articles="hotArticles"
                             v-on:refresh="refreshHot" v-on:jump="jumpToArticle"></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
    import TopBar from '../components/index/TopBar'
    import LeftMenu from "../components/index/LeftMenu"
    import TinyArticle from '../components/common/TinyArticle'
    import EditEntrance from "../components/common/EditEntrance";
    import HotArticle from "../components/common/HotArticle";

    import Logo from '../assets/image/Logo.png'
    import {getArtTypes, getHotArtOnePage, getTinyArtOnePageByType} from "../control/Load";
    import {getCusBasicInfo} from "../control/Self";
    import {jumpInCurPage, jumpInNewPage} from "../util/PageJump";

    export default {
        name: 'IndexView',
        components: {HotArticle, EditEntrance, TinyArticle, TopBar, LeftMenu},
        mounted: function () {
            window.addEventListener('scroll', this.getMoreTinyArt, false);
            getCusBasicInfo(0)
                .then((response) => {
                    if (response.data) {
                        this.customer = response.data;
                    } else {
                        // this.$router.push({path: '/port'});
                        jumpInCurPage('/port');
                    }

                });
            getArtTypes()
                .then((response) => {
                    this.artTypes = response.data;
                })
                .then(() => {
                    getTinyArtOnePageByType('综合', this.page.tinyPage, this.page.tinyPageSize)
                        .then((response) => {
                            this.tinyArticles = response.data;
                        });
                    getHotArtOnePage(this.page.hotPage, this.page.hotPageSize)
                        .then((response) => {
                            this.hotArticles = response.data;
                        });
                });
            window.scrollTo(0, 0);
        },
        methods: {
            /**
             * 如果选中的类别超过了 this.leftMenu.majorLength 的限制, 即属于二级类别,
             * 则调换 选中的类别 与 一级类别中最后一个类别 在数组中的位置.
             *
             * @param index 选中的类别下标
             */
            changeCurIndex: function (index) {
                if (index >= this.page.menuMajorLen) {
                    this.page.menuCurIndex = this.page.menuMajorLen - 1;
                    let median = this.artTypes[this.page.menuMajorLen - 1];
                    this.artTypes[this.page.menuMajorLen - 1] = this.artTypes[index];
                    this.artTypes[index] = median;
                } else {
                    this.page.menuCurIndex = index;
                }

                this.page.tinyPage = 0;
                    getTinyArtOnePageByType(this.artTypes[this.page.menuCurIndex], this.page.tinyPage, this.page.tinyPageSize)
                    .then((response) => {
                        this.tinyArticles = response.data;
                    });
                window.scrollTo(0,0);
            },

            /**
             * 刷新热点新闻
             */
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

            getMoreTinyArt: function () {
                let artHeight = document.getElementsByTagName('article')[0].offsetHeight;
                let innerHeight = window.innerHeight;
                let otherHeight = 70 + 15;
                let scrollHeight = artHeight - innerHeight + otherHeight;
                if (scrollHeight <= (document.documentElement.scrollTop + 5)) {
                    this.page.tinyPage += 1;
                    getTinyArtOnePageByType(this.artTypes[this.page.menuCurIndex], this.page.tinyPage, this.page.tinyPageSize)
                        .then((response) => {
                            for (let i = 0; i < response.data.length; i++) {
                                this.tinyArticles.push(response.data[i]);
                            }
                        })
                }
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
                // 记录页面控制信息
                page: {
                    menuCurIndex: 0,
                    menuMajorLen: 8,
                    menuTip: '更多',
                    tinyPage: 0,
                    tinyPageSize: 10,
                    hotTitle: '热点新闻',
                    hotPage: 0,
                    hotPageSize: 6
                },
                artTypes: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'],
                tinyArticles: [
                    {   artId: 1, artTitle: "即将开启降温模式",
                        artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                        artTime:"2019-11-25T08:35:55.000+0000",
                        artImage:"http://p1.pstatp.com/large/pgc-image/Reyxsbp6He2NU3",
                        customer: {
                            cusName:"光明网",
                        }
                    },
                    {   artId: 2, artTitle: "即将开启升温模式",
                        artAbstract:"降温降雨天气预报预计今晚到明天我州东北部地区阴天普遍有小雨，高山有雨夹雪和大雾，日平均气温下降4～6℃；州西南部晴转多云，局地间有阴天和零星小雨，气温下降2～4℃。请注意相关防御措施。未来24小时内，各县最低气温1℃～10℃，最高气温10～22℃。",
                        artTime:"2019-11-25T08:35:55.000+0000",
                        artImage:"",
                        customer: {
                            cusName:"光明网",
                        }
                    },
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

                }
            }
        }
    }
</script>


<style scoped src="../assets/css/Normal.css"></style>
<style scoped>
    /*.bottom-tip {*/
    /*    color: #888888;*/
    /*}*/
    .edit-entrance {
        margin-bottom: 10px;
    }
</style>