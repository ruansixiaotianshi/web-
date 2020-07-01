<template>
    <body id="poster">
    <!-- 数据绑定：model  ref引用对象-->
    <el-form  :model="loginForm" :rules="rules" class="login-container" label-position="left"
              label-width="0px" ref="loginFormRef" >
        <h3 class="login_title">系统登录</h3>
        <el-form-item  prop="username">
            <el-input type="text" prefix-icon="el-icon-date" v-model="loginForm.username"
                      auto-complete="off" placeholder="账号" round></el-input>
        </el-form-item>

        <el-form-item prop="password">
            <el-input type="password" prefix-icon="el-icon-goods" v-model="loginForm.password"
                      auto-complete="off" placeholder="密码" round></el-input>
        </el-form-item>


        <!-- 按钮区域 -->
        <el-row class="btns">
            <el-button type="primary" class="login_style" round @click="register">注册</el-button>
            <el-button type="primary" class="login_style" round v-on:click="login">登陆</el-button>
        </el-row>

    </el-form>
    </body>
</template>

<script>
    export default {
        name: 'Login',
        data () {
            return {
                loginForm: {
                    username: '',
                    password: ''
                },
                form: {
                    name: '',
                    region: '',
                    // date1: '',
                    // date2: '',
                    // delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                //rule规则
                rules: {
                    username:[
                        { required: true, message: '请输入账号', trigger: 'blur' },
                        { min: 2, max: 25, message: '长度不合理', trigger: 'blur' }
                    ],
                    password:[
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 30, message: '长度不合理', trigger: 'blur' }
                    ],
                },
                responseResult: []
            }
        },
        methods: {
            //登陆操作的函数
            login () {
                if (this.loginForm.username == null || this.loginForm.username == '') {
                    this.$message.error('用户名不能为空');
                    return;
                }
                if (this.loginForm.password == null || this.loginForm.password == '') {
                    this.$message.error('密码不能为空');
                    return;
                }
                this.$axios
                    .post('http://localhost:8181/login', {
                        username: this.loginForm.username,
                        password: this.loginForm.password
                    })
                    .then(successResponse => {
                        debugger
                        if (successResponse.data.code === 200) {
                            this.$router.replace({path: '/Usersmanage'})
                        } else {
                            alert('登录失败！')
                        }
                    })
                    .catch(failResponse => {
                    });
            },
            //     C:\Users\Administrator\AppData\Roaming\JetBrains\IntelliJIdea2020.1


            // },
            //     const _this=this
            //
            //     this.$axios
            //         .get('http://localhost:8181/login',this.loginForm.username+'&'+ this.loginForm.password).then(function (resp) {
            //         debugger
            //             if (resp.data.code == '200') {
            //             _this.$router.push({
            //                 path: "/DataManage"
            //             })
            //         } else {
            //             alert('账号或者密码错误')
            //         }
            //
            //     })},

            //注册
            register(){
                this.$router.push({
                    path: "/register"
                })
            }
        },
    }
</script>

<style>
    #poster {
        background:url("../assets/LoginPhoto.jpg") no-repeat;
        background-position: center;
        height: 100%;
        width: 100%;
        background-size: cover;
        position: fixed;
    }
    body{
        margin: 0px;
    }
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 90px auto;
        margin-top: 15%;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .login_title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }
    .btns {
        text-align: center;
        padding-bottom: 15px;
    }
    .login_style{
        width: 45%;
    }

</style>
