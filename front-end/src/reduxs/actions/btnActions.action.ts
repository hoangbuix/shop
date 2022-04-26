const setBtnEdit = (edit: any) => {
    return {
        type: 'SET_BTN_EDIT',
        payload: edit,
    }
}

const setBtnDelete = (del: any) => {
    return {
        type: 'SET_BTN_DELETE',
        payload: del,
    }
}



const btnAction = {
    setBtnEdit,
    setBtnDelete,
}

export default btnAction;