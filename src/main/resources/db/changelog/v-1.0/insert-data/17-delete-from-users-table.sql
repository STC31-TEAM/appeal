delete from users where login in ('Administrator',
                                    'Moderator',
                                    'Redactor',
                                    'Deleted_User',
                                    'Reg_User',
                                    'Verified_User',
                                    'Test_User',
                                    'Deleted_Admin');