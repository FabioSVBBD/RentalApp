USE master;
GO

CREATE DATABASE RentalApp_DB;
GO

USE RentalApp_DB;
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
  [YearPurchased] [YEAR] NULL,
  [LastService] [DATE] NULL,
  [Transmission] [varchar](50) NULL,
  [Millieage] [FLOAT] NULL,
  [DepositAmount] [FLOAT] NULL,
  
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
);
GO

CREATE TABLE [Color] (
  [ColorID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ColorName] [varchar](50) NULL,
  CONSTRAINT [FK_Color.ColorID]
    FOREIGN KEY ([ColorID])
      REFERENCES [Vehicle]([ColorID])
);
GO

CREATE TABLE [Model] (
  [ModelID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ModelName] [varchar](50) NULL,
  [Year] [YEAR] NULL,
  CONSTRAINT [FK_Model.ModelID]
    FOREIGN KEY ([ModelID])
      REFERENCES [Vehicle]([ModelID])
);
GO

CREATE TABLE [VehicleType] (
  [VehicleTypeID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Type] [varchar](50) NULL,
  CONSTRAINT [FK_VehicleType.VehicleTypeID]
    FOREIGN KEY ([VehicleTypeID])
      REFERENCES [Vehicle]([VehicleTypeID])
);
GO

CREATE TABLE [Brand] (
  [BrandID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [BrandName] [varchar](50) NULL,
  CONSTRAINT [FK_Brand.BrandID]
    FOREIGN KEY ([BrandID])
      REFERENCES [Vehicle]([BrandID])
);
GO

CREATE TABLE [Rental-Vehicle] (
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

CREATE TABLE [Rental] (
  [RentalID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [ReviewID] [INT] NULL,
  [PaymentMethodID] [INT] NULL,
  [StatusID] [INT] NOT NULL,
  [Address] [varchar](500) NOT NULL,
  [StartDate] [DATE] NOT NULL,
  [EndDate] [DATE] NULL,
  [Balance] [FLOAT] NOT NULL,
  CONSTRAINT [FK_Rental.RentalID]
    FOREIGN KEY ([RentalID])
      REFERENCES [Rental-Vehicle]([RentalID])
);
GO

CREATE TABLE [Rental-Client] (
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

CREATE TABLE [Client] (
  [ClientID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Name] [varchar](100) NOT NULL,
  [Surname] [varchar](100) NULL,
  [e-Mail] [varchar](100) NULL,
  [Phone] [numeric] NOT NULL,
  CONSTRAINT [FK_Client.ClientID]
    FOREIGN KEY ([ClientID])
      REFERENCES [Rental-Client]([ClientID])
);
GO

CREATE TABLE [Rental-Employee] (
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

CREATE TABLE [Client] (
  [EmployeeID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Name] [varchar](100) NOT NULL,
  [Surname] [varchar](100) NULL,
  [Phone] [numeric] NOT NULL,
  [DateOfEmployment] [DATE] NOT NULL,
  CONSTRAINT [FK_Client.EmployeeID]
    FOREIGN KEY ([EmployeeID])
      REFERENCES [Rental-Employee]([EmployeeID])
);

CREATE TABLE [Status] (
  [StatusId] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Status] [varchar](50) NULL
);

CREATE TABLE [Review] (
  [ReviewID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [Date] [DATE] NULL,
  [Message] [varchar](500) NULL,
  [Rating] [INT] NULL,
);

CREATE TABLE [PaymentMethod] (
  [PaymentMethodID] IDENTITY (1,1) NOT NULL PRIMARY KEY,
  [MethodName] [varchar](50) NULL
);
GO

