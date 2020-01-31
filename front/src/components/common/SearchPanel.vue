<template>
    <div class="search">
        <el-input v-model="message" placeholder="请输入内容"></el-input>
        <el-button type="primary" @click="search">{{tip}}</el-button>
    </div>
</template>

<script>
    /**
     * 搜索面板
     *
     * 调用此模块需要实现 search 监听器, 用于获取输入搜索框中的信息
     */
    export default {
        name: "SearchPanel",
        props: ['tip'],
        methods: {
            search: function () {
                this.$emit('search', this.message);
            }
        },
        data: function () {
            return {
                message: '',
            }
        }
    }
</script>

<style scoped>
    .search {
        width: 400px;
        float: left;
        margin-left: 20%;
    }

    .search >>> .el-input {
        width: 300px;
        float: left;
    }

    .search >>> .el-input__inner {
        border-radius: 5px 0px 0px 5px;
        line-height: unset;
    }

    .search >>> .el-button {
        float: left;
        border-radius: 0px 5px 5px 0px;
    }
</style>