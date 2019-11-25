<template>
    <div>
        <el-menu :default-active="curIndex" class="el-menu-vertical-demo">
            <!-- 一级标签 -->
            <el-menu-item v-for="(tag, i) in tags" :key="i" v-if="i < tags.length - 1" :index="i.toString()"
                          @click="changeCurIndex(i.toString())">
                <span slot="title">{{tag}}</span>
            </el-menu-item>

            <!-- 二级标签入口 -->
            <!-- 1. 鼠标滑动到入口, 入口文字高亮, 同时弹出横向的二级标签展示板 -->
            <!-- 2. 鼠标可以继续在二级标签展示板中滑动, 同时滑动到的二级标签文字高亮-->
            <!-- 3. 鼠标划出入口或二级标签展示板, 二级标签展示板收回, 同时入口文字取消高亮 -->
            <el-menu-item class="special-button" v-if="showLast" style="position: relative; padding: 0px;">
                <!-- 二级标签入口文字 -->
                <span slot="title" @mouseenter="showPanel()" @mouseleave="showPanel()"
                        style="display: inline-block; width: 130px;">
                    {{tags[tags.length - 1]}}
                </span>
                <!-- 二级标签展示板 -->
                <div v-show="panel"
                     style="background-color: #fff; border: solid #f4f5f6 1px; width: 520px; position: absolute;
                            left: 130px; top: -5px; padding: 5px 5px 0px 5px"
                     @mouseleave="showPanel()">
                    <div v-for="(lineNum, lineIndex) in Math.ceil(secondaryTags.length / buttonNum)" :key="lineIndex">
                        <el-button-group style="margin-bottom: 5px;">
                            <el-button class="secondary-button" type="primary"
                                       v-for="(m, mIndex) in buttonNum" :key="mIndex"
                                       v-if="lineIndex * buttonNum + mIndex < secondaryTags.length"
                                       style="width: 130px; height: 40px;">
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
    props: ['tags', 'showLast', 'secondaryTags'],
    name: "LeftNavigater",
    computed: {

    },
    methods: {
        /**
         * 修改当前高亮标签
         * @param i
         */
        changeCurIndex: function(i) {
            this.curIndex = i;
        },
        /**
         * 鼠标划入或划出二级标签入口以及二级标签时, 弹出或收回二级标签面板
         */
        showPanel: function() {
            this.panel = !this.panel;
        }
    },
    data: function() {
        return {
            // curindex 将决定当前高亮对象
            curIndex: '0',
            // panel 将决定是否显示二级标签版
            panel: false,
            // buttonNum: 二级标签面板中, 每一行的按钮数
            buttonNum: 4,
        }
    },
};
</script>

<style>
    .left-navigater .el-menu-item {
        border-radius: 5px;
        margin-bottom: 5px;
        font-size: 16px;
        font-weight: 500;

        line-height: 40px;
        height: 40px;
    }

    .left-navigater .el-menu {
        border: none;
    }

    .left-navigater .el-menu-item.is-active {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .left-navigater .el-menu-item:hover {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .left-navigater .spacial-button .el-menu-item {
        border-radius: 5px;
        margin-bottom: 5px;
        font-size: 16px;
        font-weight: 500;
    }


    /**
    二级标签入口
    不要修改下方三个选择器的顺序
     */
    .left-navigater .special-button.el-menu-item:focus {
        background-color: #ffffff;
    }

    .left-navigater .special-button.el-menu-item:hover {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .left-navigater .special-button.el-menu-item:active {
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
    .left-navigater .secondary-button.el-button--primary {
        background-color: #ffffff;
        border: none;
        color: black;
    }

    .left-navigater .secondary-button.el-button--primary:focus {
        background-color: #ffffff;
    }

    .left-navigater .secondary-button.el-button--primary:hover {
        background-color: #409EFF;
        color: #ffffff;
        border-radius: 5px;
    }

    .left-navigater .secondary-button.el-button--primary:active {
        background-color: #409EFF;
        color: #ffffff;
    }
    /**
    END
     */

</style>
