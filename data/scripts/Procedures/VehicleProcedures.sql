USE RentalApp_DB;
GO

CREATE PROCEDURE InsertVehicle
@BrandID int,
@ModelID int,
@VehicleTypeID int,
@ColorID int,
@NumSeats int,
@DayRate decimal,
@HourlyRate decimal,
@YearPurchased int,
@LastService date,
@Transmission varchar,
@Mileage decimal,
@DepositAmount decimal,
@Available bit 
AS
	INSERT INTO [Vehicle](
		[BrandID], 
		[ModelID], 
		[VehicleTypeID], 
		[ColorID], 
		[NumSeats], 
		[DayRate], 
		[HourlyRate], 
		[YearPurchased], 
		[LastService], 
		[Transmission], 
		[Mileage], 
		[DepositAmount],
		[Available]
	)
	VALUES (
		@BrandID,
		@ModelID,
		@VehicleTypeID,
		@ColorID,
		@NumSeats,
		@DayRate,
		@HourlyRate,
		@YearPurchased,
		@LastService,
		@Transmission,
		@Mileage,
		@DepositAmount,
		@Available
	)
GO
