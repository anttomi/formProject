DROP TABLE IF EXISTS question;

CREATE TABLE question (
  id LONG PRIMARY KEY,
  question VARCHAR(250) NOT NULL,
  answer VARCHAR(250),
  qtype VARCHAR (15), NOT NULL
);

INSERT INTO question (ID, QUESTION, ANSWER, QTYPE) VALUES
  (1, 'kysymys1', 'vastaus 1', 'text'),
  (2, 'kysmys2', 'vastaus 2' , 'text'),
  (3, 'ksymys3', 'vastaus 3', 'text');