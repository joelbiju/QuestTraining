create database hotelreservation;
use hotelreservation;

-- customer table
CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(30),
    phone_number VARCHAR(15),
    address VARCHAR(50)
);

-- Room type table
CREATE TABLE RoomTypes (
    room_type ENUM('single', 'double', 'suite') PRIMARY KEY,
    price_per_night DECIMAL(6, 2)
);

-- Rooms table
CREATE TABLE Rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_type ENUM('single', 'double', 'suite'),
    status ENUM('available', 'occupied', 'under maintenance'),
    floor_number INT,
    FOREIGN KEY (room_type) REFERENCES RoomTypes(room_type)
);

-- Reservation table
CREATE TABLE Reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    room_id INT,
    reservation_date DATE,
    check_in_date DATE,
    check_out_date DATE,
    status ENUM('confirmed','cancelled','completed'),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

-- Payments table
CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    reservation_id INT,
    payment_date DATE,
    amount_paid DECIMAL(6, 2),
    payment_method ENUM('card','cash'),
    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id)
);

-- Staff table
CREATE TABLE Staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    role VARCHAR(20),
    hire_date DATE
);

-- Room_assignment table
CREATE TABLE Room_Assignments (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_id INT,
    room_id INT,
    assignment_date DATE,
    task_description VARCHAR(100),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

INSERT INTO Customers (first_name, last_name, email, phone_number, address) VALUES 
('Max', 'Verstappen', 'max.verstappen@gmail.com', '1234567890', '123 Main St'),
('Lewis', 'Hamilton', 'lewis.hamilton@gmail.com', '9876543210', '456 Elm St'),
('Mike', 'Tyson', 'mike.tyson@gmail.com', '5551234567', '789 Pine St'),
('Alice', 'Johnson', 'alice.j@ymail.com', '5559876543', '321 Oak St'),
('Emma', 'Watson', 'emma.watson@yahoo.com', '4442223333', '654 Maple St');

INSERT INTO RoomTypes (room_type, price_per_night) VALUES 
('single', 100.00),
('double', 150.00),
('suite', 300.00);

INSERT INTO Rooms (room_type, status, floor_number) VALUES 
('single', 'available', 1),
('double', 'occupied', 2),
('suite', 'available', 3),
('single', 'under maintenance', 1),
('double', 'available', 2);


INSERT INTO Reservations (customer_id, room_id, reservation_date, check_in_date, check_out_date, status) VALUES 
(1, 1, '2024-06-08', '2024-11-13', '2024-11-16', 'confirmed'),
(2, 2, '2024-08-18', '2024-11-14', '2024-11-18', 'confirmed'),
(3, 3, '2024-09-28', '2024-11-15', '2024-11-17', 'completed'),
(4, 5, '2024-05-12', '2024-11-20', '2024-11-23', 'cancelled'),
(5, 4, '2024-11-05', '2024-11-21', '2024-11-24', 'confirmed');

INSERT INTO Payments (reservation_id, payment_date, amount_paid, payment_method) VALUES 
(1, '2024-06-10', 300.00, 'card'),
(2, '2024-08-14', 600.00, 'cash'),
(3, '2024-08-20', 900.00, 'card'),
(5, '2024-10-11', 450.00, 'card');

INSERT INTO Staff (first_name, last_name, role, hire_date) VALUES 
('Sarah', 'Jacob', 'receptionist', '2023-05-15'),
('Tom', 'Watson', 'manager', '2022-01-12'),
('Merline', 'Green', 'housekeeper', '2023-08-10'),
('Matt', 'Johnson', 'receptionist', '2023-09-20');

INSERT INTO Room_Assignments (staff_id, room_id, assignment_date, task_description) VALUES 
(3, 1, '2024-11-13', 'cleaning'),
(4, 2, '2024-10-12', 'maintenance'),
(3, 3, '2024-12-14', 'cleaning'),
(2, 4, '2024-08-10', 'inspection');




-- Retrieve all information about rooms available on a specific floor.
SELECT r.room_id, r.room_type, r.status, r.floor_number 
FROM Rooms r JOIN Reservations res ON r.room_id = res.room_id WHERE r.status = 'available' AND r.floor_number = 2;

-- List all reservations with customer details (first name, last name, email) sorted by check-in date (earliest first).
SELECT Reservations.reservation_id, Reservations.check_in_date, Customers.first_name, 
Customers.last_name, Customers.email FROM Reservations JOIN Customers ON Reservations.customer_id = Customers.customer_id 
ORDER BY Reservations.check_in_date ASC;

-- Find all customers who have reserved rooms for more than 3 nights.
SELECT Customers.first_name, Customers.last_name, Reservations.check_in_date, Reservations.check_out_date, 
DATEDIFF(Reservations.check_out_date, Reservations.check_in_date) AS number_of_dates FROM Reservations JOIN 
Customers ON Reservations.customer_id = Customers.customer_id WHERE 
DATEDIFF(Reservations.check_out_date, Reservations.check_in_date) > 3;

-- Get the total amount paid for each reservation
SELECT Reservations.reservation_id, SUM(Payments.amount_paid) AS amount_paid 
FROM Payments JOIN Reservations ON Payments.reservation_id = Reservations.reservation_id
GROUP BY Reservations.reservation_id;

-- Find the average room price for each room type.
SELECT room_type, AVG(price_per_night) FROM RoomTypes GROUP BY room_type;

-- Display the total revenue generated from all reservations in the last month.
SELECT SUM(p.amount_paid) AS total_revenue FROM Payments p JOIN Reservations res 
ON p.reservation_id = res.reservation_id WHERE res.reservation_date 
BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND CURDATE();

-- Find the staff members who have been assigned the most rooms for cleaning or maintenance in the last month.
SELECT Staff.first_name, Staff.last_name, COUNT(Room_Assignments.assignment_id) AS total_assignments
FROM Room_Assignments JOIN Staff ON Room_Assignments.staff_id = Staff.staff_id
WHERE Room_Assignments.assignment_date BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND CURDATE()
GROUP BY Staff.staff_id ORDER BY total_assignments DESC;

-- Retrieve the most recent reservation for each customer.
SELECT Customers.first_name, Customers.last_name, Customers.email, Reservations.reservation_id, 
Reservations.reservation_date, Reservations.check_in_date, Reservations.check_out_date
FROM Reservations JOIN Customers ON Reservations.customer_id = Customers.customer_id
WHERE (Reservations.customer_id, Reservations.reservation_date) IN 
(SELECT customer_id, MAX(reservation_date) FROM Reservations GROUP BY customer_id) ORDER BY Reservations.reservation_date DESC;

-- Delete a reservation and all corresponding payment records
ALTER TABLE Payments ADD CONSTRAINT fk_reservation
FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id) ON DELETE CASCADE;
DELETE FROM Reservations WHERE reservation_id = 3;

-- Create a query that checks which rooms are available for a given date range
SELECT r.room_id, r.room_type, r.status FROM Rooms r LEFT JOIN Reservations res 
ON r.room_id = res.room_id AND res.check_in_date <= '2024-11-20' AND res.check_out_date >= '2024-11-15'
WHERE r.status = 'available' AND res.reservation_id IS NULL;


