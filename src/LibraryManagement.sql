create database LibraryManagement;
use LibraryManagement;

create table Authors (
author_id int auto_increment primary key, 
first_name varchar(20), 
last_name varchar(20));

CREATE TABLE Books (
book_id int primary key auto_increment, 
title varchar(20), 
author_id int, 
publication_year year, 
price Decimal(6,2), 
foreign key (author_id) references Authors(author_id));

create table Borrowers (
borrower_id int auto_increment primary key, 
first_name varchar(20), 
last_name varchar(20), 
email varchar(50) unique, 
dob date);

create table Loans (
loan_id int primary key auto_increment, 
borrower_id int, 
book_id int, 
loan_date date, 
return_date date, 
foreign key(borrower_id) references Borrowers(borrower_id), 
foreign key(book_id) references Books(book_id));

insert into Authors (first_name, last_name) values 
('J.K.', 'Rowling'),
('George', 'Martin'),
('Harper', 'Lee'),
('R.R', 'Fitzgerald'),
('Leo', 'Tolstoy');

insert into Books (title, author_id, publication_year, price) values 
('Harry Potter', 1, 1998, 20),
('The Hobbit', 2, 1948, 45),
('Mobby Dick', 3, 1990, 350),
('The Great Gatsby', 4, 1902, 200),
('War and Peace', 5, 1992, 500);

insert into Borrowers(first_name, last_name, email, dob) values
('Alice','Johnson','alice.johnson@gmail.com','1990-01-22'),
('Bob','Smith','bob.smith02@gmail.com','1997-04-11'),
('John','Doe','john.doe@gmail.com','2001-03-17'),
('Daisy','Jacob','daisy.jacob@gmail.com','2002-10-28'),
('Jack','Davidson','jack.davidson@gmail.com','2004-08-29');

insert into Loans(borrower_id, book_id, loan_date, return_date) values 
(1, 11, '2024-01-10', '2024-01-24'),
(2, 12, '2024-01-15', '2024-02-01'),
(3, 13, '2024-02-01', '2024-03-14'),
(4, 14, '2024-03-05', NULL),
(5, 15, '2024-03-10', '2024-03-24');

-- Select all columns from the Books table.
SELECT * FROM Books;

-- Select the title, price, and publication_year of books where price > 20.
SELECT title,price,publication_year FROM Books WHERE price>20;

-- Select the first_name, last_name, and email of borrowers who have borrowed books after '2024-01-01'.
SELECT Borrowers.first_name, Borrowers.last_name, Borrowers.email FROM Borrowers WHERE Borrowers.borrower_id IN 
(SELECT Loans.borrower_id FROM Loans WHERE Loans.loan_date > '2024-01-01');

-- Update the price of the book with title = 'The Great Gatsby' to 25.00.
UPDATE Books SET price=25 WHERE title='The Great Gatsby';

-- Delete the book from the Books table where title = 'Moby Dick'.
DELETE FROM Loans WHERE book_id = (SELECT book_id FROM Books WHERE title = 'Mobby Dick');
DELETE FROM Books WHERE title='Mobby Dick';

-- Alter the Books table to add a new column genre of type VARCHAR(50).
ALTER TABLE Books ADD COLUMN genre varchar(20);

-- Use the COUNT function to find the total number of borrowers.
SELECT COUNT(email) FROM Borrowers;

-- Use the SUM function to find the total price of all books in the library.
SELECT SUM(price) FROM Books;

-- Use the AVG function to calculate the average price of books.
SELECT AVG(price) FROM Books;

-- Write a subquery to find all books that have been borrowed by any borrower who is over 30 years old.
SELECT title FROM Books WHERE book_id IN 
(SELECT book_id FROM Loans WHERE borrower_id IN 
(SELECT borrower_id FROM Borrowers where DATEDIFF(CURDATE(),dob)/365>30));
