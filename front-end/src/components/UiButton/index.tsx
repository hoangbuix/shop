import React, { ReactNode } from "react";
import "./UiButton.styles.scss";

interface Props {
    onClick: () => void;
    children: ReactNode;
}

const UiButton: React.FC<Props> = (props: Props) => {
    return (
        <button className="button" onClick={props.onClick}>
            {props.children}
        </button>
    )
};

export default UiButton;