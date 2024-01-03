<template>
    <div class="incidencias">
      <h1>Lista de Incidencias</h1>
      <button @click="createIncidence">Crear Nueva Incidencia</button>
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
      },
      editarIncidencia(id) {
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
      }
    }
  }
  </script>
  
  <style lang="scss">
  .incidencias {
    width: 100%;
    padding: 20px;
    h1 {
      text-align: center;
      margin-bottom: 20px;
    }
    button {
      display: block;
      margin: 0 auto 20px;
      padding: 10px 20px;
    }
    .incidencia {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 20px;
      margin-bottom: 10px;
      border: 1px solid red; 
      h2 {
        margin: 0;
      }
      .iconos {
        display: flex;
        img {
          cursor: pointer;
          width: 20px;
          height: 20px;
          &:not(:last-child) {
            margin-right: 10px;
          }
        }
      }
    }
  }
  </style>
  