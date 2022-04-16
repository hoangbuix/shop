import React, { lazy, Suspense } from "react"
import { Route, Switch } from "react-router-dom"
import Loading from "../components/Loading"
import { PATH } from "../constants/paths"
import AuthenticatedGuard from "../guards/AuthenticatedGuard"

const AdminPage = lazy(() => import("../pages/admin"));

export default function AdminRoutes() {
    return (
        <Switch>
            <Route
                exact
                path={PATH.ADMIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <AdminPage />
                    </Suspense>
                )}
            />
        </Switch>
    )
}