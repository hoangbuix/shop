import React, { useEffect } from "react";
import "./ProductSize.styles.scss";
import { connect, ConnectedProps } from "react-redux";
import UiBadge from "../../../components/UiBadge";
import UiTable from "../../../components/UiTable";
import { getAllProductSize } from "../../../reduxs/thunks/product-size.thunks";

const latestOrders = {
    header: [
        "ID",
        "Size",
        "Code",
        "Quantity",
        "Gender",
        "Status"
    ],
}

// const orderStatus: any = {
//     "shipping": "primary",
//     "pending": "warning",
//     "paid": "success",
//     "refund": "danger"
// }

const orderStatus: any = {
    "-1": "primary",
    "0": "warning",
    "1": "success",
    "3": "danger"
}
const orderActive: any = {
    "0": "Disable",
    "1": "Active",
}

const renderOrderHead = (item: any, index: any) => (
    <th key={index}>{item}</th>
)

const renderOrderBody = (item: ProductSize, index: any) => (
    <tr key={index}>
        <td>{item.id}</td>
        <td>{item.size}</td>
        <td>{item.sizeCode}</td>
        <td>{item.quantity}</td>
        <td>{item.gender}</td>
        <td>
            <UiBadge type={orderStatus[item.activeFlag]} content={orderActive[item.activeFlag]} />
        </td>
    </tr>
)



const mapStateToProps = (state: AppState) => ({
    productSizes: state.productSize.productSizes,
    isFetching: state.productSize.isFetching
})

const mapDispatchToProps = { getAllProductSize }

const connector = connect(mapStateToProps, mapDispatchToProps);

interface Props extends ConnectedProps<typeof connector> { }

const ProductSizeAdmin: React.FC<Props> = (props: Props) => {
    const { getAllProductSize, productSizes } = props;

    useEffect(() => {
        getAllProductSize();
    }, [getAllProductSize])

    return (
        <div className="card">
            <div className="card__header">
                <h3>Product Size Management</h3>
            </div>
            <div className="card__body">
                <UiTable
                    headData={latestOrders.header}
                    renderHead={(item: any, index: any) => renderOrderHead(item, index)}
                    bodyData={productSizes}
                    renderBody={(item: any, index: any) => renderOrderBody(item, index)}
                />
            </div>
            {/* <div className="card__footer">
            <Link to='/'>view all</Link>
        </div> */}
        </div>
    )
};

export default connector(ProductSizeAdmin);