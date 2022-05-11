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

export const updateCategoryStart = () => ({
    type: types.UPDATTE_CATEGORY_ID_START
});

export const updateCategorySuccess = (categoryUpdate: ResUpdateCategoryApi) => ({
    type: types.UPDATTE_CATEGORY_ID_SUCCESS,
    payload: categoryUpdate
});

export const updateCategoryFailer = (messageError: string) => ({
    type: types.UPDATTE_CATEGORY_ID_FAILER,
    payload: messageError
});

export const addCategoryStart = () => ({
    type: types.ADD_CATEGORY_START
});

export const addCategorySuccess = (addCategory: ResAddCategoryApi) => ({
    type: types.ADD_CATEGORY_SUCCESS,
    payload: addCategory
});

export const addCategoryFailer = (messageError: string) => ({
    type: types.ADD_CATEGORY_FAILER,
    payload: messageError
});