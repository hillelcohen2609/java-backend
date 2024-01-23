import React from "react";

const ErrorMessage = ({ message, breakLine }) => {
  let mess = message;
  switch (mess) {
    case 1000:
      mess = "User name must not be empty";
      break;
    case 1001:
      mess = "Password must not be empty";
      break;
    case 1002:
      mess = "Password is too weak";
      break;
    case 1003:
      mess = "Choose another user name";
      break;
    case 1004:
      mess = "User name or password are incorrect";
      break;
  }

  return (
    <span style={{ color: "red" }}>
      {breakLine ? <div>{mess}</div> : <>{mess}</>}
    </span>
  );
};

export default ErrorMessage;
