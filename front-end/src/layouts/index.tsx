import { useEffect } from "react";
import "./Layout.styles.scss";
import { useSelector, useDispatch } from "react-redux";
import { BrowserRouter, Route } from "react-router-dom";
import UiSidebar from "../components/UiSidebar";
import UiTopNav from "../components/UiTopNav";
import ThemeAction from "../reduxs/actions/theme.actions";
import Routes from "../routes/routes";

const Layout = () => {
    const themeReducer = useSelector((state: any) => state.ThemeReducer)
    const dispatch = useDispatch()

    useEffect(() => {
        const themeClass = localStorage.getItem('themeMode')

        const colorClass = localStorage.getItem('colorMode')

        dispatch(ThemeAction.setMode(themeClass))

        dispatch(ThemeAction.setColor(colorClass))
    }, [dispatch])

    return (
        <BrowserRouter>
            <Route render={(props) => (
                <div className={`layout ${themeReducer.mode} ${themeReducer.color}`}>
                    <UiSidebar {...props} />
                    <div className="layout__content">
                        <UiTopNav />
                        <div className="layout__content-main">
                            <Routes />
                        </div>
                    </div>
                </div>
            )} />
        </BrowserRouter>
    )
};

export default Layout;