ALTER TABLE companies ALTER COLUMN id SET NOT NULL;
ALTER TABLE companies ALTER COLUMN id SET DEFAULT nextval('companies_id_seq');
ALTER SEQUENCE companies_id_seq OWNED BY companies.id;
