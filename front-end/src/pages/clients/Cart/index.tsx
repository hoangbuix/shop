import React from "react";
import "./Cart.styles.scss";

const Cart: React.FC = () => {
    return (
        <div className="wrapper__cart">
            <div className="cart">
                <div className="cart__main">
                    <div>

                    </div>
                    <div className="cart__body">
                        <div className="cart__checkbox">
                            <input type="checkbox" name="" id="" />
                        </div>
                        <div className="wrapper__cart-product">
                            <div className="cart__product">
                                <div className="cart__image">
                                    <a href="_"><img src="https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2" alt="" /></a>
                                </div>
                                <div className="cart__product-name">
                                    <a href="_">HHHHHHHhhhhhhhhhhhhhhhhhhhhh</a>
                                    <div>xxxx</div>
                                </div>
                            </div>
                            <div className="space__content"></div>
                            <div className="cart__price">
                                <span className="cart__price-discount">đ130.000</span>
                                <span className="cart__price-total">d65.000</span>
                            </div>
                            <div className="cart__quantity">
                                <div>
                                    <button>-</button>
                                    <input type="text" />
                                    <button>+</button>
                                </div>
                            </div>
                            <div className="cart__total-price">
                                <span>d65.000</span>
                            </div>
                            <div className="cart__delete">
                                <button>xoa</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    )
};
export default Cart;