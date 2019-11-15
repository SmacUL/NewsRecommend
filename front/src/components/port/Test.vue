<template>
    <div style="margin-top: 30px">
        <el-input v-model="input" style="width: 200px"></el-input>
        <el-button type="primary" @click="response()">+</el-button>
        <el-button type="primary">2</el-button>

        <el-table :data="tableData" style="width: 600px; margin: 0 auto;">
            <el-table-column prop="date" label="日期" width="180"></el-table-column>
            <el-table-column prop="name" label="姓名" width="180"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
        </el-table>

    </div>
</template>

<script>
export default {
    data() {
        return {
            input:'',
            // 行
            rowCounter: 0,
            // 列
            colCounter: 0,
            // 属性
            // menu: ['date', 'name', 'address'],
            tableData: [],
            oriData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀sdsf区金沙江路 1518 弄'
            }, {
                date: '2016-054444-04',
                name: '王虎',
                address: '上海市江路 1517 弄'
            }, {
                date: '2034446-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }, {
                date: '22222222226-05-03',
                name: '王sdf虎',
                address: '上海市普陀区金沙江路 12883883 弄'
            }]
        }
    },
    methods: {
        response: function() {
            // 获得老数据
            // 放入新数组中
            //      每到 2 的时候添加一行
            //      每次对象为空时 添加新的对象
            // this.rowCounter = 0; 行
            // this.colCounter = 0; 列

            var oldObj = this.oriData[this.rowCounter];
            var oldAtt = Object.keys(oldObj)[this.colCounter];
            var oldVal = oldObj[oldAtt];

            console.log(oldObj);

            var newObj = this.tableData[this.rowCounter];
            if (this.colCounter == 0) {
                newObj = {};
                newObj[oldAtt] = oldVal;
                this.tableData.push(newObj);
            } else {
                newObj[oldAtt] = oldVal;
                // this.$set(this.tableData[this.rowCounter], oldAtt, oldVal);
                this.tableData.pop();
                this.tableData.push(newObj);
            }

            if (this.colCounter == 2) {
                this.rowCounter ++;
                this.colCounter = 0;
            } else {
                this.colCounter ++;
            }
        }
    },

}
</script>

<style>

</style>