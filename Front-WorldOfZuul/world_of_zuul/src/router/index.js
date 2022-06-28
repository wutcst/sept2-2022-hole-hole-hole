import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router)

import Home from '../components/HelloWorld.vue';
import loginInterface from '../views/loginInterface.vue';
import Home from '../components/Home.vue'

export default new Router({

    mode:'history',
      routes: [
        {
          path: '/hello',
          component: Home
        },
        {
          path: '/index',
          component: loginInterface
        },
        {
          path: '/home',
          component: Home
        }
      ]
    })