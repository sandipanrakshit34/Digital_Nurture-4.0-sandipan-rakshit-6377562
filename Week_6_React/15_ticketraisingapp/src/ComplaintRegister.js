import React from "react";

class ComplaintRegister extends React.Component {
  constructor() {
    super();
    this.state = {
      ename: "",
      complaint: "",
      NumberHolder: Math.floor(Math.random() * 100), // Random transaction ID
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    const msg =
      "Thanks " +
      this.state.ename +
      "\nYour Complaint was Submitted.\nTransaction ID is: " +
      this.state.NumberHolder;
    alert(msg);
    event.preventDefault();
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h2 style={{ color: "red" }}>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ margin: "10px" }}>
            <label>Name:&nbsp;</label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ margin: "10px" }}>
            <label>Complaint:&nbsp;</label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
              required
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
