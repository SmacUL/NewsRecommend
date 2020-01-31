<template>
    <div class="comment-reply-input">
        <div class="avatar">
            <img src="@/assets/logo.png" style="width: 100%">
        </div>
        <div style="width: 90%">
            <div ref="toolbar" class="toolbar">
                <div style="position: absolute; display: inherit; right: 0px; width: 120px;">
                    <el-button class="cancel" type="primary" @click="cancel">取消</el-button>
                    <el-button type="primary" @click="showMessage"
                               style="padding: 5px; width: 70px">发表</el-button>
                </div>
            </div>
            <div ref="textplace" class="textplace" :style="{height: height}" @click="changeHeight"></div>
        </div>
    </div>
</template>

<script>
    import WangEditor from 'wangeditor'
    export default {
        name: "CommentReplyInput",
        props: ['heightKey'],
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
            changeHeight() {
                if (this.heightKey) {
                    this.height = this.EDIT_HEIGHT;
                }
            },
            cancel() {
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

<style scoped>
    .comment-reply-input {
        display: flex;
        width: 100%;
    }

    .avatar {
        width: 7%;
        margin-right: 3%;
    }

    .toolbar {
        height: 30px;
        border: 0px solid #f1f1f1;
        background-color:#f1f1f1;
        position: relative;
    }

    .toolbar .el-button {
        line-height: 20px;
    }

    .toolbar .el-button--primary {
        border: none;
        border-radius: 0px;
        margin: 0px;
    }

    /* 取消按钮 */
    .toolbar .el-button.cancel.el-button--primary {
        padding: 5px;
        width: 50px;
        background-color: #888888;
    }

    /* 取消按钮 */
    .toolbar .el-button.cancel.el-button--primary:hover {
        background-color: #989797;
    }

    .textplace {
        /* height: 80px; */
        border: 1px solid #f1f1f1;
        text-align: left;
        margin-bottom: 40px;
        /*overflow: hidden;*/
    }

    .w-e-text {
        padding: 5px 10px;
    }

    .w-e-text p {
        margin: 0;
        line-height: 20px;
    }
</style>