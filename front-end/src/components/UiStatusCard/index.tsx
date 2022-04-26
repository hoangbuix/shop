import React from "react";
import "./UiStatusCard.styles.scss";

interface Props {
    icon?: any;
    count?: any;
    title?: any;
}

const UiStatusCard: React.FC<Props> = (props: Props) => {
    return (
        <div className='status-card'>
            <div className="status-card__icon">
                <i className={props.icon}></i>
            </div>
            <div className="status-card__info">
                <h4>{props.count}</h4>
                <span>{props.title}</span>
            </div>
        </div>
    )
};

export default UiStatusCard;