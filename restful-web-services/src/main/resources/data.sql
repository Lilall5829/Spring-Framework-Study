--  Column name should be consistent with H2 database
insert into user_details(id, birth_Date, name)
values(10001, current_date(), 'lila1');

insert into user_details(id, birth_Date, name)
values(10002, current_date(), 'lila2');

insert into user_details(id, birth_Date, name)
values(10003, current_date(), 'lila3');

insert into post(id, description, user_id)
values (20001, 'I want to learn AWS', 10001);

insert into post(id, description, user_id)
values (20002, 'I want to learn DEV', 10001);

insert into post(id, description, user_id)
values (20003, 'I want to learn WEV', 10001);