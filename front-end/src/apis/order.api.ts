import axiosClient from "../heplers/axiosClient"


export const getAllOrder = (): Promise<Order> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            axiosClient.get("http://localhost:8080/api/v1/admin/order/findAll")
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