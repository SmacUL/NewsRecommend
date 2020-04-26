<template>
    <dark-card>
        <div :style="note">
            <!-- 用户信息的显示板 -->
            <div class="customer">
                <!-- 头像 -->
                <div class="customer-avatar"><img :src="customer.cusAvatarUrl"></div>
                <!-- 信息 -->
                <div class="customer-info">
                    <span class="customer-info-name">{{customer.cusName}}</span>
                    <span class="customer-info-style">{{ customer.cusStyle}}</span>
                    <el-button class="follow" type="primary" v-if="!isFollow"
                               :disabled="visitor.cusId === customer.cusId" @click="followCustomer">
                        +关注</el-button>
                    <el-button class="follow" type="success" v-if="isFollow"
                               :disabled="visitor.cusId === customer.cusId" @click="followCustomer">
                        取消关注</el-button>
                </div>
            </div>
        </div>
    </dark-card>
</template>

<script>
    import DarkCard from '../common/DarkCard'
    import { setCusFollow} from "../../control/Self";
    export default {
        name: "EditorMain",
        props: ['customer', 'visitor', 'isFollow'],
        components: { DarkCard },
        mounted: function() {

        },
        methods: {
            followCustomer: function () {
                setCusFollow(this.customer.cusId)
                    .then((response) => {
                        // alert(response.data);
                        if (response.data === '关注失败') {
                            this.isFollow = false;
                        } else {
                            this.isFollow = true;
                        }
                    })
            }
        },
        data: function () {
            return {
                // isFollow: false,
                note: {
                    height: '150px',
                    width: '100%',
                    position: 'relative',
                },
            }
        }
    }
</script>

<style scoped>

    .customer-avatar {
        height: 150px;
        width: 150px;
        float: left;
        margin-right: 30px;
    }

    .customer-avatar img {
        width: 100%;
    }

    .customer-info {
        height: 100px;
        margin-top: 50px;
        float: left;
        text-align: left;
    }

    .customer-info-name {
        display: block;
        line-height: 45px;
        font-size: 30px;
        font-weight: 600;
    }

    .customer-info-style {
        display: block;
        font-size: 16px;
        line-height: 25px;
    }

    .el-button {
        height: 25px;
        width: 60px;
        padding: 0px;
        font-size: 10pt;
        border-radius: 1px;
        display: block;
    }
</style>