import axiosClient from "../heplers/axiosClient"


export const loginApi = ({ email, password }: ReqLogin): Promise<ResLoginApi> =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            axiosClient.post("http://localhost:8080/api/v1/admin/user/login", { email, password })
                .then((res: any) => {
                    resolve({
                        response: {
                            data: res
                        },
                        message: "Login thành công"
                    })
                }).catch(err => {
                    reject(new Error("Login thất bại"))
                })
        }, 100)
    })