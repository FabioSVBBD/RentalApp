USE RentalApp_DB;
GO

CREATE PROCEDURE dbo.[InsertRental]
  @ClientID INT,
  @EmployeeID INT,
  @VehicleID INT,
  @PaymentMethodID INT,
  @StatusID INT,
  @ReviewID INT,
  @Address varchar (500),
  @StartDate DATETIME,
  @EndDate DATETIME,
  @Balance DECIMAL(10, 2)
AS
    INSERT INTO [Rental] ([ClientID], [EmployeeID], [VehicleID], [PaymentMethodID], [StatusID], [ReviewID], [Address], [StartDate], [EndDate],  [Balance])
    VALUES (@ClientID, @EmployeeID, @VehicleID, @PaymentMethodID, @StatusID, @ReviewID, @Address, @StartDate, @EndDate, @Balance)
GO


CREATE PROCEDURE dbo.[UpdateRental]
  @RentalID INT,
  @ClientID INT,
  @EmployeeID INT,
  @VehicleID INT,
  @PaymentMethodID INT,
  @StatusID INT,
  @ReviewID INT,
  @Address varchar (500),
  @StartDate DATETIME,
  @EndDate DATETIME,
  @Balance DECIMAL(10, 2)
AS
    UPDATE [Rental]
    SET [ClientID] = @ClientID,
        [EmployeeID] = @EmployeeID, 
        [VehicleID] = @VehicleID, 
        [PaymentMethodID] = @PaymentMethodID, 
        [StatusID] = @StatusID, 
        [ReviewID] = @ReviewID, 
        [Address] = @Address, 
        [StartDate] = @StartDate, 
        [EndDate] = @EndDate,  
        [Balance] = @Balance
    WHERE @RentalID = [RentalID]
GO

CREATE VIEW dbo.[AllRentals] AS
SELECT 
    r.Address,
    r.StartDate,
    r.EndDate,
    r.Balance,
    cl.Name AS ClientName,
    cl.Surname AS ClientSurname,
    cl.Email AS ClientEmail,
    cl.Phone AS ClientPhone,
    em.Name AS EmployeeName,
    em.Surname AS EmployeeSurname,
    em.Phone AS EmployeePhone,
    em.DateOfEmployment AS EmployeeDateOfEmployment,
    ve.*,
    pm.MethodName,
    st.Status,
    rv.Date AS ReviewDate,
    rv.Message ,
    rv.Rating 
FROM [Rental] r 
    INNER JOIN [Client] cl ON cl.ClientID = r.ClientID 
    INNER JOIN [Employee] em ON em.EmployeeID = r.EmployeeID
    INNER JOIN [AllVehicles] ve ON ve.VehicleID = r.VehicleID
    INNER JOIN [PaymentMethod] pm ON pm.PaymentMethodID = r.PaymentMethodID
    INNER JOIN [Status] st ON st.StatusID = r.StatusID
    INNER JOIN [Review] rv ON rv.ReviewID = rv.ReviewID
GO