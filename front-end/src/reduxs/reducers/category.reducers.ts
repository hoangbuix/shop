import * as types from "../constains/category.constains";

const inintialState = {
    categorys: [],
    isFetching: false,
    messageError: '',
    isAuthenticated: false,
    category: null as any | null,
    data: [],
    message: null as any | null,
}

const categoryReducer = (state = inintialState, action: { type: any, payload: any }) => {
    switch (action.type) {
        case types.GET_CATEGORY_ID_START:
            return { ...state, isFetching: true };
        case types.GET_CATEGORY_ID_SUCCESS:
            return {
                ...state, isFetching: false,
                category: action.payload.data.category, isAuthenticated: true
            };
        case types.GET_CATEGORY_ID_FAILER:
            return {
                ...state,
                messageError: action.payload
            };
        case types.GET_CATEGORY_ALL_START:
            return { ...state, isFetching: true };
        case types.GET_CATEGORY_ALL_SUCCESS:
            return {
                ...state, isFetching: false,
                categorys: action.payload.data.categorys, isAuthenticated: true
            };
        case types.GET_CATEGORY_ALL_FAILER:
            return { ...state, messageError: action.payload };
        case types.DELETE_CATEGORY_ID_START:
            return { ...state, isFetching: true };
        case types.DELETE_CATEGORY_ID_SUCCESS:
            return {
                ...state, isFetching: false,
                message: action.payload.data.message, isAuthenticated: true
            };
        case types.DELETE_CATEGORY_ID_FAILER:
            return {
                ...state,
                messageError: action.payload
            };
        default:
            return state;
    }
};

export default categoryReducer;