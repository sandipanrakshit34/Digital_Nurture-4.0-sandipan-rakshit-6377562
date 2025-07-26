import React from "react";

class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0,
    };
  }

  updateEntry() {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  updateExit() {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div style={{ display: "flex", justifyContent: "center", gap: "40px", marginTop: "100px" }}>
        <div>
          <button onClick={() => this.updateEntry()} style={{ backgroundColor: "lightgreen", padding: "8px" }}>
            Login
          </button>
          <span style={{ marginLeft: "10px", fontWeight: "bold" }}>
            {this.state.entrycount} People Entered!!!
          </span>
        </div>

        <div>
          <button onClick={() => this.updateExit()} style={{ backgroundColor: "lightgreen", padding: "8px" }}>
            Exit
          </button>
          <span style={{ marginLeft: "10px", fontWeight: "bold" }}>
            {this.state.exitcount} People Left!!!
          </span>
        </div>
      </div>
    );
  }
}

export default CountPeople;
