USE master;
GO

USE RentalApp_DB;
GO

INSERT INTO [dbo].[VehicleType] ([Type])
VALUES
    ('Car'),
    ('Motorcycle'),
    ('Truck'),
    ('Van'),
    ('Bus'),
    ('Trailer');
GO

INSERT INTO [dbo].[PaymentMethod] ([MethodName])
VALUES
    ('Cash'),
    ('Credit Card'),
    ('Debit Card'),
    ('Bank Transfer'),
    ('E-wallet');
GO

INSERT INTO [dbo].[Review] ([Date], [Message], [Rating])
VALUES
    ('2021-07-14', 'Great service!', 5),
    ('2021-12-09', 'Trash website! Avoid', 1),
    ('2022-03-25', 'Not bad service, but there is room for improvement', 3);
GO