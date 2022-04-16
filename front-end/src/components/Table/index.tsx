import React from "react";

interface Props {
    dataHeader?: any;
    dataBody?: any;
    isActive?: boolean;
}


const Table: React.FC<Props> = (props: Props) => {
    return (
        <div className="wrapper__table">
            <table>
                <thead>
                    {props.dataHeader}
                </thead>
                <tbody>
                    {props.dataBody}
                </tbody>
            </table>
        </div>
    )
};

export default Table;