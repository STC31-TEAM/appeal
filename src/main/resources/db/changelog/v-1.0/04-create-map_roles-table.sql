create table map_roles (
                           id		   SERIAL	PRIMARY KEY,
                           id_user	   INTEGER	NOT NULL,
                           id_company  INTEGER	NOT NULL,
                           id_role	   INTEGER	NOT NULL

);

GRANT ALL ON TABLE public.map_roles TO PUBLIC;

comment on COLUMN map_roles.id is 'Уникальный код записи таблицы';
comment on COLUMN map_roles.id_user is 'Foreign key к таблице Users';
comment on COLUMN map_roles.id_company is 'Foreign key к таблице Companies';
comment on COLUMN map_roles.id_role is 'Foreign key к таблице Roles';