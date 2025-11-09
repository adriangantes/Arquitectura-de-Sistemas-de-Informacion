import { createRouter, createWebHistory } from "vue-router";
import HelloWorld from "../components/HelloWorld.vue";
import ErrorNotFoundView from "../views/ErrorNotFoundView.vue";

import discosRoutes from "@/components/discos/routes.js";
import artistasRoutes from "@/components/artistas/routes.js";

const routes = [
  {
    path: "/",
    name: "HelloWorld",
    component: HelloWorld,
    meta: { public: true }
  },
  {
    path: "/:catchAll(.*)*",
    component: ErrorNotFoundView,
    meta: { public: true }
  }
].concat(discosRoutes).concat(artistasRoutes);

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
