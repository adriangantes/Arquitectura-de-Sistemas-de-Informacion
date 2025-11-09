<template>
  <div v-if="artista != null">
    <div>
      <span>Nombre: </span>
      <span>{{ artista.nombre }}</span>
      <br />
      <span>Discos: </span>
      <ul v-if="discos && discos.length" class="no-bullets">
        <li v-for="disco in discos" :key="disco.id">
          {{ disco.titulo }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import ArtistasRepository from "@/repositories/ArtistasRepository";

export default {
  data() {
    return {
      artista: null,
      discos: null,
    };
  },
  async mounted() {
    this.artista = await ArtistasRepository.findById(this.$route.params.id);
    this.discos = await ArtistasRepository.findDiscosById(this.$route.params.id);
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
