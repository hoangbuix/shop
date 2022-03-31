import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import { loginApi } from "../../apis/user.api";
import Input from "../../components/Input";
import { PATH } from "../../constants/paths";

const Login: React.FC = () => {
    const [email, setEmail] = React.useState("");
    const [password, setPassword] = React.useState("");
    const [error, setError] = useState("");
    const history = useHistory();

    const handleChangeEmail = (e: React.ChangeEvent<HTMLInputElement>) => {
        setEmail(e.target.value);
    }

    const handleChangePassword = (e: React.ChangeEvent<HTMLInputElement>) => {
        setPassword(e.target.value);
    }

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        const payload = { email, password }
        loginApi(payload)
            .then(res => {
                history.push(PATH.HOME)
            })
            .catch(err => {
                setError(err.payload.message);
                console.log(error);
            })
    }


    return (
        <div>
            <h1>Login</h1>
            <form action="" method="post" onSubmit={handleSubmit}>
                <div>
                    <Input type="text" placeholder="Username" onChange={handleChangeEmail} />
                </div>
                <div>
                    <Input type="password" placeholder="Password" onChange={handleChangePassword} />
                </div>
                <div>
                    <button type="submit">Login</button>
                </div>
            </form>
        </div>
    )
};
export default Login;
