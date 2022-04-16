import React, { lazy, Suspense } from "react";
import { Route, Switch } from "react-router-dom";
import Loading from "../components/Loading";
import { PATH } from "../constants/paths";
const Login = lazy(() => import("../pages/client/Product"));

export default function ProductRoutes() {
    return (
        <Switch>
            <Route
                path={PATH.PRODUCT}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <Login />
                    </Suspense>
                )}
            />
        </Switch>
    )
}