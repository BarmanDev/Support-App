<script>
  export default {
    data() {
      return {
        incidencia: '',
        nombre: '',
        fecha: '',
        tipo: '',
        descripcion: '',
      }
    },
    methods: {
      async createIncidence() {
        const url = 'http://localhost:8080/api/v1/incidence';
        const data = {
            titleIncidence: this.incidencia,
            despriptionIncidence: this.descripcion,
            typeIncidence: this.tipo,
            dateIncidence: this.fecha,
        };
  
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
  
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          } else {
            alert('Incidencia creada con éxito');
            this.$router.push('/incidence');
          }
        } catch (error) {
          alert(`Fetch error: ${error}`);
        }
      },
    },
  }
  </script>
<template>
  <div class="crear-incidencia">
    <h1>CREAR INCIDENCIA</h1>
    <form @submit.prevent="createIncidence">
      <div class="form-content">  <!-- nuevo contenedor alrededor de las columnas -->
        <div class="left-column">
            <label for="incidencia">Titulo de incidencia</label>
            <input id="incidencia" v-model="incidencia" required>

          <label for="fecha">Fecha:</label>
          <input id="fecha" v-model="fecha" required>

          <label for="tipo">Tipo de problema:</label>
          <select id="tipo" v-model="tipo" required>
            <option disabled value="">Selecciona un tipo</option>
            <option>Hardware</option>
            <option>Software</option>
          </select>
        </div>

        <div class="right-column">
          <label for="descripcion">Descripción:</label>
          <textarea id="descripcion" v-model="descripcion" required></textarea>
        </div>
      </div>
      <div class="submit">
        <button type="submit">Enviar</button>
      </div>
    </form>
  </div>
</template>
  
<style lang="scss" scoped>
.crear-incidencia {
  width: 100%;
  min-height:69vh;  
  padding: 20px;
  padding-bottom: 4rem;
  background-color: #f8f9fa;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
  h1 {
    text-align: center;
    margin-bottom: 20px;
    color: #343a40;
  }
  form {
    .form-content {  
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
    }
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
      height: 15rem;
    }
    .left-column {
      flex: 1;
      margin-right: 10px;
    }
    .right-column {
      flex: 2;
    }
  }
  .submit {
    button {
      margin-top: 20px;
      padding: 10px 20px;
      background-color: #EC4646;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      margin-left: auto;  
      margin-right: auto;
      display: block;
      &:hover {
        background-color: #ce1919;
      }
    }
  }
  @media (max-width: 600px) {
    form {
      .form-content {
        flex-direction: column;
        .left-column, .right-column {
          margin-right: 0;  
        }
      }
    }
  }
}
</style>
