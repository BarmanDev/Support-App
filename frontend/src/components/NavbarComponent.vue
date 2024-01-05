
  <script>
  export default {
    methods: {
      logout() {
      }
    }
  }
  </script>

<template>
    <nav class="navbar">
      <div class="logo">
        <img src="../assets/img/escudo-gijón.png" alt="Logo ayto Gijón">
        <span class="logo-text">DEPARTAMENTO INFORMÁTICA <br> AYTO DE GIJÓN</span>
        
      </div>
      <a @click="logout">LOGOUT</a>
    </nav>
</template>
  
  <style lang="scss">
  .navbar {
    background-color: #EC4646;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    a {
        margin: 1rem;
      }
    .logo {
      display: flex;
      align-items: center;
      img {
        margin-left: 2rem;
        width: 90px;
        margin-right: 10px;
      }
   
    }
  }
  </style>
  