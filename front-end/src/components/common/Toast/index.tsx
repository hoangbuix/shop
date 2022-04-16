import React from "react";
import "./Toast.style.scss";

const Toast = () => {
    return (
        <div className="toast">
            <div className="toast-list" id="toast"></div>
            <button className="btn btn-successful">Show success</button>
            <button className="btn btn-warning">Show warning</button>
            <button className="btn btn-error">Show error</button>
        </div>
    )
};

export default Toast;