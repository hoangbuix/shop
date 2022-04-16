import React from "react";
import { BrowserRouter } from "react-router-dom";
import AdminRoutes from "./AdminRoutes";
import HomeRoutes from "./HomeRoutes";
import LoginRoutes from "./LoginRoutes";
import ProductRoutes from "./ProductRoutes";
import CartRoutes from "./CartRoutes";

export default function Routes() {
    return (
        <BrowserRouter>
            <AdminRoutes />
            <LoginRoutes />
            <HomeRoutes />
            <ProductRoutes />
            <CartRoutes />
        </BrowserRouter>
    )
}