import React from "react";
import "./Admin.styles.scss";
import Category from "./Category";

const AdminPage = () => {
    return (
        <div className="wrapper__admin">
            <div className="admin__menu">Admin</div>
            <div className="admin__main">
                <Category />
            </div>
        </div>
    )
};

export default AdminPage;