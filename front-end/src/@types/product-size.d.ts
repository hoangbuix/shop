interface ResProductSizeApi extends Res {
    data: {
        data: any;
    }
}

interface ResProductSize extends ActionRedux { }

interface ProductSize {
    id: number;
    gender: String;
    quantity: String;
    size: String;
    sizeCode: String;
    activeFlag: number;
    createdDate: any;
    updatedDate: Date;
}

interface ResGetProductSizeIdApi extends Res {
    data: {
        productSize: ProductSize
    }
}
interface ResGetProductSizeId extends ActionRedux {
    payload: ResGetProductSizeIdApi
}

interface ResGetProductSizeAllApi extends Res {
    data: {
        productSizes: any;
    }
}
interface ResGetProductSizeAll extends ActionRedux {
    payload: ResGetProductSizeAllApi
}