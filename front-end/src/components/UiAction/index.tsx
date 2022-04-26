import React, { useEffect, useState } from "react";
import UiModal from "../UiModal";
import "./UiAction.styles.scss";

interface Props {
    bodyData: any;
    renderBodyDataDelete?: any;
    renderBodyDataEdit?: any;
    close?: boolean;
}

const UiAction: React.FC<Props> = (props: Props) => {
    const [openEdit, setOpenEdit] = useState(false);
    const [openDelete, setOpenDelete] = useState<any>(false);

    // console.log(openDelete)
    useEffect(() => {
        setOpenDelete(props.close)
    }, [props.close])

    const setBtnEdit = () => {
        setOpenEdit(true);
    }

    const setBtnDelete = () => {
        setOpenDelete(true)
    }

    const handleClose = () => {
        setOpenEdit(false)
        setOpenDelete(false);
    }
    console.log(props.close)


    return (
        <>
            <button className="btn__action action__update" onClick={setBtnEdit}>
                <i className="bx bx-edit"></i>
            </button>
            <button className="btn__action action__delete" onClick={setBtnDelete}>
                <i className="bx bx-trash"></i>
            </button>

            {
                openEdit && <UiModal show={openEdit} handleClose={handleClose}>
                    {
                        props.bodyData && props.renderBodyDataEdit ?
                            props.bodyData.map((item: any, index: any) => props.renderBodyDataEdit(item, index)) : null
                    }
                </UiModal>
            }

            {
                openDelete && <UiModal show={openDelete} handleClose={handleClose}>
                    {
                        props.bodyData && props.renderBodyDataDelete ?
                            props.bodyData.map((item: any, index: any) => props.renderBodyDataDelete(item, index)) : null
                    }
                </UiModal>
            }
        </>
    )
};

export default UiAction;