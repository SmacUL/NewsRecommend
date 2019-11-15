<template>
    <div class="comment-reply-input">
        <div>
            <div ref="toolbar" class="toolbar"></div>
            <div ref="textplace" class="textplace"></div>
        </div>
        <div>
            <el-button type="primary">发表</el-button>
        </div>
    </div>
</template>

<script>
import WangEditor from  'wangeditor'

export default {
    name: 'CommentReplyInput',
    data: function() {
        return {
            menus: [
                'source', 
                '|', 'bold', 'underline', 'italic', 'strikethrough', 'eraser', 'forecolor', 'bgcolor', 
                '|', 'quote', 'fontfamily', 'fontsize', 'head', 'unorderlist', 'orderlist', 'alignleft', 'aligncenter', 'alignright',
                '|', 'link','unlink','table', 'emotion', 
                '|', 'img', 'video', 'location', 'insertcode',
                '|', 'undo', 'redo', 'fullscreen'
            ],
            editor: null,
            message: 'message'
        }
    },
    mounted() {
        let editor = new WangEditor(this.$refs.toolbar, this.$refs.textplace);
        this.editor = editor;
        editor.customConfig.onchange = (html) => {
            this.message = html;
        };
        editor.customConfig.menus = this.menus;
        editor.create();
    }
}
</script>

<style>
.comment-reply-input .toolbar {
    height: 25px;
    border: 1px;
    border-style: solid; 
    border-color: #f1f1f1; 
    background-color:#f1f1f1
}

.comment-reply-input .textplace {
    height: 80px;
    border: 1px;
    border-style: solid; 
    border-color: #f1f1f1;
    text-align: left;
    overflow: hidden;
}

</style>