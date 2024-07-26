CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     username VARCHAR(20) UNIQUE,
     password VARCHAR(200),
     email VARCHAR(50) UNIQUE,
     locked BOOLEAN,
     disabled BOOLEAN
);

CREATE TABLE IF NOT EXISTS role(
   id SERIAL PRIMARY KEY,
   rol VARCHAR (25),
   user_id INT,
   FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS patients(
  id SERIAL,
    nui VARCHAR(100) UNIQUE NOT NULL,
  fullname VARCHAR(150) NOT NULL,
    phone VARCHAR(150) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id)REFERENCES users(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS doctor(
  id SERIAL,
  nui VARCHAR(100) UNIQUE NOT NULL,
    fullname VARCHAR(150) NOT NULL,
    phone VARCHAR(150) NOT NULL,
    specilization VARCHAR(150) NOT NULL,
    patients_id   INT,
    FOREIGN KEY (patients_id) REFERENCES patients(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS secretaria(
     id SERIAL,
     nui VARCHAR(100) UNIQUE NOT NULL,
     fullname VARCHAR(150) NOT NULL,
     phone VARCHAR(150) NOT NULL,
     doctor_id   INT,
     FOREIGN KEY (doctor_id) REFERENCES doctor(id),
     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS appoinments(
  id SERIAL NOT NULL,
  created_at DATE NOT NULL,
  reason VARCHAR(150) NOT NULL,
  patients_id   INT,
    doctor_id INT,
  FOREIGN KEY (patients_id) REFERENCES patients(id),
  FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    PRIMARY KEY (id)
);


