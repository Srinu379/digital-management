# 💻 Digital Management System

A web-based application designed to digitize and streamline sick-room operations in institutions by replacing manual record-keeping with a structured, centralized system.

---

## 🚀 Problem Statement

Manual sick-room record handling often leads to:

* Data duplication and inconsistencies
* Difficulty in tracking patient history
* Inefficient medicine inventory management

This system addresses these issues by providing a digital platform for managing patient visits and medicine usage efficiently.

---

## 💡 Solution

Developed a centralized system where authorized medical staff can:

* Record and manage patient visits
* Track medicine inventory in real-time
* Filter and analyze records by category and gender

---

## 🛠️ Tech Stack

| Layer            | Technology                   |
| ---------------- | ---------------------------- |
| Backend          | Java, Spring MVC, Spring IoC |
| Database Access  | Spring JDBC, JdbcTemplate    |
| View             | JSP (JavaServer Pages)       |
| Database         | MySQL                        |
| Server           | Apache Tomcat 9              |
| Containerization | Docker                       |

---

## ✨ Key Features

### 👨‍⚕️ Patient & Visit Management

* Secure login for authorized medical staff
* Separate modules for:

  * Students (Roll Number)
  * Faculty (Faculty ID)
  * Non-Teaching Staff (Staff ID)
* Automatic check for existing patients before insertion
* Stores visit details including description, medicines, and timestamp

---

### 📊 Filtering & Insights

* Filter records by gender and category
* View total, male, and female visit counts

---

### 💊 Medicine Inventory System

* Displays available medicines during registration
* Automatically deducts stock on usage
* Prevents registration if medicine is out of stock
* Visual indicators:

  * 🔴 Low stock
  * 🟢 Sufficient stock
* Supports add, update, and delete operations

---

### 🔐 Security

* Session-based authentication
* Password update and forgot password functionality

---

## 🏗️ Architecture

The application follows the MVC (Model-View-Controller) architecture:

* **Controller Layer** → Handles HTTP requests
* **Service Layer** → Business logic and validation
* **DAO Layer** → Database operations using JdbcTemplate
* **View Layer (JSP)** → UI rendering

**Flow:**
Client → Controller → Service → DAO → Database → Response

---

## 🧠 System Flow

1. User logs in (validated via `users` table)
2. Selects patient category
3. System checks if patient exists

   * If not → creates new record
4. Medicine selected → stock validated & updated
5. Visit stored in respective issue table

---

## 🗂️ Project Structure

```
src/main/java/college/medical/project/
├── controllers/     → Handles HTTP requests and routing
├── DAO/             → Database access using JdbcTemplate
├── DTO/             → Data Transfer Objects
└── servicelayer/    → Business logic and validation

src/main/webapp/
├── WEB-INF/
│   ├── views/       → JSP pages (secured)
│   ├── web.xml      → Dispatcher configuration
│   └── beans.xml    → Spring configuration
└── resources/       → Static files (CSS, JS)
```

---

## 🗄️ Database Schema

### 👤 Users Table

Stores medical staff login details.

| Column      | Description          |
| ----------- | -------------------- |
| id          | Unique user ID       |
| email       | Login email          |
| userName    | Username             |
| passWord    | Password             |
| gender      | Gender               |
| phoneNumber | Contact number       |
| age         | Age                  |
| lastLogin   | Last login timestamp |

---

### 🎓 Students Table

| Column      | Description       |
| ----------- | ----------------- |
| rollNo      | Unique student ID |
| studentName | Name              |
| department  | Department        |
| gender      | Gender            |

---

### 👨‍🏫 Faculty Table

| Column      | Description |
| ----------- | ----------- |
| id          | Faculty ID  |
| facultyName | Name        |
| department  | Department  |
| gender      | Gender      |

---

### 🧑‍🔧 Non-Teaching Staff Table

| Column      | Description |
| ----------- | ----------- |
| id          | Staff ID    |
| facultyName | Name        |
| department  | Department  |
| gender      | Gender      |

---

### 🩺 Student Issues Table (`Issues`)

| Column      | Description                |
| ----------- | -------------------------- |
| id          | Issue ID                   |
| rollNo      | References Students.rollNo |
| description | Medical issue              |
| medicines   | Medicines given            |
| createdAt   | Timestamp                  |

---

### 🩺 Faculty Issues Table (`FacultyIssues`)

| Column      | Description           |
| ----------- | --------------------- |
| id          | Issue ID              |
| faculty_id  | References faculty.id |
| description | Medical issue         |
| medicines   | Medicines given       |
| createdAt   | Timestamp             |

---

### 🩺 Staff Issues Table (`NonTeachingStaffIssues`)

| Column      | Description                    |
| ----------- | ------------------------------ |
| id          | Issue ID                       |
| faculty_id  | References NonTeachingStaff.id |
| description | Medical issue                  |
| medicines   | Medicines given                |
| createdAt   | Timestamp                      |

---

### 💊 Medicines Table

| Column       | Description     |
| ------------ | --------------- |
| id           | Medicine ID     |
| MedicineName | Name            |
| quantity     | Available stock |
| description  | Details         |
| expiryDate   | Expiry date     |

---

## 🔗 Relationships

* One **Student → Many Issues**
* One **Faculty → Many Issues**
* One **Staff → Many Issues**
* Issues linked via foreign keys (`rollNo`, `faculty_id`)
* Medicines tracked and deducted during issue creation

---

## ⚙️ Setup Instructions

### Local Setup

```bash
git clone https://github.com/Srinu379/digital-management
```

1. Import as Maven project
2. Create MySQL database and run `schema.sql`
3. Set environment variables:

```
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/your_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password
```

4. Deploy on Apache Tomcat 9
5. Run at: http://localhost:8080

---

## 🐳 Docker Setup

### Build Image

```bash
docker build -t digital-management-app .
```

### Run Container

```bash
docker run -p 8080:8080 \
-e SPRING_DATASOURCE_URL=jdbc:mysql://<host>:<port>/<db> \
-e SPRING_DATASOURCE_USERNAME=<username> \
-e SPRING_DATASOURCE_PASSWORD=<password> \
digital-management-app
```

Access at: http://localhost:8080

---

## ☁️ Deployment

* Database: Aiven MySQL
* Hosting: Render (Docker + Tomcat)

---

## ⚙️ Challenges & Solutions

* Preventing invalid medicine usage → Implemented stock validation
* Avoiding duplicate patient records → Added existence checks
* Managing multiple user categories → Structured modular design
* Secure DB configuration → Used environment variables

---

## ⚠️ Limitations

* Medicine names are case-sensitive
* No pagination for large datasets
* Cold start delay on free hosting

---

## 📌 Key Takeaways

* Demonstrates strong backend development using Spring MVC
* Implements relational database design with multiple entities
* Solves a real-world workflow problem
* Uses Docker for deployment consistency

---

## 👨‍💻 Author

**Vanam Srinivas**
B.Tech CSE — KLU Hyderabad

* GitHub: https://github.com/Srinu379
* LinkedIn: https://linkedin.com/in/srinivas-vanam-79a72829b

---



