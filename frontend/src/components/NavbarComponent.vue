
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
      <a @click="logout">Logout</a>
    </nav>
</template>
  
  <style lang="scss">
  .navbar {
    background-color: #EC4646;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    .logo {
      display: flex;
      align-items: center;
      img {
        width: 100px;
        margin-right: 10px;
      }
    }
  }
  </style>
  