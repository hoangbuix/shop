interface ResProductApi extends Res {
    data: {
        data: any;
    }
}

interface ResProduct extends ActionRedux { }

interface Product {
    id: number;
    activeFlag: number;
    createdDate: any;
    updatedDate: Date;
}

interface ResGetProductIdApi extends Res {
    data: {
        product: Product
    }
}
interface ResGetProductId extends ActionRedux {
    payload: ResGetProductIdApi
}

interface ResGetProductAllApi extends Res {
    data: {
        products: any;
    }
}
interface ResGetProductAll extends ActionRedux {
    payload: ResGetProductAllApi
}