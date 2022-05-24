import service from "../utils/request";



export const loginUser = ({ email, password }: ReqLogin): Promise<ResLoginApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.post(`/admin/user/login`, { email, password }).then((response) => {
                if (response.data) {
                    resolve({
                        data: {
                            data: response.data
                        }, message: 'Login success!'
                    })
                }
            }).catch(err => {
                reject(new Error('Login failer!'))
            })

        }, 500);
    });


export const getUserId = (id: string): Promise<ResGetUserIdApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.get(`${process.env.API_URL}/admin/user/get-user-id/${id}`).then((response) => {
                if (response.data) {
                    resolve({
                        data: {
                            user: response.data
                        },
                        message: 'success!'
                    })
                }
            }).catch(err => {
                reject(new Error('Get failer!'))
            })
        }, 500);
    });

export const getUserAll = (): Promise<ResGetUserAllApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            service.get(`/admin/user/get-all`).then((response) => {
                if (response.data) {
                    resolve({
                        data: {
                            users: response.data
                        },
                        message: 'success!'
                    })
                }
            }).catch(err => {
                reject(new Error('Get failer!'))
            })
        }, 100);
    });