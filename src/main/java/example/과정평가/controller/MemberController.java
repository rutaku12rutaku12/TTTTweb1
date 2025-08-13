package example.과정평가.controller;

import example.과정평가.model.dto.MemberDto;
import example.과정평가.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member") // 공통 URL
public class MemberController {
    @Autowired private MemberService memberService;

    // [1] 등록
    @PostMapping("") // localhost:8080/member
    public boolean memberAdd(@RequestBody MemberDto memberDto ){
        System.out.println("MemberController.memberAdd");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.memberAdd( memberDto ); // 서비스 호출하고 응답을 반환
        return result;
    } // m end

    // [2] 전체조회
    @GetMapping("") // localhost:8080/member
    public List<MemberDto> memberPrint(){
        System.out.println("MemberController.memberPrint");
        List<MemberDto> result = memberService.memberPrint();
        return result;
    } // m end

    // [3] 개별조회
    @GetMapping("/update") // localhost:8080/member/update?custno=1
    public MemberDto memberFind(@RequestParam int custno ){
        System.out.println("MemberController.memberFind");
        System.out.println("custno = " + custno);
        MemberDto result = memberService.memberFind( custno );
        return result;
    } // m end

    // [4] 개별수정
    @PutMapping("") // localhost:8080/member
    public boolean memberUpdate( @RequestBody MemberDto memberDto){
        System.out.println("MemberController.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.memberUpdate( memberDto );
        return result;
    }
} // class end















