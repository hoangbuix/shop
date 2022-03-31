import React from "react";
import "./Breadcrumb.styles.scss";

const Breadcrumb: React.FC = () => {
    return (
        <div className="breadcrumbs d-flex flex-row align-items-center">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li className="active"><a href="index.html"><i className="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
            </ul>
        </div>
    )
};

export default Breadcrumb;