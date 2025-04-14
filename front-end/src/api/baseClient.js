/** Base API Axios Client */
import axios from "axios";

// Base Axios API Request Client
const baseClient = axios.create({
    baseURL: "http://localhost:8080/api",
    headers: {
        "Content-Type": "application/json"
    }
});

// Authorize requests that require JWT Tokens
baseClient.interceptors.request.use(config => {
    
    const { jwtToken } = JSON.parse(sessionStorage.getItem("user"));

    if (jwtToken)
    {
        config.headers.Authorization = `Bearer ${jwtToken}`;
    }

    return config;
},
    error => {
        Promise.reject(error);
    }
);

export default baseClient;