import React from "react";
import { BrowserRouter } from "react-router-dom";
import HomeRoutes from "./HomeRoutes";
import LoginRoutes from "./LoginRoutes";
import ProductRoutes from "./ProductRoutes";

export default function Routes() {
    return (
        <BrowserRouter>
            <LoginRoutes />
            <HomeRoutes />
            <ProductRoutes />
        </BrowserRouter>
    )
}