drop database if exists exam10 ;
create database exam10;
use exam10;

create table board(
	bno int auto_increment,
    bcontent longtext not null,
    bwriter varchar(30) not null,
    constraint primary key ( bno )
);

# 샘플
insert into board( bcontent, bwriter ) values( '안녕하세요' , '유재석' );
INSERT INTO board (bcontent, bwriter) VALUES ('반갑습니다', '강호동');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘 날씨 정말 좋네요', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('점심 뭐 드셨어요?', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('프로젝트 잘 되고 있나요?', '송은이');
INSERT INTO board (bcontent, bwriter) VALUES ('코딩이 너무 재미있어요!', '이수근');
INSERT INTO board (bcontent, bwriter) VALUES ('이번 주말에 뭐 하실 거예요?', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('저는 여행을 다녀왔어요', '장도연');
INSERT INTO board (bcontent, bwriter) VALUES ('좋은 하루 보내세요!', '양세찬');
INSERT INTO board (bcontent, bwriter) VALUES ('어제 본 영화 정말 감동이었어요', '김숙');
INSERT INTO board (bcontent, bwriter) VALUES ('새로운 프로젝트에 참여하게 됐어요', '정형돈');
INSERT INTO board (bcontent, bwriter) VALUES ('점점 더워지네요, 건강 조심하세요', '전소민');
INSERT INTO board (bcontent, bwriter) VALUES ('주말엔 푹 쉬는 게 최고예요', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('팀워크가 정말 좋아요!', '김신영');
INSERT INTO board (bcontent, bwriter) VALUES ('좋은 소식이 있어서 공유해요', '홍진경');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘도 열심히 해봅시다!', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('아이디어 회의 잘 마쳤어요', '서장훈');
INSERT INTO board (bcontent, bwriter) VALUES ('커피 한 잔 하면서 쉬어가요', '유병재');
INSERT INTO board (bcontent, bwriter) VALUES ('항상 응원하고 있습니다', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('소소한 일상이 참 소중해요', '김희철');

select *from board
