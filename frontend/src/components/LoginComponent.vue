<template>
  <div class="login-box">
    <input type="text" placeholder="Usuario" v-model="username">
    <input type="password" placeholder="Contraseña" v-model="password">
    <button class="btn-login" @click="login">Login</button>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  data() {
    return {
      username: '',
      password: '',
      router: useRouter(),  
    }
  },
  methods: {
    async login() {
      try {
        const response = await fetch('http://localhost:8080/api/v1/employee');
        if (!response.ok) {
          alert(`HTTP error! status: ${response.status}`);
        } else {
          const employees = await response.json();
          const employee = employees.find(emp => emp.name === this.username && emp.password === this.password);
          if (employee) {
            this.router.push('/about'); 
          } else {
            alert("Usuario o contraseña incorrecta intentelo de nuevo por favor");
          }
        }
      } catch (error) {
        alert(`Fetch error: ${error}`);
      }
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
  margin: 4rem auto;
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
