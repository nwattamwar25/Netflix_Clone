import axios from "axios";

export const BASE_URL = 'http://localhost:8181/api/v1/user';

export const myAxios = axios.create({
    baseURL: BASE_URL
});