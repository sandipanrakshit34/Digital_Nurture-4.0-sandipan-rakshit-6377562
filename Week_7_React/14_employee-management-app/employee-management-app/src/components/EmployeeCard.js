import React, { useContext } from "react";
import ThemeContext from "../ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext); // read the current theme

  return (
    <div style={{ border: "1px solid #ccc", padding: "10px", margin: "10px 0" }}>
      <h3>{employee.name}</h3>
      <p>{employee.position}</p>
      <button className={theme === "light" ? "light-btn" : "dark-btn"}>
        View
      </button>
    </div>
  );
}

export default EmployeeCard;
