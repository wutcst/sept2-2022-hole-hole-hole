<template>
<div class="login-bg" id="login">
    <div class="background">    
        <img :src="require(`../assets/background1.png`)" height="100%" width="100%" alt="" />
    </div>
    <div class="login-form" >
        <el-form class="login_form" label-width="80px">
            <el-form-item label="账号" class="item1" style="margin-top:100px;">
                <el-input v-model="account" style="width: 175px;"></el-input>
            </el-form-item>
            <el-form-item label="密码" class="item2" style="margin-top:40px;">
                <el-input v-model="password" show-password style="width: 175px;"></el-input>
            </el-form-item>
            <!-- <el-form-item> -->
                <el-button plain type="primary" style="margin-left: 60px;margin-top: 20px;" @click="visible=true">注册
                </el-button>
                <el-button plain type="primary" @click="login">登录
                </el-button>
            <!-- </el-form-item> -->
        </el-form>
    </div>
    <el-dialog
        title="注册"
        :visible.sync="visible"
        width="40%"
        center>
        <el-form :model="reform" ref="reform" :rules="rules" class="register_form" label-width="70px">
            <el-form-item label="用户名" style="margin-left:145px" prop="re_account">
                <el-input v-model="reform.re_account" style="width: 175px;"></el-input>  
            </el-form-item>
            <el-form-item label="玩家昵称" style="margin-left:145px" prop="re_id">
                <el-input v-model="reform.re_id" style="width: 175px;"></el-input>  
            </el-form-item>
            <el-form-item label="电子邮箱" style="margin-left:145px" prop="re_email">
                <el-input v-model="reform.re_email" style="width: 175px;"></el-input>
            </el-form-item>
            <el-form-item label="密码" style="margin-left:145px" prop="re_password">
                <el-input v-model="reform.re_password" show-password style="width: 175px;"></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="cancel">取 消</el-button>
            <el-button type="primary" @click="register">确 定</el-button>
        </span>
    </el-dialog>
    <Loading v-if="isLoging" marginTop="-10%" style="margin-left: 750px;"></Loading>
    <audio autoplay="autoplay" controls="controls" loop="loop" preload="auto" src="../assets/back.mp3"></audio>
</div>
</template>

<script>
import Loading from '../components/loading-component.vue'
export default {
    name: 'loginInterface',
    data(){
        return {
            visible:false,
            isLoging:false,
            reform:{
                re_account:'',
                re_id:'',
                re_email:'',
                re_password:'',
            },
            rules:{
                re_account:[
                    { max: 12, message:'长度在12个字符以内',trigger:'change'}
                ],
                re_id:[
                    { max: 12, message:'长度在12个字符以内',trigger:'change'}
                ],
                re_email:[
                    { max: 25, message:'长度在25个字符以内',trigger:'change'}
                ],
                re_password:[
                    { max: 12, message:'长度在12个字符以内',trigger:'change'}
                ]
            },
            account:'',
            password:''
        }
    },
    components:{
        Loading
    },
    methods:{
        //登录逻辑
        login(){
            if(this.account!=''&&this.password!=''){
                this.toLogin();
            }
        },

        //登录请求
        toLogin(){
            this.isLoging = true;
            //登录请求
            // this.isLoging = false;
            this.$router.push('/home');
        },

        cancel(){
            this.$refs['reform'].resetFields();
            this.visible = false;
        },

        //注册请求
        register(){
            this.visible = false;
            //注册请求
        }
    }
    
}
</script>

<style>

@font-face {
    font-family: ziti;
    src: url(../assets/FZFWHuanLTJW.TTF);
}

.background{
    width:100%;
    height:100%;  
    z-index:-1;
    position: absolute;
}

.login-form{
    width: 95vw;
    height: 95vh;
    /* z-index: 1; */
    display: flex;
    justify-content: center;
    align-items: center;
}

.login_form{
    width: 250px;
    z-index:1;
    /* border-color: black;
    border-width: 2px;
    border-style: solid; */
}

.login-form .el-button{
    background-color:transparent;
    border-style:none;
    color: white;
    font-family: "ziti";
    font-size: 25px;
}

.item1 .el-form-item__label {
    color: white;
    font-family: "ziti";
    font-size: 30px;
}

.item2 .el-form-item__label {
    color: white;
    font-family: "ziti";
    font-size: 30px;
}
</style>