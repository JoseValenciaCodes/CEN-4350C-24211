/** Base API Axios Client */
import axios from "axios";

const baseClient = axios.create({
    baseURL: "http://localhost:8080/api",
    headers: {
        "Content-Type": "application/json"
    }
});

export default baseClient;