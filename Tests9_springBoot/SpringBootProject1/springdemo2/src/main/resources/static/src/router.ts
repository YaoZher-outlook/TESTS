import { createRouter, createWebHistory } from 'vue-router'
import Home from './views/Home.vue'
import List from './views/List.vue'
import Profile from './views/Profile.vue'
import Attendance from './views/Attendance.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/list', name: 'List', component: List },
  { path: '/profile/:id', name: 'Profile', component: Profile, props: true },
  { path: '/attendance/:id', name: 'Attendance', component: Attendance, props: true }
]

export const router = createRouter({
  history: createWebHistory(),
  routes
})
