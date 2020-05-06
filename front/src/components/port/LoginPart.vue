<template>
    <div>
        <h1>登 录</h1>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
                <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="cusLogin()">登录</el-button>
                <el-button @click="cusRegister()">注册</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import {cusLogin} from "../../control/Self";
    import {jumpInCurPage} from "../../util/PageJump";

    export default {
        name: "LoginPart.vue",
        methods: {
            cusLogin() {
                // let data = new FormData();
                // data.append('cusName', this.ruleForm.name);
                // data.append('cusPass', this.ruleForm.pass);
                cusLogin(this.ruleForm.name, this.ruleForm.pass)
                // this.$axios.post('/api/self/login', data)
                    .then((response) => {
                        if (response.data === '登录成功' || response.data === '您已登录') {
                            this.$message.info(response.data);
                            // this.$router.push({path: '/index'});
                            jumpInCurPage('/index')
                        } else if (response.data === '登录失败') {
                            this.$message.info(response.data);
                            this.ruleForm.name = '';
                            this.ruleForm.pass = '';
                        }
                    })
            },
            cusRegister() {
                this.$emit('changePanel');
            }
        },
        data: function () {
            let validateName = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入用户名'));
                } else {
                    callback();
                }
            };
            let validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    name: '',
                    pass: '',
                },
                rules: {
                    name: [
                        {
                            validator: validateName,
                            trigger: 'blur'
                        }
                    ],
                    pass: [
                        {
                            validator: validatePass,
                            trigger: 'blur'
                        }
                    ],
                }
            };
        },


    }
</script>

<style scoped>
    h1 {
        margin-left: 100px;
    }
</style>