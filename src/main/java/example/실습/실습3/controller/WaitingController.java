package example.실습.실습3.controller;

import example.실습.실습3.model.dao.WaitingDao;
import example.실습.실습3.model.dto.WaitingDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 싱글톤 같은 기능이 포함됨 + @Component
public class WaitingController {

    // (*) 싱글톤 객체 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // (1) 등록 기능 구현
    @PostMapping("/waiting")
    public boolean waitingAdd(@RequestBody WaitingDto waitingDto ){
        // 1. 객체화 된 dto 를 dao 에게 전달 후 결과 받기
        boolean result = waitingDao.waitingAdd( waitingDto );
        // 2. 결과를 view에게 리턴
        return  result;
    } // func end

    // (2) 전체조회 기능 구현
    @GetMapping("/waiting")
    public ArrayList<WaitingDto> waitingPrint(){
        // dao 에게 요청 후 결과 받기
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();
        // 결과를 view에게 반환 하기
        return result;
    } // func end

    // (3) 삭제 기능 구현
    @DeleteMapping("/waiting")
    public boolean waitingDelete(@RequestParam int wno ){
        // 1.유효성검사  2.객체화 pass
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = waitingDao.waitingDelete(wno);
        // 4. 결과를 view에게 리턴한다.
        return result;
    }// func end

    // (4) 수정 기능 구현
    @PutMapping("/waiting")
    public boolean waitingUpdate(@RequestBody WaitingDto waitingDto){
        // 1.유효성검사 pass
        // 2.객체화
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = waitingDao.waitingUpdate( waitingDto );
        // 4. 결과를 view에게 리턴한다.
        return result;

    }// func end
}
