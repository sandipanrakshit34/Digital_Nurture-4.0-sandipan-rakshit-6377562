import React from "react";
import OfficeList from "./components/OfficeList";

function App() {
  const offices = [
    { name: "DBS", rent: 50000, address: "Chennai" },
    { name: "TechSpace", rent: 62000, address: "Bangalore" },
    { name: "WorkNest", rent: 58000, address: "Pune" },
    { name: "SpacePro", rent: 89000, address: "Delhi" }
  ];

  return (
    <div style={{ padding: "40px" }}>
      <h1>Office Space , at Affordable Range</h1>
      <img
        src="https://t4.ftcdn.net/jpg/03/84/55/29/360_F_384552930_zPoe9zgmCF7qgt8fqSedcyJ6C6Ye3dFs.jpg"
        alt="Office Space"
        style={{ display: "block", marginBottom: "30px" }}
      />
      <OfficeList offices={offices} />
    </div>
  );
}

export default App;
