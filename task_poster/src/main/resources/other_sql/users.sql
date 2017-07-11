--table users
CREATE TABLE users(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  hashPassword VARCHAR(255) NOT NULL
)