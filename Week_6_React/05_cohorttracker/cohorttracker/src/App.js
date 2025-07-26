import React from 'react';
import CohortDetails from './components/CohortDetails';
import cohorts from './data';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Cohorts Details</h1>
      {cohorts.map(cohort => (
        <CohortDetails key={cohort.id} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
