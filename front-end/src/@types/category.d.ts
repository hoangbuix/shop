interface ReqCategory {
    id: number;
    categoryCode: string;
    categoryName: string;
    description: string;
    activeFlag: number;
}

interface ReqAddCategory {
    categoryCode: string;
    categoryName: string;
    description: string;
}

interface ResCategoryApi extends Res {
    data: {
        data: any;
    }
}

interface ResCategory extends ActionRedux { }

interface ResAddCategoryApi extends Res {
    data: {
        addCategory: any;
    }
}

interface ResAddCategory extends ActionRedux { }

interface Category {
    id: number;
    categoryCode: string;
    categoryName: string;
    description: string;
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

interface ResUpdateCategoryApi extends Res {
    data: {
        category: any;
    }
}
interface ResUpdateCategory extends ActionRedux {
    payload: ResUpdateCategoryApi
}

