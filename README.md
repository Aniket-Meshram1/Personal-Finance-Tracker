💰 Personal Finance Tracker

A terminal-based Personal Finance Tracker built with Java, Maven, and PostgreSQL.
This app helps users manage their money by tracking incomes and expenses, calculating balances, and generating simple financial insights — all through a clean CLI interface.

🚀 Features

🔐 User Authentication → Register & login system.

💵 Add Income & Expenses → Categorize transactions (e.g., Food, Salary, Transport).

📊 Balance Calculation → Shows net balance = total income – total expenses.

📑 Transaction History → View all incomes & expenses with dates.

🗄 PostgreSQL Database → Persistent storage of users and transactions.

⚡ Maven Project → Easy dependency management and build process.

🛠 Tech Stack

Language: Java 17+

Build Tool: Maven

Database: PostgreSQL

Libraries: JDBC

📂 Project Structure

```text
personal-finance-tracker/
├── src/
│ ├── main/java/
│ │ ├── dao/ # Data access layer (JDBC queries)
│ │ ├── model/ # Entity classes (User, Income, Expense)
│ │ ├── service/ # Business logic
│ │ ├── util/ # Utility (DB connection)
│ │ └── Main.java # Entry point (console UI)
│ └── main/resources/ # Database schema
│
└── pom.xml
```


⚙️ Setup & Installation
1️⃣ Clone the Repository
git clone https://github.com/Aniket-Meshram1/Personal-Finance-Tracker.git
cd Personal-Finance-Tracker

2️⃣ Configure Database

Make sure PostgreSQL is installed & running.

Create a database:

CREATE DATABASE financeTracker;


Run the schema file inside src/main/resources/schema.sql.

3️⃣ Update DB Credentials

Edit DBConnection.java with your PostgreSQL username & password:

private static final String URL = "jdbc:postgresql://localhost:5432/finance_tracker";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";

4️⃣ Build & Run
mvn clean install
mvn exec:java -Dexec.mainClass="Main"

🎮 Usage

Register or Login with a username & password.

Choose options from the menu:

Add income

Add expense

View balance

View incomes

View expenses

Logout

Example:

==== Personal Finance Tracker ====
1. Register
2. Login
0. Exit

📸 Demo (Terminal Output)
Welcome, Anya
1. Add Income
2. Add Expense
3. View Balance
4. View Incomes
5. View Expenses
6. Logout

🌟 Future Enhancements

📈 Add category-wise expense pie charts.

🌐 Create a JavaFX UI or Web-based dashboard.

🔔 Add budget alerts when expenses exceed a limit.

📅 Support monthly/weekly summary reports.

👩‍💻 Author

Aniket Meshram

💼 Open to collaborations & contributions!
