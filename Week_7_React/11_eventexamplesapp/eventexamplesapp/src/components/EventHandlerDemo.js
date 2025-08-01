import React, { Component } from "react";

class EventHandlerDemo extends Component {
  constructor() {
    super();
    this.state = { count: 0 };
  }

  increment = () => {
    this.setState((prev) => ({ count: prev.count + 1 }));
    this.sayHello();
  };

  sayHello = () => {
    alert(`Hello! Member1`);
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleSynthetic = (e) => {
    e.preventDefault();
    alert(`I was clicked`);
  };

  decrement = () => {
    this.setState((prev) => ({ count: prev.count - 1 }));
  };

  render() {
    return (
      <div style={{ marginBottom: "40px" }}>
        <h2>Count: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>{" "}
        <button onClick={this.decrement}>Decrement</button>{" "}
        <button onClick={() => this.sayWelcome("welcome")}>Say Welcome</button>{" "}
        <button onClick={this.handleSynthetic}>Click on me</button>
      </div>
    );
  }
}

export default EventHandlerDemo;
