import React, { useEffect } from 'react'
import Cookies from 'js-cookie'
import { useNavigate } from 'react-router-dom'

const Dashboard = () => {
  const navigate = useNavigate()

  useEffect(()=>{
    const token = Cookies.get("token");
    if (token == undefined) {
      navigate("../login")
    }
  })

  const logout = ()=>{
    Cookies.remove("token");
    navigate("../login")
  }

  return (
    <div>
      This is Dashboard page
      <div>
        <button onClick={logout}>
          Logout
        </button>
      </div>
    </div>
  )
}

export default Dashboard
