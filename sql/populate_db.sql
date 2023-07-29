
INSERT INTO worker (name, birthday, level, salary) VALUES
('Max Hoffer', '1993-07-23', 'Senior', 7250),
('Martin Schommer', '2003-03-05', 'Trainee', 700),
('Nicolas Brown', '1999-12-15', 'Middle', 2620),
('Sebastian Muller', '2001-02-21', 'Junior', 1400),
('Lucas Chanavat', '1998-08-13', 'Middle', 3150),
('Angela Shelby', '1990-10-25', 'Senior', 5700),
('Anthony Santos', '2001-05-29', 'Junior', 1420),
('Dorothea Bart', '1997-09-15', 'Senior', 6570),
('Lisa Hauser', '1999-11-22', 'Middle', 2880),
('Marcus Cooper', '1996-06-03', 'Senior', 7000);

INSERT INTO client (name) VALUES
('Fabien Doll'),
('Roman Green'),
('Benedict Lisovskii'),
('Omar Konte'),
('Lucy Chevalier');

INSERT INTO project(client_id, start_date, finish_date) VALUES
(1,'2021-02-17','2025-06-12'),
(1,'2019-10-03','2024-04-01'),
(2,'2022-08-20','2022-10-20'),
(2,'2017-03-03','2019-04-28'),
(3,'2022-07-09','2026-12-31'),
(3,'2020-01-16','2023-12-01'),
(3,'2023-07-05','2023-12-20'),
(4,'2018-05-13','2024-04-01'),
(4,'2020-08-20','2021-12-15'),
(5,'2023-05-12','2026-11-12'),
(5,'2022-04-25','2025-07-22');

INSERT INTO project_worker (project_id, worker_id) VALUES
(1,1),(1,2),(1,3),(2,4),(2,5),(3,1),(3,6),(3,7),(3,8),(3,5),(4,9),(4,10),(4,2),(5,1),(6,1),
(6,2),(6,3),(7,4),(7,5),(8,1),(8,6),(8,7),(8,8),(8,5),(9,9),(9,10),(9,2),(10,1),(11,5),(11,2);

