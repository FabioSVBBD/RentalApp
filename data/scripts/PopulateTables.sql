USE master;
GO

USE RentalApp_DB;
GO

-- Vehicle Type
INSERT INTO [VehicleType] ([Type])
VALUES
    ('Car'),
    ('Motorcycle'),
    ('Truck'),
    ('Van'),
    ('Bus'),
    ('Trailer');
GO

-- Payment Method
INSERT INTO [PaymentMethod] ([MethodName])
VALUES
    ('Cash'),
    ('Credit Card'),
    ('Debit Card'),
    ('Bank Transfer'),
    ('E-wallet');
GO


/*Color Table*/
INSERT INTO [Color]
	([ColorName])
VALUES
	('Green'),
	('Indigo'),
	('Violet'),
	('Indigo'),
	('Pink'),
	('Teal'),
	('Red'),
	('Yellow'),
	('Crimson'),
	('Orange'),
	('Blue'),
	('Purple'),
	('Black'),
	('Grey'),
	('White'),
	('Aquamarine');
GO

/*Brand Table*/
INSERT INTO [Brand]
	([BrandName])
VALUES
	('Toyota'),
	('Nissan'),
	('Volkswagen'),
	('Kia'),
	('Renult'),
	('Mazda'),
	('Suzuki'),
	('BMW'),
	('Audi'),
	('Mercedes-Benz'),
	('GMC');
GO

/*Model Table*/
INSERT INTO [Model]
	([BrandID],
	[ModelName],
	[Year])
VALUES
	(1, 'Corolla', 2005),
	(1, 'Corolla Quest', 2020),
	(1, 'Yaris', 2005),
	(1, 'Hilux SW4', 2006),
	(1, 'Fortuner', 2022),
	(2, 'Sentra', 2009),
	(2, 'Frontier', 2011),
	(2, 'Armada', 2019),
	(3, 'Polo', 2011),
	(3, 'Golf 6', 2016),
	(3, 'Caddy', 2015),
	(4, 'Sportage', 2007),
	(4, 'Sorento', 2013),
	(4, 'Soul', 2020),
	(4, 'Duster', 2018),
	(5, 'Stepway', 2009),
	(5, 'Dynamique', 2020),
	(6, 'Mazda CX-3', 2005),
	(6, 'Mazada BT-50', 2016),
	(6, 'Mazda 2', 2012),
	(7, 'Ciaz', 2001),
	(7, 'Ertiga', 2020),
	(7, 'Jimny', 2013),
	(8, '2 Series Gran Coup', 2021),
	(8, '1 Series', 2000),
	(8, 'X5', 2016),
	(9, 'Audi A1', 2020),
	(9, 'Audi A5', 2021),
	(9, 'Audi Q5', 2021),
	(10, 'GLB 220 D 4M (X247) ZA', 2020),
	(10, 'S500 4 MATIC SEDAN (V223)', 2016),
	(10, 'V 300 D EXCLUSIVE F/L', 2015),
	(11, 'Canyon', 2005),
	(11, 'Terrain', 2016),
	(11, 'Sierra', 2022);
GO

-- Review
INSERT INTO [Review] ([Date], [Message], [Rating])
VALUES
    ('2021-07-14', 'Great service!', 5),
    ('2021-12-09', 'Trash website! Avoid', 1),
    ('2022-03-25', 'Not bad service, but there is room for improvement', 3);
GO

-- Client
INSERT INTO [Client] ([Name], Surname, Email, Phone)
    VALUES ('Nanine', 'Venners', 'nvenners0@home.pl', '860-318-935'),
    ('Andre', 'De Souza', 'adesouza1@thetimes.co.uk', '569-660-4441'),
    ('Carl', 'Ralestone', 'cralestone2@goo.ne.jp', '989-304-5808'),
    ('Barbaraanne', 'Grunbaum', 'bgrunbaum3@ox.ac.uk', '662-822-4120'),
    ('Carleen', 'Hacker', 'chacker4@phoca.cz', '801-759-0140'),
    ('Atlante', 'Boman', 'aboman5@ucla.edu', '259-517-2490'),
    ('Jessee', 'Starking', 'jstarking6@vistaprint.com', '330-905-6523'),
    ('Wainwright', 'Gabbitus', 'wgabbitus7@geocities.jp', '732-445-9775'),
    ('Tobias', 'Estevez', 'testevez8@opera.com', '402-415-1863'),
    ('Thaddus', 'Renouf', 'trenouf9@google.it', '384-868-5608');
