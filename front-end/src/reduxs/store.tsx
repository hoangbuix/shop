import { applyMiddleware, compose, createStore } from "redux";
import logger from "redux-logger";
import thunk from "redux-thunk";
import rootReducer from "./rootReducer";

const composeEnhancers =
    typeof window === "object" &&
        process.env.NODE_ENV === "development" &&
        (window as any).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
        ? (window as any).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({})
        : compose
const middlewares = [logger, thunk]
export const store = createStore(rootReducer, composeEnhancers(applyMiddleware(...middlewares)));