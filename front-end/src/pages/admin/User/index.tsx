import React, { useEffect } from "react";
import "./User.styles.scss";
import UiBadge from "../../../components/UiBadge";
import UiTable from "../../../components/UiTable";
import { connect, ConnectedProps } from "react-redux";
import { getAllUser } from "../../../reduxs/thunks/user.thunks";


const latestOrders = {
    header: [
        "ID",
        "Name",
        "Username",
        "Email",
        "Role",
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

const renderOrderBody = (item: User, index: any) => (
    <tr key={index}>
        <td>{item.id}</td>
        <td>{item.firstName + ' ' + item.lastName}</td>
        <td>{item.username}</td>
        <td>{item.email}</td>
        <td>{item.roles?.map((item2: any) => item2.roleName)}</td>
        <td>
            <UiBadge type={orderStatus[item.activeFlag]} content={orderActive[item.activeFlag]} />
        </td>
    </tr>
)



const mapStateToProps = (state: AppState) => ({
    users: state.user.users,
    isFetching: state.user.isFetching
})

const mapDispatchToProps = { getAllUser }

const connector = connect(mapStateToProps, mapDispatchToProps);

interface Props extends ConnectedProps<typeof connector> { }

const UserAdmin: React.FC<Props> = (props: Props) => {
    const { getAllUser, users } = props;

    useEffect(() => {
        getAllUser();
    }, [getAllUser])


    return (
        <div className="card">
            <div className="card__header">
                <h3>User Management</h3>
            </div>
            <div className="card__body">
                <UiTable
                    headData={latestOrders.header}
                    renderHead={(item: any, index: any) => renderOrderHead(item, index)}
                    bodyData={users}
                    renderBody={(item: any, index: any) => renderOrderBody(item, index)}
                    limit={3}
                />
            </div>
            {/* <div className="card__footer">
                <Link to='/'>view all</Link>
            </div> */}
        </div>
    )
};
export default connector(UserAdmin);