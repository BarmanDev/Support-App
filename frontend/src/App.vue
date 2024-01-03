<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Navbar from './components/NavbarComponent.vue'
</script>

<template>
  <header>
    <Navbar></Navbar>
      <!-- <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav> -->
  </header>

  <RouterView />
</template>

<style scoped lang="scss">
@import './assets/style.scss'



</style>
