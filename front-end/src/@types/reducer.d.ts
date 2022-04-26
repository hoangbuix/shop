import rootReducer from "../reduxs/rootReducer";


declare global {
    type AppState = ReturnType<typeof rootReducer>
}