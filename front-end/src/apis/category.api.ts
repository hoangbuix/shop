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

export const addCategory = ({ categoryCode, categoryName, description }: ReqAddCategory): Promise<ResAddCategoryApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.post(`/admin/category/create`, { categoryCode, categoryName, description })
                .then((response: any) => {
                    resolve({
                        data: {
                            addCategory: response
                        },
                        message: 'Create success!'
                    })
                }).catch((err: any) => {
                    console.log(err.payload.message)
                    reject(new Error('Get failer!'))
                })
        }, 100);
    });


export const updateCategory = ({ id, categoryCode, categoryName, description, activeFlag }: ReqCategory): Promise<ResUpdateCategoryApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.put(`/admin/category/update`, { id, categoryCode, categoryName, description, activeFlag }).then((response) => {
                resolve({
                    data: {
                        category: response
                    },
                    message: 'Update success!'
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