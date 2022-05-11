import React from "react";
import { BrowserRouter } from "react-router-dom";
import DashboardRoutes from "./DashboadRoutes";
import HomeRoutes from "./HomeRoutes";
import LoginRoutes from "./LoginRoutes";

export default function Routes() {
    return (
        <BrowserRouter>
            {/* <LoginRoutes /> */}
            {/* <HomeRoutes /> */}
            <DashboardRoutes />
        </BrowserRouter>
    )
}