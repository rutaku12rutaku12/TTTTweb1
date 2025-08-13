package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

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

}// class end

































