import React, { useEffect, useState } from "react";
import axios from "axios";
import ErrorMessage from "./ErrorMessage";
import Cookies from "js-cookie";
import { useLocation, useNavigate } from "react-router-dom";

const LoginPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [check, setCheck] = useState("login");
  const [errorMessage, setErrorMessage] = useState(0);

  const navigate = useNavigate();

  useEffect(() => {
    const token = Cookies.get("token");
    if (token != undefined) {
      navigate("../dashboard");
    }
  });

  const submit = () => {
    if (check === "login") {
      axios
        .post("http://localhost:8989/login", null, {
          params: {
            username,
            password,
          },
        })
        .then((res) => {
          console.log(res.data);

          if (res.data.success) {
            console.log("true");
            Cookies.set("token", res.data.token);
            navigate("../dashboard");
          } else {
            setErrorMessage(res.data.errorCode);
          }
        });
    } else {
      axios
        .post("http://localhost:8989/sign-up", null, {
          params: {
            username,
            password,
          },
        })
        .then((res) => {
          console.log(res.data);
          if (res.data.success) {
            console.log("true");
          } else {
            setErrorMessage(res.data.errorCode);
          }
        });
    }
  };

  return (
    <>
      <table>
        <thead>
          <input
            type="radio"
            name="check"
            value={"login"}
            checked={check === "login"}
            onChange={(event) => setCheck("login")}
          />
          login
          <input
            type="radio"
            name="check"
            value={"sign-up"}
            checked={check === "sign-up"}
            onChange={(event) => setCheck("sign-up")}
          />
          signup
        </thead>
        <tr>
          <td>user name:</td>
          <td>
            <input
              type="text"
              value={username}
              onChange={(event) => setUsername(event.target.value)}
            />
          </td>
          <td>
            {username == "" && (
              <ErrorMessage message={"User name missing"} breakLine={false} />
            )}
          </td>
        </tr>
        <tr>
          <td>password:</td>
          <td>
            <input
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
            />
          </td>
          <td>
            {" "}
            {password.length < 6 &&
              password.length > 0 &&
              check === "sign-up" && (
                <ErrorMessage message={"Password too weak"} breakLine={false} />
              )}
          </td>
        </tr>
        {check === "sign-up" && (
          <tr>
            <td>repeat password:</td>
            <td>
              <input
                type="password"
                value={password2}
                onChange={(event) => setPassword2(event.target.value)}
              />
            </td>
            <td>
              {password2 != password && (
                <ErrorMessage
                  message={"passwords don't much"}
                  breakLine={false}
                />
              )}
            </td>
          </tr>
        )}
      </table>

      {errorMessage > 0 && (
        <ErrorMessage message={errorMessage} breakLine={true} />
      )}

      <button
        onClick={submit}
        disabled={
          password.length < 6 ||
          username == "" ||
          (check === "sign-up" && password2 != password)
        }
      >
        {check === "sign-up" ? "Sign-up" : "Login"}
      </button>
    </>
  );
};

export default LoginPage;
