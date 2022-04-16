import React, { useState } from "react";
import { Link, NavLink } from "react-router-dom";

interface Props {
    name?: any;
    subMenus?: any;
    iconClassName?: any;
    onClick?: any;
    to?: any;
    exact?: any;
}

const MenuItem = (props: Props) => {
    const { name, subMenus, iconClassName, onClick, to, exact } = props;
    const [expand, setExpand] = useState(false);

    return (
        <li onClick={props.onClick}>
            <Link to={to}
                // onClick={() => {
                //   setExpand((e) => !e);
                // }}
                className={`menu-item`}
            >
                <div className="menu-icon">
                    <i className={iconClassName}></i>
                </div>
                <span>{name}</span>
            </Link>
            {subMenus && subMenus.length > 0 ? (
                <ul className={`sub-menu`}>
                    {subMenus.map((menu: any, index: any) => (
                        <li key={index}>
                            <NavLink to={menu.to}>{menu.name}</NavLink>
                        </li>
                    ))}
                </ul>
            ) : null}
        </li>
    )
}

export default MenuItem;