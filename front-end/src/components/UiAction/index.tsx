import React, { useState } from "react";
import UiButton from "../UiButton";
import UiModal, { ModalFooter } from "../UiModal";
import "./UiAction.styles.scss";

interface Props {
    bodyData: any;
    renderBodyDataDelete?: any;
    renderBodyDataEdit?: any;
    onClick: () => void;
    onClickDelete: () => void;
}

const UiAction: React.FC<Props> = (props: Props) => {
    const [openEdit, setOpenEdit] = useState<any>(false);
    const [openDelete, setOpenDelete] = useState<any>(false);

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


    return (
        <>
            <button className="btn__action action__update" onClick={setBtnEdit}>
                <i className="bx bx-edit"></i>
            </button>
            <button className="btn__action action__delete" onClick={setBtnDelete}>
                <i className="bx bx-trash"></i>
            </button>
            {
                openEdit && <UiModal show={openEdit} setShow={setOpenEdit}>
                    {
                        props.bodyData && props.renderBodyDataEdit ?
                            props.bodyData.map((item: any, index: any) => props.renderBodyDataEdit(item, index)) : null
                    }
                    <ModalFooter>
                        <UiButton onClick={props.onClick}>Update</UiButton>
                        <UiButton onClick={() => setOpenEdit(false)}>Close</UiButton>
                    </ModalFooter>
                </UiModal>
            }

            {
                openDelete && <UiModal show={openDelete} setShow={handleClose}>
                    {
                        props.bodyData && props.renderBodyDataDelete ?
                            props.bodyData.map((item: any, index: any) => props.renderBodyDataDelete(item, index)) : null
                    }

                    <ModalFooter>
                        <UiButton onClick={props.onClickDelete}>Delete</UiButton>
                        <UiButton onClick={() => setOpenEdit(false)}>Close</UiButton>
                    </ModalFooter>
                </UiModal>
            }
        </>
    )
};

export default UiAction;