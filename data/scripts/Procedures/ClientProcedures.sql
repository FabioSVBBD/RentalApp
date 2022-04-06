USE RentalApp_DB;
GO


-- Exec dbo.[InsertClient] @Name = '' , @Surname  = '', @Email  = '@mail', @Phone = 000

CREATE PROCEDURE dbo.[InsertClient] @Name varchar(100) , @Surname varchar(100), @Email varchar(100), @Phone numeric
AS
BEGIN
    INSERT INTO [Client] ([Name], [Surname], [Email], [Phone])
    VALUES (@Name, @Surname, @Email, @Phone)
END
GO

-- Exec dbo.[UpdateClient] @ID=1, @Name = '' , @Surname  = '', @Email  = '', @Phone = 000
CREATE PROCEDURE dbo.[UpdateClient] @ID INT, @Name varchar(100) , @Surname varchar(100), @Email varchar(100), @Phone numeric
AS
    UPDATE [Client]
    SET [Name] = @Name, 
        [Surname] = @Surname, 
        [Email] = @Email, 
        [Phone] = @Phone
    WHERE [ClientID]= @ID
GO

