import React from "react";

interface Props {
    type?: string;
    placeholder?: string;
    id?: string;
    style?: any;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const Input: React.FC<Props> = (props: Props) => {
    return <div className="wrapper__input">
        <input type={props.type} placeholder={props.placeholder} onChange={props.onChange} required readOnly />
    </div>;
}
export default Input;