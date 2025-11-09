<template>
  <div v-if="disco != null">
    <div>
      <span>Título: </span>
      <span>{{ disco.titulo }}</span>
      <br />
      <span>Interprete: </span>
      <span>{{ disco.interprete?.nombre ?? "N/A" }}</span>
      <br />
      <div>
      <span>Canciones: </span>
      <div>
        <ul class="no-bullets">
          <li v-for="cancion in disco.canciones" :key="cancion.id">
            {{ cancion.numeroDePista }} - {{ cancion.titulo }}
          </li>
        </ul>
      </div>
      </div>
    </div>
  </div>
  <div>
    <form @submit.prevent="addCancion" class="add-song-form" style="margin-top:8px;">
      <input
        v-model="nuevaCancionTitulo"
        placeholder="Título nueva canción"
        required
      />
      <button type="submit" :disabled="!nuevaCancionTitulo.trim()">Añadir canción</button>
    </form>
  </div>
</template>

<script>
import DiscosRepository from "@/repositories/DiscosRepository";

export default {
  data() {
    return {
      disco: null,
      nuevaCancionTitulo: ""
    };
  },
  async mounted() {
    await this.loadDisco();
  },
  methods: {
    async loadDisco() {
      this.disco = await DiscosRepository.findById(this.$route.params.id);
      if (this.disco?.canciones) {
        this.disco.canciones = this.disco.canciones
          .slice()
          .sort((a, b) => a.numeroDePista - b.numeroDePista);
      }
    },
    async addCancion() {
      if (!this.nuevaCancionTitulo || !this.nuevaCancionTitulo.trim()) return;
      const nueva = {
        cancion: this.nuevaCancionTitulo.trim()
      };
      try {
        await DiscosRepository.addCancion(this.disco.id, nueva);
        this.nuevaCancionTitulo = "";
        await this.loadDisco();
      } catch (e) {
        console.error("Error al añadir canción:", e);
      }
    }
  }
};
</script>


<style scoped>
h2 {
  margin-bottom: 8px;
}
.no-bullets {
  list-style: none;
  padding-left: 0;
  margin: 0;
}
ul {
  padding-left: 16px;
}
li {
  margin: 6px 0;
}
</style>
