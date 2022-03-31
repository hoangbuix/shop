import React from "react";
import Input from "../Input";
import "./SidebarSort.styles.scss";

const SidebarSort: React.FC = () => {
    return (
        // <!-- Sidebar -->
        <div className="sidebar">
            <div className="sidebar_section">
                <div className="sidebar_title">
                    <h5>Product Category</h5>
                </div>
                <ul className="sidebar_categories">
                    <li><a href="_">Men</a></li>
                    <li className="active"><a href="_"><span><i className="fa fa-angle-double-right" aria-hidden="true"></i></span>Women</a></li>
                    <li><a href="_">Accessories</a></li>
                    <li><a href="_">New Arrivals</a></li>
                    <li><a href="_">Collection</a></li>
                    <li><a href="_">Shop</a></li>
                </ul>
            </div>

            {/* <!-- Price Range Filtering --> */}
            <div className="sidebar_section">
                <div className="sidebar_title">
                    <h5>Filter by Price</h5>
                </div>
                <p>
                    <Input type="text" id="amount" style="border:0; color:_f6931f; font-weight:bold;" />
                </p>
                <div id="slider-range"></div>
                <div className="filter_button"><span>filter</span></div>
            </div>

            {/* <!-- Sizes --> */}
            <div className="sidebar_section">
                <div className="sidebar_title">
                    <h5>Sizes</h5>
                </div>
                <ul className="checkboxes">
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>S</span></li>
                    <li className="active"><i className="fa fa-square" aria-hidden="true"></i><span>M</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>L</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>XL</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>XXL</span></li>
                </ul>
            </div>

            {/* <!-- Color --> */}
            <div className="sidebar_section">
                <div className="sidebar_title">
                    <h5>Color</h5>
                </div>
                <ul className="checkboxes">
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Black</span></li>
                    <li className="active"><i className="fa fa-square" aria-hidden="true"></i><span>Pink</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>White</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Blue</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Orange</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>White</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Blue</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Orange</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>White</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Blue</span></li>
                    <li><i className="fa fa-square-o" aria-hidden="true"></i><span>Orange</span></li>
                </ul>
                <div className="show_more">
                    <span><span>+</span>Show More</span>
                </div>
            </div>

        </div>
    )
};

export default SidebarSort;