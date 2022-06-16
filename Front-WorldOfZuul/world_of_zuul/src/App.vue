<template>
  <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <div>
    <transition name="fade">
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </transition>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
//import loginInterface from './views/loginInterface.vue'

export default {
  name: 'App',
  // components: {
  //   loginInterface
  //   // HelloWorld
  // }
  data(){
    return {
      isLogin:false,
      userInfo:{
        level:null,
      }
    }
  },

  mounted(){
    this.getUserInfo();
  },

  methods:{
    getUserInfo(){
      this.userInfo = {
        level: 0,
      }
      this.$store.commit('updateUserInfo',this.userInfo);
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
