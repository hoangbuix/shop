interface ResCategory {
    id: any;
    categoryName: any;
    categoryCode: any;
    activeFlag: any;
    updatedDate: any;
    createdDate: any;

}

interface Category extends Res {
    response: {
        data: any;
    }
}