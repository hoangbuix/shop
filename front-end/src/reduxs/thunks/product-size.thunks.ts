import { getProductSizeAll } from "../../apis/product-size.api";
import * as actions from "../actions/product-size.actions";


// export const getProductSizeById = (id: string) => (dispatch?: any) => {
//     dispatch(actions.getProductSizeIdStart())
//     // return getUserId(id).then(res => {
//     //     return dispatch(actions.getUserIdSuccess(res))
//     // }).catch(err => dispatch(actions.getUserIdFailer(err)))
// }

export const getAllProductSize = () => (dispatch?: any) => {
    dispatch(actions.getProductSizeAllStart())
    return getProductSizeAll()
        .then(res => dispatch(actions.getProductSizeAllSuccess(res)))
        .catch(err => dispatch(actions.getProductSizeAllFailer(err)))
}