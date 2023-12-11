DROP TABLE IF EXISTS car_wheel;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS body;
DROP TABLE IF EXISTS wheel;

CREATE TABLE IF NOT EXISTS body (
id SERIAL PRIMARY KEY,
body_type VARCHAR(20) NOT NULL,
number_of_doors INT NOT NULL,
weight DOUBLE PRECISION NOT NULL,
height DOUBLE PRECISION NOT NULL
);

INSERT INTO body (body_type, number_of_doors, weight, height) VALUES
('HATCHBACK', 5, 1200.5, 150.0),
('SEDAN', 4, 1400.2, 160.5),
('HATCHBACK', 3, 1100.8, 145.5);

CREATE TABLE IF NOT EXISTS wheel (
id SERIAL PRIMARY KEY,
wheel_type VARCHAR(5) NOT NULL,
is_broken BOOLEAN NOT NULL,
color VARCHAR(10) NOT NULL,
brand VARCHAR(255) NOT NULL,
manufacturing_date DATE NOT NULL,
warranty_expiry_date DATE NOT NULL
);

INSERT INTO wheel (wheel_type, is_broken, color, brand, manufacturing_date, warranty_expiry_date) VALUES
('R16', FALSE, 'BLACK', 'Brand1', '2022-01-01', '2023-01-01'),
('R17', TRUE, 'GRAY', 'Brand2', '2022-02-15', '2023-02-15'),
('R15', FALSE, 'PURPLE', 'Brand3', '2022-03-20', '2023-03-20'),
('R16', FALSE, 'OBSIDIAN', 'Brand4', '2022-04-10', '2023-04-10'),
('R17', TRUE, 'BLACK', 'Brand5', '2022-05-05', '2023-05-05');

CREATE TABLE IF NOT EXISTS car (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
body_id INT REFERENCES body(id),
creation_date DATE NOT NULL
);

INSERT INTO car (name, body_id, creation_date) VALUES
('Car1', 1, '2022-06-01'),
('Car2', 2, '2022-07-15'),
('Car3', 3, '2022-08-20'),
('Car4', 2, '2022-09-10'),
('Car5', 1, '2022-10-05');

CREATE TABLE IF NOT EXISTS car_wheel (
car_id INT REFERENCES car(id) ON DELETE CASCADE,
wheel_id INT REFERENCES wheel(id)
);

INSERT INTO car_wheel (car_id, wheel_id) VALUES
(1, 1),
(1, 1),
(1, 2),
(1, 2),
(2, 3),
(2, 3),
(3, 2),
(3, 3),
(3, 4),
(4, 5),
(4, 5),
(5, 1),
(5, 2);

