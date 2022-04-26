interface ReqCategory {
    categoryCode: String;
    categoryName: String;
    description: String;
}

interface ResCategoryApi extends Res {
    data: {
        data: any;
    }
}

interface ResCategory extends ActionRedux { }

interface Category {
    id: number;
    categoryCode: String;
    categoryName: String;
    description: String;
    activeFlag: number;
    createdDate: any;
    updatedDate: Date;
}

interface ResGetCategoryIdApi extends Res {
    data: {
        category: Category
    }
}
interface ResGetCategoryId extends ActionRedux {
    payload: ResGetCategoryIdApi
}

interface ResGetCategoryAllApi extends Res {
    data: {
        categorys: any;
    }
}
interface ResGetCategoryAll extends ActionRedux {
    payload: ResGetCategoryAllApi
}

interface ResDeleteCategoryIdApi extends Res {
    data: {
        message: any;
    }
}
interface ResDeleteCategoryId extends ActionRedux {
    payload: ResDeleteCategoryIdlApi
}
