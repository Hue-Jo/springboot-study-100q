DROP TABLE IF EXISTS NOTICE;

create table NOTICE(
    ID BIGINT auto_increment primary key,
    TITLE VARCHAR(255),
    CONTENTS VARCHAR(255),

    HITS INTEGER,
    LIKES INTEGER,

    REGISTER_DT TIMESTAMP,
    UPDATE_DT TIMESTAMP,

    DELETED  BOOLEAN,
    DELETED_DT TIMESTAMP

);