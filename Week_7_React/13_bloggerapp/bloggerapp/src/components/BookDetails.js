import React from "react";

export default function BookDetails({ books }) {
  return (
    <div>
      <h1>Book Details</h1>
      <ul>
        {books.map((book) => (
          <li key={book.id}>{book.bname}: ${book.price}</li>
        ))}
      </ul>
    </div>
  );
}
