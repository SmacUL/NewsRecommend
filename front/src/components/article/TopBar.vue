<template>
    <div class="clear-float">
        <div class="body-image" v-on:click="jumpToIndex">
            <img src="@/assets/image/Logo.png"/>
        </div>
        <search-panel :tip="tip"  v-on:search="searchArticles"></search-panel>
        <div class="manage">
            <img v-if="customer.cusAvatarUrl !== ''" :src="customer.cusAvatarUrl" v-on:click="jumpToSelf"/>
            <img v-if="customer.cusAvatarUrl === ''" :src="manSrc" v-on:click="jumpToSelf"/>
            <el-button type="text" @click="loginOut">退出登录</el-button>
        </div>
    </div>
</template>

<script>
    import SearchPanel from '../common/SearchPanel'
    import Man from '../../assets/image/Man.png'
    import {jumpInCurPage, jumpInNewPage} from "../../util/PageJump";
    import {quitLogin} from "../../control/Self";

    export default {
        name: 'TopBar',
        props: ['message', 'customer'],
        components: {SearchPanel},
        methods: {
            jumpToIndex: function() {
                jumpInCurPage('/index/');
            },
            jumpToSelf: function() {
                jumpInNewPage('/self/' + this.customer.cusId)
            },
            searchArticles: function (message) {
                jumpInNewPage('/search/' + message )
                // searchContentByKeyAndTagTypePage(message, 'global', 'test', 0, 10)
            },
            loginOut: function () {
                quitLogin()
                    .then((response) => {
                        if (response.data === '退出成功') {
                            this.$router.push({path: '/port'});
                        }
                    })
            }
        },
        data: function() {
            return {
                tip: '搜索',
                manSrc: Man,
            }
        }
    }
</script>

<style scoped>


    .body-image {
        float: left;
        height: 40px;
        margin-top: 5px;
    }

    .body-image img {
        height: 30px;
        width: 130px;
    }

    .manage {
        float: right;
        height: 40px;
        padding-top: 5px;
    }

    .manage >>> .el-button {
        font-size: 16px;
        height: 40px;
        float: right;
    }

    .manage img {
        width: 30px;
        height: 30px;
        /*padding: 5px 10px;*/
        margin-right: 5px;
    }

</style>
