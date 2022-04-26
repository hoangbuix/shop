import React, { useEffect, useState } from "react";
import "./Category.styles.scss";
import { connect, ConnectedProps } from "react-redux";
import UiBadge from "../../../components/UiBadge";
import UiTable from "../../../components/UiTable";
import { getAllCategory, deleteCategoryById } from "../../../reduxs/thunks/category.thunks";
import UiModal from "../../../components/UiModal";
import UiToast from "../../../components/UiToast";
import UiButton from "../../../components/UiButton";
import UiAction from "../../../components/UiAction";

const latestOrders = {
    header: [
        "ID",
        "Name",
        "Code",
        "Description",
        "Status",
        "Action"
    ],
}

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






const mapStateToProps = (state: AppState) => ({
    categorys: state.category.categorys,
    isFetching: state.category.isFetching,
    message: state.category.message
})

const mapDispatchToProps = { getAllCategory, deleteCategoryById }

const connector = connect(mapStateToProps, mapDispatchToProps);

interface Props extends ConnectedProps<typeof connector> { }

const CategoryAdmin: React.FC<Props> = (props: Props) => {
    const { getAllCategory, categorys, deleteCategoryById } = props;
    const [openDele, setOpenDel] = useState(false);
    const [close, setClose] = useState(false);


    const handleClose = () => {
        setOpenDel(false);
    }

    useEffect(() => {
        getAllCategory();
    }, [getAllCategory])

    // useState
    const [list, setList] = useState<any>([]);

    // Definition
    let notificationProperties = null;

    // Function
    const showNotification = (notificationType: any, msg: any) => {
        switch (notificationType) {
            case "success":
                notificationProperties = {
                    id: list.length + 1,
                    title: "Success",
                    description: msg,
                    backgroundColor: "#31B22F",
                };
                break;
            case "danger":
                notificationProperties = {
                    id: list.length + 1,
                    title: "Danger",
                    description: msg,
                    backgroundColor: "#d9534f",
                };
                break;
            case "info":
                notificationProperties = {
                    id: list.length + 1,
                    title: "Info",
                    description: msg,
                    backgroundColor: "#44AACB",
                };
                break;
            case "warning":
                notificationProperties = {
                    id: list.length + 1,
                    title: "Warning",
                    description: msg,
                    backgroundColor: "#f0ad4e",
                };
                break;
            case "request":
                notificationProperties = {
                    id: list.length + 1,
                    title: "Request",
                    description: msg,
                    backgroundColor: "#5F676A",
                };
                break;

            default:
                notificationProperties = [];
                break;
        }
        setList([...list, notificationProperties]);
    };

    const renderOrderHead = (item: any, index: any) => (
        <th key={index}>{item}</th>
    )

    const renderBodyDataDelete = (item: Category, index: any) => {
        const handleDelete = (id: any) => {
            deleteCategoryById(id).then((res: any) => {
                setClose(false);
                showNotification("success", res.payload.data.message)
            }).catch((err: any) => {
                console.log(err)
            })
        }

        return (
            <div key={index} className="wrapper__action__delete">
                <div className="action__main" >
                    <h4 className="action__delete action__main-data">Are you sure?</h4>
                    <hr />
                    <span className="action__main-data">ID: {item.id}</span>
                    <hr />
                    <span className="action__main-data">Code: {item.categoryCode}</span>
                    <hr />
                    <span className="action__main-data">Name: {item.categoryName}</span>
                    <hr />
                    <span className="action__main-data"> Description: {item.description}</span>
                </div>
                <div className="action__btn">
                    <button className="btn__action-delete" onClick={() => handleDelete(item.id)}>Delete</button>
                    <button className="btn__action-cancel">Cancel</button>
                </div>
            </div >
        )
    }



    const renderOrderBody = (item: Category, index: any) => (
        < tr key={index} >
            <td>{item.id}</td>
            <td>{item.categoryName}</td>
            <td>{item.categoryCode}</td>
            <td>{item.description}</td>
            <td>
                <UiBadge type={orderStatus[item.activeFlag]} content={orderActive[item.activeFlag]} />
            </td>
            <td>
                <UiAction close={close} key={index} bodyData={[item]} renderBodyDataDelete={(item2: any, index2: any) => renderBodyDataDelete(item2, index2)} />
            </td>
        </tr >
    )


    return (
        <div className="card">
            <div className="card__header">
                <h3>Category Management</h3>
                <div className="wrapper__btn__action">
                    <div className="cart__btn">
                        <button onClick={() => setOpenDel(true)}>
                            <i className="bx bx-add-to-queue"></i>
                        </button>
                    </div>
                    <div className="cart__btn">
                        <button><i className="bx bx-reset"></i></button>
                    </div>
                </div>
            </div>
            <div className="card__body">
                <UiTable
                    headData={latestOrders.header}
                    renderHead={(item: any, index: any) => renderOrderHead(item, index)}
                    bodyData={categorys}
                    renderBody={(item: any, index: any) => renderOrderBody(item, index)}
                    titleSearch='category code'
                    limit={10}
                />
            </div>
            <UiButton handleClick={() => showNotification("success", 'test')}>
                Warning
            </UiButton>
            {
                <UiToast
                    notificationList={list}
                    position="top-right"
                    setList={setList}
                />
            }
            {
                openDele && <UiModal handleClose={handleClose} show={openDele} >
                    <form method="post">
                        <div>
                            <input type="text" name="" id="" />
                        </div>
                        <div>
                            <input type="text" name="" id="" />
                        </div>
                        <div>
                            <input type="text" name="" id="" />
                        </div>
                    </form>
                </UiModal>
            }
            {

            }
        </div>
    )
};

export default connector(CategoryAdmin);