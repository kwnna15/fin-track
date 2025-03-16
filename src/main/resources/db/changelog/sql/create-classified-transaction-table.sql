CREATE TABLE classified_transaction (
    id UUID PRIMARY KEY,
    transaction_classification VARCHAR(100) NOT NULL,
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL
);
