create table tickets_users (
                               id	          BIGSERIAL PRIMARY KEY,
                               id_ticket	  BIGINT NOT NULL,
                               id_user	      BIGINT NOT NULL,
                               user_reaction  BOOLEAN
);

GRANT ALL ON TABLE public.tickets_users TO PUBLIC;

comment on COLUMN tickets_users.id is 'Уникальный код записи таблицы';
comment on COLUMN tickets_users.id_ticket is 'FK к ID Табл Tickets';
comment on COLUMN tickets_users.id_user is 'FK к ID Табл Users';
comment on COLUMN tickets_users.user_reaction is 'Признак лайка/дизлайка true - лайк, false - дизлайк';