interface ReqLogin {
    email: string
    password: string
}
interface ResLoginApi extends Res {
    data: {
        access_token: any
    }
}

interface ResLogin extends ActionRedux { }