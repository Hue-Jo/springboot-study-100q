DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS NOTICE;

create table USER
(
    ID        BIGINT auto_increment primary key,
    EMAIL     VARCHAR(255),
    USER_NAME VARCHAR(255),
    PASSWORD  VARCHAR(255),
    PHONE     VARCHAR(255),
    REG_DT    TIMESTAMP,
    UPDATE_DT TIMESTAMP,
    STATUS    INTEGER,
    LOCK_YN   BOOLEAN
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
    constraint FK_NOTICE_USER_ID foreign key (USER_ID) references USER (ID)
);

create table NOTICE_LIKE
(
    ID        BIGINT auto_increment primary key,
    NOTICE_ID VARCHAR(255),
    USER_ID   VARCHAR(255)
);

create table USER_LOGIN_HISTORY
(
    ID         BIGINT auto_increment primary key,
    USER_ID    BIGINT,
    EMAIL      VARCHAR(255),
    USER_NAME  VARCHAR(255),
    LOGIN_DATE TIMESTAMP,
    IP_ADDR    VARCHAR(255)
);