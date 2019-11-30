<template>
    <div class="show-panel">
<!--        <div style="background-image: url('@/assets/image/selfbackground.jpg');">-->
        <div :style="note">
            <!-- 用户信息的显示板 -->
            <div
                style="position: absolute; top: 150px; width: 100%;height: 150px; background-color: rgba(244, 245, 246, 0.7)">
                <!-- 头像 -->
                <div style="height: 100px; z-index: 1000; width: 100px; position: absolute; top: -50px; left: 3%;">
                    <img style="width: 100%; " :src="customer.cusAvatarUrl" >
                </div>
                <!-- 信息 -->
                <div style="position: relative;height: 150px;">
                    <div style="position: absolute; margin-left: 3%; width: 17%; margin-top: 70px; height: 80px; text-align: left">
                        <div>
                            <span>{{customer.cusName}}</span>
                            <span>{{customer.cusGender}}</span>
                        </div>

                        <el-button class="follow" type="primary">+关注</el-button>
                    </div>
                    <div style="position: absolute;margin-left: 20%; width: 80%; height: 150px; text-align: left;">
                        <span style="display: block; font-size: 20px; line-height: 48px;">{{ customer.cusStyle}}</span>
                        <div style="display: flex; text-align: right">
                            <div style="width: 70px; margin-right: 30px;">
                                <span style="display: block">Email</span>
                                <span style="display: block">Phone</span>
                                <span style="display: block">地址</span>
                            </div>
                            <div style="width: 250px; text-align: left">
                                <span style="display: block">{{ customer.cusEmail }}</span>
                                <span style="display: block">{{ customer.cusPhone }}</span>
                                <span style="display: block">{{ customer.cusAddress }}</span>
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

<style>
    .show-panel .follow.el-button--primary {
        height: 20px;
        width: 60px;
        padding: 0px;
        font-size: 10pt;
        border-radius: 1px;
    }

</style>
