import Vue from "vue";
import Vuex from "vuex"

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        domain:'www.baidu.com',
        UserInfo:{
            level: null,
        }
    },

    mutations:{
        updateUserInfo(state,newUserInfo){
            state.UserInfo = newUserInfo;
        }
    }
})