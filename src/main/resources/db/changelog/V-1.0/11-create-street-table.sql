create table street (
                        id	        		SERIAL PRIMARY KEY,
                        id_city	            INTEGER	NOT NULL,
                        street_name		    VARCHAR(100) NOT NULL,
                        post_code	 	    INTEGER,
                        street_description	VARCHAR(250)

);

GRANT ALL ON TABLE public.street TO PUBLIC;

comment on COLUMN street.id is 'Уникальный код записи таблицы';
comment on COLUMN street.id_city is 'Foregin key к таблице City (ID)';
comment on COLUMN street.street_name is 'Наименование улицы';
comment on COLUMN street.post_code is 'Почтовый индекс адреса';
comment on COLUMN street.street_description is 'Дополнительное описание';