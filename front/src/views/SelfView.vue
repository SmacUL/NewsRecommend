<template>
    <div>
        <header><top-bar class="top-bar" :customer="customer"></top-bar></header>

        <main>
            <!-- section 1 包含 用户的个人信息-->
            <section>
                <show-panel :customer="ownerCustomer" :visitor="customer" :is-follow="control.isFollow"></show-panel>
            </section>
            <!-- section 2 包含 左右两个部分, 左侧是用户自己的文章, 右侧是用户成就-->
            <section class="clear-float section-main">
                <article class="self-view-article">
                    <tiny-center :ownerCustomer="ownerCustomer" :customerDynamics="customerDynamics"></tiny-center>
                </article>
                <aside :style="asideStyle" class="self-view-aside">
                    <right-menu :info="cusCountInfo"></right-menu>
                </aside>
            </section>
        </main>
    </div>
</template>

<script>
    import TopBar from "../components/self/TopBar";
    import ShowPanel from "../components/self/EditorMain";
    import TinyCenter from "../components/self/TinyCenter"
    import RightMenu from "../components/self/RightMenu";
    import {checkCusFollow, getCusBasicInfo, getCusFeatureInfo, getCusSelfDynamic} from "../control/Self";
    import {jumpInCurPage} from "../util/PageJump";
    export default {
        name: "SelfView",
        components: {RightMenu, TinyCenter, ShowPanel, TopBar},
        mounted: function() {
            window.addEventListener('scroll', this.scrollHandler, false);
            let cusId = this.$route.params.cusId;
            getCusBasicInfo(0)
                .then((response) => {
                    if (response.data) {
                        this.customer = response.data;
                    } else {
                        jumpInCurPage('/port');
                    }
                });
            getCusBasicInfo(cusId)
                .then((response) => {
                    this.ownerCustomer = response.data;
                })
                .then(() => {
                checkCusFollow(this.ownerCustomer.cusId)
                    .then((response) => {
                        this.control.isFollow = response.data;
                    })
            });
            getCusFeatureInfo(cusId)
                .then((response) => {
                    this.cusCountInfo = response.data;
                });
            getCusSelfDynamic(cusId, 0, 10)
                .then((response) => {
                    this.customerDynamics = response.data;
                });


        },
        methods: {
            scrollHandler: function () {
                // 侧面栏目悬停
                let scrollDis = document.documentElement.scrollTop || document.body.scrollTop || window.pageYOffset || 0;
                if (scrollDis > 192) {
                    this.asideStyle = 'margin-top: 0px';
                } else {
                    this.asideStyle = 'position: static;';
                }
                // 滚动加载
                let artHeight = document.getElementsByTagName('article')[0].offsetHeight;
                let innerHeight = window.innerHeight;
                let otherHeight = 70 + 182 + 10;
                let scrollHeight = artHeight - innerHeight + otherHeight;
                if (scrollHeight <= (document.documentElement.scrollTop + 5)) {
                    this.control.dnyPage += 1;
                    getCusSelfDynamic(this.cusId, this.control.dnyPage, this.control.dnyPageSize)
                        .then((response) => {
                            // this.customerDynamics = response.data;
                            for (let i = 0; i < response.data.length; i++) {
                                this.customerDynamics.push(response.data[i]);
                            }
                        });
                }
            }
        },
        data: function () {
            return {
                asideStyle: 'position: static',
                control: {
                    dnyPage: 0,
                    dnyPageSize: 10,
                    isFollow: false
                },
                cusId: this.$route.params.cusId,
                customer: {

                },
                ownerCustomer: {

                },
                cusCountInfo: {

                },
                customerDynamics: {

                }
            }
        }
    }
</script>

<style scoped src="../assets/css/Narrow.css"></style>
<style scoped>
    .section-main {
        margin-top: 10px;
    }

    .self-view-article {
        float: left;
    }
    
    .self-view-aside {

    }
</style>