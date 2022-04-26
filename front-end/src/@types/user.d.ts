interface ReqLogin {
    email: string;
    password: string;
}

interface ResLoginApi extends Res {
    data: {
        data: any;
    }
}

interface ResLogin extends ActionRedux { }

interface User {
    id: number;
    avatar: String;
    firstName: String;
    lastName: String;
    password: String;
    email: String;
    username: String;
    roles: any;
    activeCode: null;
    activeFlag: number;
    createdDate: any;
    updatedDate: Date;
}

interface ResGetUserIdApi extends Res {
    data: {
        user: User
    }
}
interface ResGetUserId extends ActionRedux {
    payload: ResGetUserIdApi
}

interface ResGetUserAllApi extends Res {
    data: {
        users: any;
    }
}
interface ResGetUserAll extends ActionRedux {
    payload: ResGetUserAllApi
}