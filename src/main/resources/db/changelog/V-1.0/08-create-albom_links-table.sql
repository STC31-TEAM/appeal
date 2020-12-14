create table albom_links (
                             id	     INTEGER PRIMARY KEY,
                             id_link INTEGER NOT NULL,
                             link	 VARCHAR(1000)
);

GRANT ALL ON TABLE public.type_services TO PUBLIC;

comment on COLUMN albom_links.id is 'Уникальный код записи таблицы';
comment on COLUMN albom_links.id_link is 'FK к ID_Link Табл Tickets';
comment on COLUMN albom_links.link is 'Ссылки к внешнему хранилищу фото';