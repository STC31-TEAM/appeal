delete from ticket_users where (id_ticket = 1 and id_user = 2) or
                                (id_ticket = 1 and id_user = 4) or
                                (id_ticket = 1 and id_user = 5) or
                                (id_ticket = 1 and id_user = 1) or
                                (id_ticket = 2 and id_user = 1) or
                                (id_ticket = 2 and id_user = 5) or
                                (id_ticket = 2 and id_user = 6) or
                                (id_ticket = 2 and id_user = 8) or
                                (id_ticket = 3 and id_user = 7) or
                                (id_ticket = 3 and id_user = 6) or
                                (id_ticket = 3 and id_user = 3) or
                                (id_ticket = 3 and id_user = 6) or
                                (id_ticket = 3 and id_user = 2);