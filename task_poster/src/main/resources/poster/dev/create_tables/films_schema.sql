CREATE TABLE films (
  id SERIAL PRIMARY KEY,
  name VARCHAR(150),
  releaseDate VARCHAR(30),
  country VARCHAR(50),
  producer VARCHAR(50),
  lasting INTEGER,
  description VARCHAR(1000),
  picture VARCHAR(300)
);
