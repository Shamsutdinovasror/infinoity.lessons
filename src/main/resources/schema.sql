CREATE TABLE students
(
    id          SERIAL PRIMARY KEY,
    firstName   VARCHAR(100),
    lastName    VARCHAR(100),
    email       VARCHAR(100) UNIQUE NOT NULL,
    age         int                 NOT NULL,
    phoneNumber VARCHAR(50)         NOT NULL
);