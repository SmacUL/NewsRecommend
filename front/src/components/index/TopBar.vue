<template>
    <div class="clear-float">
        <div class="body-image">
            <img src="@/assets/image/Logo.png"/>
        </div>
        <search-panel :tip="tip"  v-on:search="searchArticles"></search-panel>
        <div class="manage">
            <el-button type="text">登录</el-button>
            <el-button type="text">注册</el-button>
        </div>
    </div>
</template>

<script>
    import SearchPanel from '../common/SearchPanel'

    export default {
        name: 'TopBar',
        props: ['message'],
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
            }
        },
        data: function() {
            return {
                tip: '搜索'
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
    }

    .manage >>> .el-button {
        font-size: 18px;
    }

</style>
