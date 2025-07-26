// src/components/TrainerDetail.js
import React from "react";
import { useParams } from "react-router-dom";
import trainersMock from "../data/TrainersMock";

const TrainerDetail = () => {
  const { id } = useParams();
  const trainer = trainersMock.find((t) => t.trainerId === id);

  if (!trainer) return <h2>Trainer not found.</h2>;

  return (
    <div>
      <h2>Trainer Details</h2>
      <h3>{trainer.name} ({trainer.technology})</h3>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill) => (
          <li key={skill}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetail;
