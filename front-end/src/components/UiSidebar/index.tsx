import React from "react";
import { Link } from "react-router-dom";
import "./UiSidebar.styles.scss";
import UiSidebarItem from "./UiSidebarItem";


const sidebar_items = [
    {
        "display_name": "Dashboard",
        "route": "/admin/dashboard",
        "icon": "bx bx-category-alt"
    },
    {
        "display_name": "Users",
        "route": "/admin/user",
        "icon": "bx bx-user-pin"
    },
    {
        "display_name": "Products",
        "route": "/admin/product",
        "icon": "bx bx-package"
    },
    {
        "display_name": "Product Size",
        "route": "/admin/product-size",
        "icon": "bx bx-package"
    },
    {
        "display_name": "Orders",
        "route": "/admin/orders",
        "icon": "bx bx-cart"
    },
    {
        "display_name": "Analytics",
        "route": "/admin/analytics",
        "icon": "bx bx-bar-chart-alt"
    },
    {
        "display_name": "categories",
        "route": "/admin/category",
        "icon": "bx bx-list-ol"
    },
    {
        "display_name": "discount",
        "route": "/admin/discount",
        "icon": "bx bx-gift"
    },
    {
        "display_name": "inventory",
        "route": "/admin/inventory",
        "icon": "bx bx-store-alt"
    },
    {
        "display_name": "settings",
        "route": "//adminsettings",
        "icon": "bx bx-cog"
    }
]


interface Props {
    location?: any;
}

const UiSidebar: React.FC<Props> = (props: Props) => {
    const activeItem = sidebar_items.findIndex(item => item.route === props.location.pathname);
    const logo = "https://iweb.tatthanh.com.vn/pic/3/blog/images/image(2068).png";

    return (
        <div className='sidebar'>
            <div className="sidebar__logo">
                <img src={logo} alt="company logo" />
            </div>
            {
                sidebar_items.map((item, index) => (
                    <Link to={item.route} key={index}>
                        <UiSidebarItem
                            title={item.display_name}
                            icon={item.icon}
                            active={index === activeItem}
                        />
                    </Link>
                ))
            }
        </div>
    )
};

export default UiSidebar;