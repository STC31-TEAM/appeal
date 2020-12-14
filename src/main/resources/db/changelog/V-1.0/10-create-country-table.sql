create table сity (
                      id	        	SMALLSERIAL PRIMARY KEY,
                      id_area			INTEGER NOT NULL,
                      city_name			VARCHAR(100) NOT NULL,
                      city_description	VARCHAR(250)
);

GRANT ALL ON TABLE public.сity TO PUBLIC;

comment on COLUMN сity.id is 'Уникальный код записи таблицы';
comment on COLUMN сity.id_area is 'Foregin key к таблице Area (ID)';
comment on COLUMN сity.city_name is 'Наименование населённого пункта';
comment on COLUMN сity.city_description is 'Дополнительное описание';