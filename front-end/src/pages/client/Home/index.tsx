import React from "react";
import Navbar from "../../../components/Navbar";
import SidebarSort from "../../../components/SidebarSort";
import { Cookies } from "../../../heplers/cookies";
import "./Home.styles.scss";

const Home: React.FC = () => {
    const s = new Cookies();
    console.log(s.getCookie('JWT_COOKIE'));
    return (
        <div className="wrapper__home">
            <div>
                <Navbar />
                {/* <SidebarSort /> */}
            </div>
            <div>
                <main>
                    <h1>Home</h1>
                    <div>
                    </div>
                </main>
            </div>
            <div>Footer</div>
        </div>
    )
};
export default Home;