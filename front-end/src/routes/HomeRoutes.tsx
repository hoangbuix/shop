import React, { lazy, Suspense } from "react"
import { Route, Switch } from "react-router-dom"
import Loading from "../components/Loading"
import { PATH } from "../constants/paths"
import AuthenticatedGuard from "../guards/AuthenticatedGuard"

const Home = lazy(() => import("../pages/client/Home"));

export default function HomeRoutes() {
    return (
        <Switch>
            <Route
                exact
                path={PATH.HOME}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <Home />
                    </Suspense>
                )}
            />
        </Switch>
    )
}