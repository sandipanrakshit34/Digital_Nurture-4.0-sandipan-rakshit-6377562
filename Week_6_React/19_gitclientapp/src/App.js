import './App.css';
import GitClient from './GitClient';
import { useEffect, useState } from 'react';

function App() {
  const [repositories, setRepositories] = useState([]);

  useEffect(() => {
    GitClient.getRepositories('techiesyed')
      .then(response => setRepositories(response.data))
      .catch(error => console.error('Error fetching repositories:', error));
  }, []);

  return (
    <div className="App">
      <h1>Git repositories of User - TechieSyed</h1>
      {repositories.map(repo => (
        <p key={repo.name}>{repo.name}</p>
      ))}
    </div>
  );
}

export default App;
