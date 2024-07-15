DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS NOTICE;

create table USER
(
    ID          BIGINT auto_increment primary key,
    EMAIL       VARCHAR(255),
    USER_NAME   VARCHAR(255),
    PASSWORD    VARCHAR(255),
    PHONE       VARCHAR(255),
    REG_DT    TIMESTAMP,
    UPDATE_DT TIMESTAMP
);

create table NOTICE
(
    ID          BIGINT auto_increment primary key,
    TITLE       VARCHAR(255),
    CONTENTS    VARCHAR(255),

    HITS        INTEGER,
    LIKES       INTEGER,

    REGISTER_DT TIMESTAMP,
    UPDATE_DT   TIMESTAMP,

    DELETED     BOOLEAN,
    DELETED_DT  TIMESTAMP,

    USER_ID     BIGINT,
    constraint FK_NOTICE_USER_ID foreign key (USER_ID) references USER(ID)
);