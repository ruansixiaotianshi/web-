import Vue from 'vue'
import VueRouter from 'vue-router'
import UsersManage from '../views/UsersManage'
import AddUsers from '../views/AddUsers'
import Index from '../views/Index'
import UsersUpdate from '../views/UsersUpdate'
import SelectData from "../views/SelectData";
import DataCode from "../views/DataCode";
import Login from "../views/Login";
import Register from "../views/Register";
Vue.use(VueRouter)

const routes = [
  {
    path: "/Login",
    name: "用户登陆",
    component: Login,

  },
    {
        path: "/Register",
        name: "用户注册",
        component: Register,

    },

  { path:"/",
        name:"人员管理",
        component:Index,
        show:true,
        redirect:"/Register",
        children:[
          {
            path:"/UsersManage",
            name:"用户查询",
            component:UsersManage
          },
          {
            path:"/AddUsers",
            name:"添加用户",
            component:AddUsers
          }
        ]
      },
      {
        path:"/",
        name:"数据管理",
        component:Index,
        show:true,
        redirect:"/Login",
        children:[
          {
            path:"/SelectData",
            name:"数据查询",
            component:SelectData
          },
          {
            path:"/DataCode",
            name:"数据加密",
            component:DataCode
          }
        ]
      },

      {
        path:'/update',
        component:UsersUpdate,
        show:false
      }





  ]




const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
