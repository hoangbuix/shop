import * as types from "../constains/product.constains";


export const getProductIdStart = () => ({
    type: types.GET_PRODUCT_ID_START
});

export const getProductIdSuccess = (product: ResGetProductIdApi) => ({
    type: types.GET_PRODUCT_ID_SUCCESS,
    payload: product
});

export const getProductIdFailer = (messageError: string) => ({
    type: types.GET_PRODUCT_ID_FAILER,
    payload: messageError
});

export const getProductAllStart = () => ({
    type: types.GET_PRODUCT_ALL_START
});

export const getProductAllSuccess = (products: ResGetProductAllApi) => ({
    type: types.GET_PRODUCT_ALL_SUCCESS,
    payload: products,
});

export const getProductAllFailer = (messageError: string) => ({
    type: types.GET_PRODUCT_ALL_FAILER,
    payload: messageError
});