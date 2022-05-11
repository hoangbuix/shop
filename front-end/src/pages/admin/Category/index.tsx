import React, { useEffect, useState } from "react";
import "./Category.styles.scss";
import { connect, ConnectedProps } from "react-redux";
import UiBadge from "../../../components/UiBadge";
import UiTable from "../../../components/UiTable";
import { getAllCategory, categoryAdd, categoryUpdate, deleteCategoryById } from "../../../reduxs/thunks/category.thunks";
import UiModal, { ModalBody, ModalHeader } from "../../../components/UiModal";
import UiToast from "../../../components/UiToast";
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
    message: state.category.message,
    categoryUpdate: state.category.categoryUpdate,
    addCategory: state.category.addCategory
})

const mapDispatchToProps = { getAllCategory, categoryAdd, deleteCategoryById, categoryUpdate }

const connector = connect(mapStateToProps, mapDispatchToProps);

interface Props extends ConnectedProps<typeof connector> { }

const CategoryAdmin: React.FC<Props> = (props: Props) => {
    const { getAllCategory, categorys, categoryAdd, categoryUpdate, deleteCategoryById } = props;
    const [openAdd, setOpenAdd] = useState(false);
    const [activeFlags, setActiveFlags] = useState<any>();
    const [categoryCode, setCategoryCode] = useState('');
    const [categoryName, setCategoryName] = useState('');
    const [description, setDescription] = useState('');


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

    const activeData = [
        {
            "id": 1,
            "icon": "bx bx-error",
            "action": "Active"
        },
        {
            "id": 1,
            "icon": "bx bx-error",
            "action": "Disable"
        }
    ]

    const renderActive = (item: any, index: any) => (
        <option key={index} value={index.action}>{item.action}</option>
    )

    const handleChangeActiveFlag = (e: React.ChangeEvent<HTMLSelectElement>) => {
        e.preventDefault()
        setActiveFlags(e.target.value)
    }

    const handleChangeCategoryCode = (e: React.ChangeEvent<HTMLInputElement>) => {
        e.preventDefault();
        setCategoryCode(e.target.value);
    }
    const handleChangeCategoryName = (e: React.ChangeEvent<HTMLInputElement>) => {
        e.preventDefault();
        setCategoryName(e.target.value);
    }
    const handleChangeCategoryDescription = (e: React.ChangeEvent<HTMLInputElement>) => {
        e.preventDefault();
        setDescription(e.target.value);
    }
    let id: any = 0, code: any, name: any, des: any, act: any;
    const renderBodyDataEdit = (item: Category, index: any) => {
        id = item.id;
        code = categoryCode ? categoryCode : item.categoryCode;
        name = categoryName ? categoryName : item.categoryName;
        des = description ? description : item.description;
        act = activeFlags ? activeFlags : item.activeFlag === 1 ? 'Active' : 'Disable';
        return (
            <div key={index}>
                <ModalHeader>
                    <h2>Modal header</h2>
                </ModalHeader>
                <ModalBody>
                    <div className="form" >
                        <div className="form-item">
                            <input type="text" id="username" autoComplete="off"
                                required value={code} onChange={handleChangeCategoryCode} />
                            <label htmlFor="username">Category Code: *</label>
                        </div>
                        <div className="form-item">
                            <input type="text" id="username" autoComplete="off" required value={name}
                                onChange={handleChangeCategoryName} />
                            <label htmlFor="username">Category Name: *</label>
                        </div>
                        <div className="form-item">
                            <input type="text" id="username" autoComplete="off" required value={des}
                                onChange={handleChangeCategoryDescription} />
                            <label htmlFor="username">Description: *</label>
                        </div>
                        <div className="form-item">
                            {/* <label htmlFor="activeFlag">Active Flag: *</label> */}
                            <select name="action" onChange={handleChangeActiveFlag} value={act}>
                                <option value="">Active Flag: *</option>
                                {
                                    act && activeData.map((item2: any, index2: any) => (
                                        renderActive(item2, index2)
                                    ))
                                }
                            </select>
                        </div>
                    </div>
                </ModalBody>
                {/* <ModalFooter>
                    <UiButton onClick={() => handleEdit()}>Update</UiButton>
                </ModalFooter> */}
            </div>
        )
    }

    const renderBodyDataDelete = (item: Category, index: any) => {
        id = item.id;
        return (
            <div key={index} className="wrapper__action__delete">
                <ModalHeader>
                    <h4 className="action__delete action__main-data">Are you sure?</h4>
                </ModalHeader>
                <ModalBody>
                    <div className="action__main" >
                        <span className="action__main-data">ID: {item.id}</span>
                        <hr />
                        <span className="action__main-data">Code: {item.categoryCode}</span>
                        <hr />
                        <span className="action__main-data">Name: {item.categoryName}</span>
                        <hr />
                        <span className="action__main-data"> Description: {item.description}</span>
                    </div>
                </ModalBody>
            </div >
        )
    }


    const handleEdit = async () => {
        const dataActive = act === 'Active' ? 1 : 0
        const payload = {
            id: id,
            categoryCode: code,
            categoryName: name,
            description: des,
            activeFlag: dataActive
        }
        await categoryUpdate(payload)
            .then((res: any) => {
                setTimeout(() => {
                    window.location.reload()
                }, 1000)
                showNotification("success", "Update Success!")
            })
            .catch((err: any) => {
                console.log(err)
            })
    }

    const handleDelete = () => {
        deleteCategoryById(id).then((res: any) => {
            setTimeout(() => {
                window.location.reload()
            }, 1000)
            showNotification("success", res.payload.data.message)
        }).catch((err: any) => {
            console.log(err)
        })
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
                <UiAction key={index} bodyData={[item]} onClick={handleEdit} onClickDelete={handleDelete}
                    renderBodyDataDelete={(item2: any, index2: any) => renderBodyDataDelete(item2, index2)}
                    renderBodyDataEdit={(item2: any, index2: any) => renderBodyDataEdit(item2, index2)}
                />
            </td>
        </tr >
    )

    const renderBodyDataAdd = () => {
        const handleAdd = () => {
            const payload = { categoryCode, categoryName, description };
            categoryAdd(payload).then((res: any) => {
                setTimeout(() => {
                    window.location.reload()
                }, 1000)
                showNotification("Warning", res)
            }).catch(err => {
                console.log(err)
            })
        }
        return (
            <div>
                <ModalHeader>
                    <h2>Add Category</h2>
                </ModalHeader>
                <ModalBody>
                    <div className="form">
                        <div className="form-item">
                            <input type="text" id="username" autoComplete="off"
                                required value={categoryCode} onChange={handleChangeCategoryCode} />
                            <label htmlFor="username">Category Code: *</label>
                        </div>
                        <div className="form-item">
                            <input type="text" id="username" autoComplete="off" required={true} value={categoryName}
                                onChange={handleChangeCategoryName} />
                            <label htmlFor="username">Category Name: *</label>
                        </div>
                        <div className="form-item">
                            <input type="text" id="username" autoComplete="off" required value={description}
                                onChange={handleChangeCategoryDescription} />
                            <label htmlFor="username">Description: *</label>
                        </div>
                        <button className="form__button" onClick={() => handleAdd()}>Add</button>
                    </div>
                </ModalBody>
            </div>
        )
    }



    return (
        <div className="card">
            <div className="card__header">
                <h3>Category Management</h3>
                <div className="wrapper__btn__action">
                    <div className="cart__btn">
                        <button onClick={() => setOpenAdd(true)}>
                            <i className="bx bx-add-to-queue"></i>
                        </button>
                    </div>
                    <div className="cart__btn">
                        <button onClick={() => window.document.location.reload()}><i className="bx bx-reset"></i></button>
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
                    limit={5}
                />
            </div>
            {
                <UiToast
                    notificationList={list}
                    position="top-right"
                    setList={setList}
                />
            }
            {
                openAdd && <UiModal setShow={setOpenAdd} show={openAdd} >
                    {
                        renderBodyDataAdd()
                    }
                </UiModal>
            }
        </div>
    )
};

export default connector(CategoryAdmin);