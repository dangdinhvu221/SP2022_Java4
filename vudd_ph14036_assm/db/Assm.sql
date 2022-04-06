CREATE DATABASE AssignmentJava4
GO

USE AssignmentJava4
GO

CREATE TABLE users
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	username NVARCHAR(255),
	password NVARCHAR(255),
	fullName NVARCHAR(255),
	address NVARCHAR(max),
	email NVARCHAR(255),
	phone NVARCHAR(20),
	gender BIT,
	avatar NVARCHAR(max),
	created DATETIME,
	isAdmin BIT,
	status BIT,
)
GO

CREATE TABLE supplier
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameSupplier NVARCHAR(255),
	phone VARCHAR(20),
	address NVARCHAR(max)
)
GO

CREATE TABLE category
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameCategory VARCHAR(255)
)
GO

CREATE TABLE products
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameProduct NVARCHAR(255),
	category_id INT,
	supplier_id INT,
	quantity INT,
	price INT, 
	color INT,
	size NVARCHAR(255),
	imageProduct NVARCHAR(max),
	description NVARCHAR(max),
	title NVARCHAR(max),
	lastUpdate DATETIME,
	created DATETIME
)
GO

CREATE TABLE orderStates
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameStates NVARCHAR(255)
)
GO

CREATE TABLE orders
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	[user_id] INT,
	amount FLOAT,
	orderState INT,
	customerName NVARCHAR(255),
	ship_address NVARCHAR(max),
	phone NVARCHAR(20),
	created DATETIME,
	updated DATETIME,
	fixer DATETIME,
)
GO

CREATE TABLE orderdetails
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	product_id INT,
	order_id INT,
	quantity INT,
)
GO

ALTER TABLE dbo.products ADD FOREIGN KEY (supplier_id) REFERENCES dbo.supplier(id)
ALTER TABLE dbo.products ADD FOREIGN KEY (category_id) REFERENCES dbo.category(id)
ALTER TABLE dbo.orders ADD FOREIGN KEY (user_id) REFERENCES dbo.Users(id)
ALTER TABLE dbo.orders ADD FOREIGN KEY (orderState) REFERENCES dbo.orderStates(id)
ALTER TABLE dbo.orderdetails ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)
ALTER TABLE dbo.orderdetails ADD FOREIGN KEY (order_id) REFERENCES dbo.orders(id)


CREATE TABLE favorite
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	user_id INT,
	product_id INT,
	likeDate DATETIME

)
GO

CREATE TABLE share
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	user_id INT, 
	product_id INT,
	email NVARCHAR(255),
	shareDate DATETIME
)
GO

ALTER TABLE dbo.favorite ADD FOREIGN KEY (user_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.favorite ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)
ALTER TABLE dbo.share ADD FOREIGN KEY (user_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.share ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)

ALTER TABLE dbo.products ALTER COLUMN color NVARCHAR(255)