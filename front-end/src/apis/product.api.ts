import service from "../utils/request";

export const getProductAll = (): Promise<ResGetProductAllApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.get(`/admin/product/findAll`).then((response) => {
                resolve({
                    data: {
                        products: response
                    },
                    message: 'success!'
                })
            }).catch(err => {
                reject(new Error('Get failer!'))
            })
        }, 100);
    });