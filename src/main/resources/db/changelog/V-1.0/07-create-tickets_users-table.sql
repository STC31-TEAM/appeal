create table tickets_users (
                               id	          BIGSERIAL PRIMARY KEY,
                               id_tickets	  BIGINT NOT NULL,
                               id_users	      BIGINT NOT NULL,
                               user_likes	  BOOLEAN,
                               user_dislikes  BOOLEAN
);

GRANT ALL ON TABLE public.tickets_users TO PUBLIC;

comment on COLUMN tickets_users.id is 'Уникальный код записи таблицы';
comment on COLUMN tickets_users.id_tickets is 'FK к ID Табл Tickets';
comment on COLUMN tickets_users.id_users is 'FK к ID Табл Users';
comment on COLUMN tickets_users.user_likes is 'Признак/Лайк пользователя к заявке/заказу';
comment on COLUMN tickets_users.user_dislikes is 'Признак/ДизЛайк пользователя к заявке/заказу';