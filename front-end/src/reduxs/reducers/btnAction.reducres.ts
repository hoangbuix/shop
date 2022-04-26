const btnActionReducer = (state = {}, action: any) => {
    switch (action.type) {
        case 'SET_BTN_EDIT':
            return {
                ...state,
                edit: action.payload
            }
        case 'SET_BTN_DELETE':
            return {
                ...state,
                del: action.payload
            }
        default:
            return state
    }
}

export default btnActionReducer;