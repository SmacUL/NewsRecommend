<template>
    <div class="reply-main">
        <div  v-for="(reply, i) in replys.slice((control.rep.page-1)*control.rep.pageSize, (control.rep.page)*control.rep.pageSize)" :key="i">
            <div class="clear-float">
                <div class="avatar">
                    <img :src="reply.customer.cusAvatarUrl">
                </div>
                <div class="comment">
                    <div style="text-align: left; font-weight: 500; font-size: 18px;">
                        <span>{{reply.customer.cusName}}</span>
                        <span style="font-weight:400; font-size:16px;" v-if="reply.repRepId !== null"> 回复 </span>
                        <span v-if="reply.repRepId !== null">{{ findReplyTarget(reply.repRepId) }}</span>
                    </div>
                    <!--<div class="content">{{reply.repContent}}</div>-->
                    <div class="content" v-html="reply.repContent"></div>
                    <div class="info">
                        <span>{{ date(reply.repTime) }}</span>
                        <el-button type="text" @click="addCancelReply(reply.repId)">
                            <span v-show="add.type === 2 && add.id === reply.repId">收起</span>
                            <span v-show="add.type !== 2 || add.id !== reply.repId">评论</span>
                        </el-button>
                    </div>
                </div>
                <!-- 评论回复输入框 -->
                <comment-reply-input @readycancel="cancelMessage" @messageHandler="addReply"
                                     v-if="add.type === 2 && add.id === reply.repId"
                                     :heightKey=false :customer="customer">
                </comment-reply-input>
            </div>

        </div>
        <el-pagination v-if="replys.length > control.rep.pageSize"
                       small
                       layout="prev, pager, next"
                       @current-change="replyHandleCurrentChange"
                       :page-size="control.rep.pageSize"
                       :current-page="control.rep.page"
                       :total="replys.length"
        >
        </el-pagination>
    </div>
</template>

<script>
    import CommentReplyInput from "./CommentReplyInput";
    import {transUTCtoLocal} from "../../../util/TimeHandler";
    import {cusAddReply} from "../../../control/Discuss";
    export default {
        name: "ReplyMain",
        components: {CommentReplyInput},
        props: ['replys', 'comId', 'add', 'customer'],
        methods: {
            replyHandleCurrentChange(val) {
                this.control.rep.page = val;
                this.add.type = -1;
                this.add.id = -1;
            },
            addCancelReply(repId) {
                if (this.add.type == 2 && this.add.id == repId) {
                    this.add.type = -1;
                    this.add.id  = -1;
                } else {
                    this.add.type = 2;
                    this.add.id = repId;
                }
            },
            cancelMessage() {
                this.add.type = -1;
                this.add.id  = -1;
            },
            findReplyTarget(id) {
                let result = '';
                this.replys.forEach((item) => {
                    if (item.repId === id) {
                        result = item.customer.cusName;
                    }
                });
                return result;
            },
            date: function (time) {
                return transUTCtoLocal(time)
            },
            addReply: function (message) {
                let reply = {
                    repContent: message,
                    repType: 1,
                    repCusId: this.customer.cusId,
                    repArtId: this.replys[0].repArtId,
                    // 回复针对的评论的 id
                    repComId: this.replys[0].repComId,
                    repRepId: this.add.id,
                };
                cusAddReply(reply)
                    .then((response) => {
                        if (response.data) {
                            this.$message.info("回复成功");
                            this.$emit('quickShow');
                            this.control.rep.page = 1;
                        } else {
                            this.$message.info("回复失败");
                        }
                    });

                this.add.type = -1;
                this.add.id = -1;
            }
        },
        data: function () {
            return {
                control: {
                    rep: {
                        page: 1,
                        pageSize: 4,
                    }
                }
            }
        },
    }
</script>

<style scoped>
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
</style>