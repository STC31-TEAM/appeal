create table roles (
                       id	    SMALLSERIAL PRIMARY KEY,
                       role  	VARCHAR(100) UNIQUE NOT NULL
);

GRANT ALL ON TABLE public.roles TO PUBLIC;

comment on COLUMN roles.id is 'Уникальный код записи таблицы';
comment on COLUMN roles.role is 'Наименование роли';