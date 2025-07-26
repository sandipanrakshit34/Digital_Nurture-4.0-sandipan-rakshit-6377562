import React from "react";

export default function CourseDetails({ courses }) {
  return (
    <div>
      <h1>Course Details</h1>
      <ul>
        {courses.map((c) => (
          <li key={c.id}>{c.name}: {c.date}</li>
        ))}
      </ul>
    </div>
  );
}
