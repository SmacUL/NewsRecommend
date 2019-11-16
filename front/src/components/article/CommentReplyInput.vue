<template>
    <div class="comment-reply-input" style="display: flex; width: 100%;">
        <div class="avater" style="width: 7%; margin-right: 3%">
            <img src="@/assets/logo.png" style="width: 100%">
        </div>
        <div style="width: 90%">
            <div ref="toolbar" class="toolbar">
                <div style="position: absolute; display: inherit; right: 0px; width: 120px;">
                    <el-button class="cancle" type="primary" @click="cancle()">取消</el-button>
                    <el-button type="primary" @click="showMessage" 
                        style="padding: 5px; width: 70px">发表</el-button>     
                </div>
            </div>
            <div ref="textplace" class="textplace" :style="{height: height}" @click="changeHight()"></div>
        </div>
    </div>
</template>

<script>
import WangEditor from  'wangeditor'

export default {
    name: 'CommentReplyInput',
    // heightKey 用于标明当前能否修改输入框的高度, true 时可以;
    props: ['heightKey'],
    computed: {
    },
    data: function() {
        return {
            height: '70px',
            
            DEFAULT_HEIGHT: '70px',
            EDIT_HEIGHT: '210px',

            menus: [
                'source', 'bold', 'underline', 'italic', 'emotion', 'undo', 'redo', 'fullscreen', 'emoticon',
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
    },
    methods: {
        showMessage() {
            alert(this.message);
        },
        changeHight() {
            if (this.heightKey) {
                this.height = this.EDIT_HEIGHT;
            }
        },
        cancle() {
            if (this.heightKey) {
                this.height = this.DEFAULT_HEIGHT;
                this.editor.txt.clear();
            } else {
                this.editor.txt.clear();
                this.$emit('readycancel');
            }

        }
    }
}
</script>

<style>
.comment-reply-input .toolbar {
    height: 30px;
    border: 0px;
    border-style: solid; 
    border-color: #f1f1f1; 
    background-color:#f1f1f1;
    position: relative;
}

.comment-reply-input .toolbar .el-button {
    line-height: 20px;
}

.comment-reply-input .toolbar .el-button--primary {
    border: none;
    border-radius: 0px;
    margin: 0px;
}

/* 取消按钮 */
.comment-reply-input .toolbar .el-button.cancle.el-button--primary {
    padding: 5px; 
    width: 50px; 
    background-color: #888888;
}

/* 取消按钮 */
.comment-reply-input .toolbar .el-button.cancle.el-button--primary:hover {
    background-color: #989797;
}

.comment-reply-input .textplace {
    /* height: 80px; */
    border: 1px;
    border-style: solid; 
    border-color: #f1f1f1;
    text-align: left;
    margin-bottom: 40px;
    /*overflow: hidden;*/
}

.comment-reply-input .w-e-text-container .w-e-panel-container {

}

.comment-reply-input .w-e-text {
    padding: 5px 10px;
}

.comment-reply-input .w-e-text p {
    margin: 0;
    line-height: 20px;
}

</style>