USE RentalApp_DB;
GO

CREATE PROCEDURE dbo.[InsertVehicle]
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

CREATE PROCEDURE dbo.[UpdateVehicle]
@VIN int,
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
	UPDATE [Vehicle]
	SET
		[BrandID] = @BrandID,
		[ModelID] = @ModelID,
		[VehicleTypeID] = @VehicleTypeID,
		[ColorID] = @ColorID,
		[NumSeats] = @NumSeats,
		[DayRate] = @DayRate,
		[HourlyRate] = @HourlyRate,
		[YearPurchased] = @YearPurchased,
		[LastService] = @LastService,
		[Transmission] = @Transmission,
		[Mileage] = @Mileage,
		[DepositAmount] = @DepositAmount,
		[Available] = @Available
	WHERE @VIN = [VIN]
GO

CREATE PROCEDURE dbo.[getVehicles]
AS
	SELECT 
		v.VIN, 
		v.NumSeats, 
		v.DayRate, 
		v.HourlyRate, 
		v.YearPurchased, 
		v.LastService, 
		v.Transmission, 
		v.Mileage, 
		v.DepositAmount, 
		v.Available, 
		b.BrandName,
		m.ModelName,
		m.Year,
		vt.Type
	FROM Vehicle v 
	INNER JOIN Color c ON c.ColorID = v.ColorID
	INNER JOIN Model m ON m.ModelID = v.ModelID
	INNER JOIN Brand b ON b.BrandID = v.BrandID
	INNER JOIN VehicleType vt ON vt.VehicleTypeID = v.VehicleTypeID
GO