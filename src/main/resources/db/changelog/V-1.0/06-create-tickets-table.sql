create table tickets (
                         id				  BIGSERIAL	PRIMARY KEY,
                         id_users 		  BIGINT NOT NULL,
                         id_company		  INTEGER NOT NULL,
                         id_country		  SMALLINT NOT NULL,
                         id_city	      INTEGER NOT NULL,
                         id_street	      INTEGER NOT NULL,
                         id_typesServices SMALLINT NOT NULL,
                         id_link		  INTEGER NOT NULL,
                         titles			  VARCHAR(100) NOT NULL,
                         description	  VARCHAR(200) NOT NULL,
                         open_date		  DATE NOT NULL,
                         close_date		  DATE NOT NULL,
                         count_likes	  INTEGER,
                         count_dislikes	  INTEGER,
                         status		      SMALLINT NOT NULL
);

GRANT ALL ON TABLE public.tickets TO PUBLIC;

comment on COLUMN tickets.id is 'Уникальный код записи таблицы';
comment on COLUMN tickets.id_users is 'Пользователь, который создал заявку, FK к ID — табл REG_USERS';
comment on COLUMN tickets.id_company is 'Пользователь, который создал заявку, FK к ID — табл REG_USERS';
comment on COLUMN tickets.id_country is 'Foregin key к таблице Country';
comment on COLUMN tickets.id_city is 'Foregin key к таблице Country';
comment on COLUMN tickets.id_street is 'Foregin key к таблице Street';
comment on COLUMN tickets.id_typesServices is 'Foregin key к таблице TypesServices, определяет тип обращения';
comment on COLUMN tickets.id_link is 'Foregin key к таблице AlbomLinks, определяет тип обращения';
comment on COLUMN tickets.titles is 'Заголовок название обращения';
comment on COLUMN tickets.description is 'Заголовок название обращения';
comment on COLUMN tickets.open_date is 'Дата открытия';
comment on COLUMN tickets.close_date is 'Дата закрытия';
comment on COLUMN tickets.count_likes is 'Количество поставленных лайков ';
comment on COLUMN tickets.count_dislikes is 'Количество поставленных дизлайков';
comment on COLUMN tickets.status is 'Статус заявки: на пример 0-открыта 1—верифицирована 2-закрыта и т.д.';