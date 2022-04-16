interface ResProduct {
    id: int,
    activeFlag: int,
    createdDate: Date,
    updatedDate: Date,
    productName: any,
    productCode: any,
    description: any,
    slug: any,
    price: any,
    productImage: any,
    quantityProduct: int,
    totalProduct: int,
    totalSold: int,
    brandId: int,
    categoryId: int,
    productSize: int
}


interface Product extends Res {
    response: {
        data: any;
    };
}