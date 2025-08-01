import React from "react";

export default function BlogDetails({ blog }) {
  return (
    <div>
      <h1>Blog Details</h1>
      <h2>{blog.title}</h2>
      <p>{blog.author}</p>
      <p>{blog.content}</p>
    </div>
  );
}
