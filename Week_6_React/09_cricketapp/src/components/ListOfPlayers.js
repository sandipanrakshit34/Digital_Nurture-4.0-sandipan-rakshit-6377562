import React from "react";

export default function ListOfPlayers({ players }) {
  return (
    <div>
      <ul>
        {players.map((item, index) => (
          <li key={index}>Mr. {item.name} {item.score}</li>
        ))}
      </ul>
    </div>
  );
}
