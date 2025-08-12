drop database if exists assessment;
create database assessment;
use assessment;

create table member(
	custno int auto_increment not null,
    constraint primary key(custno),
    custname varchar(20) ,
    phone varchar(13) ,
    address varchar(60) ,
    joindate date ,
    grade char(1) ,
    city char(2)
);

create table money(
	custno int not null,
    constraint foreign key(custno) references member(custno),
    salenol int not null,
    constraint primary key(salenol),
    pcost int,
    amount int ,
    price int ,
    pcode varchar(4) ,
    sdate date
);

alter table member auto_increment = 100001;

select *from member;
select *from money;
select *from member join money;

select member.custno as 회원번호, member.custname as 회원성명 ,
case member.grade
when 'A' then 'VIP'
when 'B' then '일반'
when 'C' then '직원'
end as 고객등급 , sum((money.price-money.pcost)*(money.amount)) as 매출
from member join money on member.custno = money.custno
where member.grade In ('A' , 'B', 'C')
group by member.custno,member.custname,member.grade having sum((money.price-money.pcost)*(money.amount))>0 order by 매출 desc;


insert into member (custname,phone,address,joindate,grade,city) values
(  "김행복" , "010-1111-2222", "서울 동대문구 휘경1동", "2015-12-02", "A" , 01),
(  "이축복" , "010-1111-3333", "서울 동대문구 휘경2동", "2015-12-06", "B" , 01),
(  "장믿음" , "010-1111-4444", "울릉군 울릉읍 독도1리", "2015-10-01", "B" , 30),
(  "최사랑" , "010-1111-5555", "울릉군 울릉읍 독도2리", "2015-11-13", "A" , 30),
(  "진평화" , "010-1111-6666", "제주도 제주시 외나무골", "2015-12-25", "B" , 60),
(  "자공단" , "010-1111-7777", "제주도 제주시 감나무골", "2015-12-11", "C" , 60);

insert into money ( custno , salenol , pcost , amount , price , pcode , sdate ) values
( 100001 , 20160001 , 500 , 5 , 2500 , "A001" ,"2016-01-01"),
( 100001 , 20160002 , 1000 , 4 , 4000 , "A002" ,"2016-01-01"),
( 100001 , 20160003 , 500 , 3 , 1500 , "A008" ,"2016-01-01"),
( 100002 , 20160005 , 500 , 1 , 500 , "A001" ,"2016-01-03"),
( 100003 , 20160006 , 1500 , 2 , 3000 , "A003" ,"2016-01-03"),
( 100004 , 20160007 , 500 , 2 , 1000 , "A001" ,"2016-01-04"),
( 100004 , 20160008 , 300 , 1 , 300 , "A005" ,"2016-01-04"),
( 100004 , 20160009 , 600 , 1 , 600 , "A006" ,"2016-01-04"),
( 100004 , 20160010 , 3000 , 1 , 3000 , "A007" ,"2016-01-06");





