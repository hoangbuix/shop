import React, { ReactNode } from "react";
import "./UiModal.styles.scss";

interface Props {
    active?: any;
    titleTxt?: string;
    children?: ReactNode;
    handleClose: () => void;
    show: boolean;
}

const UiModal: React.FC<Props> = (props: Props) => {
    const showHideClassName = props.show ? 'modal display-block' : 'modal display-none';

    return (
        <div className={showHideClassName}>
            <div className="container">
                <h3>{props.titleTxt}</h3>
                {props.children}
                <span className='close' onClick={props.handleClose}>&#10006;</span>
            </div>
        </div>
    )
};

export default UiModal;

