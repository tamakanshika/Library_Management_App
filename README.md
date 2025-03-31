# Library Management System

##  Overview
This is a **Library Management System** built with **Java Spring Boot** and **MongoDB Atlas** as the cloud database. The application allows users to **add, edit, delete, search and browse books**.

## Features
- Add new books with details like **Book ID, Title, Author, Genre, and Availability Status**.
- Search books using **indexes on Book ID and Title**.
- Edit and delete books.
- Beautifully designed **Thymeleaf-based frontend**.
- Deployment using **Railway.app**.

---

## 🛠️ Tech Stack
- **Backend**: Java, Spring Boot
- **Database**: MongoDB Atlas
- **Frontend**: Thymeleaf, HTML, CSS
- **Deployment**: Railway.app

---

## ⚙️ Installation & Setup

### **1 Clone the Repository**
```bash
 git clone https://github.com/your-username/library-management-system.git
 cd library-management-system
```

### **2️ Configure MongoDB Atlas**
- Update the `application.properties` file with your **MongoDB URI**:
  ```properties
  spring.application.name=lms
  spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<your-cluster>.mongodb.net/?retryWrites=true&w=majority&appName=Cluster1
  spring.data.mongodb.database=LMS
  ```

### **3️ Run the Application**
```bash
 mvn spring-boot:run
```

> The app will be available at: **http://localhost:8080**

---

## Deployment on Railway
This webapp is deployed at the following link:  https://librarymanagementapp-production-4835.up.railway.app/


## Usage
- **Home Page**: `/`
- **Browse Books**: `/books`
- **Add New Book**: `/books/add`
- **Edit Book**: `/books/edit/{bookId}`
- **Delete Book**: `/books/delete/{bookId}`

---



