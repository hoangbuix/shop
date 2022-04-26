import * as types from "../constains/user.constains";

export const loginStart = () => ({
    type: types.LOGIN_START
});

export const loginSuccess = (user: ResLoginApi) => ({
    type: types.LOGIN_SUCCESS,
    payload: user
});

export const loginFailer = (messageError: string) => ({
    type: types.LOGIN_FAILER,
    payload: messageError
});

export const getUserIdStart = () => ({
    type: types.GET_USER_ID_START
});

export const getUserIdSuccess = (user: ResGetUserIdApi) => ({
    type: types.GET_USER_ID_SUCCESS,
    payload: user
});

export const getUserIdFailer = (messageError: string) => ({
    type: types.GET_USER_ID_FAILER,
    payload: messageError
});

export const getUserAllStart = () => ({
    type: types.GET_USER_ALL_START
});

export const getUserAllSuccess = (users: ResGetUserAllApi) => ({
    type: types.GET_USER_ALL_SUCCESS,
    payload: users,
});

export const getUserAllFailer = (messageError: string) => ({
    type: types.GET_USER_ALL_FAILER,
    payload: messageError
});