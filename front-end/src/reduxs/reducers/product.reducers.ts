import * as types from "../constains/product.constains";

const inintialState = {
    products: [],
    isFetching: false,
    messageError: '',
    isAuthenticated: false,
    product: null as Product | null,
    data: []
}

const productReducer = (state = inintialState, action: { type: any, payload: any }) => {
    switch (action.type) {
        case types.GET_PRODUCT_ID_START:
            return { ...state, isFetching: true };
        case types.GET_PRODUCT_ID_SUCCESS:
            return {
                ...state, isFetching: false,
                product: action.payload.data.product, isAuthenticated: true
            };
        case types.GET_PRODUCT_ID_FAILER:
            return {
                ...state,
                messageError: action.payload
            };
        case types.GET_PRODUCT_ALL_START:
            return { ...state, isFetching: true };
        case types.GET_PRODUCT_ALL_SUCCESS:
            return {
                ...state, isFetching: false,
                products: action.payload.data.products, isAuthenticated: true
            };
        case types.GET_PRODUCT_ALL_FAILER:
            return { ...state, messageError: action.payload };
        default:
            return state;
    }
};

export default productReducer;