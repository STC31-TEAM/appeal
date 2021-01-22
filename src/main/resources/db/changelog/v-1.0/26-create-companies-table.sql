create table companies (
                          id			   SERIAL PRIMARY KEY,
                          id_country	   SMALLINT NOT NULL,
                          id_city		   INTEGER NOT NULL,
                          id_street		   INTEGER NOT NULL,
                          id_user		   BIGINT NOT NULL,
                          id_service_type  SMALLINT NOT NULL,
                          status		   SMALLINT NOT NULL,
                          title			   VARCHAR(200) NOT NULL,
                          login			   VARCHAR(100) NOT NULL,
                          password		   VARCHAR(1000) NOT NULL,
                          phone			   BIGINT NOT NULL,
                          email			   VARCHAR(100) UNIQUE NOT NULL
);

GRANT ALL ON TABLE public.companies TO PUBLIC;

comment on COLUMN companies.id is 'Уникальный код записи таблицы';
comment on COLUMN companies.id_country is 'Foreign key к таблице Countries';
comment on COLUMN companies.id_city is 'Foreign key к таблице Cities';
comment on COLUMN companies.id_street is 'Foreign key к таблице Streets';
comment on COLUMN companies.id_user is 'FK к ID табл USERS — представитель компании (1 человек)';
comment on COLUMN companies.id_service_type is 'FK к ID Табл ServiceTypes — тип предоставляемой услуги.';
comment on COLUMN companies.status is 'Статус компании 0/1/2 и тд Зарегистрирован/Верифицирован/Удален и т.д.';
comment on COLUMN companies.title is 'Описание компании';
comment on COLUMN companies.login is 'Логин (должен быть уникальным)';
comment on COLUMN companies.password is 'Пароль пользователя (должен быть зашифрован)';
comment on COLUMN companies.phone is 'Телефон';
comment on COLUMN companies.email is 'Email';