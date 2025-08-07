drop database if exists practice3;
create database practice3;
use practice3;

create table waiting(
	wno int auto_increment,
    wphone longtext not null,
    wcount int not null,
    constraint primary key(wno)
    );
    
INSERT INTO waiting (wphone, wcount) VALUES ('010-9364-4432', 3);
INSERT INTO waiting (wphone, wcount) VALUES ('010-8364-4432', 4);
INSERT INTO waiting (wphone, wcount) VALUES ('010-6664-4432', 5);
INSERT INTO waiting (wphone, wcount) VALUES ('010-3364-4432', 6);
INSERT INTO waiting (wphone, wcount) VALUES ('010-2364-4432', 7);
INSERT INTO waiting (wphone, wcount) VALUES ('010-1664-4432', 8);
INSERT INTO waiting (wphone, wcount) VALUES ('010-7664-4232', 8);
INSERT INTO waiting (wphone, wcount) VALUES ('010-9687-4432', 8);
INSERT INTO waiting (wphone, wcount) VALUES ('010-7564-4432', 9);
INSERT INTO waiting (wphone, wcount) VALUES ('010-1664-4232', 1);

select * from waiting;
