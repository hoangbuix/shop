import React, { useCallback, useEffect } from "react";
import "./UiToast.styles.scss";


interface Props {
    notificationList?: any;
    position?: any;
    setList: (data: any) => void;
}

const UiToast: React.FC<Props> = (props: Props) => {
    // useCallback
    const deleteToast = useCallback((id: any) => {
        const toastListItem: any = props.notificationList?.filter((t: any) => t.id !== id);
        props.setList(toastListItem);
    }, [props]);

    // useEffect
    useEffect(() => {
        const interval = setInterval(() => {
            if (props.notificationList.length) {
                deleteToast(props.notificationList[0]?.id);
            }
        }, 2000);
        return () => {
            clearInterval(interval);
        };
    }, [props.notificationList, deleteToast]);


    return (
        <div className={`container__toast ` + props.position}>
            {
                props.notificationList?.map((notification: any, index: any) => (
                    <div
                        key={index}
                        className={`notification toast ` + props.position}
                        style={{ backgroundColor: notification.backgroundColor }}
                    >
                        <button onClick={() => deleteToast(notification.id)}>
                            X
                        </button>
                        <div>
                            <p className="title">{notification.title}</p>
                            <p className="description">
                                {notification.description}
                            </p>
                        </div>
                    </div>
                ))}
        </div>
    )
};

export default UiToast;