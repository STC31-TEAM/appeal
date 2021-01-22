CREATE SEQUENCE album_links_id_seq START WITH 10;
ALTER TABLE album_links ALTER COLUMN id SET NOT NULL;
ALTER TABLE album_links ALTER COLUMN id SET DEFAULT nextval('album_links_id_seq');
ALTER SEQUENCE album_links_id_seq OWNED BY album_links.id;