
insert into USER (ID, EMAIL, USER_NAME, PASSWORD, PHONE,  REG_DT, UPDATE_DT) VALUES (1, 'test1@mail.com', '홍길동', '11111111', '010-1111-1111', '2024-01-01 00:01:01.000001', null);
insert into USER (ID, EMAIL, USER_NAME, PASSWORD, PHONE,  REG_DT, UPDATE_DT) VALUES (2, 'test2@mail.com', '홍판서', '22222222', '010-2222-2222', '2024-01-01 00:01:11.000001', null);
insert into USER (ID, EMAIL, USER_NAME, PASSWORD, PHONE,  REG_DT, UPDATE_DT) VALUES (3, 'test3@mail.com', '홍대감', '33333333', '010-3333-3333', '2024-01-01 00:11:01.000001', null);



insert into NOTICE (ID, CONTENTS, HITS, LIKES, REGISTER_DT, TITLE, DELETED, USER_ID) VALUES (1, '내용1', 0, 0, '2024-01-01 01:01:01.000000', '제목1', 0, 1);
insert into NOTICE (ID, CONTENTS, HITS, LIKES, REGISTER_DT, TITLE, DELETED, USER_ID) VALUES (2, '내용2', 0, 0, '2024-01-01 01:01:02.000000', '제목2', 0, 1);
insert into NOTICE (ID, CONTENTS, HITS, LIKES, REGISTER_DT, TITLE, DELETED, USER_ID) VALUES (3, '내용3', 0, 0, '2024-01-01 01:05:03.000000', '제목3', 0, 1);
