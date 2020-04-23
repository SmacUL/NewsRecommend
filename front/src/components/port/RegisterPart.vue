<template>
    <div>
        <h1>注 册</h1>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="请创建用户名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="请创建密码" prop="pass">
                <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="请确认密码" prop="checkPass">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="cusRegister()">注册</el-button>
                <el-button @click="cusLogin()">有账号了, 去登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import {cusRegister} from "../../control/Self";

    export default {
        name: "RegisterPart.vue",
        methods: {
            cusRegister: function() {
                if (this.ruleForm.pass !== this.ruleForm.checkPass) {
                    return;
                }


                //
                // let data = new FormData();
                // data.append('cusName', this.ruleForm.name);
                // data.append('cusPass', this.ruleForm.pass);
                // this.$axios.post('/api/self/register', data);
                cusRegister(this.ruleForm.name, this.ruleForm.pass)
                    .then((response) => {
                        if (response.data === '注册成功') {
                            this.$message.info(response.data);
                            this.$emit('changePanel');
                        } else {
                            this.$message.info(response.data);
                            this.ruleForm.name = '';
                            this.ruleForm.pass = '';
                            this.ruleForm.checkPass = '';
                        }
                    })
            },
            cusLogin: function () {
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
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            let validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    name: '',
                    pass: '',
                    checkPass: ''
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
                    checkPass: [
                        {
                            validator: validatePass2,
                            trigger: 'blur'
                        }
                    ]
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