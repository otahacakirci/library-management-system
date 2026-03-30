const API = "http://localhost:8080/api/books";
let editingBookId = null;

async function loadBooks() {
    const response = await fetch(API);
    const books = await response.json();

    const list = document.getElementById("bookList");
    list.innerHTML = "";

    books.forEach(book => {
        const li = document.createElement("li");

        const text = document.createElement("span");
        text.textContent = `${book.title} - ${book.author} (${book.publishedYear}) `;

        const editButton = document.createElement("button");
        editButton.textContent = "Edit";
        editButton.onclick = function () {
            startEdit(book.id, book.title, book.author, book.publishedYear);
        };

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.onclick = function () {
            deleteBook(book.id);
        };

        li.appendChild(text);
        li.appendChild(editButton);
        li.appendChild(deleteButton);

        list.appendChild(li);
    });
}

async function saveBook() {
    const title = document.getElementById("titleInput").value;
    const author = document.getElementById("authorInput").value;
    const publishedYear = document.getElementById("yearInput").value;
    const message = document.getElementById("message");

    const newBook = {
        title: title,
        author: author,
        publishedYear: Number(publishedYear)
    };

    let response;

    if (editingBookId === null) {
        response = await fetch(API, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newBook)
        });
    } else {
        response = await fetch(`${API}/${editingBookId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newBook)
        });
    }

    if(response.ok) {
        message.style.color = "green";
        message.textContent = editingBookId === null
            ? "Book added successfully."
            : "Book updated successfully.";
       
        document.getElementById("titleInput").value = "";
        document.getElementById("authorInput").value = "";
        document.getElementById("yearInput").value = "";

        editingBookId = null;
        document.getElementById("cancelButton").style.display = "none";

        
    }
    else {
        const errorData = await response.json();
       
        console.log(errorData); // görmek için

        let errorMessage = "";

        for (let field in errorData.errors) {
        errorMessage += errorData.errors[field] + "<br>";
    }

        message.innerHTML = errorMessage;
        
    }

    loadBooks();
}

async function deleteBook(id) {
    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });

    loadBooks();
}

function startEdit(id, title, author, publishedYear){

    document.getElementById("titleInput").value = title;
    document.getElementById("authorInput").value = author;
    document.getElementById("yearInput").value = publishedYear;

    editingBookId = id;
    document.getElementById("cancelButton").style.display = "inline-block";
}

function cancelEdit() {
    document.getElementById("titleInput").value = "";
    document.getElementById("authorInput").value = "";
    document.getElementById("yearInput").value = "";

    editingBookId = null;

    const message = document.getElementById("message");
    message.textContent = "";

    document.getElementById("cancelButton").style.display = "none";
}


loadBooks();






