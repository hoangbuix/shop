import { getCategoryAll, addCategory, updateCategory, deleteCategoryId } from "../../apis/category.api";
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

export const categoryAdd = ({ categoryCode, categoryName, description }: ReqAddCategory) => (dispatch?: any) => {
    const payload = { categoryCode, categoryName, description }
    dispatch(actions.addCategoryStart())
    return addCategory(payload).then(res => {
        return dispatch(actions.addCategorySuccess(res))
    }).catch(err => Promise.reject(dispatch(actions.addCategoryFailer(err))))
}


export const categoryUpdate = ({ id, categoryCode, categoryName, description, activeFlag }: ReqCategory) => (dispatch?: any) => {
    const payload = { id, categoryCode, categoryName, description, activeFlag }
    dispatch(actions.updateCategoryStart())
    return updateCategory(payload).then(res => {
        return dispatch(actions.updateCategorySuccess(res))
    }).catch(err => Promise.reject(dispatch(actions.updateCategoryFailer(err))))
}



export const deleteCategoryById = (id: string) => (dispatch?: any) => {
    dispatch(actions.deleteCategoryIdStart())
    return deleteCategoryId(id).then(res => {
        return dispatch(actions.deleteCategoryIdSuccess(res))
    }).catch(err => dispatch(actions.deleteCategoryIdFailer(err)))
}