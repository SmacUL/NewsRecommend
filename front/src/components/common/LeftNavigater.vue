<template>
    <div>
        <el-menu :default-active="curIndex" class="el-menu-vertical-demo">
            <!-- 一级标签 -->
            <el-menu-item v-for="(tag, i) in tags" :key="i" v-if="i < tags.length - 1" :index="i.toString()"
                          @click="changeCurIndex(i.toString(), 0)">
                <span slot="title">{{tag}}</span>
            </el-menu-item>

            <!-- 二级标签入口 -->
            <!-- 1. 鼠标滑动到入口, 入口文字高亮, 同时弹出横向的二级标签展示板 -->
            <!-- 2. 鼠标可以继续在二级标签展示板中滑动, 同时滑动到的二级标签文字高亮-->
            <!-- 3. 鼠标划出入口或二级标签展示板, 二级标签展示板收回, 同时入口文字取消高亮 -->
            <!-- 4. 鼠标点击二级标签, 则此二级标签上升为一级标签, 并且和倒数第二个一级标签调换位置 -->
            <el-menu-item class="special-button" v-if="showLast">
                <!-- 二级标签入口文字 -->
                <span class="button-span" slot="title" @mouseenter="showPanel(true)" @mouseleave="showPanel(false)">
                    {{tags[tags.length - 1]}}
                </span>
                <!-- 二级标签展示板 -->
                <div v-show="panel" class="secondary-panel"
                     @mouseenter="showPanel(true)" @mouseleave="showPanel(false)">
                    <div v-for="(lineNum, lineIndex) in Math.ceil(secondaryTags.length / buttonNum)" :key="lineIndex">
                        <el-button-group>
                            <el-button class="secondary-button" type="primary"
                                       v-for="(m, mIndex) in buttonNum" :key="mIndex"
                                       v-if="lineIndex * buttonNum + mIndex < secondaryTags.length"
                                       @click="changeCurIndex(lineIndex * buttonNum + mIndex, 1)">
                                {{ secondaryTags[lineIndex * buttonNum + mIndex] }}
                                <!--{{ lineIndex * buttonNum + mIndex }}-->
                            </el-button>
                        </el-button-group>
                    </div>
                </div>
            </el-menu-item>

        </el-menu>

    </div>
</template>

<script>
export default {
    // tags: 一级标签
    // showLast: 是否显示二级标签入口以及后面一堆的东西
    // secondaryTags: 二级标签
    // curIndex: 由父组件来决定当前选择的对象
    props: ['tags', 'showLast', 'secondaryTags', 'curIndex'],
    name: "LeftNavigater",
    computed: {

    },
    methods: {
        /**
         * 返回父组件当前标签信息, 在点击完成后, 收回二级标签面板
         * @param i
         * @param type
         */
        changeCurIndex: function(i, type) {
            this.$emit('changecurindex', i, type);
            if (type === 1) {
                this.showPanel(false)
            }
        },

        /**
         * 鼠标划入或划出二级标签入口以及二级标签时, 弹出或收回二级标签面板
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
};
</script>

<style scoped>
    .el-menu-item {
        border-radius: 5px;
        margin-bottom: 5px;
        font-size: 16px;
        font-weight: 500;

        line-height: 40px;
        height: 40px;
    }

    .el-menu {
        border: none;
    }

    .el-menu-item.is-active {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .el-menu-item:hover {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }


    .special-button {
        position: relative;
        padding: 0px !important;
    }

    .special-button .button-span {
        display: inline-block;
        width: 130px;
    }

    .spacial-button .el-menu-item {
        border-radius: 5px;
        margin-bottom: 5px;
        font-size: 16px;
        font-weight: 500;
    }

    .secondary-panel {
        background-color: #fff;
        border: solid #f4f5f6 1px;
        width: 520px;
        position: absolute;
        left: 130px;
        top: -5px;
        padding: 5px 5px 0px 5px
    }

    .el-button-group {
        margin-bottom: 5px;
    }

    .secondary-button {
        width: 130px; height: 40px;
    }

    /**
    二级标签入口
    不要修改下方三个选择器的顺序
     */
    .special-button.el-menu-item:focus {
        background-color: #ffffff;
    }

    .special-button.el-menu-item:hover {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .special-button.el-menu-item:active {
        background-color: #409EFF;
        color: #ffffff;
    }
    /**
    END
     */


    /**
    二级标签
    不要修改下方四个选择器的顺序
     */
    .secondary-button.el-button--primary {
        background-color: #ffffff;
        border: none;
        color: black;
    }

    .secondary-button.el-button--primary:focus {
        background-color: #ffffff;
    }

    .secondary-button.el-button--primary:hover {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .secondary-button.el-button--primary:active {
        background-color: #409EFF;
        color: #ffffff;
    }
    /**
    END
     */

</style>
