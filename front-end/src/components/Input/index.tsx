import React from "react";
import "./Input.styles.scss";

interface Props {
    type?: string;
    placeholder?: string;
    id?: string;
    style?: any;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const Input: React.FC<Props> = (props: Props) => {
    return <div className="wrapper__input">
        <input type={props.type} placeholder={props.placeholder} onChange={props.onChange} required />
    </div>;
}
export default Input;