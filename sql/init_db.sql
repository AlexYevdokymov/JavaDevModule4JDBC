
CREATE TABLE IF NOT EXISTS worker (
ID IDENTITY PRIMARY KEY,
name VARCHAR(1000) NOT NULL,
birthday DATE,
level ENUM('Trainee','Junior','Middle','Senior') NOT NULL,
salary INT,
CONSTRAINT wk_name_length CHECK (CHAR_LENGTH(name) >= 2),
CONSTRAINT bd_date CHECK birthday >= '1900-12-31' ,
CONSTRAINT salary_amount CHECK salary between 100 and 100000
);

CREATE TABLE IF NOT EXISTS client (
ID IDENTITY PRIMARY KEY,
name VARCHAR(1000) NOT NULL,
CONSTRAINT cl_name_length CHECK (CHAR_LENGTH(name) >= 2)
);

CREATE TABLE IF NOT EXISTS project (
ID IDENTITY PRIMARY KEY,
client_id BIGINT,
start_date DATE,
finish_date DATE,
FOREIGN KEY(client_id) REFERENCES client(ID)
);

CREATE TABLE IF NOT EXISTS project_worker (
project_id BIGINT,
worker_id BIGINT,
PRIMARY KEY (project_id, worker_id),
FOREIGN KEY (project_id) REFERENCES project(ID),
FOREIGN KEY (worker_id) REFERENCES worker(ID)
);
