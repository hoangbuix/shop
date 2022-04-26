import { combineReducers } from "redux";
import btnActionReducer from "./reducers/btnAction.reducres";
import categoryReducer from "./reducers/category.reducers";
import productSizeReducer from "./reducers/product-size.reducers";
import productReducer from "./reducers/product.reducers";
import ThemeReducer from "./reducers/theme.reducer";
import userReducer from "./reducers/user.reducer";

const rootReducer = combineReducers({
    ThemeReducer,
    user: userReducer,
    product: productReducer,
    category: categoryReducer,
    productSize: productSizeReducer,
    btnAction: btnActionReducer,
});

export default rootReducer;