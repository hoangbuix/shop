import { loginUser, getUserId, getUserAll } from "../../apis/user.api";
import * as actions from "../actions/user.actions";

export const login = (payload: ReqLogin) => (dispatch?: any) => {
    dispatch(actions.loginStart())
    return loginUser(payload)
        .then(res => {
            return dispatch(actions.loginSuccess(res))
        }).catch(err =>
            Promise.reject(dispatch(actions.loginFailer(err))))
};

export const getUserById = (id: string) => (dispatch?: any) => {
    dispatch(actions.getUserIdStart())
    // return getUserId(id).then(res => {
    //     return dispatch(actions.getUserIdSuccess(res))
    // }).catch(err => dispatch(actions.getUserIdFailer(err)))
}

export const getAllUser = () => (dispatch?: any) => {
    dispatch(actions.getUserAllStart())
    return getUserAll()
        .then(res => dispatch(actions.getUserAllSuccess(res))
        ).catch(err => dispatch(actions.getUserAllFailer(err)))
}