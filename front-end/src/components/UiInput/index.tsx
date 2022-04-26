import React from "react";
import "./UiInput.styles.scss";

interface Props {
    label?: string;
    type?: string;
    placeholder?: string;
    id?: string;
    style?: any;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const UiInput: React.FC<Props> = (props: Props) => {
    return (
        <div className="wrapper__input">
            <input type={props.type} placeholder={props.placeholder} />
            <span></span>
            <label>{props.label}</label>
        </div>
    )
}

export default UiInput;