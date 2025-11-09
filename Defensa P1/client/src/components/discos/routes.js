import DiscosList from "./DiscosList.vue";
import DiscoDetail from "./DiscoDetail.vue";

export default [
  {
    path: "/discos",
    name: "DiscosList",
    component: DiscosList
  },
  {
    path: "/discos/:id",
    name: "DiscoDetail",
    component: DiscoDetail
  }
  ]
