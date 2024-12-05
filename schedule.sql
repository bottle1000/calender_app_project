create table author
(
    id         bigint auto_increment comment '작성자 고유 식별자'
        primary key,
    name       varchar(30)                        not null comment '작성자명',
    email      varchar(100)                       not null comment '이메일',
    created_at datetime default CURRENT_TIMESTAMP null comment '등록일',
    updated_at datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '수정일',
    constraint email
        unique (email)
);

create table calender
(
    id         bigint auto_increment comment '일정 고유 식별자'
        primary key,
    todo_list  varchar(200)                       not null comment '할 일',
    author_id  bigint                             not null comment '작성자 ID',
    password   varchar(50)                        not null comment '비밀번호',
    created_at datetime default CURRENT_TIMESTAMP null comment '작성일',
    updated_at datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '수정일',
    constraint fk_calendar_author
        foreign key (author_id) references author (id)
            on delete cascade
);


