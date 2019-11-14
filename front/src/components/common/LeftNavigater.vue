<template>
  <div class="left-navigater-inner">
    <el-menu :default-active="curindex" v-for="(tag, i) in tags" :key="i" class="el-menu-vertical-demo">
        <el-menu-item :index="i.toString()" @click="changeCurIndex(i.toString())">
            <span slot="title">{{tag}}</span>
            <span>{{i}}</span>
        </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
    props: ['tags'],
    name: "LeftNavigater",
    data: function() {
        return {
            
            curindex: '0',
        }
    },
    methods: {
        changeCurIndex(i) {
            this.curindex = i;
        }
    }
};
</script>

<style>
.left-navigater-inner .el-menu-item {
    border-radius: 5px;
    margin-bottom: 5px;
    font-size: 16px;
    font-weight: 500;
}

.left-navigater-inner .el-menu {
    border: none;
}

.left-navigater-inner .el-menu-item.is-active {
    background-color: #409EFF;
    color: #ffffff;
    border-radius: 5px;
}

.left-navigater-inner .el-menu-item:hover {
    background-color: #87C2FF;
    color: #ffffff;
    border-radius: 5px;
}

</style>