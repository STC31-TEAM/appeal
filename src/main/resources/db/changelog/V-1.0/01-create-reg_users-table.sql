create table reg_users (
                           id 			  BIGINT primary key,
                           id_map_roles  INTEGER UNIQUE NOT NULL,
                           id_country    SMALLINT NOT NULL,
                           id_city 	  INTEGER NOT NULL,
                           id_street 	  INTEGER NOT NULL,
                           id_company 	  INTEGER NOT NULL,
                           status 		  SMALLINT NOT NULL,
                           login 		  VARCHAR(100) UNIQUE NOT NULL,
                           password 	  VARCHAR(1000) NOT NULL,
                           name		  VARCHAR(100) NOT NULL,
                           surname		  VARCHAR(100) NOT NULL,
                           birthday 	  DATE NOT NULL,
                           phone		  BIGINT NOT NULL,
                           email		  VARCHAR(100) UNIQUE NOT NULL
);

GRANT ALL ON TABLE public.reg_users TO PUBLIC;

comment on COLUMN reg_users.id is 'Уникальный код записи таблицы';
comment on COLUMN reg_users.id_map_roles is 'Foregin key к таблице набора ролей пользователя MapUsersRoles';
comment on COLUMN reg_users.id_country is 'Foregin key к таблице Country';
comment on COLUMN reg_users.id_city is 'Foregin key к таблице City';
comment on COLUMN reg_users.id_street is 'Foregin key к таблице Street';
comment on COLUMN reg_users.id_company is 'Foregin key к таблице Companys (если человек представитель компании)';
comment on COLUMN reg_users.status is 'Статус пользователя 0/1/2 Незарегистрирован/Зарегистрирован/Верифицирован/ удален  и тд можно добавлять';
comment on COLUMN reg_users.login is 'Логин (должен быть уникальным)';
comment on COLUMN reg_users.password is 'Пароль пользователя (должен быть зашифрован)';
comment on COLUMN reg_users.name is 'Имя';
comment on COLUMN reg_users.surname is 'Фамилия';
comment on COLUMN reg_users.birthday is 'Дата рождения';
comment on COLUMN reg_users.phone is 'Телефон';
comment on COLUMN reg_users.email is 'Email';
