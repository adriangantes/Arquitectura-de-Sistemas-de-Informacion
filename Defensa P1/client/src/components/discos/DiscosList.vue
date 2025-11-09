<template>
  <div>
    <h2>Discos</h2>
    <ul class="no-bullets">
      <li v-for="disco in discos" :key="disco.id">
        <router-link :to="{ name: 'DiscoDetail', params: { id: disco.id } }">{{ disco.titulo }}</router-link> -
        <router-link :to="{ name: 'ArtistaDetail', params: { id: disco.interprete.id } }">{{ disco.interprete.nombre }}</router-link>
         - {{ disco.cancionesCount }} canciones      </li>
    </ul>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import DiscosRepository from "@/repositories/DiscosRepository";

const discos = ref([]);

async function loadDiscos() {
  try {
    const res = await DiscosRepository.findAll();
    const lista = res?.data ?? res ?? [];

    discos.value = await Promise.all(
      lista.map(async (d) => {
        try {
          const r = await DiscosRepository.findById(d.id);
          const cancionesCount = r.canciones.length;
          return { ...d, cancionesCount };
        } catch (e) {
          console.error("Error cargando disco", d.id, e);
          return { ...d, cancionesCount: 0 };
        }
      })
    );
  } catch (e) {
    console.error(e);
    discos.value = [];
  }
}

onMounted(loadDiscos);
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
