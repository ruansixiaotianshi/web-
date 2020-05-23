import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import PageOne from '../views/PageOne.vue'
import PageTwo from '../views/PageTwo.vue'
import PageThree from '../views/PageThree.vue'
import PageFour from '../views/PageFour.vue'
import App from '../App';
Vue.use(VueRouter)

  const routes = [
  {
    path: "/",
    name: "导航1",
    component: App,
    children:[
      {
        path: "/pageOne",
        name:"页面1",
        component: PageOne
      },

      {
        path: "/pageTwo",
        name:"页面2",
        component: PageTwo
      }

    ]
  },
    {
      path:"/navigation",
      name:"导航2",
      component: App,
      children: [
        {
          path: "/pageThree",
          name:"页面3",
          component: PageThree
        },
        {
          path: "/pageFour",
          name:"页面4",
          component: PageFour
        }

      ]
    }



  ]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
