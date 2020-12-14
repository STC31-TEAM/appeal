create table country (
                         id	        		 SMALLSERIAL PRIMARY KEY,
                         country_name		 VARCHAR(100) NOT NULL,
                         country_description VARCHAR(250)

);

GRANT ALL ON TABLE public.country TO PUBLIC;

comment on COLUMN country.id is 'Уникальный код записи таблицы';
comment on COLUMN country.country_name is 'Наименование страны';
comment on COLUMN country.country_description is 'Дополнительное описание';