import React, { useEffect, useState } from "react";
import { getAllCategory } from "../../../apis/category.api";
import Table from "../../../components/Table";

interface PropsTable {
    data: any[];
}

const Category: React.FC = () => {
    const [category, setCategory] = useState<ResCategory[]>();

    useEffect(() => {
        getAllCategory().then(res => {
            setCategory(res.response.data);
        }).catch(err => {
            alert(err);
        })
    }, undefined)


    const RenderTabelHeader = () => {
        return (
            <tr>
                <th>ID</th>
                <th>Category Name</th>
                <th>Category Code</th>
                <th>Active Flag</th>
                <th>Created Date</th>
                <th>Updated Date</th>
            </tr>
        )
    }

    const RenderBodyTable = () => {
        return (
            <>
                {
                    category?.map((item, idx) => (
                        <tr key={idx}>
                            <td>{item.id}</td>
                            <td>{item.categoryName}</td>
                            <td>{item.categoryCode}</td>
                            <td>{item.activeFlag}</td>
                            <td>{item.createdDate}</td>
                            <td>{item.updatedDate}</td>
                        </tr>
                    ))
                }
            </>
        )
    }

    return (
        <div>
            <div>
                <h4>Category</h4>
            </div>
            <div>
                <Table dataHeader={<RenderTabelHeader />} dataBody={<RenderBodyTable />} />
            </div>
        </div>
    )
};



export default Category;