import React from "react";
import Star from "../Star";
import "./Card.styles.scss";

interface Props {
    name?: any;
    image?: any;
    rate?: any;
    totalProcess?: any;
    price?: any;
    discount?: any;
}

const Card: React.FC<Props> = (props: Props) => {
    return (
        <div className="wrapper__card">
            <div className="card">
                <img className="card__img" src="https://images.pexels.com/photos/861233/pexels-photo-861233.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2" alt="xxx" />
                <div className="card__body">
                    <span className="card__title">San pham ban chay San pham ban chay San pham ban chay</span>
                    <p></p>
                    <div className="card__rate">
                        <div className="card__rate-star">
                            <Star star={3.5} />
                        </div>
                        <div className="card__rate-quantity">
                            <span>Đã bán: 45</span>
                        </div>
                    </div>
                    <div className="card__price">
                        <div className="price__discount has__discount">
                            <div className="price-discount__price ">1000.000đ</div>
                            <div className="price-discount__discount">-45%</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Card;