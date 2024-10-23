import React, { useState } from 'react';  
import './Login.css';  
import logo from '../../assets/logo.png';  
import { signUp, signIn } from '../../services/userService';  
import { useNavigate } from 'react-router-dom';

const Login = () => {  
    const [signState, setSignState] = useState("Sign In");  
    const [userName, setUserName] = useState("");  
    const [email, setEmail] = useState("");  
    const [passWord, setPassword] = useState("");  
    const [errorMessage, setErrorMessage] = useState(""); // For error handling  
    const [successMessage, setSuccessMessage] = useState(""); // For success messages  

    const navigate = useNavigate();

    const submitForm = (event) => {  
        event.preventDefault();  
        const data = { userName, email, passWord }; // Data to be sent  

        // Check if signState is "Sign Up" or "Sign In"  
        if (signState === "Sign Up") {  
            signUp(data)  
                .then((resp) => {  
                    console.log(resp);  
                    setSuccessMessage("Sign Up successful! You can now sign in.");  
                    setErrorMessage(""); // Clear any previous errors  
                    // Optionally clear fields or reset state  
                    setUserName("");  
                    setEmail("");  
                    setPassword("");  
                })  
                .catch((error) => {  
                    console.log(error);  
                    setErrorMessage("Sign Up failed. Please try again.");  
                    setSuccessMessage(""); // Clear any previous success messages  
                });  
        } else {  
            signIn(data)  
                .then((respo) => {  
                    console.log(respo);  
                    if(respo.status){
                        navigate("/home");
                    }else{
                        navigate("/");  
                        setSuccessMessage(respo.message);  
                        setErrorMessage("");
                    }
                   
                })  
                .catch((error) => {  
                    console.log(error);  
                    setErrorMessage("Sign In failed. Please check your credentials.");  
                    setSuccessMessage(""); // Clear any previous success messages  
                    navigate("/");
                });  
        }  
    };  

    return (  
        <div className='login'>  
            <img src={logo} className='login-logo' alt="" />  
            <div className="loginform">  
                <h1>{signState}</h1>  
                <form onSubmit={submitForm}>  
                    {signState === "Sign Up" && (  
                        <input  
                            type="text"  
                            placeholder='Your Name'  
                            onChange={(e) => setUserName(e.target.value)}  
                            value={userName}  
                        />  
                    )}  
                    <input  
                        type="email"  
                        placeholder='Email'  
                        onChange={(e) => setEmail(e.target.value)}  
                        value={email}  
                    />  
                    <input  
                        type="password"  
                        placeholder='Password'  
                        onChange={(e) => setPassword(e.target.value)}  
                        value={passWord}  
                    />  
                    <button type="submit">{signState}</button>  
                    <div className="form-help">  
                        <div className="remember">  
                            <input type="checkbox" />  
                            <label htmlFor="">Remember Me</label>  
                        </div>  
                        <p>Need Help?</p>  
                    </div>  
                </form>  
                {/* Display success or error messages */}  
                {errorMessage && <p className="error-message">{errorMessage}</p>}  
                {successMessage && <p className="success-message">{successMessage}</p>}  
                <div className="form-switch">  
                    {signState === "Sign In" ? (  
                        <p>New to Netflix? <span onClick={() => setSignState("Sign Up")}> Sign Up Now</span></p>  
                    ) : (  
                        <p>Already have an account? <span onClick={() => setSignState("Sign In")}> Sign In Now</span></p>  
                    )}  
                </div>  
            </div>  
        </div>  
    );  
};  

export default Login;