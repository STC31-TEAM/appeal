alter table users drop column id_map_role;
alter table users add column id_role SMALLSERIAL;
