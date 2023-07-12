-- member
create table member2 (
                         mno     int             auto_increment,
                         userid  varchar(18)     unique,
                         passwd  varchar(18)     not null,
                         name    varchar(10)     not null,
                         email   varchar(50)     unique,
                         zipcode char(7)         not null,
                         addr1   varchar(100)    not null,
                         addr2   varchar(100)    not null,
                         phone   char(13)        not null,
                         regdate datetime        default current_timestamp,
                         primary key (mno)
);

insert into member2
(userid, passwd, name, email, zipcode, addr1, addr2, phone)
values ('abc123','987xyz','zzyzzy','zzyzzy@abc123.co.kr',
        '123-456','서울 관악구','블라블라','123-4567-8912');

select * from member2;

-- board
create table board2 (
                        bno         int             auto_increment,
                        title       varchar(100)    not null,
                        userid      varchar(18)     not null,
                        regdate     datetime        default current_timestamp,
                        thumbs      int             default 0,
                        views       int             default 0,
                        contnets    text            not null,
                        ipaddr      varchar(15)     not null,
                        primary key (bno)
    /*foreign key (userid) references member2(userid)*/

);