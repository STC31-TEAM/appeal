create table roles (
                       id	         SMALLSERIAL PRIMARY KEY,
                       id_map_roles  INTEGER UNIQUE NOT NULL,
                       role  	     VARCHAR(100) UNIQUE NOT NULL
);

GRANT ALL ON TABLE public.roles TO PUBLIC;

comment on COLUMN roles.id is 'Уникальный код записи таблицы';
comment on COLUMN roles.id_map_roles is 'Foregin key к таблице USERS';
comment on COLUMN roles.role is 'Наименование роли';