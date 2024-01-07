<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Navbar from './components/NavbarComponent.vue'
import Footer from './components/FooterComponent.vue'
</script>

<template>
  <header>
    <Navbar />
  </header>

  <RouterView />
  <Footer />
</template>

<style scoped lang="scss">
@import './assets/style.scss'



</style>
