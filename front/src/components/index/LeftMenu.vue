<template>
    <el-menu :default-active="curIndex.toString()" class="el-menu-vertical-demo">
        <el-menu-item v-for="(artClass, i) in artClassList.slice(0, majorLength)" :key="i" :index="i.toString()" v-on:click="changeCurIndex(i)">
            <span slot="title">{{artClass}}</span>
        </el-menu-item>

        <!-- 二级 种类入口 -->
        <el-menu-item class="more-class" v-if="artClassList.length > majorLength">
            <span @mouseenter="showPanel(true)" @mouseleave="showPanel(false)">{{tip}}</span>
            <div class="more-panel" v-show="panel" @mouseenter="showPanel(true)" @mouseleave="showPanel(false)">
                <div v-for="(lineNum, lineIndex) in Math.ceil((artClassList.length - majorLength) / buttonNum)" :key="lineIndex">
                    <el-button type="primary"
                               v-for="(artClass, i) in artClassList.slice(majorLength + lineIndex * buttonNum, majorLength + lineIndex * buttonNum + buttonNum)"
                               :key="i" v-on:click="changeCurIndex(majorLength + lineIndex * buttonNum + i)">
                        {{artClass}}
                    </el-button>
                </div>
            </div>
        </el-menu-item>

    </el-menu>
</template>

<script>
    /**
     * 类别菜单, 是 LeftMenu 的唯一子组件, 负责内容展示.
     *
     * 若调用此模块, 需要实现 changeCurIndex 监听器, 用于获取被选中的种类索引.
     */
    export default {
        props: ['curIndex', 'majorLength', 'tip', 'artClassList'],
        name: "LeftMenuInner",
        methods: {
            /**
             * 修改当前选中的种类, 并通知上级组件
             * @param index
             */
            changeCurIndex: function(index) {
                this.$emit('changeCurIndex', index);
                this.showPanel(false)
            },

            /**
             * 鼠标划入或划出二级标签入口以及二级标签时, 弹出或收回二级标签面板
             * @param bool
             */
            showPanel: function(bool) {
                this.panel = bool;
            }
        },
        data: function() {
            return {
                // panel 将决定是否显示二级标签版
                panel: false,
                // buttonNum: 二级标签面板中, 每一行的按钮数
                buttonNum: 4,
            }
        },
    }
</script>

<style scoped>
    .el-menu {
        border: none;
    }

    .el-menu-item {
        border-radius: 5px;
        margin-bottom: 5px;
        font-size: 16px;
        font-weight: 500;
        line-height: 40px;
        height: 40px;
        padding: 0 !important;
    }

    .el-menu-item.is-active {
        border-radius: 5px;
        color: teal;
        background-color: #e6f2f2;
    }

    .el-menu-item:hover {
        border-radius: 5px;
        color: teal;
    }

    .el-menu-item span {
        display: inline-block;
        width: 130px;
    }

    .more-panel {
        border: solid #E8F2F2 1px;
        width: 520px;
        position: absolute;
        left: 130px;
        top: -5px;
        padding: 4px;
        z-index: 10000;
        background-color: white;
    }

    .more-class {
        position: relative;
    }

    .more-class .button-span {
        display: inline-block;
        width: 130px;
    }

    .more-class .el-menu-item {
        border-radius: 5px;
        margin-bottom: 5px;
        font-size: 16px;
        font-weight: 500;
    }

    /* 更多按钮 */
    .more-class.el-menu-item:focus {
        color: teal;
    }

    .more-class.el-menu-item:hover {
        border-radius: 5px;
        color: teal;
    }

    .more-class.el-menu-item:active {
        color: teal;
    }

    /* 二级按钮面板内的按钮 */
    .more-panel .el-button--primary {
        background-color: #ffffff;
        border: none;
        color: black;
        width: 130px;
        height: 40px;
        margin: 0;
    }

    .more-panel .el-button--primary:focus {
        color: teal;
        background-color: #E8F2F2;
    }

    .more-panel .el-button--primary:hover {
        border-radius: 5px;
        color: teal;
        background-color: #E8F2F2;
    }

    .more-panel .el-button--primary:active {
        color: teal;
        background-color: #E8F2F2;
    }
</style>