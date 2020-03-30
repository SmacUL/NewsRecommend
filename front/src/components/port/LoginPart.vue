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
    export default {
        name: "LoginPart.vue",
        methods: {
            cusLogin() {
                let data = new FormData();
                data.append('cusName', this.ruleForm.name);
                data.append('cusPass', this.ruleForm.pass);
                this.$axios.post('/api/self/login', data)
                    .then((response) => {
                        if (response.data) {
                            this.$message.info('登录成功');
                            this.$router.push({path: '/index'});
                        } else {
                            this.$message.info('登录失败, 请重新输入');
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