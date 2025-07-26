import React from "react";

export default function ScoreBelow70({ players }) {
  const below70 = players.filter((p) => p.score <= 70);
  return (
    <div>
      <ul>
        {below70.map((item, index) => (
          <li key={index}>Mr. {item.name} {item.score}</li>
        ))}
      </ul>
    </div>
  );
}
