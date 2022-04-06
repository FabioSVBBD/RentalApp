USE master;
GO

CREATE DATABASE RentalApp_DB;
GO

USE RentalApp_DB;
GO

CREATE TABLE [Color] (
  [ColorID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ColorName] [varchar](50) NOT NULL,
  
  CONSTRAINT unqColor 
        UNIQUE(ColorName)
);
GO

CREATE TABLE [Model] (
  [ModelID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ModelName] [varchar](50) NOT NULL,
  [Year] [INT] NULL,
  
  CONSTRAINT unqModel
        UNIQUE(ModelName)
);
GO

CREATE TABLE [VehicleType] (
  [VehicleTypeID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Type] [varchar](50) NOT NULL,
  
  CONSTRAINT unqType 
        UNIQUE(Type)
);
GO

CREATE TABLE [Brand] (
  [BrandID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [BrandName] [varchar](50) NOT NULL,
  
  CONSTRAINT unqBrand 
        UNIQUE(BrandName)
);
GO

CREATE TABLE dbo.[Vehicle] (
  [VIN] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [BrandID] [INT] NOT NULL,
  [ModelID] [INT] NOT NULL,
  [VehicleTypeID] [INT] NOT NULL,
  [ColorID] [INT] NOT NULL,
  [NumPassengers] [INT] NULL,
  [DayRate] [FLOAT] NULL,
  [HourlyRate] [FLOAT] NULL,
  [YearPurchased] [INT] NOT NULL,
  [LastService] [DATE] NOT NULL,
  [Transmission] [varchar](1) NOT NULL,
  [Milleage] [FLOAT] NOT NULL,
  [DepositAmount] [FLOAT] NOT NULL,
  
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
      REFERENCES [Color]([ColorID])
);
GO

CREATE TABLE [Status] (
  [StatusID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Status] [varchar](50) NULL
);
GO

CREATE TABLE [Review] (
  [ReviewID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Date] [DATE] NULL,
  [Message] [varchar](500) NULL,
  [Rating] [INT] NULL,
);
GO

CREATE TABLE [PaymentMethod] (
  [PaymentMethodID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [MethodName] [varchar](50) NULL
);
GO

CREATE TABLE [Client] (
  [ClientID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Name] [varchar](100) NOT NULL,
  [Surname] [varchar](100) NULL,
  [Email] [varchar](100) NOT NULL,
  [Phone] [numeric] NOT NULL,
  
  CONSTRAINT unqEmail 
        UNIQUE(Email)
);
GO

CREATE TABLE [Employee] (
  [EmployeeID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Name] [varchar](100) NOT NULL,
  [Surname] [varchar](100) NULL,
  [Phone] [numeric] NOT NULL,
  [DateOfEmployment] [DATE] NOT NULL
);
GO

CREATE TABLE [Rental] (
  [RentalID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ReviewID] [INT] NULL,
  [PaymentMethodID] [INT] NOT NULL,
  [StatusID] [INT] NOT NULL,
  [Address] [varchar](500) NOT NULL,
  [StartDate] [DATETIME] NOT NULL,
  [EndDate] [DATETIME] NULL,
  [Balance] [FLOAT] NOT NULL,
  
  CONSTRAINT [FK_Rental.ReviewID]
    FOREIGN KEY ([ReviewID])
      REFERENCES [Review]([ReviewID]),
      
  CONSTRAINT [FK_Rental.PaymentMethodID]
    FOREIGN KEY ([PaymentMethodID])
      REFERENCES [PaymentMethod]([PaymentMethodID]),
  
  CONSTRAINT [FK_Rental.StatusID]
    FOREIGN KEY ([StatusID])
      REFERENCES [Status]([StatusID])
);
GO

CREATE TABLE [Rental-Vehicle] (
  [RentalVehicleID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [RentalID] [INT] NOT NULL,
  [VIN] [INT] NOT NULL,
  
  CONSTRAINT [FK_Rental-Vehicle.RentalID]
    FOREIGN KEY ([RentalID])
      REFERENCES [Rental]([RentalID]),
      
  CONSTRAINT [FK_Rental-Vehicle.VIN]
    FOREIGN KEY ([VIN])
      REFERENCES [Vehicle]([VIN])
);
GO

CREATE TABLE [Rental-Client] (
  [RentalClientID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [RentalID] [INT] NOT NULL,
  [ClientID] [INT] NOT NULL,
  
  CONSTRAINT [FK_Rental-Client.RentalID]
    FOREIGN KEY ([RentalID])
      REFERENCES [Rental]([RentalID]),
  
  CONSTRAINT [FK_Rental-Client.ClientID]
    FOREIGN KEY ([ClientID])
      REFERENCES [Client]([ClientID])
);
GO

CREATE TABLE [Rental-Employee] (
  [RentalEmployeeID] [INT] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [RentalID] [INT] NOT NULL,
  [EmployeeID] [INT] NOT NULL,
  
  CONSTRAINT [FK_Rental-Employee.RentalID]
    FOREIGN KEY ([RentalID])
      REFERENCES [Rental]([RentalID]),
      
  CONSTRAINT [FK_Rental-Employee.EmployeeID]
    FOREIGN KEY ([EmployeeID])
      REFERENCES [Employee]([EmployeeID])
);
GO
