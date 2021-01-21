create table service_types (
                               id	         SMALLSERIAL PRIMARY KEY,
                               service_type  VARCHAR(100) NOT NULL,
                               description   VARCHAR(250)
);

GRANT ALL ON TABLE public.service_types TO PUBLIC;

comment on COLUMN service_types.id is 'Уникальный код записи таблицы';
comment on COLUMN service_types.service_type is 'Тип обращения';
comment on COLUMN service_types.description is 'Описание';