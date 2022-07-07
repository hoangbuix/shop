import { AxiosResponse } from "axios";
import service from "../utils/request";

const responseBody = <T>(res: AxiosResponse<T>) => res.data;

export const defaultApi = {
    get: <T>(url: string) => service.get<T>(url).then(responseBody),
    post: <T>(url: string, body: {}) => service.post<T>(url, body).then(responseBody),
    put: <T>(url: string, body: {}) => service.put<T>(url, body).then(responseBody),
    delete: <T>(url: string) => service.delete<T>(url).then(responseBody),
};