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
    methods: {
      async updateIncidence() {
        const id = this.$route.params.id;
        const url = `http://localhost:8080/api/v1/incidence/editIncidence/${id}`;
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
            alert('Incidencia actualizada con éxito');
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
  <div class="title">
    <h1>EDITAR INCIDENCIA </h1>
    <router-link to="/incidence" class="back-button">
      <img class="btn-back" src="../assets/icons/MdiArrowLeftBox.svg" alt="botón atras">
    </router-link>
  </div>
  <div class="crear-incidencia">      
    <form @submit.prevent="updateIncidence">
      <div class="form-container">
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
        <button type="submit">Actualizar</button>
      </div>
    </form>
  </div>
</template>

<style lang="scss" scoped>
.title {
  position: relative;
  background-color: #f8f9fa;
  margin: 0 auto;
  padding: 0.4rem;
}

.btn-back {
  position: absolute;
  top: 50%; /* Centra el botón verticalmente */
  right: 0;
  transform: translateY(-50%); 
  margin-right: 1.5rem;
  width: 4rem; 
}
.crear-incidencia {
    width: 100%;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
    background-color: #f8f9fa;
    padding-bottom: 5rem;

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
    .submit {
      display: flex;
      justify-content: center;
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
    }
    .form-container {
      display: flex;
      justify-content: space-between;


      @media (max-width: 600px) {
        flex-direction: column;  
      }
    }
    .left-column {
      flex: 1;
      margin-right: 10px;
  
    }
    .right-column {
      flex: 2;
    }

    @media (max-width: 600px) {

      button {  
        padding: 20px 40px;
        font-size: 1.2em;
      } 
    }
  }
</style>

  