import axios from "axios";
import { BACKEND_URL } from "../constants.js";

const HTTP = axios.create({
  baseURL: BACKEND_URL
});

export default HTTP;
