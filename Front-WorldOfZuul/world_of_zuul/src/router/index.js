import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router)

import HelloWorld from '../components/HelloWorld.vue';
import loginInterface from '../views/loginInterface.vue';

export default new Router({

    mode:'history',
      routes: [
        {
          path: '/hello',
          component: HelloWorld 
        },
        {
          path: '/home',
          component: loginInterface
        }
      ]
    })