<template>
    <div>
        <login-part v-if="page.loginShow" class="login-part" v-on:changePanel="changePanel"></login-part>
        <register-part v-if="!page.loginShow" class="register-part" v-on:changePanel="changePanel"></register-part>
    </div>
</template>

<script>
    import LoginPart from '../components/port/LoginPart'
    import RegisterPart from '../components/port/RegisterPart'

    export default {
        name: "PortView.vue",
        components: {RegisterPart, LoginPart},
        methods: {
            changePanel: function () {
                if (this.page.loginShow) {
                    this.page.loginShow = false;
                } else {
                    this.page.loginShow = true;
                }
            }
        },
        data: function () {
            return {
                page: {
                    loginShow: true
                }
            }
        }
    }
</script>

<style scoped src="../assets/css/Normal.css"></style>
<style scoped>
    .login-part, .register-part {
        width: 450px;
        margin: 0 auto;
        padding-top: 200px;
    }


</style>