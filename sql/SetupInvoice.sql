USE dmai0919_1081509
CREATE TABLE Invoice
(
    InvoiceID SMALLINT IDENTITY(1, 1),
    Title TEXT NOT NULL,
    Description TEXT NULL,
    Date DATETIME NOT NULL,
    Solution TEXT NULL,

    CONSTRAINT PK_Invoice PRIMARY KEY (InvoiceID)
)