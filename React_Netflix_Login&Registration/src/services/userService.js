import { myAxios } from "./helper";

export const signUp = (user)=>{
    return myAxios.post("/save", user).then((response)=> response.data)
};

export const signIn =(user1) =>{
    return myAxios.post("/login" , user1).then((response)=>response.data)
}