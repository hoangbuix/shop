import React from "react";
import { FaStar, FaStarHalfAlt } from "react-icons/fa";

interface Props {
    star: number;
}

const Star = (props: Props) => {
    let stars = [];
    let tmp = props.star;
    for (let i = 0; i <= props.star; i++) {
        if (tmp !== 0.5) {
            stars.push(<FaStar />)
        } else {
            stars.push(<FaStarHalfAlt />);
        }
        tmp--;
    }

    return (
        <>
            {
                stars.map((star: any, key) =>
                    <span key={key}>{star}</span>
                )
            }
        </>
    )
};

export default Star;