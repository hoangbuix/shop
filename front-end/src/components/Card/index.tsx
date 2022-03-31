import React from "react";
import "./Card.styles.scss";

interface Props {
    title?: string;
    description?: string;
    image?: string;
    body?: any;
}

const Card: React.FC<Props> = (props: Props) => {
    const { title, description, image, body, ...rest } = props;
    return (
        <div className="wrapper__card">
            <div className="card">
                <img src="https://scontent.fthd1-1.fna.fbcdn.net/v/t39.30808-6/275777103_521253092867109_872136299253471218_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=0debeb&_nc_ohc=I1V0phPRnp4AX9_AR0F&_nc_ht=scontent.fthd1-1.fna&oh=00_AT_obybIGSlrc092BwTFBiJ3c3G3JzYL81FQRjza4jDgmg&oe=6243D536" alt="" />
                <div className="card__header">
                    <h1 className="card__title">{title}</h1>
                </div>
                <div className="card__body">
                    ...rest
                </div>
                <div className="card__footer">
                    <p>Footer</p>
                </div>
            </div>
        </div>
    )
};

export default Card;