import React from "react";

export default function EvenPlayers({ IndianPlayers }) {
  const [, second, , fourth, , sixth] = IndianPlayers;

  return (
    <ul>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </ul>
  );
}
