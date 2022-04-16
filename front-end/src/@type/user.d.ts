interface ReqLogin {
    email: string
    password: string
}
interface ResLoginApi extends Res {
    response: {
        data: any
    }
}

interface ResLogin extends ActionRedux { }