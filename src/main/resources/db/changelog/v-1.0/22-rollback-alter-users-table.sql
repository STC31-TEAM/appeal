alter table users drop column id_role;
DROP SEQUENCE users_id_seq;
alter table users add column id_map_role INTEGER UNIQUE NOT NULL;