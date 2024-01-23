import React, { useEffect, useState } from "react";
import axios from "axios";
import Cookies from "js-cookie";
import { useNavigate } from "react-router-dom";

const Manager = () => {
  const [users, setUsers] = useState([]);
  const navigate = useNavigate()

  useEffect(() => {
    axios.get("http://localhost:8989/get-all-users").then((res) => {
      //console.log(res.data);
      if (res.data.success) {
        console.log("data ",res.data);
        setUsers(res.data.users);
      }
    });
  }, []);

  //console.log(users);

  const logAs = (item)=>{
    console.log("item ",item);
    Cookies.set("token",item.token);
    navigate("../dashboard")


  }

  return (
    <div>
      <div>Users: {users.length}</div>
      <table>
        {users.map((item,index) => {
          return (
            <tr key={index}>
              <td>{item.id}</td>
              <td>{item.username}</td>
              <td>
                <button onClick={()=>logAs(item)}>Login As</button>
              </td>
            </tr>
          );
        })}
      </table>
    </div>
  );
};

export default Manager;
