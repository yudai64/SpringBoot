CREATE TABLE IF NOT EXISTS inquiry  (
  id INT NOT NULL AUTO_INCREMENT, 
  name VARCHAR(20) NOT NULL,
  email VARCHAR(30) NOT NULL,
  content TEXT NOT NULL,
  PRIMARY KEY(id)
);