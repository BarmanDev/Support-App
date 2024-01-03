<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Navbar from './components/NavbarComponent.vue'
import Footer from './components/FooterComponent.vue'
</script>

<template>
  <header>
    <Navbar />
      <!-- <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav> -->
  </header>

  <RouterView />
  <Footer />
</template>

<style scoped lang="scss">
@import './assets/style.scss'



</style>
