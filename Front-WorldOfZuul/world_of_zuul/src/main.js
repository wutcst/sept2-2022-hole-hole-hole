import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import router from './router';
// import store from './store'
import VueResource from 'vue-resource'
Vue.use(ElementUI);
Vue.use(VueResource);
Vue.config.productionTip = false;

new Vue({
    // store,
    // router,
    render: h => h(App),
    // created(){
    //     this.CheckLogin();
    // },
    // methods:{
    //     CheckLogin(){
    //         // if(!this.getCookie('session')){
    //         //     this.$router.push('/hello');
    //         // }else{
    //         //     this.$router.push('/home');
    //         // }
    //         this.$router.push('/home');
    //     }
    // }
}).$mount('#app')

