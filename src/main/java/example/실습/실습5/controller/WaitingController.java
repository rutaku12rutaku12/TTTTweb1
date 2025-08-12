package example.실습.실습5.controller;

import example.실습.실습5.model.dto.WaitingDto;
import example.실습.실습5.service.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiting") // 공통 URL
public class WaitingController {
    @Autowired private WaitingService waitingService;

    // [1] 등록
    @PostMapping("") // localhost:8080/waiting
    public boolean waitingAdd(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingController.waitingAdd");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingAdd( waitingDto ); // 서비스 호출하고 응답을 반환
        return result;
    } // m end
    // [2] 전체조회
    @GetMapping("") // localhost:8080/waiting
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingController.waitingPrint");
        List<WaitingDto> result = waitingService.waitingPrint();
        return result;
    } // m end

    // [3] 개별조회
    @GetMapping("/find") // localhost:8080/waiting/find?wno=1
    public WaitingDto waitingFind(@RequestParam int wno ){
        System.out.println("WaitingController.waitingFind");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingService.waitingFind( wno );
        return result;
    } // m end

    // [4] 개별삭제
    @DeleteMapping("") // localhost:8080/waiting?wno=2
    public boolean waitingDelete(@RequestParam int wno ){
        System.out.println("WaitingController.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingService.waitingDelete(wno);
        return result;
    } // m end

    // [5] 개별수정
    @PutMapping("") // localhost:8080/waiting
    public boolean waitingUpdate( @RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingController.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingUpdate( waitingDto );
        return result;
    }


} // class end






















