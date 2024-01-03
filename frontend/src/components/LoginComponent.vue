<template>
    <div class="login-box">
      <input type="text" placeholder="Usuario" v-model="username">
      <input type="password" placeholder="Contraseña" v-model="password">
      <button class="btn-login" @click="login">Login</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      login() {
      }
    }
  }
  </script>
  
  <style lang="scss">
  .login-box {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 30rem;
    height: 20rem;
    margin: 4rem  auto;
    padding: 20px;
    background-color: #EC4646;
    input {
      margin-bottom: 20px;
      width: 23rem;  
    height: 3rem; 
    font-size: 16px;
    text-align: center;
    }
    .btn-login {
      cursor: pointer;
      width: 10rem;
      height: 40px; 
      font-size: 16px;  
    }
  }
  </style>
  