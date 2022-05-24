import service from "../utils/request";

export const getProductSizeAll = (): Promise<ResGetProductSizeAllApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.get(`/admin/product-size/findAll`)
                .then((response: any) => {
                    if (response.data.length > 0) {
                        resolve({
                            data: {
                                productSizes: response.data
                            },
                            message: 'success!'
                        })
                    }
                }).catch(err => {
                    reject(new Error('Get failer!'))
                })
        }, 100);
    });