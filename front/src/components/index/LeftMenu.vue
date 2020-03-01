<template>
    <left-menu-inner :curIndex="leftMenu.curIndex" :majorLength="leftMenu.majorLength" :tip="leftMenu.tip" :artClassList="leftMenu.artClassList" v-on:changeCurIndex="changeCurIndex"></left-menu-inner>
</template>

<script>
    /**
     * 类别菜单
     */
    import LeftMenuInner from "./LeftMenuInner";
    import {translator} from "../../util/ClassTransfer"
    export default {
        components: {LeftMenuInner},
        name: "LeftMenu",
        computed: {

        },
        mounted: function () {
            this.getLeftMenu();
        },
        methods: {
            /**
             * 如果选中的类别超过了 this.leftMenu.majorLength 的限制, 即属于二级类别,
             * 则调换 选中的类别 与 一级类别中最后一个类别 在数组中的位置.
             *
             * @param index 选中的类别下标
             */
            changeCurIndex: function (index) {
               if (index >= this.leftMenu.majorLength) {
                   this.leftMenu.curIndex = this.leftMenu.majorLength - 1;
                   let median = this.leftMenu.artClassList[this.leftMenu.majorLength - 1];
                   this.leftMenu.artClassList[this.leftMenu.majorLength - 1] = this.leftMenu.artClassList[index];
                   this.leftMenu.artClassList[index] = median;
               } else {
                   this.leftMenu.curIndex = index;
               }
            },


            getLeftMenu() {
                this.$axios.get('/api/index/classes')
                    .then((response) => {
                        this.leftMenu.artClassList = translator(response.data);
                    })
                    .catch(() => {
                        this.$message.info("抱歉, 发生了点故障");
                    });
            },
        },
        data: function() {
            return {
                leftMenu: {
                    curIndex: 0,
                    majorLength: 8,
                    tip: '更多',
                    artClassList: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'],
                },

            }
        },
    };
</script>

<style scoped>

</style>
