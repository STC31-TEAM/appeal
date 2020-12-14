create table companys (
                          id			   SERIAL PRIMARY KEY,
                          id_map_roles	   INTEGER NOT NULL,
                          id_country	   SMALLINT NOT NULL,
                          id_city		   INTEGER NOT NULL,
                          id_street		   INTEGER NOT NULL,
                          id_user		   BIGINT NOT NULL,
                          id_type_services SMALLINT NOT NULL,
                          status		   SMALLINT NOT NULL,
                          title			   VARCHAR(200) NOT NULL,
                          login			   VARCHAR(100) NOT NULL,
                          password		   VARCHAR(1000) NOT NULL,
                          phone			   BIGINT NOT NULL,
                          email			   VARCHAR(100) UNIQUE NOT NULL

);

GRANT ALL ON TABLE public.companys TO PUBLIC;

comment on COLUMN companys.id is 'Уникальный код записи таблицы';
comment on COLUMN companys.id_map_roles is 'Foregin key к таблице набора ролей пользователя MapUsersRoles';
comment on COLUMN companys.id_country is 'Foregin key к таблице Country';
comment on COLUMN companys.id_city is 'Foregin key к таблице City';
comment on COLUMN companys.id_street is 'Foregin key к таблице Street';
comment on COLUMN companys.id_user is 'FK к ID табл REG_USERS — представитель компании';
comment on COLUMN companys.id_type_services is 'FK к ID Табл TypeServices — тип предоставляемой услуги.';
comment on COLUMN companys.status is 'Статус компании 0/1/2/3 и тд  Незарегистрирован/Зарегистрирован/Верифицирован/ удален и т.д.';
comment on COLUMN companys.title is 'Описание компании';
comment on COLUMN companys.login is 'Логин (должен быть уникальным)';
comment on COLUMN companys.password is 'Пароль пользователя (должен быть зашифрован)';
comment on COLUMN companys.phone is 'Телефон';
comment on COLUMN companys.email is 'Email';