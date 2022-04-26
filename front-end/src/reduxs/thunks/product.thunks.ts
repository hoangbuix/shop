import { getProductAll } from "../../apis/product.api";
import * as actions from "../actions/product.actions";



export const getProductById = (id: string) => (dispatch?: any) => {
    dispatch(actions.getProductIdStart())
    // return getUserId(id).then(res => {
    //     return dispatch(actions.getUserIdSuccess(res))
    // }).catch(err => dispatch(actions.getUserIdFailer(err)))
}

export const getAllProduct = () => (dispatch?: any) => {
    dispatch(actions.getProductAllStart())
    return getProductAll()
        .then(res => dispatch(actions.getProductAllSuccess(res))
        ).catch(err => dispatch(actions.getProductAllFailer(err)))
}