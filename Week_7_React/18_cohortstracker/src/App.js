import React from 'react';
import CohortDetails from './components/CohortDetails';
import { CohortData } from './components/Cohort';

function App() {
  return (
    <div className="App">
      <h2>Cohort Tracker</h2>
      <CohortDetails cohort={CohortData[0]} />
    </div>
  );
}

export default App;
