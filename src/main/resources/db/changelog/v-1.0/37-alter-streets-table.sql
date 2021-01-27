CREATE SEQUENCE streets_id_seq START WITH 10;
ALTER TABLE streets ALTER COLUMN id TYPE BIGSERIAL;
ALTER TABLE streets ALTER COLUMN id SET DEFAULT nextval('streets_id_seq');
ALTER SEQUENCE streets_id_seq OWNED BY streets.id;
