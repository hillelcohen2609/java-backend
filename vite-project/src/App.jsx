import { BrowserRouter, NavLink, Routes, Route } from "react-router-dom";
import "./App.css";
import LoginPage from "./LoginPage";
import Dashboard from "./Dashboard";
import Manager from "./Manager";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/manager" element={<Manager />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
