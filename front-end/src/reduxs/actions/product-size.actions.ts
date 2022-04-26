import * as types from "../constains/product-size.constains";


export const getProductSizeIdStart = () => ({
    type: types.GET_PRODUCTSIZE_ID_START
});

export const getProductSizeIdSuccess = (productSize: ResGetProductSizeIdApi) => ({
    type: types.GET_PRODUCTSIZE_ID_SUCCESS,
    payload: productSize
});

export const getProductSizeIdFailer = (messageError: string) => ({
    type: types.GET_PRODUCTSIZE_ID_FAILER,
    payload: messageError
});

export const getProductSizeAllStart = () => ({
    type: types.GET_PRODUCTSIZE_ALL_START
});

export const getProductSizeAllSuccess = (productSizes: ResGetProductSizeAllApi) => ({
    type: types.GET_PRODUCTSIZE_ALL_SUCCESS,
    payload: productSizes,
});

export const getProductSizeAllFailer = (messageError: string) => ({
    type: types.GET_PRODUCTSIZE_ALL_FAILER,
    payload: messageError
});
