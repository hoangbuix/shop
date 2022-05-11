import React, { ReactNode, useEffect, useRef } from "react";
import "./UiModal.styles.scss";

interface Props {
    hideCloseButton?: any;
    setShow: (show: boolean) => void;
    children?: ReactNode,
    show: any;
}

const UiModal: React.FC<Props> = (props: Props) => {
    const modalRef = useRef<HTMLInputElement>(null);
    useEffect(() => {
        const clickOutsideContent = (e: any) => {
            if (e.target === modalRef.current) {
                props.setShow(false);
            }
        };
        window.addEventListener('click', clickOutsideContent);
        return () => {
            window.removeEventListener('click', clickOutsideContent);
        };
    }, [props]);

    return <div ref={modalRef} className={`modal ${props.show ? 'active' : ''}`}>
        <div className="modal__content">
            {
                !props.hideCloseButton && <span onClick={() => props.setShow(false)} className="modal__close">
                    &times;
                </span>
            }
            {props.children}
        </div>
    </div>
};

export default UiModal;

interface PropsRender {
    children: ReactNode;
}
export const ModalHeader = (props: PropsRender) => {
    return <div className="modal__header">
        {props.children}
    </div>
}

export const ModalBody = (props: PropsRender) => {
    return <div className="modal__body">
        {props.children}
    </div>
}

export const ModalFooter = (props: PropsRender) => {
    return <div className="modal__footer">
        {props.children}
    </div>
}