GO

-- Status
INSERT INTO [Status] ([Status])
    VALUES ('Processing'),('Active'),('Cancelled'),('Complete');
GO

-- Employee
INSERT INTO [Employee] ([Name], Surname, Phone, DateOfEmployment)
    VALUES ('Jack', 'Dielhenn', '967-905-3400', '2021-05-13 00:18:31'),
    ('Roldan', 'Loveday', '642-116-9328', '2021-08-05 02:31:15'),
    ('Roana', 'Lanigan', '232-339-6432', '2021-08-14 11:06:04'),
    ('Buddie', 'Treske', '832-545-0936', '2021-05-12 05:40:55'),
    ('Isidoro', 'Cavaney', '510-599-9532', '2021-09-16 13:41:44'),
    ('Frieda', 'Finnigan', '884-725-8732', '2021-09-06 23:20:27'),
    ('Anderson', 'Hawke', '943-126-8036', '2021-06-21 19:22:27'),
    ('Tawnya', 'MacShane', '392-988-6191', '2021-03-21 18:42:58'),
    ('Chancey', 'Aizlewood', '375-433-2127', '2021-12-21 23:26:29'),
    ('Katinka', 'Rodd', '329-716-8181', '2021-04-13 16:34:56');
GO

-- Vehicle
INSERT INTO [Vehicle]
	([VIN], [BrandID], [ModelID], [VehicleTypeID], [ColorID],
	[NumSeats], [DayRate], [HourlyRate], [YearPurchased], [LastService],
	[Transmission], [Mileage], [DepositAmount], [Available])
VALUES
    ('WDBAB23A6DB369209', 5, 15, 1, 2, 4, 350.00, 50.00, 2018, '2021-01-03', 'A', 700, 4000.00, 1),
    ('JH4KA7680RC011845', 3, 10, 1, 10, 4, 400.00, 65.00, 2019, '2022-03-26', 'A', 500, 4800.00, 1),
    ('YS3ED48E5Y3070016', 6, 19, 4, 6, 2, 250.00, 35.00, 2017, '2022-03-30', 'M', 1000, 3500.00, 1),
    ('5J6RE4H48BL023237', 2, 8, 5, 8, 6, 500.00, 75.00, 2020, '2021-05-25', 'M', 300, 6000.00, 1),
    ('1G8ZH1277XZ105148', 8, 25, 1, 3, 4, 428.00, 60.00, 2019, '2021-02-13', 'M', 850, 5500.00, 1),
    ('3GCEC14X66G218202', 10, 31, 1, 5, 4, 358.00, 55.00, 2018, '2021-03-13', 'A', 2000, 4300.00, 1),
    ('1HD1KHM16DB613457', 1, 4, 4, 14, 2, 280.00, 40.00, 2019, '2021-06-11', 'A', 1500, 3700.00, 1);
GO

-- Rental
INSERT INTO [Rental]
	([ClientID], [EmployeeID], [VehicleID], [PaymentMethodID],
	[StatusID], [ReviewID], [Address], [StartDate], [EndDate], [Balance])
VALUES
    (3, 5, 1, 2, 2, 1, '1984 Thomas St, Pietermaritzburg, KwaZulu-Natal', '2021-01-01', '2021-01-03', 1050),
    (2, 3, 2, 2, 4, 2, '416 Diesel Street, Westonaria, Gauteng', '2022-03-25', '2022-03-26', 400),
    (5, 3, 3, 2, 4, 3, '566 Akasia St, Pietermaritzburg, KwaZulu-Natal', '2022-03-25', '2022-03-30', 1250),
    (1, 2, 4, 3, 1, null, '899 Stanley Rd,  Durban, KwaZulu-Natal', '2021-05-15', '2021-05-25', 5000),
    (6, 1, 5, 1, 3, null, '1416 Market St, Johannesburg, Gauteng', '2021-02-11', '2021-02-13', 428),
    (7, 9, 6, 4, 4, null, '2482 Schoeman St, Pretoria,  Gauteng', '2021-11-10', '2021-11-15', 1000);
GO