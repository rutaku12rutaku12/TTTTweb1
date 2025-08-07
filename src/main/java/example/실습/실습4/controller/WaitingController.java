package example.실습.실습4.controller;

import example.실습.실습4.model.dao.WaitingDao;
import example.실습.실습4.model.dto.WaitingDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiting") // 지정한 클래스내 모든 메소드들의 공통 url 설정
public class WaitingController {

    // 0 . DAO 싱글톤 불러오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 저장
    @PostMapping("/save") // localhost:8080/waiting/save
    public boolean save(@RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingController.save");
        System.out.println("waitingDto = " + waitingDto);
        // DAO
        boolean result = waitingDao.save( waitingDto );
        return result;
    }
    // 2. 전체조회
    @GetMapping("/find") // localhost:8080/waiting/find
    public List<WaitingDto> find(){
        System.out.println("WaitingController.find");
        List<WaitingDto> result = waitingDao.find();
        return result;
    }
}























