create table roles (
                       id	    SMALLSERIAL PRIMARY KEY,
--                        было id_map_roles, стало id_user
                       id_user  INTEGER UNIQUE NOT NULL,
                       role  	VARCHAR(100) UNIQUE NOT NULL
);

GRANT ALL ON TABLE public.roles TO PUBLIC;

comment on COLUMN roles.id is 'Уникальный код записи таблицы';
comment on COLUMN roles.id_user is 'Foreign key к таблице USERS'; -- было id_map_roles, стало id_user
comment on COLUMN roles.role is 'Наименование роли';