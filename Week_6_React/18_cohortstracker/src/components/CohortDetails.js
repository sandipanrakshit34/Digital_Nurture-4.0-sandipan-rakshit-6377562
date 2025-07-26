import React from 'react';

const CohortDetails = ({ cohort }) => {
  if (!cohort) return <p>No cohort selected.</p>;

  return (
    <div>
      <h3>{cohort.code}</h3>
      <p>Name: {cohort.name}</p>
      <p>Status: {cohort.status}</p>
    </div>
  );
};

export default CohortDetails;
