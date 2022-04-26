import service from "../utils/request";

export const getProductSizeAll = (): Promise<ResGetProductSizeAllApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.get(`/admin/product-size/findAll`).then((response) => {
                resolve({
                    data: {
                        productSizes: response
                    },
                    message: 'success!'
                })
            }).catch(err => {
                reject(new Error('Get failer!'))
            })
        }, 100);
    });