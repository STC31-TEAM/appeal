create table streets
(
    id          BIGSERIAL PRIMARY KEY,
    id_city     INTEGER NOT NULL,
    street_name VARCHAR(100) NOT NULL
);

GRANT ALL ON TABLE public.streets TO PUBLIC;

comment on COLUMN streets.id is 'Уникальный код записи таблицы';
comment on COLUMN streets.id_city is 'Foreign key к таблице Cities (ID)';
comment on COLUMN streets.street_name is 'Наименование улицы';