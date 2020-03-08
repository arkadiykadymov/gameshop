insert into user (id, username, password)
    values (1, 'root', 'root');

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');