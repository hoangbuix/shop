import React, { Fragment, useEffect, useState } from "react";
import "./UiTable.styles.scss";

interface Props {
    limit?: any;
    bodyData?: any;
    headData?: any;
    renderHead?: any;
    renderBody?: any;
    titleSearch?: any;
}

const UiTable: React.FC<Props> = (props: Props) => {
    const initDataShow: any = (props.bodyData && props.limit) ? props.bodyData.slice(0, Number(props.limit)) : props.bodyData;

    const [dataShow, setDataShow] = useState<any>(initDataShow);
    console.log(dataShow);

    useEffect(() => {
        setDataShow(initDataShow)
    }, [props])



    let pages: any = 1;

    let range: any = [];

    if (props.limit !== undefined) {
        let page = Math.floor(props.bodyData.length / Number(props.limit));
        pages = props.bodyData.length % Number(props.limit) === 0 ? page : page + 1;
        range = [...Array(pages).keys()];
    }

    const [currPage, setCurrPage] = useState(0)

    const selectPage = (page: any) => {
        const start = Number(props.limit) * page
        const end = start + Number(props.limit)
        setDataShow(props.bodyData.slice(start, end))
        setCurrPage(page)
    }


    return (
        <Fragment>
            <div>
                {/* <div style={{ width: '200px', transform: 'translate(10px,-15px)' }}>
                    <div className="table__search">
                        <input type="text" placeholder={`${props.titleSearch ? 'Search ' + props.titleSearch : 'Search here...'}`} />
                        <i className='bx bx-search'></i>
                    </div>
                </div> */}
                <div className="table-wrapper">
                    <table>
                        {
                            props.headData && props.renderHead ? (
                                <thead>
                                    <tr>
                                        {
                                            props.headData.map((item: any, index: any) => props.renderHead(item, index))
                                        }
                                    </tr>
                                </thead>
                            ) : null
                        }
                        {
                            props.bodyData && props.renderBody ? (
                                <tbody>
                                    {
                                        dataShow?.map((item: any, index: any) => props.renderBody(item, index))
                                    }
                                </tbody>
                            ) : <p>No resuls</p>
                        }
                    </table>
                </div>
                {
                    pages > 1 ? (
                        <div className="table__pagination">
                            {
                                range.map((item: any, index: any) => (
                                    <div key={index} className={`table__pagination-item ${currPage === index ? 'active' : ''}`} onClick={() => selectPage(index)}>
                                        {item + 1}
                                    </div>
                                ))
                            }
                        </div>
                    ) : null
                }
            </div>

        </Fragment>
    )
};

export default UiTable;