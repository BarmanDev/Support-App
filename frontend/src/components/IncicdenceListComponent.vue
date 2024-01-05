<template>
    <div class="incidencias">
      <h1>LISTA DE INCIDENCIAS</h1>
      <button @click="createIncidence">CREAR NUEVA</button>
      <div class="incidencia" v-for="incidencia in incidencias" :key="incidencia.idIncidence">
        <h2>{{ incidencia.titleIncidence }}</h2>
        <div class="iconos">
          <img src="../assets/icons/MdiPen.svg" alt="Editar" @click="editarIncidencia(incidencia.idIncidence)">
          <img src="../assets/icons/MdiTrashCan.svg" alt="Borrar" @click="deleteIncidence(incidencia.idIncidence)">
          <img src="../assets/icons/MdiEye.svg" alt="Ver" @click="verIncidencia(incidencia.idIncidence)">
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        incidencias: [],
      }
    },
    async created() {
      try {
        const response = await fetch('http://localhost:8080/api/v1/incidence');
        if (!response.ok) {
          alert(`HTTP error! status: ${response.status}`);
        } else {
          this.incidencias = await response.json();
        }
      } catch (error) {
        alert(`Fetch error: ${error}`);
      }
    },
    methods: {
        createIncidence() {
            this.$router.push('/createincidence');
      },
        editarIncidencia(id) {
           this.$router.push({ name: 'editIncidence', params: { id: id } });
      },

      async deleteIncidence(id) {
        try {
          const response = await fetch(`http://localhost:8080/api/v1/incidence/deleteIncidence/${id}`, {
            method: 'DELETE',
          });
          if (!response.ok) {
            alert(`HTTP error! status: ${response.status}`);
          } else {
            this.incidencias = this.incidencias.filter(incidencia => incidencia.idIncidence !== id);
          }
        } catch (error) {
          alert(`Fetch error: ${error}`);
        }
      },
      verIncidencia(id) {
        this.$router.push({ name: 'incidenceView', params: { id: id } });
      }
    }
  }
  </script>
  
  <style lang="scss" scoped>
  .incidencias {
    width: 100%;
    padding: 20px;
    background-color: #f8f9fa;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
    padding-bottom: 7rem;
    h1 {
      text-align: center;
      margin-bottom: 20px;
      color: #343a40;
    }
    button {
      display: block;
      margin: 0 auto 20px;
      padding: 10px 20px;
      background-color: #EC4646;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      &:hover {
        background-color: #ce1919;
      }
    }
    .incidencia {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 20px;
      margin-bottom: 10px;
      border: 1px solid #ced4da; 
      border-radius: 4px;
      h2 {
        margin: 0;
        color: #495057;
      }
      .iconos {
        display: flex;
        img {
          cursor: pointer;
          width: 90px;
          height: 40px;
          &:not(:last-child) {
            margin-right: 10px;
          }
        }
      }
    }
  }
  </style>
  
  