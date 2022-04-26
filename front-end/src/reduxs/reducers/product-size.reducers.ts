import * as types from "../constains/product-size.constains";

const inintialState = {
    productSizes: [],
    isFetching: false,
    messageError: '',
    isAuthenticated: false,
    productSize: null as ProductSize | null,
    data: []
}

const productSizeReducer = (state = inintialState, action: { type: any, payload: any }) => {
    switch (action.type) {
        case types.GET_PRODUCTSIZE_ID_START:
            return { ...state, isFetching: true };
        case types.GET_PRODUCTSIZE_ID_SUCCESS:
            return {
                ...state, isFetching: false,
                productSize: action.payload.data.productSize, isAuthenticated: true
            };
        case types.GET_PRODUCTSIZE_ID_FAILER:
            return {
                ...state,
                messageError: action.payload
            };
        case types.GET_PRODUCTSIZE_ALL_START:
            return { ...state, isFetching: true };
        case types.GET_PRODUCTSIZE_ALL_SUCCESS:
            return {
                ...state, isFetching: false,
                productSizes: action.payload.data.productSizes, isAuthenticated: true
            };
        case types.GET_PRODUCTSIZE_ALL_FAILER:
            return { ...state, messageError: action.payload };
        default:
            return state;
    }
};

export default productSizeReducer;