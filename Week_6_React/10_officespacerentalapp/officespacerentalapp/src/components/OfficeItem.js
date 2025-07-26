import React from "react";

function OfficeItem({ office }) {
  const { name, rent, address } = office;
  const rentStyle = {
    color: rent < 60000 ? "red" : "green",
    fontWeight: "bold",
  };

  return (
    <div style={{ marginBottom: "30px" }}>
      <h2>Name: {name}</h2>
      <p style={rentStyle}>Rent: Rs. {rent}</p>
      <p>Address: {address}</p>
      <hr />
    </div>
  );
}

export default OfficeItem;
