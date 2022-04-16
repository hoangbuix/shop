import axiosClient from "../heplers/axiosClient"


export const getAllProduct = (): Promise<Product> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            axiosClient.get("http://localhost:8080/api/v1/admin/product/findAll")
                .then((res: any) => {
                    resolve({
                        response: {
                            data: res,
                        },
                        message: "Success"
                    })
                }).catch(err => {
                    reject(new Error("Error"))
                })
        }, 1000)
    });

export const findByProductId = (id: any): Promise<Product> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            axiosClient.get(`http://localhost:8080/api/v1/admin/product/findById/${id}`)
                .then((res: any) => {
                    resolve({
                        response: {
                            data: res,
                        },
                        message: "Success"
                    })
                }).catch(err => {
                    reject(new Error("Error"))
                })
        }, 1000)
    })