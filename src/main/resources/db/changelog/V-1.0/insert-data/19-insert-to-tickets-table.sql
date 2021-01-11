insert into tickets
values(DEFAULT,                                                 /* id */
            4,                                                  /* user */
                ,                                               /* company */
            1,                                                  /* country */
            1,                                                  /* city */
            3,                                                  /* street */
            1,                                                  /* service type */
            1,                                                  /* album link */
            'Автомастерская на Кузнецком мосту',                /* title */
            'Очень нехватает автомастерской рядом с домом',     /* description */
            '2021-01-04',                                       /* open date */
                ,                                               /* close date */
            3,                                                  /* count likes */
            1,                                                  /* count dislikes */
            0);                                                 /* status */

insert into tickets
values(DEFAULT,                                                 /* id */
            5,                                                  /* user */
            1,                                                  /* company */
            1,                                                  /* country */
            1,                                                  /* city */
            3,                                                  /* street */
            2,                                                  /* service type */
            2,                                                  /* album link */
            'Пекарня на Кузнецком Мосту',                       /* title */
            'Открываем пекарню со свежим хлебом',               /* description */
            '2021-01-08',                                       /* open date */
                ,                                               /* close date */
            5,                                                  /* count likes */
            2,                                                  /* count dislikes */
            1);                                                 /* status */

insert into tickets
values(DEFAULT,                                                 /* id */
            6,                                                  /* user */
            NULL,                                                  /* company */
            1,                                                  /* country */
            2,                                                  /* city */
            4,                                                  /* street */
            6,                                                  /* service type */
            3,                                                  /* album link */
            'Ремонт мелкой бытовой техники',                       /* title */
            'Приходится возить чайники и другую технику ' ||
             'в другом районе города',                          /* description */
            '2021-01-01',                                       /* open date */
            '2021-01-10',                                               /* close date */
            1,                                                  /* count likes */
            5,                                                  /* count dislikes */
            2);                                                 /* status */