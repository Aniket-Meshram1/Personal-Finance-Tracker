CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE income (
    income_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    amount NUMERIC(10,2) NOT NULL,
    category VARCHAR(50),
    date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE expenses (
    expense_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    amount NUMERIC(10,2) NOT NULL,
    category VARCHAR(50),
    date DATE DEFAULT CURRENT_DATE
);
