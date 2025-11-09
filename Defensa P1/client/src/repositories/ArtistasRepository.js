import HTTP from "@/common/http";

const resource = "artistas";

export default {
  async findById(id) {
    const response = await HTTP.get(`${resource}/${id}`);
    return response.data;
  },
  async findDiscosById(id) {
    const response = await HTTP.get(`${resource}/${id}/discos`);
    return response.data;
  }
}
