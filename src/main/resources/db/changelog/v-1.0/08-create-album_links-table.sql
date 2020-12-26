create table album_links (
                             id	     INTEGER PRIMARY KEY,
                             id_link INTEGER NOT NULL,
                             link	 VARCHAR(1000)
);

GRANT ALL ON TABLE public.album_links TO PUBLIC;

comment on COLUMN album_links.id is 'Уникальный код записи таблицы';
comment on COLUMN album_links.id_link is 'FK к ID_Link Табл Tickets';
comment on COLUMN album_links.link is 'Ссылки к внешнему хранилищу фото';