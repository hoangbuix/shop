import React, { useState } from "react";
import { connect, ConnectedProps } from "react-redux";
import { useHistory } from "react-router-dom";
import { PATH } from "../../../constants/paths";
import { login } from "../../../reduxs/thunks/user.thunks";

const mapStateToProps = (state: any) => ({
    users: state.user.data,
    isFetching: state.user.isFetching
})

const mapDispatchToProps = { login }

const connector = connect(mapStateToProps, mapDispatchToProps);

interface Props extends ConnectedProps<typeof connector> { }

const Login: React.FC<Props> = (props: Props) => {
    const { login, isFetching } = props;

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState("")
    const history = useHistory();

    const handleChangeEmail = (e: React.ChangeEvent<HTMLInputElement>) => {
        setEmail(e.target.value);
    }

    const handleChangePassword = (e: React.ChangeEvent<HTMLInputElement>) => {
        setPassword(e.target.value);
    }

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        if (!isFetching) {
            const payload = { email, password }
            await login(payload)
                .then(res => {
                    history.push(PATH.HOME)
                })
                .catch(err => {
                    setError(err.payload.message)
                })
        }
    }

    return (
        <div>
            <h1>Login</h1>
            <form action="post" onSubmit={handleSubmit}>
                <div>
                    <input type="email" onChange={handleChangeEmail} />
                </div>
                <div>
                    <input type="password" onChange={handleChangePassword} />
                </div>
                <div>
                    <span>{error}</span>
                </div>
                <div>
                    <button>Login</button>
                </div>
            </form>
        </div>
    )
};

export default connector(Login);