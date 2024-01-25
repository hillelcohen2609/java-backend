import React, { useEffect, useState } from 'react'
import Cookies from 'js-cookie'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

const Dashboard = () => {
  const [username,setUsername ] = useState("");
  const navigate = useNavigate()

  useEffect(()=>{
    const token = Cookies.get("token");
    if (token == undefined) {
      navigate("../login")
    }else{
      axios.get("http://localhost:8989/get-user-name?token="+token).then(res=>{
        setUsername(res.data.username);
      })
    }
  })

  const logout = ()=>{
    Cookies.remove("token");
    navigate("../login")
  }

  return (
    <div>
      Hello {username}
      <div>
        <button onClick={logout}>
          Logout
        </button>
      </div>
    </div>
  )
}

export default Dashboard
