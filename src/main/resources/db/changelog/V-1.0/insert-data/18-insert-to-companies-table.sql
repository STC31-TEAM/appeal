alter table companies drop column id_map_role;

insert into companies
values(1,                             /* id */
            1,                              /* country */
            1,                              /* city */
            3,                              /* street */
            5,                              /* user */
            2,                              /* service type */
            1,                              /* status */
            'Пекарня на Кузнецком Мосту',   /* title */
            'KuznecBucker',                 /* login */
            'KuznecBucker',                 /* password */
            84126942836,                    /* phone */
            'Kuznec_Bucker@mail.ru');       /* email */

values(2,                             /* id */
            2,                              /* country */
            4,                              /* city */
            10,                             /* street */
            6,                              /* user */
            6,                              /* service type */
            0,                              /* status */
            'Ремонт на Владимирской',       /* title */
            'VladRepair',                   /* login */
            'VladRepair',                   /* password */
            84126857395,                    /* phone */
            'VladRepair@gmail.com');        /* email */

values(3,                             /* id */
            2,                              /* country */
            4,                              /* city */
            7,                              /* street */
            16,                             /* user */
            4,                              /* service type */
            2,                              /* status */
            'Магазин на Проспекте Туран',   /* title */
            'TyranShop',                    /* login */
            'TyranShop',                    /* password */
            84124724192,                    /* phone */
            'TyranShop@gmail.com');         /* email */