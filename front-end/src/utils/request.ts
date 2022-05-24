import axios from "axios";

interface ReqMessage {
  message: any;
  type: any;
  duration: any;
}

export const Message = ({ message, type, duration }: ReqMessage): any => {
  return {
    message: message,
    type: type,
    duration: duration,
  };
};
// const URL: any = process.env.REACT_APP_API_URL;
// create an axios instance
const service = axios.create({
  baseURL: "/api/v1/", // api base_url
  timeout: 5000, // request timeout
  headers: { "Content-Type": "application/json" },
  // withCredentials: false,
  xsrfCookieName: "JWT_TOKEN",
  xsrfHeaderName: "X-JWT_TOKEN",
});

// request interceptor
service.interceptors.request.use((serviceConfig: any) => {
  // const cookies = new Cookies();
  // const getCookie = cookies.getCookie("JWT_TOKEN");
  // if (getCookie)
  //   serviceConfig.headers["Cookie"] = `${getCookie}`;

  return serviceConfig;
},
  (error) => {
    Promise.reject(error);
  }
);

// respone interceptor
service.interceptors.response.use((response) => {
  if (response && response.data) {
    return response;
  }
  return response;
},
  (error) => {
    Message({
      message: error.message,
      type: "error",
      duration: 5 * 1000,
    });
    return Promise.reject(error);
  }
);

export default service;
