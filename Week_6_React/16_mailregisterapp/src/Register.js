import React, { Component } from 'react';
import './Register.css'; // (Optional for styling)

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: '',
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        const validEmailRegex = RegExp(
          /^[^\s@]+@[^\s@]+\.[^\s@]+$/
        );
        errors.email = validEmailRegex.test(value) ? '' : 'Email is not valid!';
        break;
      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  validateForm = (errors) => {
    return Object.values(errors).every(val => val.length === 0);
  };

  handleSubmit = (event) => {
    event.preventDefault();

    if (this.validateForm(this.state.errors)) {
      alert('Valid Form');
      // Here you can handle further logic like sending data to a server
    } else {
      if (this.state.errors.fullName !== '') {
        alert(this.state.errors.fullName);
      }
      if (this.state.errors.email !== '') {
        alert(this.state.errors.email);
      }
      if (this.state.errors.password !== '') {
        alert(this.state.errors.password);
      }
    }
  };

  render() {
    const { fullName, email, password } = this.state;

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1 style={{ color: 'red' }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name: </label>
            <input type="text" name="fullName" value={fullName} onChange={this.handleChange} />
          </div>
          <div>
            <label>Email: </label>
            <input type="text" name="email" value={email} onChange={this.handleChange} />
          </div>
          <div>
            <label>Password: </label>
            <input type="password" name="password" value={password} onChange={this.handleChange} />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;
