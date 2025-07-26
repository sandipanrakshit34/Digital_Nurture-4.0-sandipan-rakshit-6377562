import React from "react";
import ListOfPlayers from "./components/ListOfPlayers";
import ScoreBelow70 from "./components/ScoreBelow70";
import OddPlayers from "./components/OddPlayers";
import EvenPlayers from "./components/EvenPlayers";
import ListOfIndianPlayers from "./components/ListOfIndianPlayers";

function App() {
  const flag = true;

  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elizabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];

  const T20Players = [
    "First Player",
    "Second Player",
    "Third Player"
  ];
  const RanjiTrophyPlayers = [
    "Fourth Player",
    "Fifth Player",
    "Sixth Player"
  ];
  const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div style={{ padding: "20px" }}>
      {flag ? (
        <div>
          <h1>List of Players</h1>
          <ListOfPlayers players={players} />
          <hr />
          <h1>List of Players having Scores less than 70</h1>
          <ScoreBelow70 players={players} />
        </div>
      ) : (
        <div>
          <h1>Indian Team</h1>
          <h2>Odd Players</h2>
          <OddPlayers IndianTeam={T20Players} />
          <hr />
          <h2>Even Players</h2>
          <EvenPlayers T20Players={T20Players} />
          <hr />
          <h2>List of Indian Players Merged:</h2>
          <ListOfIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      )}
    </div>
  );
}

export default App;
