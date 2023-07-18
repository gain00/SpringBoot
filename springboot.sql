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


-- bps

create table pds (
                     pno         int             auto_increment,
                     title       varchar(100)    not null,
                     userid      varchar(18)     not null,
                     regdate     datetime        default current_timestamp,
                     thumbs      int             default 0,
                     views       int             default 0,
                     contnets    text            not null,
                     ipaddr      varchar(15)     not null,
                     primary key (pno)
);

create table pdsattach(
    pano        int             auto_increment,
    pno         int             not null, -- 게시글번호
    fname       varchar(100)    not null, -- uuid포함
    ftype       varchar(3)      not null,
    fsize       varchar(3)      not null,
    fdown       int             default 0,
    primary key (pano)


);

alter table pds
    add constraint fkpuid
        foreign key (userid) references member2(userid);
alter table pdsattach
    add constraint fkpno
        foreign key (pno) references pds(pno);

DROP TABLE pds;


-- catesian product
select * from pds p, pdsattach pa;

select * from pds p join pdsattach pa where p.pno = pa.pno;

select * from pds p join pdsattach pa on p.pno = pa.pno where p.pno = '4';

select * from pds p join pdsattach pa using(pno) where p.pno = '4';

-- view
create view ppa
as select * from pds p join pdsattach pa using(pno);

select * from ppa where pno ='4';

-- comments
create table pdscomments (
    cno         int         auto_increment,
    comments    mediumtext  not null,
    userid      varchar(18) not null ,
    regdate     datetime    default current_timestamp,
    pno         int         not null ,
    ref         int         not null ,
    primary key(cno)


);
alter table pdscomments
add constraint fkrefcno
foreign key (ref)   references  pdscomments(cno);

alter table pdscomments
    add constraint fkpnopno
        foreign key (pno)   references  pds(pno);

insert into pdscomments (userid, comments, ref, pno)
values ('abc123','댓글1','1','8');

insert into pdscomments (userid, comments, ref, pno)
values ('abc123','댓글2','2','8');
insert into pdscomments (userid, comments, ref, pno)
values ('abc123','댓글2','3','8');
insert into pdscomments (userid, comments, ref, pno)
values ('abc123','대댓글11','2','8');
insert into pdscomments (userid, comments, ref, pno)
values ('abc123','대댓글2','1','8');

select * from pdscomments;
select * from pdscomments where pno = 8 order by ref;

