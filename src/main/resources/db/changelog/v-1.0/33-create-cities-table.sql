create table cities (
                        id	        BIGSERIAL PRIMARY KEY,
                        id_country	INTEGER NOT NULL,
                        city_name   VARCHAR(100) NOT NULL
);

GRANT ALL ON TABLE public.cities TO PUBLIC;

comment on COLUMN cities.id is 'Уникальный код записи таблицы';
comment on COLUMN cities.id_country is 'Foreign key к таблице Country (ID)';
comment on COLUMN cities.city_name is 'Наименование населённого пункта';