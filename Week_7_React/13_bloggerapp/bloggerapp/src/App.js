import React, { useState } from "react";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

const books = [
  { id: 101, bname: "Master React", price: 670 },
  { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
  { id: 103, bname: "Mongo Essentials", price: 450 }
];

const blog = {
  title: "React Learning",
  author: "Stephen Biz",
  content: "Welcome to learning React!"
};

const courses = [
  { id: 1, name: "Angular", date: "4/5/2021" },
  { id: 2, name: "React", date: "6/3/2020" }
];

function App() {
  const [selectedView, setSelectedView] = useState("Books"); // state to switch view

  let componentToRender;
  switch (selectedView) {
    case "Books":
      componentToRender = <BookDetails books={books} />;
      break;
    case "Blogs":
      componentToRender = <BlogDetails blog={blog} />;
      break;
    case "Courses":
      componentToRender = <CourseDetails courses={courses} />;
      break;
    default:
      componentToRender = null;
  }

  return (
    <div style={{ padding: "20px" }}>
      <h1>Blogger App</h1>
      <button onClick={() => setSelectedView("Books")}>Show Books</button>{" "}
      <button onClick={() => setSelectedView("Blogs")}>Show Blogs</button>{" "}
      <button onClick={() => setSelectedView("Courses")}>Show Courses</button>

      <hr />

      {/* Conditional Rendering Techniques */}
      {/* Using switch */}
      {componentToRender}

      {/* Using && operator */}
      {selectedView === "Books" && <p>You are looking at Books</p>}

      {/* Using ternary */}
      {selectedView === "Courses" ? <p>Enjoy Courses!</p> : null}
    </div>
  );
}

export default App;
