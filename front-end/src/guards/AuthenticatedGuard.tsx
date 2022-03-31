
import React from "react"
import { RouteProps, RouteComponentProps, Route, Redirect, Router } from "react-router-dom"



interface ReduxProps {
    isAuthenticated: boolean
}
interface Props extends ReduxProps, RouteProps {
    component: React.ComponentType<RouteComponentProps>
}

function AuthenticatedGuard(props: Props) {
    const { isAuthenticated, component: Component, ...rest } = props
    return (
        <Route
            {...rest}
            render={props => {
                if (!isAuthenticated && !localStorage.getItem("token")) {
                    return <Redirect to="/login" />
                }
                return <Component {...props} />
            }}
        />
    )
}


export default AuthenticatedGuard;