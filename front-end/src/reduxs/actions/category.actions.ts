import * as types from "../constains/category.constains";


export const getCategoryIdStart = () => ({
    type: types.GET_CATEGORY_ID_START
});

export const getCategoryIdSuccess = (category: ResGetCategoryIdApi) => ({
    type: types.GET_CATEGORY_ID_SUCCESS,
    payload: category
});

export const getCategoryIdFailer = (messageError: string) => ({
    type: types.GET_CATEGORY_ID_FAILER,
    payload: messageError
});

export const getCategoryAllStart = () => ({
    type: types.GET_CATEGORY_ALL_START
});

export const getCategoryAllSuccess = (categorys: ResGetCategoryAllApi) => ({
    type: types.GET_CATEGORY_ALL_SUCCESS,
    payload: categorys,
});

export const getCategoryAllFailer = (messageError: string) => ({
    type: types.GET_CATEGORY_ALL_FAILER,
    payload: messageError
});


export const deleteCategoryIdStart = () => ({
    type: types.DELETE_CATEGORY_ID_START
});

export const deleteCategoryIdSuccess = (message: ResDeleteCategoryIdApi) => ({
    type: types.DELETE_CATEGORY_ID_SUCCESS,
    payload: message
});

export const deleteCategoryIdFailer = (messageError: string) => ({
    type: types.DELETE_CATEGORY_ID_FAILER,
    payload: messageError
});