import React, { ReactNode } from "react";
import "./UiButton.styles.scss";

interface Props {
    handleClick: () => void;
    children: ReactNode;
}

const UiButton: React.FC<Props> = (props: Props) => {
    return (
        <button className="button" onClick={props.handleClick}>
            {props.children}
        </button>
    )
};

export default UiButton;