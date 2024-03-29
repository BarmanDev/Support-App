import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/incidence',
      name: 'incidence',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/IncidenceListView.vue')
    },
    {
      path: '/createincidence',
      name: 'createincidence',
      component: () => import('../views/CreateIncidenceView.vue')

    },
    {
      path: '/incidence/:id',
      name: 'incidenceView',
      component: () => import('../views/IncidenceView.vue')
    },
    {
      path: '/editincidence/:id',
      name: 'editIncidence',
      component: () => import('../views/EditIncidenceView.vue')
    }
    
  ]
})

export default router
