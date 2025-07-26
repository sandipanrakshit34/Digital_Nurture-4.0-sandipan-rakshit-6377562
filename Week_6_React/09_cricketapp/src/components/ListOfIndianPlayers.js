import React from "react";

export default function ListOfIndianPlayers({ IndianPlayers }) {
  return (
    <div>
      <ul>
        {IndianPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
}
