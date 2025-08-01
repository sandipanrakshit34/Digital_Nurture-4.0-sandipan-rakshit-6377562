import React from "react";

function GuestPage() {
  const flights = [
    { id: 1, from: "NYC", to: "London", price: "$800" },
    { id: 2, from: "Paris", to: "Tokyo", price: "$1200" }
  ];
  return (
    <div>
      <h1>Please sign up.</h1>
      <h2>Available Flights:</h2>
      <ul>
        {flights.map(f => (
          <li key={f.id}>{f.from} → {f.to}: {f.price}</li>
        ))}
      </ul>
    </div>
  );
}
export default GuestPage;
