import HTTP from "@/common/http";

const resource = "discos";

export default {
    async findAll() {
        const response = await HTTP.get(`${resource}`);
        return response.data;
    },
  async findById(id) {
      const response = await HTTP.get(`${resource}/${id}`);
      return response.data;
  },
  async addCancion(id,cancion){
      const response = await HTTP.put(`${resource}/${id}/canciones`,cancion);
      return response.data;

  }
}
