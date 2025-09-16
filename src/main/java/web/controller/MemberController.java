package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;
import web.service.MemberService;
import web.service.PointService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired private MemberService memberService;
    @Autowired private PointService pointService;

    // [1] 회원가입
    @PostMapping("/signup")
    public int signUP(@RequestBody MemberDto memberDto){
        int result = memberService.signUp(memberDto);
        return result;
    }

    // [1-1] 회원가입 시 포인트 증정
    @PostMapping("/point")
    public int Point(@RequestBody PointDto pointDto){
        int result = pointService.signPoint(pointDto);
    }
    // [2] 로그인
    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto ,
                     HttpServletRequest request ){
        // 1. 세션 정보 가져오기
        HttpSession session = request.getSession();
        // 2. 로그인 성공한 회원번호 확인
        int result = memberService.login(memberDto);
        if( result > 0 ) {
            // 3. 세션 정보에 속성 추가하기.
            session.setAttribute("loginMno",result); // 속성값은 자동타입변환으로 Object 타입
        }
        // 4.반환
        return result;
    }

    // [3] 로그아웃 , 세션은 서버를 재시작 하면 초기화 되거나 직접 제거
    @GetMapping("/logout")
    public boolean logout( HttpServletRequest request ){
        // 1. 세션 정보 가져오기
        HttpSession session = request.getSession();
        // 2. 만약에 세션이 없거나 특정한 속성값이 없으면 ( 유효성검사 )
        if( session == null || session.getAttribute("loginMno")==null ){
            return false; // 비로그인상태 // 로그아웃 실패
        }
        // 3. 로그인상태이면 속성값 제거하기
        session.removeAttribute("loginMno");
        return true;
    } // func end

    // [4] 내정보조회
    @GetMapping("/info")
    public MemberDto info( HttpServletRequest request){
        // 1. HttpServletRequest (요청정보)객체 에서 세션 객체 꺼내기
        HttpSession session = request.getSession();
        // 2. 만약에 비어있으면 비로그인상태
        if( session == null || session.getAttribute("loginMno")==null){
            return null;
        }
        // 3. 로그인상태이면 세션 정보내 로그인상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); // 로그인시 정의 속성명과 동일하게 작성
        // Object 타입은 자바의 최상위 클래스로써 모든 자료를 저장한다. 세션은 Object 타입으로 저장한다.
        // 즉] 세션은 모든 타입의 자료를 저장할 수 있다.
        // 4. 타입변환 , 강제타입변환이란? (변환할타입명)변수명; **태생** : Object가 되기전에 타입 확인? int
        int loginMno = (int)obj;
        // 5. 서비스에게 전달하고 응답받기
        MemberDto result = memberService.info(loginMno);
        return result;
    }

    // [5] 중복검사
    @GetMapping("/check")
    public boolean check(@RequestParam String type , @RequestParam String data ){
        boolean result = memberService.check( type,data );
        return result;
    }

    // [6] 회원정보수정
    @PutMapping("/update")
    public boolean update(@RequestBody MemberDto memberDto , HttpServletRequest request ){
        // 1. 세션 객체 꺼내기
        HttpSession session = request.getSession();
        // 2. 만약에 세션이 없다면 비로그인상태 : *수정불가능
        if( session == null || session.getAttribute("loginMno") == null){
            return false;
        }
        // 3. 로그인된 회원번호 꺼내기 = 수정하는 회원의 번호
        Object obj = session.getAttribute("loginMno");
        int loginMno = (int)obj;
        // 4. dto 담아주기
        memberDto.setMno( loginMno );
        // 5. 서비스에게 전달후 응답받기
        boolean result = memberService.update(memberDto);
        return result;
    }

    // [7] 회원비밀번호수정
    @PutMapping("/update/password")
    public boolean updatePassword(@RequestBody Map<String,String> map , HttpServletRequest request){
        // 1. 요청 객체에서 세션 정보 꺼내기
        HttpSession session = request.getSession();
        // 2.
        if( session == null || session.getAttribute("loginMno")==null) return false;
        // 3.
        Object obj = session.getAttribute("loginMno");
        int loginMno = (int)obj;
        // 4.
        boolean result =memberService.updatePassword( loginMno , map );
        session.removeAttribute("loginMno"); // 로그아웃
        return result;
    }

    // [8] 회원탈퇴
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam String oldpwd , HttpSession session ) {
        // 1. 매개변수로 받은 요청정보내 세션객체를 확인 해서 없으면 비로그인 상태
        if( session == null || session.getAttribute("loginMno") == null ) return false;
        // 2.
        int loginMno = (int)session.getAttribute("loginMno");
        // 3.
        session.removeAttribute("loginMno"); // 로그아웃
        return  memberService.delete( loginMno , oldpwd );
    }

//    // [9] 아이디 찾기 : 입력 이름+연락처 , 일치 시 아이디 반환
//    @PostMapping("/find")
//    public String findId(@RequestBody List<Map<String, String>> list){
//        String mid = memberService.findId( list );
//
//        return mid;
//    }

    // [9-1] 아이디 찾기 : 입력 이름+연락처 , 일치 시 아이디 반환
    @GetMapping("/findid")
    public Map<String , String> findId(@RequestParam Map<String, String> map){
        return memberService.findId( map );
    }

//    // [10] 비밀번호 찾기
//    @PutMapping("/find")
//    public String findPwd(@RequestBody Map < String ,String > map ){
//        String result = memberService.findPwd( map );
//        return result;
//    }

    // [10-1] 비밀번호 찾기
    @GetMapping("/findpwd")
    public Map<String,String> findPwd(@RequestParam Map < String ,String > map ){
        return memberService.findPwd( map );
    }

} // class end











































