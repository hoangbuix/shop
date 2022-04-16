import React from "react";
import "./Cart.styles.scss";


type Props = {
}

const Cart: React.FC<Props> = (props: Props) => {

    return (
        <div className="wrapper__cart">
            <div className="cart">
                <div>XXXX</div>
                <div className="cart__product grid wide">
                    <div className="row">
                        <div className="col c-4 m-4">
                            <div className="product__wrapper-image">
                                <div className="product__image">
                                    <div className="product__checkbox">
                                        <label>
                                            <input type="checkbox" name="" id="" />
                                            <span></span>
                                        </label>
                                    </div>
                                    <a href="" className="product__img">
                                        <picture>
                                            <source src="" type="" />
                                            <img src="https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2" alt="" />
                                        </picture>
                                    </a>
                                </div>
                                <div className="product__content">
                                    <a href="" className="product__name">
                                        <img src="" alt="" />
                                        Day la xxxxxxxx
                                    </a>
                                    <span className="product__now"></span>
                                    <p className="product__asa">
                                        icon
                                        <span>Thuong 3.76 ASA</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="col c-2 m-2">
                            <span className="product__real-prices">4545444</span>
                            <del className="product__discount-prices">599.999d</del>
                        </div>
                        <div className="col c-2 m-2">C</div>
                        <div className="col c-2 m-2">D</div>
                        <div className="col c-2 m-2">D</div>

                    </div>
                </div>
            </div>
        </div>
    )
};

export default Cart;