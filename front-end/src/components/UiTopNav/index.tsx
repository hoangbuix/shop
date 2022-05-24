import React from "react";
import { Link } from "react-router-dom";
import { Cookies } from "../../utils/cookies";
import UiDropdown from "../UiDropdown";
import UiThemeMenu from "../UiThemeMenu";
import "./UiTopNav.styles.scss";


const notifications = [
    {
        "icon": "bx bx-error",
        "content": "Curabitur id eros quis nunc suscipit blandit"
    },
    {
        "icon": "bx bx-package",
        "content": "Duis malesuada justo eu sapien elementum, in semper diam posuere"
    },
    {
        "icon": "bx bx-cart",
        "content": "Donec at nisi sit amet tortor commodo porttitor pretium a erat"
    },
    {
        "icon": "bx bx-error",
        "content": "In gravida mauris et nisi"
    },
    {
        "icon": "bx bx-cart",
        "content": "Curabitur id eros quis nunc suscipit blandit"
    }
]

const user_menu = [
    {
        "icon": "bx bx-user",
        "content": "Profile",
        "route": "/admin/profile",
    },
    {
        "icon": "bx bx-wallet-alt",
        "content": "My Wallet",
        "route": "/mywallet",
    },
    {
        "icon": "bx bx-cog",
        "content": "Settings",
        "route": "/admin/setting",
    },
    {
        "icon": "bx bx-log-out-circle bx-rotate-180",
        "content": "Logout",
        "route": "/logout",
    }
];

const user_image = 'https://scontent.fthd1-1.fna.fbcdn.net/v/t1.6435-9/103939659_760946558043229_9042968797911566040_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=174925&_nc_ohc=9GCkNxphxqQAX8Jy5gb&tn=hSIa8QWwfe1wz2UT&_nc_ht=scontent.fthd1-1.fna&oh=00_AT_1tvyz-YUgTxOoE6vtPfr_etYNHk1vA0bphcm5xcEWqQ&oe=628994D1';
const curr_user = {
    display_name: 'Test',
    image: user_image
}

const renderNotificationItem = (item: any, index: any) => (
    <div className="notification-item" key={index}>
        <i className={item.icon}></i>
        <span>{item.content}</span>
    </div>
)

const renderUserToggle = (user: any) => (
    <div className="topnav__right-user">
        <div className="topnav__right-user__image">
            <img src={user.image} alt="" />
        </div>
        <div className="topnav__right-user__name">
            {user.display_name}
        </div>
    </div>
)


const deletCookies = (data: any) => {
    if (data === 'Logout') {
        console.log(data)
        const cookies = new Cookies()
        cookies.deleteCookie('JWT_TOKEN');
    }
}

const renderUserMenu = (item: any, index: any) => (
    <Link to={item.route} key={index} onClick={() => deletCookies(item.content)}>
        <div className="notification-item">
            <i className={item.icon}></i>
            <span>{item.content}</span>
        </div>
    </Link>
)

const UiTopNav = () => {
    return (
        <div className='topnav'>
            <div className="topnav__search">
                <input type="text" placeholder='Search here...' style={{ display: 'none' }} />
                <i className='bx bx-search' style={{ display: 'none' }}></i>
            </div>
            <div className="topnav__right">
                <div className="topnav__right-item">
                    {/* dropdown here */}
                    <UiDropdown
                        customToggle={() => renderUserToggle(curr_user)}
                        contentData={user_menu}
                        renderItems={(item: any, index: any) => renderUserMenu(item, index)} />
                </div>
                <div className="topnav__right-item">
                    <UiDropdown
                        icon='bx bx-bell'
                        badge='12'
                        contentData={notifications}
                        renderItems={(item: any, index: any) => renderNotificationItem(item, index)}
                        renderFooter={() => <Link to='/'>View All</Link>} />
                    {/* dropdown here */}
                </div>
                <div className="topnav__right-item">
                    <UiThemeMenu />
                </div>
            </div>
        </div>)
};

export default UiTopNav;