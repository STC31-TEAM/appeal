create table users (
                           id 			 BIGINT primary key,
                           id_map_role   INTEGER UNIQUE NOT NULL,
                           id_country    SMALLINT NOT NULL,
                           id_city 	     INTEGER NOT NULL,
                           id_street 	 INTEGER NOT NULL,
                           id_company    INTEGER NOT NULL,
                           status   	 SMALLINT NOT NULL,
                           login 		 VARCHAR(100) UNIQUE NOT NULL,
                           password 	 VARCHAR(1000) NOT NULL,
                           name		     VARCHAR(100) NOT NULL,
                           surname		 VARCHAR(100) NOT NULL,
                           birthday 	 DATE NOT NULL,
                           phone		 BIGINT NOT NULL,
                           email		 VARCHAR(100) UNIQUE NOT NULL
);

GRANT ALL ON TABLE public.users TO PUBLIC;

comment on COLUMN users.id is 'Уникальный код записи таблицы';
comment on COLUMN users.id_map_role is 'Foreign key к таблице набора ролей пользователя MapRoles';
comment on COLUMN users.id_country is 'Foreign key к таблице Countries';
comment on COLUMN users.id_city is 'Foreign key к таблице Cities';
comment on COLUMN users.id_street is 'Foreign key к таблице Streets';
comment on COLUMN users.id_company is 'Foreign key к таблице Companies (если человек представитель компании)';
comment on COLUMN users.status is 'Статус пользователя 0/1/2 Зарегистрирован/Верифицирован/Удален и тд можно добавлять';
comment on COLUMN users.login is 'Логин (должен быть уникальным)';
comment on COLUMN users.password is 'Пароль пользователя (должен быть зашифрован)';
comment on COLUMN users.name is 'Имя';
comment on COLUMN users.surname is 'Фамилия';
comment on COLUMN users.birthday is 'Дата рождения';
comment on COLUMN users.phone is 'Телефон';
comment on COLUMN users.email is 'Email';
