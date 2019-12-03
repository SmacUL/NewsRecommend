<template>
    <div class="show-panel">
<!--        <div style="background-image: url('@/assets/image/selfbackground.jpg');">-->
        <div :style="note">
            <!-- 用户信息的显示板 -->
            <div class="customer">
                <!-- 头像 -->
                <div class="customer-avatar"><img :src="customer.cusAvatarUrl" ></div>
                <!-- 信息 -->
                <div class="customer-info">
                    <div class="customer-info-left">
                        <div><span>{{customer.cusName}}</span><span>{{customer.cusGender}}</span></div>
                        <el-button class="follow" type="primary">+关注</el-button>
                    </div>
                    <div class="customer-info-right">
                        <span class="customer-info-style">{{ customer.cusStyle}}</span>
                        <div class="customer-info-panel">
                            <div>
                                <span>Email</span>
                                <span>Phone</span>
                                <span>地址</span>
                            </div>
                            <div>
                                <span>{{ customer.cusEmail }}</span>
                                <span>{{ customer.cusPhone }}</span>
                                <span>{{ customer.cusAddress }}</span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'ShowPanel',
    props: ['customer'],
    data: function () {
        return {
            note: {
                backgroundImage: "url(" + require("@/assets/image/selfbackground.jpg") + ") ",
                backgroundPosition: "center center",
                backgroundRepeat: "no-repeat",
                backgroundSize: "cover",
                height: '300px',
                width: '100%',
                position: 'relative',
            },
        }
    }
}
</script>

<style scoped>
    .follow.el-button--primary {
        height: 20px;
        width: 60px;
        padding: 0px;
        font-size: 10pt;
        border-radius: 1px;
    }

    .customer {
        position: absolute;
        top: 150px;
        width: 100%;
        height: 150px;
        background-color: rgba(244, 245, 246, 0.7);
    }

    .customer-avatar {
        height: 100px;
        z-index: 1000;
        width: 100px;
        position: absolute;
        top: -50px; left: 3%;
    }

    .customer-avatar img {
        width: 100%;
    }

    .customer-info {
        position: relative;
        height: 150px;
    }

    .customer-info-left {
        position: absolute;
        margin-left: 3%;
        margin-top: 70px;
        width: 17%;
        height: 80px;
        text-align: left;
    }

    .customer-info-right {
        position: absolute;
        margin-left: 20%;
        width: 80%;
        height: 150px;
        text-align: left;
    }

    .customer-info-style {
        display: block;
        font-size: 20px;
        line-height: 48px;
    }

    .customer-info-panel {
        display: flex;
    }

    .customer-info-panel div:nth-child(1) {
        width: 70px;
        margin-right: 30px;
        text-align: right;
    }

    .customer-info-panel div:nth-child(2) {
        width: 250px;
        text-align: left;
    }

    .customer-info-panel span {
        display: inline-block;
    }


</style>
