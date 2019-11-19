<template>
    <div style="margin-top: 30px">
<!--        <el-input style="width: 200px"></el-input>-->
<!--        <el-button type="primary">+</el-button>-->
        <el-button type="primary" @click="change()">2</el-button>
        <el-table :data="showData" style="width: 600px; margin: 0 auto;">
            <div  v-for="(tag, i) in curTags" :key="i">
                <el-table-column :prop="tag" :label="tag" width="180"></el-table-column>
            </div>
        </el-table>

    </div>
</template>

<script>
export default {

    mounted: function() {

        this.show();
    },
    computed: {

    },
    data: function() {
        return {
            curTags: [],
            showData: [],
            // 最初的数据
            obItem: [
                [
                    {itemName: '姓名', content: 'aaaaa'},
                    {itemName: '性别', content: '男'},
                    {itemName: '年龄', content: '26'},
                    {itemName: '缴费确认', content: 'yes'},
                ], [
                    {itemName: '姓名', content: 'bbbbb'},
                    {itemName: '性别', content: '女'},
                    {itemName: '年龄', content: '27'},
                    {itemName: '缴费确认', content: 'no'},
                ]
            ],
            // 点击 按钮 2 之后, change 方法响应, 用 obItem 替换 obItem
            obItem2: [
                [
                    {itemName: '姓名', content: 'aaaaa'},
                    {itemName: 'hh', content: 'uee'},
                    {itemName: '年龄', content: '26'},
                    {itemName: 'sjs', content: 'cjjd'},
                ], [
                    {itemName: '姓名', content: 'bbbbb'},
                    {itemName: 'hh', content: 'hsd'},
                    {itemName: '年龄', content: '27'},
                    {itemName: 'sjs', content: 'ucxi'},
                ]
            ],
        }
    },
    methods: {
        change: function () {
            this.obItem = this.obItem2;
            this.show();

        },
        show: function () {
            var user = this.obItem[0];
            // 获取 obItem 中的标签列表, 方便表格渲染
            for (var i = 0; i < user.length; i++) {
                this.$set(this.curTags, i, user[i].itemName);
            }
            // 整理数据方便表格渲染
            var newUser = new Object();
            for (var j = 0; j < this.obItem.length; j++) {
                user = this.obItem[j];
                for (i = 0; i < this.curTags.length; i++) {
                    newUser[this.curTags[i]] = user[i].content;
                }
                this.$set(this.showData, j, newUser);
                newUser = new Object();
            }
            // console.log(this.showData);
        }
    },

}
</script>

<style>

</style>
