 CREATE OR ALTER FUNCTION FN_GET_CUSTOMER_INFO
(
    @id INT,
    @name NVARCHAR(100),
	@email NVARCHAR(100),
	@phone NVARCHAR(50)

)
RETURNS @CustomerInfo TABLE
(
    CustomerID INT,
    CustomerName NVARCHAR(100),
    Email NVARCHAR(100),
    Phone NVARCHAR(50)
)
AS
BEGIN
    INSERT INTO @CustomerInfo
    SELECT id, name, email, phone_number
    FROM customer

	INSERT INTO @CustomerInfo
    VALUES(@id, @name, @email, @phone)

    RETURN
END