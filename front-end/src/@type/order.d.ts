interface ResOrder {
    activeFlag: any;
    brandId: any;
    categoryId: any;
    createdDate: Date;
    description: any;
    id: any;
    price: any;
    productCode: any;
    productImage: any;
    productName: any;
    productSize: any;
    quantityProduct: any;
    slug: any;
    totalProduct: any;
    totalSold: any;
    updatedDate: Date;
}


interface Order extends Res {
    response: {
        data: any;
    };
}