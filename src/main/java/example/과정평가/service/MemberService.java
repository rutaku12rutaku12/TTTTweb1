package example.과정평가.service;

import example.과정평가.model.dao.MemberDao;
import example.과정평가.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberDao memberDao;

    // [1] 등록
    public boolean memberAdd(MemberDto memberDto){
        System.out.println("MemberService.memberAdd");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberDao.memberAdd( memberDto );
        return result;
    } // m end

    // [2] 전체조회
    public List<MemberDto> memberPrint(){
        System.out.println("MemberService.memberPrint");
        List<MemberDto> result = memberDao.memberPrint();
        return result;
    } // m end

    // [3] 개별조회
    public MemberDto memberFind( int custno ){
        System.out.println("MemberService.memberFind");
        System.out.println("custno = " + custno);
        MemberDto result = memberDao.memberFind( custno );
        return result;
    } // m end

    // [4] 개별 수정
    public boolean memberUpdate( MemberDto memberDto ){
        System.out.println("MemberService.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberDao.memberUpdate( memberDto );
        return result;
    } // m end

} // class end














