create database normalization_db;
use normalization_db;

-- Convert the following table into 1NF
-- table Orders
-- Columns: `OrderID`, `CustomerName`, `ProductNames`

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerName VARCHAR(50),
    ProductName VARCHAR(50)
);

-- Normalize the following table to 2NF
-- Table: Student_Courses
-- Columns: `StudentID`, `StudentName`, `CourseID`, `CourseName`, `InstructorID`, `InstructorName`

CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50)
);
CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(50)
);
CREATE TABLE Instructors (
    InstructorID INT PRIMARY KEY,
    InstructorName VARCHAR(50)
);
CREATE TABLE Student_Course_Enrollments (
    StudentID INT,
    CourseID INT,
    InstructorID INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
    FOREIGN KEY (InstructorID) REFERENCES Instructors(InstructorID)
);

-- Normalize the following table to 3NF
-- Table: Sales
-- Columns: `SalesID`, `ProductID`, `ProductName`, `CategoryID`, `CategoryName`, `SaleDate`

CREATE TABLE Sales (
    Sales_id INT PRIMARY KEY,
    Product_id INT,
    Sale_date DATE,
    FOREIGN KEY (Product_id) REFERENCES Products(Product_id)
);
CREATE TABLE Products (
    Product_id INT PRIMARY KEY,
    Product_name VARCHAR(50),
    Category_id INT,
    FOREIGN KEY (Category_id) REFERENCES Categories(Category_id)
);
CREATE TABLE Categories (
    Category_id INT PRIMARY KEY,
    Category_name VARCHAR(50)
);


-- case study
CREATE TABLE Books (
    BookID INT PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100)
);

-- Given a 2NF table with columns (OrderID, ProductID, ProductName, and SupplierName)
-- write the SQL commands to normalize this table to 3NF.

CREATE TABLE Orders (
    OrderID INT,
    ProductID INT,
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    SupplierID INT,
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);
CREATE TABLE Suppliers (
    SupplierID INT PRIMARY KEY,
    SupplierName VARCHAR(100)
);
