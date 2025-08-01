import React from "react";
import OfficeItem from "./OfficeItem";

function OfficeList({ offices }) {
  return (
    <div>
      {offices.map((office, index) => (
        <OfficeItem key={index} office={office} />
      ))}
    </div>
  );
}

export default OfficeList;
