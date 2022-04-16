import axiosClient from "../heplers/axiosClient"

export const findProductSizeById = (id: any): Promise<ProductSize> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            axiosClient.get(`http://localhost:8080/api/v1/admin/product-size/findById/${id}`)
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