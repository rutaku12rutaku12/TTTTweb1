package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.Map;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {
    @Autowired private MemberDao memberDao; // 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기

    // [1] 회원가입
    public int signUp(MemberDto memberDto){
        int result = memberDao.signUp(memberDto);
        return result;
    }

    // [2] 로그인
    public int login(MemberDto memberDto) {
        int result = memberDao.login(memberDto);
        return result;
    }

    // [3] 로그아웃

    // [4] 내정보조회
    public MemberDto info( int mno ){
        MemberDto result = memberDao.info( mno );
        return result;
    }

    // [5] 특정할 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check( String type , String data ){
        boolean result = memberDao.check( type ,data );
        return result;
    }

    // [6] 회원정보수정
    public boolean update(MemberDto memberDto){
        boolean result = memberDao.update(memberDto);
        return result;
    }

    // [7] 회원비밀번호수정
    public boolean updatePassword( int mno , Map<String,String> map ){
        boolean result = memberDao.updatePassword( mno , map);
        return result;
    }

    // [8] 회원탈퇴
    public boolean delete( int mno , String oldpwd) {
        boolean result = memberDao.delete( mno , oldpwd);
        return result;
    }
    // [9] 아이디 찾기 : 입력 이름+연락처 , 일치 시 아이디 반환
    public String findId( Map<String , String> map){
        String result = memberDao.findId( map );
        return result;
    }

    // [10] 비밀번호 찾기

}// class end

































