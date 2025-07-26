import React from "react";

export default function OddPlayers({ IndianPlayers }) {
  const [first, , third, , fifth] = IndianPlayers;

  return (
    <ul>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </ul>
  );
}
