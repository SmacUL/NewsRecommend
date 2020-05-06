<template>
    <div>
        <comment-reply-input :customer="customer" @messageHandler="addComment"></comment-reply-input>
        <div class="comments" v-for="(comment, i) in comments.slice((control.com.page-1)*control.com.pageSize, (control.com.page)*control.com.pageSize)" :key="i">
            <div class="clear-float">
                <div class="avatar">
                    <img :src='comment.customer.cusAvatarUrl'>
                </div>
                <div class="comment">
                    <div style="text-align: left; font-weight: 500; font-size: 18px;">
                        <el-button type="text" @click="jumpToCus(comment.customer.cusId)">{{comment.customer.cusName}}</el-button>
                    </div>
                    <!--<div class="content">{{comment.comContent}}</div>-->
                    <div class="content" v-html="comment.comContent"></div>
                    <div class="info">
                        <span>{{ date(comment.comTime) }}</span>
                        <!--<span>{{comment.comLikeNum}}</span>-->
                        <el-button type="text" @click="addCancelReply(comment.comId)">
                            <span v-show="control.add.type == 1 && control.add.id == comment.comId">收起</span>
                            <span v-show="control.add.type != 1 || control.add.id != comment.comId">评论</span>
                        </el-button>
                    </div>
                </div>
                <!-- 评论回复输入框 -->
                <comment-reply-input @readycancel="cancelMessage" @messageHandler="addReply"
                                     v-if="control.add.type == 1 && control.add.id == comment.comId"
                                     :heightKey=false :customer="customer">
                </comment-reply-input>
            </div>

            <reply-main :replys=comment.replys :commentId=comment.comId :add="control.add" :customer="customer"
                        @quickShow="$emit('quickShow')">
            </reply-main>
        </div>
        <el-pagination v-if="comments.length > control.com.pageSize"
                       background
                       layout="prev, pager, next"
                       @current-change="commentHandleCurrentChange"
                       :page-size="control.com.pageSize"
                       :current-page="control.com.page"
                       :total="comments.length"
                       class="page-switcher"
        >
        </el-pagination>
    </div>
</template>

<script>
    import CommentReplyInput from "./comment-reply-main/CommentReplyInput";
    import ReplyMain from "./comment-reply-main/ReplyMain";
    import {transUTCtoLocal} from "../../util/TimeHandler";
    import {addNewCom, cusAddReply} from "../../control/Discuss";
    import {jumpInNewPage} from "../../util/PageJump";

    /**
     * /src/components/article/comment-reply-main/ 路径下包含了 CommentReplyMain 模块需要的子组件
     */
    export default {
        name: "CommentReplyCenter",
        components: {ReplyMain, CommentReplyInput},
        props: ["comments", 'customer'],
        methods: {
            cancelMessage: function() {
                this.control.add.id = -1;
            },
            addCancelReply(comId) {
                if (this.control.add.type === 1 && this.control.add.id === comId) {
                    this.control.add.type = -1;
                    this.control.add.id = -1;
                } else {
                    this.control.add.type = 1;
                    this.control.add.id = comId;
                }
            },
            commentHandleCurrentChange(val) {
                this.control.com.page = val;
                this.control.type = -1;
                this.control.id = -1;
                let artHeight = document.getElementsByClassName('article-main')[0].offsetHeight;
                let otherHeight = 70 + 15;
                let scrollHeight = artHeight + otherHeight;
                window.scrollTo(0, scrollHeight);
            },
            date: function (time) {
                return transUTCtoLocal(time);
            },
            /**
             * 发表评论对文章
             *
             * @param message
             */
            addComment: function (message) {
                // let comment = new FormData();
                // comment.append('comContent', message);
                // comment.append('comCustomerId', this.customer.cusId);
                // comment.append('comArticleId', this.comments[0].comArticleId);

                let comment = {
                    comContent: message,
                    comCusId: this.customer.cusId,
                    comArtId: this.comments[0].comArtId,
                };
                addNewCom(comment)
                    .then((response) => {
                        if(response.data) {
                            this.$message.info("评论成功");
                            this.$emit('quickShow');
                            this.control.com.page = 1;
                        } else {
                            this.$message.info("评论失败");
                        }
                    })
            },

            /**
             * 添加回复
             *
             * @param message
             */
            addReply: function (message) {
                // let reply = new FormData();
                // reply.append('repContent', message);
                // reply.append('repType', 0);
                // reply.append('repCustomerId', this.customer.cusId);
                // reply.append('repArticleId', this.comments[0].comArticleId);
                // reply.append('repCommentId', this.control.add.id);
                let reply = {
                    repContent: message,
                    repType: 0,
                    repCusId: this.customer.cusId,
                    repArtId: this.comments[0].comArtId,
                    // 回复针对的评论的 id
                    repComId: this.control.add.id,
                };
                cusAddReply(reply)
                    .then((response) => {
                        if (response.data) {
                            this.$message.info("回复成功");
                            this.$emit('quickShow');
                            // todo 这个地方要重新计算一遍位置
                        } else {
                            this.$message.info("回复失败");
                        }
                    });
                this.control.add.type = -1;
                this.control.add.id = -1;
            },
            jumpToCus: function (cusId) {
                jumpInNewPage('/self/' + cusId);
            }
        },
        data: function() {
            return {
                control: {
                    com: {
                        page: 1,
                        pageSize: 8,
                    },
                    add: {
                        type: -1,
                        id: -1,
                    }
                }
            }
        },

    }
</script>

<style scoped>
    .comments {
        margin-bottom: 10px;
    }

    .reply-main {
        margin-left: 10%;
        margin-bottom: 5px;
    }

    .avatar {
        float: left;
        margin-right: 3%;
        width: 7%;
    }

    .avatar img{
        width: 100%;
    }

    .comment {
        float: left;
        width: 90%;
    }

    .name {
        font-size: 20px;
        font-weight: 600;
        text-align: left;
        margin-bottom: 5px;
        float: left;
    }

    .reply {
        float: left;
    }

    .content {
        font-size: 16px;
        line-height: 20px;
        text-align: left;
        word-wrap: break-word;
    }

    .info {
        font-size: 14px;
        color: #888888;
        text-align: left;
    }

    .info span {
        margin-right: 10px;
    }

    .content >>> p {
        margin: 0;
    }

    .page-switcher {
        float: left;
        padding-bottom: 50px;
    }
</style>