import React, { useState } from "react";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";
import GuestPage from "./components/GuestPage";
import UserPage from "./components/UserPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ padding: "2rem" }}>
      {isLoggedIn ? (
        <>
          <UserPage />
          <LogoutButton onClick={() => setIsLoggedIn(false)} />
        </>
      ) : (
        <>
          <GuestPage />
          <LoginButton onClick={() => setIsLoggedIn(true)} />
        </>
      )}
    </div>
  );
}

export default App;
