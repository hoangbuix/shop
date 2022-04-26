import service from "../utils/request";

export const getCategoryAll = (): Promise<ResGetCategoryAllApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.get(`/admin/category/findAll`).then((response) => {
                resolve({
                    data: {
                        categorys: response
                    },
                    message: 'success!'
                })
            }).catch(err => {
                reject(new Error('Get failer!'))
            })
        }, 100);
    });


export const deleteCategoryId = (id: any): Promise<ResDeleteCategoryIdApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.delete(`/admin/category/delete/${id}`).then((response) => {
                resolve({
                    data: {
                        message: response
                    },
                    message: 'Delete success!'
                })
            }).catch(err => {
                reject(new Error('Get failer!'))
            })
        }, 100);
    });