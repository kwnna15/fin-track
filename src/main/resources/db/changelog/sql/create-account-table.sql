CREATE TABLE account (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id VARCHAR(255) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    display_name VARCHAR(255) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    provider_id VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL
);
