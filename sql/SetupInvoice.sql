USE dmai0919_1081509
CREATE TABLE Invoice
(
    InvoiceID SMALLINT IDENTITY(1, 1),
    Title VARCHAR(60) NOT NULL,
    Description VARCHAR(200) NOT NULL,
    Date DATETIME,
    Solution VARCHAR(200) NULL,

    CONSTRAINT PK_Invoice PRIMARY KEY (InvoiceID)
);

CREATE TABLE TablesVersionNo
(
    TableName varchar(60) PRIMARY KEY,
    VersionNo INT DEFAULT 0
)