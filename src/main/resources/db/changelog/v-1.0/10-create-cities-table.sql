create table cities (
                        id	        	SMALLSERIAL PRIMARY KEY,
--                       было id_area, поменял на id_country, вероятно опечатка была
                        id_country		INTEGER NOT NULL,
                        city_name VARCHAR(100) NOT NULL
);

GRANT ALL ON TABLE public.cities TO PUBLIC;

comment on COLUMN cities.id is 'Уникальный код записи таблицы';
comment on COLUMN cities.id_country is 'Foreign key к таблице Country (ID)';
comment on COLUMN cities.city_name is 'Наименование населённого пункта';