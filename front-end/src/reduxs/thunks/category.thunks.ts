import { getCategoryAll, deleteCategoryId } from "../../apis/category.api";
import * as actions from "../actions/category.actions";



export const getCategoryById = (id: string) => (dispatch?: any) => {
    dispatch(actions.getCategoryIdStart())
    // return getUserId(id).then(res => {
    //     return dispatch(actions.getUserIdSuccess(res))
    // }).catch(err => dispatch(actions.getUserIdFailer(err)))
}

export const getAllCategory = () => (dispatch?: any) => {
    dispatch(actions.getCategoryAllStart())
    return getCategoryAll()
        .then(res => dispatch(actions.getCategoryAllSuccess(res)))
        .catch(err => dispatch(actions.getCategoryAllFailer(err)))
}

export const deleteCategoryById = (id: string) => (dispatch?: any) => {
    dispatch(actions.deleteCategoryIdStart())
    return deleteCategoryId(id).then(res => {
        return dispatch(actions.deleteCategoryIdSuccess(res))
    }).catch(err => dispatch(actions.deleteCategoryIdFailer(err)))
}