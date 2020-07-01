<template>
    <body id="poster">
    <el-form  :model="loginForm" :rules="rules" class="login-container" label-position="left"
              label-width="0px" ref="loginFormRef" >
        <h3 class="login_title">用户注册</h3>
        <el-form-item  prop="username">
            <el-input type="text" prefix-icon="el-icon-date" v-model="loginForm.username"
                      auto-complete="off" placeholder="账号" round></el-input>
        </el-form-item>

        <el-form-item prop="password">
            <el-input type="password" prefix-icon="el-icon-goods" v-model="loginForm.password"
                      auto-complete="off" placeholder="密码" round></el-input>
        </el-form-item>

        <!-- 再次确认密码 -->
        <el-form-item prop="repassword">
            <el-input type="password" prefix-icon="el-icon-goods" v-model="loginForm.repassword"
                      auto-complete="off" placeholder="确认密码" round></el-input>
        </el-form-item>
        <el-form-item >
            <el-checkbox-group v-model="form.type">
                <el-checkbox label="政府" name="type"></el-checkbox>
                <el-checkbox label="浪潮管理" name="type"></el-checkbox>

            </el-checkbox-group>
        </el-form-item>
        <!-- 按钮区域 -->
        <el-row class="btns">
            <el-button type="primary" class="login_style" round @click="register">注册</el-button>
            <el-button type="primary" class="login_style" round @click="cancel">取消</el-button>
        </el-row>

    </el-form>
    </body>
</template>

<script>
    export default {
        name: 'Register',
        data () {
            return {
                loginForm: {
                    username: '',
                    password: '',
                    repassword:''
                },
                form: {
                    name: '',
                    //region: '',
                    // date1: '',
                    // date2: '',
                    // delivery: false,
                   type: [],
                   // resource: '',
                    //desc: ''
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
                    repassword:[
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 30, message: '长度不合理', trigger: 'blur' }
                    ],
                },
                responseResult: []
            }
        },
        methods: {
            //注册
            register(){
                if(this.loginForm.username==null || this.loginForm.username==''){
                    this.$message.error('用户名不能为空');
                    return;
                }
                if(this.loginForm.password==null || this.loginForm.password==''){
                    this.$message.error('密码不能为空');
                    return;
                }
                if(this.loginForm.password != this.loginForm.repassword){
                    this.$message.error('密码不一致');
                    return;
                }

                this.$axios
                    .post('http://localhost:8181/users', {
                        username: this.loginForm.username,
                        password: this.loginForm.password
                    })
                    .then(successResponse => {
                        //成功
                        if (successResponse.data.status === 200) {
                            this.$message.success("Register success");
                            this.$router.replace({path: '/login'})
                        }else{
                            //登陆失败
                            this.$message.error(successResponse.data.msg);
                        }
                    })
                    .catch(failResponse => {
                    })
            },
            cancel(){
                this.$router.push({
                    path: "/Login"
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
