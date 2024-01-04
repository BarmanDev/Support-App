<template>
    <div class="crear-incidencia">
      <h1>Ver Incidencia</h1>
      <div class="left-column">
        <label for="incidencia">Titulo de incidencia</label>
        <input id="incidencia" v-model="incidencia" readonly>
  
        <label for="fecha">Fecha:</label>
        <input id="fecha" v-model="fecha" readonly>
  
        <label for="tipo">Tipo de problema:</label>
        <input id="tipo" v-model="tipo" readonly>
      </div>
  
      <div class="right-column">
        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" v-model="descripcion" readonly></textarea>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        incidencia: '',
        fecha: '',
        tipo: '',
        descripcion: '',
      };
    },
    async created() {
      const id = this.$route.params.id;
      try {
        const response = await fetch(`http://localhost:8080/api/v1/incidence/${id}`);
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        } else {
          const data = await response.json();
          this.incidencia = data.titleIncidence;
          this.fecha = data.dateIncidence;
          this.tipo = data.typeIncidence;
          this.descripcion = data.despriptionIncidence;
        }
      } catch (error) {
        alert(`Fetch error: ${error}`);
      }
    },
  };
  </script>
  
  <style lang="scss" scoped>
  .crear-incidencia {
    width: 100%;
    padding: 20px;
    background-color: #f8f9fa;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
    h1 {
      text-align: center;
      margin-bottom: 20px;
      color: #343a40;
    }
    display: flex;
    justify-content: space-between;
    label {
      font-weight: bold;
      color: #495057;
    }
    input, select, textarea {
      display: block;
      width: 100%;
      padding: 10px;
      border: 1px solid #ced4da;
      border-radius: 4px;
      color: #495057;
      margin-bottom: 10px;
    }
  
    textarea{
      height: 20rem;
    }
    button {
      margin-top: 20px;
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
    .left-column {
      flex: 1;
      margin-right: 10px;
    }
    .right-column {
      flex: 2;
    }
  }
  </style>
  