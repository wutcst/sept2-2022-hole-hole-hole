<template>
<div class="login-bg" id="login">
    <!-- <div class="login-bg">
    </div>
    <div class="login-info">
        <input type="text" placeholder="用户名" v-model="account"><br>
        <input type="password" placeholder="密码" v-model="password"><br>
        <a href="javascript:;" class="login-btn" @click="login">Login</a>
    </div> -->
    <div class="login-form" >
        <el-form label-width="50px">
            <el-form-item label="账号" style="margin-top:15px">
                <el-input v-model="account" style="width: 175px;"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="password" show-password style="width: 175px;"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="margin-left:40px" @click="login">登录
                </el-button>
            </el-form-item>
        </el-form>
    </div>
    <Loading v-if="isLoging" marginTop="-10%" style="margin-left: 550px;"></Loading>
</div>
</template>

<script>
import Loading from '../components/loading-component.vue'
export default {
    name: 'loginInterface',
    data(){
        return {
            isLoging:false,
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
            // this.isLoging = false;
            this.$router.push('/hello');
        }
    }
    
}
</script>

<style>
.login-form{
    width: 95vw;
    height: 95vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.el-form{
    background-color: #9bf2ed;
    width: 250px;
    border-color: black;
    border-width: 2px;
    border-style: solid;
}

</style>