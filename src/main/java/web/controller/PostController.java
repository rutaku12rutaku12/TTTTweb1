package web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;


@RestController // (1) HTTP 요청/응답 자료 매핑 기술
@RequestMapping("/post") // (2) HTTP URL 매핑 기술
@RequiredArgsConstructor // (3) final 변수에 대한 자동 생성자 주입
public class PostController {

    private final PostService postService; // @RequiredArgsConstructor 사용함으로 @Autowired 생략 한다.

    // [1] 게시물 등록
    @PostMapping("") // method : post , url : localhost:8080/post , body : { btitle : , bcontetn : , cno : , pno }
    public int writePost(@RequestBody PostDto postDto , HttpSession session){
        // 1. 현재 로그인 상태 확인
        Object login = session.getAttribute("loginMno");
        // 2. 비로그인이면 등록 실패처리
        if( login == null ) return 0;
        // 3. 로그인이면 현재 로그인한 회원번호을 postDto 대입하기
        int mno = (int)login;
        postDto.setMno(mno);
        // 4. 서비스 호출 하고 응답 반환 하기
        return postService.writePost( postDto );
    } // func end

    // [2] 게시물 전체 조회
    @GetMapping("")
    // method : GET, URL : localhost:8080/post?cno=1&page=1&count=5  // 1번 카테고리의 1페이지의 5개 게시물
    // method : GET, URL : localhost:8080/post?cno=1&page=2&count=10  // 1번 카테고리의 2페이지의 10개 게시물
    public PageDto findAllPost(@RequestParam( defaultValue = "1" ) int cno ,
                               @RequestParam( defaultValue = "1" ) int page ,
                               @RequestParam( defaultValue = "5" ) int count ){
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 없으면 defaultValue 속성으로 기본값 대입 할 수 있다.
        // cno : 카테고리번호 , page : 현재페이지번호 , count : 페이지당 게시물수
        return postService.findAllPost(cno,page,count);
    }
} // class end













