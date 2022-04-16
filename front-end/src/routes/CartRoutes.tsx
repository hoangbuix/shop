import React, { lazy, Suspense } from "react"
import { Route, Switch } from "react-router-dom"
import Loading from "../components/Loading"
import { PATH } from "../constants/paths"
import AuthenticatedGuard from "../guards/AuthenticatedGuard"

const Cart = lazy(() => import("../pages/client/Card"));

export default function CartRoutes() {
    return (
        <Switch>
            <Route
                exact
                path={PATH.CART}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <Cart />
                    </Suspense>
                )}
            />
        </Switch>
    )
}