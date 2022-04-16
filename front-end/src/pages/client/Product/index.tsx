import React, { useEffect, useState } from "react";
import { getAllProduct } from "../../../apis/product.api";
import Card from "../../../components/common/Card";
// import Breadcrumb from "../../components/Breadcrumb";
import Navbar from "../../../components/Navbar";
// import SidebarSort from "../../components/SidebarSort";



const Product: React.FC = () => {
    const [product, setProduct] = useState<ResProduct[]>();
    const [idP, setIdP] = useState();
    useEffect(() => {
        getAllProduct().then((res) => {
            setProduct(res.response.data);
        }).catch(err => {
            alert(err);
        })
    }, [product, idP])

    const handleAddToCard = (id: any) => {
        setIdP(id);
        localStorage.setItem(`addProductId`, JSON.stringify(idP));
    }

    return (
        <div>
            <div><Navbar /></div>
            <div>
                <div className="grid wide">
                    <div className="row">
                        {
                            product?.map((item, idx) => {
                                return (
                                    <div className="col c-2 m-2 l-2" key={idx}>
                                        <Card />
                                    </div>
                                )
                            })
                        }
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Product;