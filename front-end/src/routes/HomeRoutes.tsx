import React, { lazy, Suspense } from "react"
import { Switch } from "react-router-dom"
import Loading from "../components/UiLoading"
import { PATH } from "../constants/paths"
import AuthenticatedGuard from "../guards/AuthenticatedGuard"
const Home = lazy(() => import("../pages/clients/Home"))

export default function HomeRoutes() {
    return (
        <Switch>
            <AuthenticatedGuard
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
