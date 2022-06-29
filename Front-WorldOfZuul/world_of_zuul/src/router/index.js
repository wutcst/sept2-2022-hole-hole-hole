import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router)

import loginInterface from '../views/loginInterface.vue';
import Home from '../components/Home.vue'

export default new Router({

    mode:'history',
      routes: [
        {
          path: '/index',
          name: 'index',
          component: loginInterface
        },
        {
          path: '/home',
          name: 'home',
          component: Home
        }
      ]
    })
