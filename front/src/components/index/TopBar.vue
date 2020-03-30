<template>
    <div class="clear-float">
        <div class="body-image">
            <img src="@/assets/image/Logo.png"/>
        </div>
        <search-panel :tip="tip"  v-on:search="searchArticles"></search-panel>
        <div class="manage">
            <img v-if="customer.cusAvatarUrl !== ''" :src="customer.cusAvatarUrl"/>
            <img v-if="customer.cusAvatarUrl === ''" :src="manSrc"/>
            <el-button type="text" @click="loginOut">退出登录</el-button>
        </div>
    </div>
</template>

<script>
    import SearchPanel from '../common/SearchPanel'

    import Man from '../../assets/image/Man.png'

    export default {
        name: 'TopBar',
        props: ['customer'],
        components: {SearchPanel},
        methods: {
            searchArticles: function () {
                this.$axios.get('/api/index/test')
                    .then((response) => {
                        this.$message.info(response);
                    })
                    .catch((response) => {
                        this.$message.info(response);
                    })
            },
            loginOut: function () {
                this.$router.push({path: '/port'});
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
    }

    .manage >>> .el-button {
        font-size: 16px;
        height: 40px;
        float: right;
    }

    .manage img {
        width: 30px;
        height: 30px;
        padding: 5px 10px;
    }

    /*.manage .el-button {*/
    /*    height: 40px;*/
    /*    display: inline-block;*/
    /*}*/

</style>
