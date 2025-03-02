CREATE TABLE transaction (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    transaction_id VARCHAR(255) NOT NULL,
    description TEXT,
    amount VARCHAR(50) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    transaction_type VARCHAR(100) NOT NULL,
    transaction_category VARCHAR(100) NOT NULL,
    transaction_classification TEXT[],
    merchant_name VARCHAR(255),
    running_balance_amount VARCHAR(50),
    running_balance_currency VARCHAR(10),
    meta_bank_transaction_id VARCHAR(255),
    meta_provider_category VARCHAR(255),
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL
);
