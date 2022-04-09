USE master;
GO

CREATE DATABASE RentalApp_DB;
GO

USE RentalApp_DB;
GO

CREATE TABLE [Color] (
  [ColorID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ColorName] [varchar](50) NOT NULL
);
GO

CREATE TABLE [Model] (
  [ModelID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ModelName] [varchar](50) NOT NULL,
  [Year] [INT] NOT NULL
);
GO

CREATE TABLE [VehicleType] (
  [VehicleTypeID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Type] [varchar](50) NOT NULL
);
GO

CREATE TABLE [Brand] (
  [BrandID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [BrandName] [varchar](50) NOT NULL
);
GO

CREATE TABLE dbo.[Vehicle] (
  [VehicleID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [VIN] [VARCHAR](50) NOT NULL,
  [BrandID] [INT] NOT NULL,
  [ModelID] [INT] NOT NULL,
  [VehicleTypeID] [INT] NOT NULL,
  [ColorID] [INT] NOT NULL,
  [NumSeats] [INT] NOT NULL,
  [DayRate] DECIMAL(10, 2) NOT NULL,
  [HourlyRate] DECIMAL(10, 2) NOT NULL,
  [YearPurchased] [INT] NOT NULL,
  [LastService] [DATE] NOT NULL,
  [Transmission] [varchar](1) NOT NULL,
  [Mileage] DECIMAL(10, 2) NOT NULL,
  [DepositAmount] DECIMAL(10, 2) NOT NULL,
  [Available] [BIT] NOT NULL
  
  CONSTRAINT [FK_Vehicle.BrandID]
    FOREIGN KEY ([BrandID])
      REFERENCES [Brand]([BrandID]),
      
  CONSTRAINT [FK_Vehicle.ModelID]
    FOREIGN KEY ([ModelID])
      REFERENCES [Model]([ModelID]),
      
  CONSTRAINT [FK_Vehicle.VehicleTypeID]
    FOREIGN KEY ([VehicleTypeID])
      REFERENCES [VehicleType]([VehicleTypeID]),
      
  CONSTRAINT [FK_Vehicle.ColorID]
    FOREIGN KEY ([ColorID])
      REFERENCES [Color]([ColorID]),

  CONSTRAINT unqVIN 
    UNIQUE(VIN)
);
GO

CREATE TABLE [Status] (
  [StatusID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Status] [varchar](50) NOT NULL
);
GO

CREATE TABLE [Review] (
  [ReviewID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Date] [DATE] NOT NULL,
  [Message] [varchar](500) NOT NULL,
  [Rating] [INT] NOT NULL,

  CONSTRAINT RatingRange
	  CHECK (Rating BETWEEN 1 AND 5)
);
GO

CREATE TABLE [PaymentMethod] (
  [PaymentMethodID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [MethodName] [varchar](50) NOT NULL
);
GO

CREATE TABLE [Client] (
  [ClientID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Name] [varchar](100) NOT NULL,
  [Surname] [varchar](100) NOT NULL,
  [Email] [varchar](100) NOT NULL,
  [Phone] [varchar](20) NOT NULL,
  
  CONSTRAINT unqEmail 
        UNIQUE(Email)
);
GO

CREATE TABLE [Employee] (
  [EmployeeID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Name] [varchar](100) NOT NULL,
  [Surname] [varchar](100) NOT NULL,
  [Phone] [varchar](20) NOT NULL,
  [DateOfEmployment] [DATE] NOT NULL
);
GO

CREATE TABLE [Rental] (
  [RentalID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ClientID] [INT] NOT NULL,
  [EmployeeID] [INT] NOT NULL,
  [VehicleID] [INT] NOT NULL,
  [PaymentMethodID] [INT] NOT NULL,
  [StatusID] [INT] NOT NULL,
  [ReviewID] [INT] NOT NULL,
  [Address] [varchar](500) NOT NULL,
  [StartDate] [DATETIME] NOT NULL,
  [EndDate] [DATETIME] NOT NULL,
  [Balance] DECIMAL(10, 2) NOT NULL,
  
  CONSTRAINT [FK_Rental.ReviewID]
    FOREIGN KEY ([ReviewID])
      REFERENCES [Review]([ReviewID]),
      
  CONSTRAINT [FK_Rental.PaymentMethodID]
    FOREIGN KEY ([PaymentMethodID])
      REFERENCES [PaymentMethod]([PaymentMethodID]),
  
  CONSTRAINT [FK_Rental.StatusID]
    FOREIGN KEY ([StatusID])
      REFERENCES [Status]([StatusID]),
  
  CONSTRAINT [FK_Rental.ClientID]
    FOREIGN KEY ([ClientID])
      REFERENCES [Client]([ClientID]),
  
  CONSTRAINT [FK_Rental.EmployeeID]
    FOREIGN KEY ([EmployeeID])
      REFERENCES [Employee]([EmployeeID]),
  
  CONSTRAINT [FK_Rental.VehicleID]
    FOREIGN KEY ([VehicleID])
      REFERENCES [Vehicle]([VehicleID])
);
GO