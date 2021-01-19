alter table users drop column id_role;
alter table users add column id_map_role  INTEGER UNIQUE NOT NULL;