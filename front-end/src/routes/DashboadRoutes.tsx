import React, { Suspense } from "react"
import { Switch } from "react-router-dom"
import Loading from "../components/UiLoading"
import { PATH } from "../constants/paths"
import AuthenticatedGuard from "../guards/AuthenticatedGuard"
import CategoryAdmin from "../pages/admin/Category"
import DashBoard from "../pages/admin/Dashboard"
import OrderAdmin from "../pages/admin/Order"
import ProductAdmin from "../pages/admin/Product"
import ProductSizeAdmin from "../pages/admin/ProductSize"
import Profile from "../pages/admin/Profile"
import UserAdmin from "../pages/admin/User"

export default function DashboardRoutes() {
    return (
        <Switch>
            <AuthenticatedGuard
                exact
                path={PATH.DASHBOARD}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <DashBoard />
                    </Suspense>
                )}
            />
            <AuthenticatedGuard

                exact
                path={PATH.PROFLE}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <Profile />
                    </Suspense>
                )}
            />
            <AuthenticatedGuard
                exact
                path={PATH.USERADMIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <UserAdmin />
                    </Suspense>
                )}
            />
            <AuthenticatedGuard
                exact
                path={PATH.PRODUCTADMIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <ProductAdmin />
                    </Suspense>
                )}
            />
            <AuthenticatedGuard
                exact
                path={PATH.CATEGORYADMIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <CategoryAdmin />
                    </Suspense>
                )}
            />
            <AuthenticatedGuard
                exact
                path={PATH.PRODUCTSIZEADMIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <ProductSizeAdmin />
                    </Suspense>
                )}
            />
            <AuthenticatedGuard
                exact
                path={PATH.ORDERADMIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <OrderAdmin />
                    </Suspense>
                )}
            />
        </Switch>
    )
}