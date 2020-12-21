create table countries (
                           id	        		 SMALLSERIAL PRIMARY KEY,
                           country_name VARCHAR(100) NOT NULL
);

GRANT ALL ON TABLE public.countries TO PUBLIC;

comment on COLUMN countries.id is 'Уникальный код записи таблицы';
comment on COLUMN countries.country_name is 'Наименование страны';