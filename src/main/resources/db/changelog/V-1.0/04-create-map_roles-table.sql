create table map_roles (
                           id		   SERIAL	PRIMARY KEY,
                           id_users	   INTEGER	NOT NULL,
                           id_company  INTEGER	NOT NULL,
                           id_roles	   INTEGER	NOT NULL

);

GRANT ALL ON TABLE public.map_roles TO PUBLIC;

comment on COLUMN map_roles.id is 'Уникальный код записи таблицы';
comment on COLUMN map_roles.id_users is 'Foregin key к таблице USERS';
comment on COLUMN map_roles.id_company is 'Foregin key к таблице Companys';
comment on COLUMN map_roles.id_roles is 'Foregin key к таблице Roles';