import React from "react";
import "./UiBadge.styles.scss";


interface Props {
    type?: any;
    content?: any;
}

const UiBadge: React.FC<Props> = (props: Props) => {
    return (
        <span className={`badge badge-${props.type}`}>
            {props.content}
        </span>
    )
};

export default UiBadge;