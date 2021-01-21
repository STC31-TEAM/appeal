create table tickets (
                         id				  BIGSERIAL	PRIMARY KEY,
                         id_user 		  BIGINT NOT NULL,
                         id_company		  INTEGER,
                         id_country		  SMALLINT NOT NULL,
                         id_city	      INTEGER NOT NULL,
                         id_street	      INTEGER NOT NULL,
                         id_service_type  SMALLINT NOT NULL,
                         id_album_link	  INTEGER NOT NULL,
                         title			  VARCHAR(100) NOT NULL,
                         description	  VARCHAR(200) NOT NULL,
                         open_date		  DATE NOT NULL,
                         close_date		  DATE,
                         count_likes	  INTEGER,
                         count_dislikes	  INTEGER,
                         status		      SMALLINT NOT NULL
);

GRANT ALL ON TABLE public.tickets TO PUBLIC;

comment on COLUMN tickets.id is 'Уникальный код записи таблицы';
comment on COLUMN tickets.id_user is 'Пользователь, который создал заявку, FK к ID — табл USERS';
comment on COLUMN tickets.id_company is 'Пользователь, который создал заявку, FK к ID — табл USERS';
comment on COLUMN tickets.id_country is 'Foreign key к таблице Country';
comment on COLUMN tickets.id_city is 'Foreign key к таблице City';
comment on COLUMN tickets.id_street is 'Foreign key к таблице Street';
comment on COLUMN tickets.id_service_type is 'Foreign key к таблице ServiceTypes, определяет тип обращения';
comment on COLUMN tickets.id_album_link is 'Foreign key к таблице AlbumLinks, определяет тип обращения';
comment on COLUMN tickets.title is 'Заголовок название обращения';
comment on COLUMN tickets.description is 'Заголовок название обращения';
comment on COLUMN tickets.open_date is 'Дата открытия';
comment on COLUMN tickets.close_date is 'Дата закрытия';
comment on COLUMN tickets.count_likes is 'Количество поставленных лайков ';
comment on COLUMN tickets.count_dislikes is 'Количество поставленных дизлайков';
comment on COLUMN tickets.status is 'Статус заявки: на пример 0-открыта 1—верифицирована 2-закрыта';