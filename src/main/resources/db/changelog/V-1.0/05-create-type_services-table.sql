create table type_services (
                               id	         SMALLSERIAL PRIMARY KEY,
                               type_services VARCHAR(100) NOT NULL,
                               description   VARCHAR(250)
);

GRANT ALL ON TABLE public.type_services TO PUBLIC;

comment on COLUMN type_services.id is 'Уникальный код записи таблицы';
comment on COLUMN type_services.type_services is 'Тип обращения';
comment on COLUMN type_services.description is 'Описание';